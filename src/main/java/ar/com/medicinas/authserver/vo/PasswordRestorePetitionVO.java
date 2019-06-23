package ar.com.medicinas.authserver.vo;

public class PasswordRestorePetitionVO {
	private String email;
	private String uuid;

	public PasswordRestorePetitionVO() {
	}

	public PasswordRestorePetitionVO(String email, String uuid) {
		this.email = email;
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "PasswordRestorePetitionVO{" +
				"email='" + email + '\'' +
				", uuid='" + uuid + '\'' +
				'}';
	}
}
