package com.tiwari.studence.common.services.interfaces;

import com.google.protobuf.GeneratedMessageV3;

public interface IService<T extends GeneratedMessageV3, Req extends GeneratedMessageV3, Resp extends GeneratedMessageV3>
        extends IGetEntity<T>, ICreateEntity<T>, ISearchEntity<Req, Resp>, IUpdateEntity<T>, IDeleteEntity<T> {

}
