package de.demo.logging;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

@ManagedBean(name = "helloWorldBean")
@RequestScoped
public class HelloWorldBean {

	/*
	 * //Transient keyword to produce non-serializable
	 * instances for injection into non-transient fields
	 * of passivating beans
	 * */
	@Inject
	private Logger log;

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	/* to test running index.xhtml*/
	@PostConstruct
	public void init() {

		log.info("HELLO WORLD INJECTED LOGGER WORKS!");

		msg = "Hello World!! JFS example...";
	}

}
