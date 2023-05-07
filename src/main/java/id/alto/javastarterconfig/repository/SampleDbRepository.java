package id.alto.javastarterconfig.repository;

import id.alto.javastarterconfig.entity.SampleDb;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SampleDbRepository extends CrudRepository<SampleDb, UUID> {
}
