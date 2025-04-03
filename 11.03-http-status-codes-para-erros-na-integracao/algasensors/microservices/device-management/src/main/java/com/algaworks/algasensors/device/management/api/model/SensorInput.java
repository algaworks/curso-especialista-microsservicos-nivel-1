package com.algaworks.algasensors.device.management.api.model;

import lombok.Data;

@Data
public class SensorInput {
    private String name;
    private String ip;
    private String location;
    private String protocol;
    private String model;
}
