package de.demos;

import static org.junit.Assert.assertEquals;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.junit.Test;

public class ResourcePropertiesTest {

	@Inject
	Logger log;

	@Test
	public void testResourceProperty() {

		ResourceBundle bundle = ResourceBundle.getBundle("resources");

		try {

			System.out.println(bundle.getString("test"));
			log.debug("test property: " + bundle.getString("test"));
			assertEquals(bundle.getString("test"), "This is a test property!");

		}
		catch (MissingResourceException e) {

			System.err.println(e);
		}
		finally {

			assertEquals(bundle.getString("test"), "This is a test property!");

		}

	}

}
