package ar.com.medicinas.authserver.dao;

import ar.com.medicinas.authserver.model.TimestampBean;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.List;

@NoRepositoryBean
public interface TimestampDao<T extends TimestampBean> {
	List<T> findAllByCreationDateBefore(LocalDateTime localDateTime);

	List<T> findAllByCreationDateAfter(LocalDateTime localDateTime);

	List<T> findAllByCreationDateBetween(LocalDateTime from, LocalDateTime to);

	List<T> findAllByLastUpdateBefore(LocalDateTime localDateTime);

	List<T> findAllByLastUpdateAfter(LocalDateTime localDateTime);

	List<T> findAllByLastUpdateBetween(LocalDateTime from, LocalDateTime to);
}
