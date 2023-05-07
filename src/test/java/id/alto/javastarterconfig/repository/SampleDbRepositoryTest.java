package id.alto.javastarterconfig.repository;

import id.alto.javastarterconfig.entity.SampleDb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SampleDbRepositoryTest {

    @Autowired
    SampleDbRepository underTest;

    @Test
    void itShouldSelectSampleDbByPhoneNumber() {
        String phoneNumber = "0000";
        SampleDb sampleDb = new SampleDb(UUID.randomUUID(), "Alto", phoneNumber, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        underTest.save(sampleDb);
        Optional<SampleDb> fetchSampleDb = underTest.findByPhoneNumber(phoneNumber);
        assertThat(fetchSampleDb).isPresent().hasValueSatisfying(s -> assertEquals(phoneNumber, s.getPhoneNumber()));
    }

    @Test
    void itShouldSaveSampleDb() {
        UUID id = UUID.randomUUID();
        SampleDb sampleDb = new SampleDb(id, "Test Name", "0000", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        underTest.save(sampleDb);
        Optional<SampleDb> fetchSampleDb = underTest.findById(id);
        assertThat(fetchSampleDb).isPresent().hasValueSatisfying(s -> {
            assertThat(s.getId()).isEqualTo(id);
            assertThat(s.getName()).isEqualTo("Test Name");
        });
    }

}