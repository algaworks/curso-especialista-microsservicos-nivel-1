package com.algaworks.algasensors.temperature.processing;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochRandomGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class UUIDv7Test {

    @Test
    void shouldGenerateUUIDv7() {
        UUID uuid = IdGenerator.generateTimeBasedUUID();

        OffsetDateTime uuidDateTime = UUIDv7Utils.extractOffsetDateTime(uuid).truncatedTo(ChronoUnit.MINUTES);
        OffsetDateTime currentDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        Assertions.assertThat(uuidDateTime).isEqualTo(currentDateTime);
    }

}
