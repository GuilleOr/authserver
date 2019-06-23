package ar.com.medicinas.authserver.rest.dto;

public class UserListDTO {

	private String id;
	private String email;
	private String name;
	private String taxId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	@Override
	public String toString() {
		return "UserListDTO{" +
				"id='" + id + '\'' +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", taxId='" + taxId + '\'' +
				'}';
	}
}
