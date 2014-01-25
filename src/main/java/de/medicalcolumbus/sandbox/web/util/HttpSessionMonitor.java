package de.medicalcolumbus.sandbox.web.util;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 * Monitors and logs session lifecycle events.
 * @author chromyd
 */
	@WebListener
	public class HttpSessionMonitor implements HttpSessionListener {
	@Inject
	private Logger log;

		public void sessionCreated(HttpSessionEvent event) {
			log.info("Session ID {} created at {}", event.getSession().getId(), new Date());
		}

		public void sessionDestroyed(HttpSessionEvent event) {
			log.info("Session ID {} destroyed at {}", event.getSession().getId(), new Date());
		}

	}

