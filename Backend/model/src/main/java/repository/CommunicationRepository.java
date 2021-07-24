package repository;

import entity.CommunicationGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends CrudRepository<CommunicationGroup , Long> {
}
