package ar.com.medicinas.authserver.service.impl;

import ar.com.medicinas.authserver.dao.CustomClientDao;
import ar.com.medicinas.authserver.model.CustomClientDetails;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service(value = "customClientServiceDetailsImpl")
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	private CustomClientDao clientDao;

	@Override
	@Transactional(readOnly = true)
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		CustomClientDetails client = clientDao.findByClientId(clientId).orElseThrow(() -> new ClientRegistrationException(clientId));
		Hibernate.initialize(client.getResourceIds());
		Hibernate.initialize(client.getScope());
		Hibernate.initialize(client.getAuthorizedGrantTypes());
		Hibernate.initialize(client.getAuthorities());
		Hibernate.initialize(client.getRegisteredRedirectUri());
		BaseClientDetails base = new BaseClientDetails(client.getClientId(), client.getResourceIds().stream().collect(Collectors.joining(",")),
				client.getScope().stream().collect(Collectors.joining(",")),
				client.getAuthorizedGrantTypes().stream().collect(Collectors.joining(",")),
				client.getAuthorities().stream().collect(Collectors.joining(",")));
		base.setClientSecret(client.getClientSecret());
		base.setRegisteredRedirectUri(client.getRegisteredRedirectUri());
		base.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
		base.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());
		base.setAdditionalInformation(client.getAdditionalInformation());
		base.setAutoApproveScopes(client.getScope());
		return base;
	}
}
