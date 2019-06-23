package ar.com.medicinas.authserver.service;

import ar.com.medicinas.authserver.model.ProcessEnum;

import java.util.List;

public interface EmailService {
	void sendEmail(Object data, String emailTemplate, ProcessEnum processEnum, List<String> direcciones, List<String> direccionesCC, List<String> direccionesCCO);
}
