package ar.com.medicinas.authserver.service.impl;

import ar.com.medicinas.authserver.dao.PetitionDao;
import ar.com.medicinas.authserver.exception.PetitionExistException;
import ar.com.medicinas.authserver.model.Petition;
import ar.com.medicinas.authserver.service.ClientPetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PetitionServiceImpl extends BaseBeanService<Petition> implements ClientPetitionService {
	@Autowired
	private PetitionDao petitionDao;

	@Override
	public Petition createNewClientPetition(Petition petition) {
		if (findValidPetitionByEmail(petition.getEmail()).isPresent()) {
			throw new PetitionExistException(petition.getEmail());
		}
		return prepareToCreate(petition);
	}

	@Override
	public Optional<Petition> readValidPetition(String uuid) {
		LocalDateTime time = LocalDateTime.now();
		time = time.plusDays(-1);
		return this.petitionDao.findPetitionByUuidAndCreationDateAfter(uuid, time);
	}

	private Optional<Petition> findValidPetitionByEmail(String email) {
		LocalDateTime time = LocalDateTime.now();
		time = time.plusDays(-1);
		return petitionDao.findPetitionByEmailAndCreationDateAfter(email, time);
	}

	private Optional<Petition> readValidPetitionByUuid(String uuid) {
		LocalDateTime time = LocalDateTime.now();
		time = time.plusDays(-1);
		return petitionDao.findPetitionByUuidAndCreationDateAfter(uuid, time);
	}

}
