package com.algaworks.algasensors.device.management.domain.model;

import io.hypersistence.tsid.TSID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sensor {
    private TSID id;
    private String name;
    private String ip;
    private String location;
    private String protocol;
    private String model;
    private Boolean enabled;
}
