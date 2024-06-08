package com.tiwari.studence.classes.provider;

import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.classes.ClassesPb;

public class ClassesProvider implements IPbBuilderProvider<ClassesPb, ClassesPb.Builder> {
    @Override
    public ClassesPb.Builder getBuilder() {
        return ClassesPb.newBuilder();
    }

    @Override
    public ClassesPb.Builder getBuilder(ClassesPb builder) {
        return ClassesPb.newBuilder(builder);
    }


}
