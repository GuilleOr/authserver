package ar.com.medicinas.authserver.rest.mapper;

import ar.com.medicinas.authserver.model.User;
import ar.com.medicinas.authserver.rest.dto.CreateUserRequest;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements OrikaMapperFactoryConfigurer {
	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		configureCreateUserRequestToUser(orikaMapperFactory);
	}

	private void configureCreateUserRequestToUser(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(User.class, CreateUserRequest.class)
				.field("name", "name")
				.field("documentNumber", "documentNumber")
				.field("documentType.id", "documentTypeId")
				.field("userType", "userType")
				.field("password", "password")
				.field("email", "email")
				.field("username", "username")
				.byDefault()
				.register();
	}
}
