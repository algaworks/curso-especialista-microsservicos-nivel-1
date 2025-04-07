package com.algaworks.algasensors.device.management.api.model;

import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class SensorMonitoringOuput {
    private TSID id;
    private Double lastTemperature;
    private OffsetDateTime updatedAt;
    private Boolean enabled;
}
