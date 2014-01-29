package de.medicalcolumbus.sandbox.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
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

	@PersistenceContext
	protected EntityManager em;

	@Deployment
	public static WebArchive createDeployment() {

		final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackage("de.demo.logging")
				.addPackages(true,"de.medicalcolumbus.sandbox.domain")
				.addPackages(true, "de.medicalcolumbus.sandbox.domain.dao")
					.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("glassfish-resources.xml", "glassfish-resources.xml")
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml");

		return webArchive;
	}


}
