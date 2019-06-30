package ar.com.medicinas.authserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "document_type")
public class DocumentType extends LogicalDeleteableBean {
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String countryId;
}
