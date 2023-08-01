package com.tiwari.studence.organisation.bquery;

import java.util.concurrent.Executors;

import javax.inject.Inject;

import com.tiwari.studence.bquery.database.connection.BQueryConnector;
import com.tiwari.studence.common.bquery.BQueryTableServices;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.util.exception.ExceptionHandler;
import com.tiwari.studence.util.serverConfig.IServerListener;

public class OrganisationBigQueryService extends BQueryTableServices<OrganisationBigQuerySchema,OrganisationPb> implements IOrganisationBigQueryService{

	
	@Inject
	public OrganisationBigQueryService(IServerListener serverlistner, BQueryConnector BQueryConnector,
			ExceptionHandler exceptionHandler, OrganisationBigQuerySchema s) {
		super(serverlistner, BQueryConnector, exceptionHandler, Executors.newFixedThreadPool(10), s);
	}

}
