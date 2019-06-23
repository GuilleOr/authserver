package ar.com.medicinas.authserver.service.impl;

import ar.com.medicinas.authserver.model.TimestampBean;

import java.time.LocalDateTime;

public class TimestampBeanService<T extends TimestampBean> {
	protected T prepareToCreate(T baseBean) {
		baseBean.setCreationDate(LocalDateTime.now());
		baseBean.setLastUpdate(LocalDateTime.now());
		return baseBean;
	}

	protected T prepareToUpdate(T baseBean) {
		baseBean.setLastUpdate(LocalDateTime.now());
		return baseBean;
	}
}
