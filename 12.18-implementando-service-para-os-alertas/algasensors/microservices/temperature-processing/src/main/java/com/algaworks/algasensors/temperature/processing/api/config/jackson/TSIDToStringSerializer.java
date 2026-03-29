package com.algaworks.algasensors.temperature.processing.api.config.jackson;

import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;
import io.hypersistence.tsid.TSID;

public class TSIDToStringSerializer extends ValueSerializer<TSID> {

    @Override
    public void serialize(TSID value, JsonGenerator gen, SerializationContext serializers) {
        gen.writeString(value.toString());
    }
}
