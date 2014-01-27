package de.medicalcolumbus.sandbox.web.bean;


import org.slf4j.Logger;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

/**
 * Provides an application wide exception handling functionality. For every exception that propagates to the frontend
 * it is responsible for:
 * <ul>creating a token that will be displayed to the user</ul>
 * <ul>logging the exception together with the token</ul>
 * @author chromyd
 */
@Named
@RequestScoped
public class ErrorBean {
	@Inject
	Logger log;

	public String getLogToken() {
		String token= UUID.randomUUID().toString();
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, Object> req = fc.getExternalContext().getRequestMap();
		Throwable ex = (Throwable) req.get("javax.servlet.error.exception");
		log.error("token " + token, ex);
		return token;
	}
}
