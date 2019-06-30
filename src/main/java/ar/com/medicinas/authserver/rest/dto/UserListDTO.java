package ar.com.medicinas.authserver.rest.dto;

import lombok.Data;

@Data
public class UserListDTO {

	private String id;
	private String email;
	private String name;
	private String taxId;
}
