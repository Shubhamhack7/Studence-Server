package com.tiwari.studence.organisation;

import com.google.inject.Injector;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tiwari.studence.common.service.v2.entity.create.GCreateEntity;

import com.tiwari.studence.organisation.convertor.OrganisationUiPbConvertor;
import com.tiwari.studence.organisation.injector.InjectorProvider;
import com.tiwari.studence.organisation.module.OrganisationModule;
import com.tiwari.studence.organisation.service.IOrganisationUiPbService;
import com.tiwari.studence.organisation.store.OrganisationEntityStore;
import com.tiwari.studence.organisation.updater.OrganisationUiPbServiceUpdater;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationUiPb;
import com.tiwari.studence.proto.time.TimezoneEnum;
import com.tiwari.studence.util.exception.ErrorException;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) throws ErrorException, InvalidProtocolBufferException {
    Injector inj = InjectorProvider.createInjector();
     /* IOrganisationService a  = inj.getInstance(IOrganisationService.class);
      IOrganisationBigQueryService service  = inj.getInstance(IOrganisationBigQueryService.class);
      OrganisationSearchReqPb.Builder builder = OrganisationSearchReqPb.newBuilder();
      builder.setNextToken("SUQjVXJAUkFOR0UjMTMyMw==");
      OrganisationPbW
      System.out.print(ProtobufToJson.protobufToJsonString(builder.build()));
        //System.out.println(a.search(builder.build()).get());
      //System.out.println(service.createTable("100_ORGANISATION","studence_dev_devel"));
      Map<String,Object> data = new HashMap<String,Object>();
      data.put("dbInfo.id","asdas");
      data.put("dbInfo.lifetime","active");
      data.put("name","help");
      System.out.println(a.search(builder.build()).get());*/
    createEntity(inj);

  }

  private static void createEntity(Injector inj) {
    IOrganisationUiPbService gcreate = inj.getInstance(
            IOrganisationUiPbService.class);
    OrganisationUiPb.Builder builder = OrganisationUiPb.newBuilder();
    builder.getDbInfoBuilder().setTimezone(TimezoneEnum.ASIA_KOLKATA);
    gcreate.createEntity(builder.build());
  }
}
