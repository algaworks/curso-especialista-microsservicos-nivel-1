package com.algaworks.algasensors.temperature.monitoring.api.model;

import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class SensorAlertOutput {
    private TSID id;
    private Double maxTemperature;
    private Double minTemperature;
}
