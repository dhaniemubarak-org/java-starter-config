package id.alto.javastarterconfig.service;

import id.alto.javastarterconfig.entity.SampleDb;
import id.alto.javastarterconfig.repository.SampleDbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SampleDbServiceImpl implements SampleDbService {

    private final SampleDbRepository sampleDbRepository;

    @Override
    public SampleDb createSampleDb(SampleDb request) {
        Optional<SampleDb> sampleDbOptional = sampleDbRepository.findByPhoneNumber(request.getPhoneNumber());
        if (sampleDbOptional.isPresent()) {
            SampleDb sampleDb = sampleDbOptional.get();
            if (sampleDb.getName().equals(request.getName())) {
                return sampleDb;
            }
            throw new IllegalStateException(String.format("Phone number [%s] is taken", request.getPhoneNumber()));
        }
        if (request.getId() == null) {
            request.setId(UUID.randomUUID());
        }
        return sampleDbRepository.save(request);
    }
}
