package ar.com.medicinas.authserver.vo;

import ar.com.medicinas.authserver.model.ProcessEnum;

import java.util.List;

public class EmailVO {
	private Object data;
	private ProcessEnum processName;
	private List<String> direcciones;
	private List<String> direccionesCC;
	private List<String> direccionesCCO;
	private String emailTemplate;

	public EmailVO(EmailVOBuilder emailVOBuilder) {
		this.data = emailVOBuilder.data;
		this.processName = emailVOBuilder.processName;
		this.direcciones = emailVOBuilder.direcciones;
		this.direccionesCC = emailVOBuilder.direccionesCC;
		this.direccionesCCO = emailVOBuilder.direccionesCCO;
		this.emailTemplate = emailVOBuilder.emailTemplate;
	}

	public static EmailVOBuilder builder() {
		return new EmailVOBuilder();
	}

	public Object getData() {
		return data;
	}

	public ProcessEnum getProcessName() {
		return processName;
	}

	public List<String> getDirecciones() {
		return direcciones;
	}

	public List<String> getDireccionesCC() {
		return direccionesCC;
	}

	public List<String> getDireccionesCCO() {
		return direccionesCCO;
	}

	public String getEmailTemplate() {
		return emailTemplate;
	}

	public static class EmailVOBuilder {
		private Object data;
		private ProcessEnum processName;
		private List<String> direcciones;
		private List<String> direccionesCC;
		private List<String> direccionesCCO;
		private String emailTemplate;

		public EmailVOBuilder data(Object data) {
			this.data = data;
			return this;
		}

		public EmailVOBuilder processName(ProcessEnum processName) {
			this.processName = processName;
			return this;
		}

		public EmailVOBuilder direcciones(List<String> direcciones) {
			this.direcciones = direcciones;
			return this;
		}

		public EmailVOBuilder direccionesCC(List<String> direccionesCC) {
			this.direccionesCC = direccionesCC;
			return this;
		}

		public EmailVOBuilder direccionesCCO(List<String> direccionesCCO) {
			this.direccionesCCO = direccionesCCO;
			return this;
		}

		public EmailVOBuilder emailTemplate(String emailTemplate) {
			this.emailTemplate = emailTemplate;
			return this;
		}

		public EmailVO build() {
			return new EmailVO(this);
		}
	}
}
