package ar.com.medicinas.authserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Data
@Entity
public class ResetPasswordPetition extends BaseBean {

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

}
