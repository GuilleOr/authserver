package ar.com.medicinas.authserver.service.impl;

import ar.com.medicinas.authserver.model.LogicalDeleteableBean;
import lombok.Data;

@Data
public abstract class LogicalDeleteableBeanService<T extends LogicalDeleteableBean> extends BaseBeanService<T> {
	protected T prepareToCreate(T baseBean) {
		baseBean.setActive(true);
		return super.prepareToCreate(baseBean);
	}
}
