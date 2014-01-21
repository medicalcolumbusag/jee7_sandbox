package de.medicalcolumbus.sandbox.service;

import javax.inject.Inject;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

/**
 * @author jucosorin
 * @author Octavian Sima
 */
@RunWith(Arquillian.class)
public abstract class BaseArquillianTest {

	@Inject
	protected UserTransaction utx;

	@Deployment
	public static WebArchive createDeployment() {
		final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackages(true, "com.tuorial")
				.addAsWebInfResource("META-INF/beans.xml", "beans.xml")
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml");

		return webArchive;
	}

}
