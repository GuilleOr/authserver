package ar.com.medicinas.authserver.dao;

import ar.com.medicinas.authserver.model.ResetPasswordPetition;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ResetPasswordPetitionDao extends BaseBeanDao<ResetPasswordPetition> {
	Optional<ResetPasswordPetition> findByUser_IdAndCreationDateAfter(Long userId, LocalDateTime date);
}
