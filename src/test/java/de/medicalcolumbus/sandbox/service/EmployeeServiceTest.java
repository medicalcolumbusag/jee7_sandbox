package de.medicalcolumbus.sandbox.service;

import static org.hamcrest.core.Is.is;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tutorial.Employee;
import com.tutorial.EmployeeMgr;
import com.tutorial.qualifiers.EmployeeBeanQ;

/**
 * @author laura.liparulo
 */
@RunWith(Arquillian.class)
public class EmployeeServiceTest {

	@Inject @EmployeeBeanQ
	EmployeeMgr employeeService;

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "employee.war")
				.addPackage( "com.tutorial")
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void getAll() throws Exception {

		List<Employee> employees = employeeService.findAll();

		for (Employee employee: employees){
			System.out.println(employee.getFirstName()+" "+employee.getLastName());
		}

		Assert.assertThat(employees.size(), is(3));
	}

}
