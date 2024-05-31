package com.tiwari.studence.common.http.client;

import com.tiwari.studence.common.async.CallbackFuture;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.exception.VoidException;
import okhttp3.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Singleton
public class HttpClient {
  private final OkHttpClient m_client;
  public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

  @Inject
  public HttpClient() {
    m_client = createHttpClient();
  }

  private OkHttpClient createHttpClient() {
    OkHttpClient client = new OkHttpClient.Builder().readTimeout(1, TimeUnit.MINUTES).cache(cache())
            .addNetworkInterceptor(new Interceptor() {
              @Override
              public Response intercept(Chain chain) throws IOException {
                Response resp = chain.proceed(chain.request());
                Response.Builder builder = resp.newBuilder();
                if (resp.headers("cache-control").size() == 0) {
                  builder.addHeader("cache-control", "no-store");
                }
                return builder.build();
              }
            }).build();
    client.dispatcher().setMaxRequests(5000);
    client.dispatcher().setMaxRequestsPerHost(5000);
    return client;
  }

  public IFuture<String, VoidException> doGetForString(String url) {
    Request request = new Request.Builder().url(url).build();
    return callAsyncForString(request, "");
  }

  public IFuture<String, VoidException> doGetForString(String url, String headerName,
          String headerValue) {
    Request request = new Request.Builder().url(url).addHeader(headerName, headerValue).build();
    return callAsyncForString(request, "");
  }

  public IFuture<String, VoidException> doPostJsonForString(String url, String json) {
    return doPostJsonForString(url, json, null);
  }

  public IFuture<String, VoidException> doPostJsonForString(String url, String json,
          String authorizationKey) {
    RequestBody body = RequestBody.create(JSON, json);
    Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
    if (authorizationKey != null) {
      requestBuilder.addHeader("Authorization", "key=" + authorizationKey);
    }
    Request request = requestBuilder.build();
    return callAsyncForString(request, json);
  }

  private IFuture<String, VoidException> callAsyncForString(Request request,
          final String debugInfo) {
    final CallbackFuture<String, VoidException> callback = new CallbackFuture<String, VoidException>();
    m_client.newCall(request).enqueue(new Callback() {
      @Override
      public void onResponse(Call call, Response response) throws IOException {
        try {
          ResponseBody responseBody = response.body();
          int code = response.code();
          if (response.isSuccessful()) { // 2xx
            callback.set(responseBody.string());
          } else {
            if (400 <= code && code < 500) {
              callback.handleUnexpectedException(new LoggedRuntimeException(
                      ErrorCategoryUiEnum.SELF_CODE_ERROR, call.request().toString(), code, debugInfo));
            } else if (500 <= code && code < 600) {
              callback.handleUnexpectedException(
                      new LoggedRuntimeException(ErrorCategoryUiEnum.DOWNSTREAM_SERVER_ERROR,
                              call.request().toString(), code, debugInfo));
            } else {
              callback.handleUnexpectedException(new LoggedRuntimeException(
                      ErrorCategoryUiEnum.SELF_CODE_ERROR, call.request().toString(), code, debugInfo));
            }
          }
        } catch (Throwable t) {
          callback.handleUnexpectedException(
                  Exceptions.handleThrowable(t, call.request(), debugInfo));
        } finally {
          callback.done();
        }
      }

      @Override
      public void onFailure(Call call, IOException arg1) {
        callback.handleUnexpectedException(new LoggedRuntimeException(
                ErrorCategoryUiEnum.NO_SLOW_OR_BLOCKED_DOWNSTREAM_CONNECTION_ERROR, call.request().toString(),
                debugInfo));
        callback.done();
      }
    });
    return callback;
  }

  private Cache cache() {
    return new Cache(cacheDirectory(), 1024 * 1024 * 1024); // 1GB
  }

  private File cacheDirectory() {
    File directory = new File(System.getProperty("user.home") + File.separator + "okhttpcache");
    if (!directory.exists()) {
      directory.mkdir();
    }
    return directory;
  }

}
