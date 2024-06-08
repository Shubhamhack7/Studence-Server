package com.tiwari.studence.util.protobuf;

public interface IoSupplier<R> {
  R get() throws Exception;
}