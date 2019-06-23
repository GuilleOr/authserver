package ar.com.medicinas.authserver.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class LogicalDeleteableBean extends BaseBean {
	private Boolean active;
}
