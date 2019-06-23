package ar.com.medicinas.authserver.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class TimestampBean {
	private LocalDateTime creationDate;
	private LocalDateTime lastUpdate;
}
