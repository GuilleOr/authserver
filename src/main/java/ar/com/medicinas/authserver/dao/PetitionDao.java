package ar.com.medicinas.authserver.dao;

import ar.com.medicinas.authserver.model.Petition;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PetitionDao extends BaseBeanDao<Petition> {
	Optional<Petition> findPetitionByUuidAndCreationDateAfter(String uuid, LocalDateTime time);

	Optional<Petition> findPetitionByEmailAndCreationDateAfter(String email, LocalDateTime time);
}
