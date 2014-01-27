package de.medicalcolumbus.sandbox.web.util;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import java.util.Iterator;

/**
 * Handles ViewExpiredExceptionException by redirecting to a specific error page.
 * Based on Ed Burns blog: https://weblogs.java.net/blog/edburns/archive/2009/09/03/dealing-gracefully-viewexpiredexception-jsf2
 *
 * @author chromyd
 */
public class ViewExpiredExceptionExceptionHandler extends ExceptionHandlerWrapper {
	private ExceptionHandler wrapped;

	public ViewExpiredExceptionExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext(); ) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			if (context.getException() instanceof ViewExpiredException) {
				FacesContext fc = FacesContext.getCurrentInstance();
				NavigationHandler nav =
						fc.getApplication().getNavigationHandler();
				try {
					nav.handleNavigation(fc, null, "viewExpired");
					fc.renderResponse();
				} finally {
					i.remove();
				}
			}
		}
		// At this point, the queue will not contain any ViewExpiredEvents.
		// Therefore, let the parent handle them.
		getWrapped().handle();
	}
}
