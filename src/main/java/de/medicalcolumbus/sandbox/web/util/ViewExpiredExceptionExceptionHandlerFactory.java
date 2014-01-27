package de.medicalcolumbus.sandbox.web.util;

/**
 * Creates instances of ViewExpiredExceptionExceptionHandler.
 * Based on Ed Burns blog: https://weblogs.java.net/blog/edburns/archive/2009/09/03/dealing-gracefully-viewexpiredexception-jsf2
 * @author chromyd
 */
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class ViewExpiredExceptionExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;

	public ViewExpiredExceptionExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler result = parent.getExceptionHandler();
		result = new ViewExpiredExceptionExceptionHandler(result);

		return result;
	}


}