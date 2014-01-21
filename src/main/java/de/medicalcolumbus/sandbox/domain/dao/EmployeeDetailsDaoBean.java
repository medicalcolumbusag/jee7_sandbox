package de.medicalcolumbus.sandbox.domain.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.medicalcolumbus.sandbox.domain.entity.EmployeeDetails;

/**
 * Created by chromyd on 17/01/14.
 */
@Stateless
public class EmployeeDetailsDaoBean implements EmployeeDetailsDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EmployeeDetails> findByCountryId(String countryId) {
        return em.createNamedQuery("EmployeeDetails.findByCountryId", EmployeeDetails.class)
                .setParameter(1, countryId).getResultList();
    }
}
