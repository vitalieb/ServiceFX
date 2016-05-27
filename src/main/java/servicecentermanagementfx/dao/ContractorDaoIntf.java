/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecentermanagementfx.dao;

import java.sql.SQLException;
import java.util.Collection;
import servicecentermanagementfx.entities.Contractor;
import servicecentermanagementfx.entities.ContractorCompany;
import servicecentermanagementfx.entities.ContractorPerson;

/**
 *
 * @author Vitalie
 */
public interface ContractorDaoIntf {
    
    //CRUD
    int create(Contractor departament) throws SQLException;
    void update(Contractor departament);
    void delete(Contractor departament);
    
    Contractor findById(int departamentId);
    Collection<Contractor> findAll();
    Collection<ContractorPerson> findAllPersons();
    Collection<ContractorCompany> findAllCompanies();
}
