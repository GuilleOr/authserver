package ar.com.medicinas.authserver.dao;

import ar.com.medicinas.authserver.model.CustomClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomClientDao extends JpaRepository<CustomClientDetails, Long> {
	Optional<CustomClientDetails> findByClientId(String clientId);
}
