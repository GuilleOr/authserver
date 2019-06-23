package ar.com.medicinas.authserver.service.impl;

import ar.com.medicinas.authserver.dao.ResetPasswordPetitionDao;
import ar.com.medicinas.authserver.exception.ImpossibleToCreateResetPasswordRequest;
import ar.com.medicinas.authserver.exception.UserNotFoundException;
import ar.com.medicinas.authserver.model.ProcessEnum;
import ar.com.medicinas.authserver.model.ResetPasswordPetition;
import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.service.EmailService;
import ar.com.medicinas.authserver.service.ResetPasswordPetitionService;
import ar.com.medicinas.authserver.service.UserService;
import ar.com.medicinas.authserver.vo.PasswordRestorePetitionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class ResetPasswordPetitionServiceImpl extends BaseBeanService<ResetPasswordPetition> implements ResetPasswordPetitionService {
	private static final Logger LOG = LoggerFactory.getLogger(ResetPasswordPetitionServiceImpl.class);
	@Autowired
	private ResetPasswordPetitionDao resetPasswordPetitionDao;
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;

	@Transactional
	@Override
	public ResetPasswordPetition resetPassword(User user) {
		LocalDateTime date = LocalDateTime.now().minusDays(1);
		Optional<ResetPasswordPetition> result = resetPasswordPetitionDao.findByUser_IdAndCreationDateAfter(user.getId(), date);
		if (result.isPresent()) {
			LOG.info(new StringBuilder("Para el usuasrio: ").append(user.getUuid()).append(" ya existe la peticion para reiniciar la password").toString());
			throw new ImpossibleToCreateResetPasswordRequest();
		}
		ResetPasswordPetition entityToSave = new ResetPasswordPetition();
		entityToSave.setUser(user);
		return resetPasswordPetitionDao.save(prepareToCreate(entityToSave));
	}

	@Override
	public Optional<ResetPasswordPetition> findResetPasswordPetitionByValidUuid(String uuid) {
		return resetPasswordPetitionDao.findByUuidAndCreationDateAfter(uuid, LocalDateTime.now().minusDays(1));
	}

	@Override
	public ResetPasswordPetition createResetPasswordPetition(String email) {
		ResetPasswordPetition object = new ResetPasswordPetition();
		object.setUser(userService.readUserByEmail(email).orElseThrow(() -> new UserNotFoundException(email)));
		ResetPasswordPetition persistedObject = resetPasswordPetitionDao.save(prepareToCreate(object));
		sentRestorePasswordEmail(persistedObject);
		return persistedObject;
	}

	private void sentRestorePasswordEmail(ResetPasswordPetition persistedObject) {
		PasswordRestorePetitionVO objectToSend = new PasswordRestorePetitionVO(persistedObject.getUuid(), persistedObject.getUser().getEmail());
		emailService.sendEmail(objectToSend, "restore-password", ProcessEnum.RESTORE_PASSWORD, Collections.singletonList(persistedObject.getUser().getEmail()), null, null);
	}

}
