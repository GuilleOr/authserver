package ar.com.medicinas.authserver.exception;

import java.util.Objects;

public class CustomError {

	private String code;
	private String message;
	private String description;
	private Integer status;

	public CustomError() {
	}

	public CustomError(String code, String message, String description, Integer status) {
		this.code = code;
		this.message = message;
		this.description = description;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomError that = (CustomError) o;
		return Objects.equals(code, that.code) &&
				Objects.equals(message, that.message) &&
				Objects.equals(description, that.description) &&
				Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message, description, status);
	}

	@Override
	public String toString() {
		return "CustomError{" +
				"code='" + code + '\'' +
				", message='" + message + '\'' +
				", description='" + description + '\'' +
				", status=" + status +
				'}';
	}
}
