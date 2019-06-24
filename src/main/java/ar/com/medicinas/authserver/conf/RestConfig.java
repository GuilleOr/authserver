package ar.com.medicinas.authserver.conf;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
@EnableOAuth2Client
public class RestConfig {

	private static final Logger LOG = LoggerFactory.getLogger(RestConfig.class);
	@Value("${oauth.resource:http://localhost:8082}")
	private String baseUrl;
	@Value("${oauth.authorize:http://localhost:8082/oauth/authorize}")
	private String authorizeUrl;
	@Value("${oauth.token:http://localhost:8082/oauth/token}")
	private String tokenUrl;
	@Value("${med.auth-server.userId}")
	private String clientInfo;
	@Value("${med.auth-server.userSecret}")
	private String clientSecret;
	@Value("${config.timeout.generic:30000}")
	private Integer timeout;

	@Bean
	public RestTemplate commonRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public HttpLoggingInterceptor httpLoggingInterceptor() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);
		return logging;
	}

	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient.Builder()
				.addInterceptor(httpLoggingInterceptor())
				.build();
	}

	@Bean("emailServiceRestTemplate")
	public RestTemplate emailServiceRestTemplate() {
		LOG.info("Timeout Connect Email server: " + this.timeout);
		LOG.info("Timeout Read Email server: " + this.timeout);
		OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory(okHttpClient());
		requestFactory.setConnectTimeout(timeout);
		requestFactory.setReadTimeout(timeout);
		return new RestTemplate(requestFactory);
	}

	@Bean
	@Scope("prototype")
	public RestTemplate userRestTemplateAuthServer() {
		LOG.info("Timeout Connect Auth server: " + this.timeout);
		LOG.info("Timeout Read Auth server: " + this.timeout);
		OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory(okHttpClient());
		requestFactory.setConnectTimeout(timeout);
		requestFactory.setReadTimeout(timeout);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_FORM_URLENCODED));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		return restTemplate;
	}

}

