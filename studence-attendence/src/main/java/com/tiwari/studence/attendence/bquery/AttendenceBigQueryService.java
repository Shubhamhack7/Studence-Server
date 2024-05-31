package com.tiwari.studence.attendence.bquery;

import com.tiwari.studence.bquery.database.connection.BQueryConnector;
import com.tiwari.studence.common.bquery.BQueryTableServices;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.util.exception.ExceptionHandler;
import com.tiwari.studence.util.serverConfig.IServerListener;

import javax.inject.Inject;
import java.util.concurrent.Executors;

public class AttendenceBigQueryService extends BQueryTableServices<AttendenceBigQuerySchema,AttendencePb> implements IAttendenceBigQueryService {

	
	@Inject
	public AttendenceBigQueryService(IServerListener serverlistner, BQueryConnector BQueryConnector,
									 ExceptionHandler exceptionHandler, AttendenceBigQuerySchema s) {
		super(serverlistner, BQueryConnector, exceptionHandler, Executors.newFixedThreadPool(10), s);
	}

}
