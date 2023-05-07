package id.alto.javastarterconfig.service;

import id.alto.javastarterconfig.entity.SampleDb;
import id.alto.javastarterconfig.repository.SampleDbRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

class SampleDbServiceImplTest {

    @Mock
    private SampleDbRepository sampleDbRepository;

    @Captor
    ArgumentCaptor<SampleDb> sampleDbArgumentCaptor;

    private SampleDbServiceImpl underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new SampleDbServiceImpl(sampleDbRepository);
    }

    @Test
    void itShouldCreateSampleDbTest() {
        String phoneNumber = "08888";
        SampleDb sampleDb = new SampleDb(UUID.randomUUID(), "Alto", phoneNumber, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        given(sampleDbRepository.findByPhoneNumber(phoneNumber)).willReturn(Optional.empty());
        underTest.createSampleDb(sampleDb);
        then(sampleDbRepository).should().save(sampleDbArgumentCaptor.capture());
        SampleDb sampleDbCaptureValue = sampleDbArgumentCaptor.getValue();
        assertEquals(sampleDb, sampleDbCaptureValue);
    }

    @Test
    void itShouldNotCreateSampleDbTest() {
        String phoneNumber = "08888";
        SampleDb sampleDb = new SampleDb(UUID.randomUUID(), "Alto", phoneNumber, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        given(sampleDbRepository.findByPhoneNumber(phoneNumber)).willReturn(Optional.of(sampleDb));
        underTest.createSampleDb(sampleDb);
        then(sampleDbRepository).should(never()).save(any());
    }

    @Test
    void itShouldThrowWhenPhoneNumberIsTaken() {
        String phoneNumber = "08888";
        SampleDb sampleDb = new SampleDb(UUID.randomUUID(), "Alto", phoneNumber, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        SampleDb sampleDbTwo = new SampleDb(UUID.randomUUID(), "Network", phoneNumber, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
        given(sampleDbRepository.findByPhoneNumber(phoneNumber)).willReturn(Optional.of(sampleDbTwo));

        assertThatThrownBy(() -> underTest.createSampleDb(sampleDb))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(String.format("Phone number [%s] is taken", phoneNumber));
        then(sampleDbRepository).should(never()).save(any(SampleDb.class));
    }
}