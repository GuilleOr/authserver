package ar.com.medicinas.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RedirectController {

	@Autowired
	@Qualifier("customClientServiceDetailsImpl")
	private ClientDetailsService clientDetailsService;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping
	public String redirect() {
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		String clientId = ((OAuth2Authentication) a).getOAuth2Request().getClientId();
		ClientDetails client = clientDetailsService.loadClientByClientId(clientId);
		if(client == null) {
			return "redirect:/login";
		} else {
			return "redirect:"+ client.getRegisteredRedirectUri().stream().findFirst().orElse("/login");
		}

	}
}
