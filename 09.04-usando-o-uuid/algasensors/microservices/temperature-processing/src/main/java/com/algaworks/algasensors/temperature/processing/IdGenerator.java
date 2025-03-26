package com.algaworks.algasensors.temperature.processing;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochRandomGenerator;

import java.util.UUID;

public class IdGenerator {
    private static final TimeBasedEpochRandomGenerator timeBasedEpochRandomGenerator =
            Generators.timeBasedEpochRandomGenerator();

    private IdGenerator() {
    }

    public static UUID generateTimeBasedUUID() {
        return timeBasedEpochRandomGenerator.generate();
    }
}
