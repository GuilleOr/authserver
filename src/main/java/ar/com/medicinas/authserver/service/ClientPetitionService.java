package ar.com.medicinas.authserver.service;

import ar.com.medicinas.authserver.model.Petition;

import java.util.Optional;

public interface ClientPetitionService {
	Petition createNewClientPetition(Petition petition);

	Optional<Petition> readValidPetition(String uuid);
}
