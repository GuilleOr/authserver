package ar.com.medicinas.authserver.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ChangePasswordRequest {
	@NotNull
	@NotEmpty
	private String oldPassword;
	@NotNull
	@NotEmpty
	private String newPassword;
	@NotNull
	@NotEmpty
	private String repeatNewPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatNewPassword() {
		return repeatNewPassword;
	}

	public void setRepeatNewPassword(String repeatNewPassword) {
		this.repeatNewPassword = repeatNewPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordRequest{" +
				"oldPassword='" + oldPassword + '\'' +
				", newPassword='" + newPassword + '\'' +
				", repeatNewPassword='" + repeatNewPassword + '\'' +
				'}';
	}
}
