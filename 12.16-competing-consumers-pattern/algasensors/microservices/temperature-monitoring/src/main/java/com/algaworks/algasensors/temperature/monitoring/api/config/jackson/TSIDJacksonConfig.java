package com.algaworks.algasensors.temperature.monitoring.api.config.jackson;

import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.module.SimpleModule;
import io.hypersistence.tsid.TSID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TSIDJacksonConfig {

    @Bean
    public JacksonModule tsidModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(TSID.class, new TSIDToStringSerializer());
        module.addDeserializer(TSID.class, new StringToTSIDDeserializer());
        return module;
    }

}
