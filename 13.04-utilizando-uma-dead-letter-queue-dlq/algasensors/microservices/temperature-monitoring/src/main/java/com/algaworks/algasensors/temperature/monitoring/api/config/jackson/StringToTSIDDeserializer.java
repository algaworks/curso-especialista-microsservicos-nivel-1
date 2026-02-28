package com.algaworks.algasensors.temperature.monitoring.api.config.jackson;

import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;
import io.hypersistence.tsid.TSID;

public class StringToTSIDDeserializer extends ValueDeserializer<TSID> {

    @Override
    public TSID deserialize(JsonParser p, DeserializationContext ctxt) {
        return TSID.from(p.getText());
    }
}
