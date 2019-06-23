package ar.com.medicinas.authserver.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Objects;

@Data
public abstract class BusinessException extends RuntimeException {

	private final String code;
	private final String message;
	private final String[] messageArguments;
	private final String description;
	private final String[] descriptionArguments;
	private final HttpStatus status;

	/**
	 * Constructs a new runtime exception with {@code null} as its
	 * detail message.  The cause is not initialized, and may subsequently be
	 * initialized by a call to {@link #initCause}.
	 */
	public BusinessException(String code, String message, String[] messageArguments, String description, String[] descriptionArguments, HttpStatus status) {
		this.code = code;
		this.message = message;
		this.messageArguments = messageArguments;
		this.description = description;
		this.descriptionArguments = descriptionArguments;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String[] getMessageArguments() {
		return messageArguments;
	}

	public String getDescription() {
		return description;
	}

	public String[] getDescriptionArguments() {
		return descriptionArguments;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BusinessException that = (BusinessException) o;
		return Objects.equals(code, that.code) &&
				Objects.equals(message, that.message) &&
				Arrays.equals(messageArguments, that.messageArguments) &&
				Objects.equals(description, that.description) &&
				Arrays.equals(descriptionArguments, that.descriptionArguments) &&
				status == that.status;
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(code, message, description, status);
		result = 31 * result + Arrays.hashCode(messageArguments);
		result = 31 * result + Arrays.hashCode(descriptionArguments);
		return result;
	}

	@Override
	public String toString() {
		return "BusinessException{" +
				"code='" + code + '\'' +
				", message='" + message + '\'' +
				", messageArguments=" + Arrays.toString(messageArguments) +
				", description='" + description + '\'' +
				", descriptionArguments=" + Arrays.toString(descriptionArguments) +
				", status=" + status +
				'}';
	}
}
