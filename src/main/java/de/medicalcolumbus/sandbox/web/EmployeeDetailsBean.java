package de.medicalcolumbus.sandbox.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import de.medicalcolumbus.sandbox.domain.dao.EmployeeDetailsDao;
import de.medicalcolumbus.sandbox.domain.entity.EmployeeDetails;

/**
 * Created by chromyd on 17/01/14.
 */
@ManagedBean
@RequestScoped
public class EmployeeDetailsBean {

    @Inject
    private EmployeeDetailsDao employeeDetailsDao;

    public List<EmployeeDetails> getAllUsEmployees() {
        return employeeDetailsDao.findByCountryId("US");
    }
}
