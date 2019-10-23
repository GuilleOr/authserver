package ar.com.medicinas.authserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
@Entity
public class CustomClientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String clientId;
	private String clientSecret;
	@ElementCollection
	@Column(name = "resourceIds")
	private Set<String> resourceIds = new HashSet<>();
	private Boolean secretRequired;
	private Boolean scoped;
	@ElementCollection
	@Column(name = "scopes")
	private Set<String> scope = new HashSet<>();
	@ElementCollection
	@Column(name = "authorization_grant_types")
	private Set<String> authorizedGrantTypes = new HashSet<>();
	@ElementCollection
	@Column(name = "registered_redirect_uri")
	private Set<String> registeredRedirectUri = new HashSet<>();
	@ElementCollection
	@Column(name = "authorities")
	private Collection<String> authorities = new HashSet<>();
	private Integer accessTokenValiditySeconds;
	private  Integer refreshTokenValiditySeconds;
	private Boolean autoApprove;
	@Transient
	private Map<String, Object> additionalInformation = new HashMap<>();
}
