package de.demos;

import static org.junit.Assert.assertEquals;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.junit.Test;

public class ResourcePropertiesTest {

	@Test
	public void testResourceProperty() {

		ResourceBundle bundle = ResourceBundle.getBundle("resources");

		try {

		System.out.println(bundle.getString("test"));
		}
		catch (MissingResourceException e) {

			System.err.println(e);
		}
		finally {
			assertEquals(bundle.getString("test"), "This is a test property!");
		}

	}

}
