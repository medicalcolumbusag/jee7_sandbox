package de.medicalcolumbus.sandbox.web;

import de.medicalcolumbus.sandbox.domain.dao.EmployeeDetailsDao;
import de.medicalcolumbus.sandbox.domain.entity.EmployeeDetails;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by chromyd on 17/01/14.
 */
@ManagedBean
@RequestScoped
public class EmployeeDetailsBean {
    @EJB
    private EmployeeDetailsDao employeeDetailsDao;

    public List<EmployeeDetails> getAllUsEmployees() {
        return employeeDetailsDao.findByCountryId("US");
    }
}
