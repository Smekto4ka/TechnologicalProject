package ru.oogis.repository;

import ru.oogis.entity.CommunicationGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends CrudRepository<CommunicationGroup , Long> {
}
