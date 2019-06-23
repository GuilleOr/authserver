package ar.com.medicinas.authserver.dao;

import ar.com.medicinas.authserver.model.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.Optional;

@NoRepositoryBean
public interface BaseBeanDao<T extends BaseBean> extends JpaRepository<T, Long>, TimestampDao<T> {
	Optional<T> findById(Long id);

	Optional<T> findByUuid(String uuid);

	Optional<T> findByUuidAndCreationDateAfter(String uuid, LocalDateTime date);

	void deleteByUuid(String uuid);
}
