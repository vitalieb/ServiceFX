/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecentermanagementfx.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicecentermanagementfx.DataSource;
import servicecentermanagementfx.dao.ContractorDaoIntf;
import servicecentermanagementfx.entities.Contractor;
import servicecentermanagementfx.entities.ContractorCompany;
import servicecentermanagementfx.entities.ContractorPerson;

/**
 *
 * @author Vitalie
 */
public class ContractorDaoImpl implements ContractorDaoIntf {

    private static final Logger LOG = Logger.getLogger(ContractorDaoImpl.class.getName());

    private final DataSource ds = DataSource.getInstance();
    private Connection conn;

    @Override
    public int create(Contractor contractor) throws SQLException {
        //   trebuie de adaugat cod care pune id la Contractor cu ajutorul la setId()
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);

            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            String db = props.getProperty("jdbc.db");

            Statement stat = conn.createStatement();
            String sql = "";

            if (contractor instanceof ContractorCompany) {

                sql = "INSERT INTO `" + db + "`.`contractors` (`isCompany`, `phoneNumber`, `address`, `shortName`, `fullName`, `fiscalCode`, `VAT`, `bankName`, `bankAccount`) VALUES (?,?,?,?,?,?,?,?,?);";
                PreparedStatement pstat = conn.prepareStatement(sql);

                pstat.setInt(1, 1);
                pstat.setString(2, ((ContractorCompany) contractor).getPhoneNumber());
                pstat.setString(3, ((ContractorCompany) contractor).getAddress());
                pstat.setString(4, ((ContractorCompany) contractor).getShortName());
                pstat.setString(5, ((ContractorCompany) contractor).getFullName());
                pstat.setString(6, ((ContractorCompany) contractor).getFiscalCode());
                pstat.setString(7, ((ContractorCompany) contractor).getVAT());
                pstat.setString(8, ((ContractorCompany) contractor).getBankName());
                pstat.setString(9, ((ContractorCompany) contractor).getBankAccount());

                pstat.executeUpdate();
                conn.commit();

            } else if (contractor instanceof ContractorPerson) {
                sql = "INSERT INTO `" + db + "`.`contractors` (`isCompany`, `phoneNumber`, `address`, `name`, `surname`) VALUES (?,?,?,?,?);";
                PreparedStatement pstat = conn.prepareStatement(sql);

                pstat.setInt(1, 0);
                pstat.setString(2, contractor.getPhoneNumber());
                pstat.setString(3, contractor.getAddress());
                pstat.setString(4, ((ContractorPerson) contractor).getName());
                pstat.setString(5, ((ContractorPerson) contractor).getSurname());

                pstat.executeUpdate();
                conn.commit();
            }

            sql = "SELECT LAST_INSERT_ID()";
            PreparedStatement pstat2 = conn.prepareStatement(sql);
            ResultSet resultSet;
            resultSet = pstat2.executeQuery();
            while (resultSet.next()) {
                contractor.setId(resultSet.getInt(1));
            }
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not INSERT", ex);
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Rollback problem!", ex2);
            }
            throw new SQLException(ex);

        } catch (IOException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Properties file exception!", ex);
        } finally {
            try {
                ds.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not close connection", ex);
            }
        }
    return contractor.getId();
    }

    @Override
    public void update(Contractor contractor) {
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);

            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            String db = props.getProperty("jdbc.db");

            Statement stat = conn.createStatement();
            String sql = "";

            if (contractor instanceof ContractorCompany) {

                sql = "UPDATE `" + db + "`.`contractors` SET `isCompany`=?, `phoneNumber`=?, `address`=?, `shortName`=?, `fullName`=?, `fiscalCode`=?, `VAT`=?, `bankName`=?, `bankAccount`=? WHERE `idcontractors`=? ;";
                PreparedStatement pstat = conn.prepareStatement(sql);

                pstat.setInt(1, 1);
                pstat.setString(2, ((ContractorCompany) contractor).getPhoneNumber());
                pstat.setString(3, ((ContractorCompany) contractor).getAddress());
                pstat.setString(4, ((ContractorCompany) contractor).getShortName());
                pstat.setString(5, ((ContractorCompany) contractor).getFullName());
                pstat.setString(6, ((ContractorCompany) contractor).getFiscalCode());
                pstat.setString(7, ((ContractorCompany) contractor).getVAT());
                pstat.setString(8, ((ContractorCompany) contractor).getBankName());
                pstat.setString(9, ((ContractorCompany) contractor).getBankAccount());
                pstat.setInt(10, ((ContractorCompany) contractor).getId());

                pstat.executeUpdate();
                conn.commit();

            } else if (contractor instanceof ContractorPerson) {
                sql = "UPDATE `" + db + "`.`contractors` SET `isCompany`=?, `phoneNumber`=?, `address`=?, `name`=?, `surname`=? WHERE `idcontractors`=? ;";
                PreparedStatement pstat = conn.prepareStatement(sql);

                pstat.setInt(1, 0);
                pstat.setString(2, ((ContractorPerson) contractor).getPhoneNumber());
                pstat.setString(3, ((ContractorPerson) contractor).getAddress());
                pstat.setString(4, ((ContractorPerson) contractor).getName());
                pstat.setString(5, ((ContractorPerson) contractor).getSurname());
                pstat.setInt(6, ((ContractorPerson) contractor).getId());

                pstat.executeUpdate();
                conn.commit();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not UPDATE", ex);
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Rollback problem!", ex2);
            }
        } catch (IOException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Properties file exception!", ex);
        } finally {
            try {
                ds.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not close connection", ex);
            }
        }
    }

    @Override
    public void delete(Contractor contractor) {
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);

            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            String db = props.getProperty("jdbc.db");

            Statement stat = conn.createStatement();
            String sql = "";

            sql = "DELETE FROM `" + db + "`.`contractors` WHERE `idcontractors`=? ;";
            PreparedStatement pstat = conn.prepareStatement(sql);

            pstat.setInt(1, contractor.getId());

            pstat.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not DELETE", ex);
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Rollback problem!", ex2);
            }
        } catch (IOException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Properties file exception!", ex);
        } finally {
            try {
                ds.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not close connection", ex);
            }
        }
    }

    @Override
    public Contractor findById(int contractorId) {

        Contractor contractorFromDB = null;

        try {
            conn = ds.getConnection();

            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            String db = props.getProperty("jdbc.db");

            Statement stat = conn.createStatement();

            String sql = "SELECT * FROM `" + db + "`.`contractors` WHERE `idcontractors`=" + contractorId + " ;";
            ResultSet rs = stat.executeQuery(sql);

            if (rs.next()) {
                if (rs.getInt(2) == 1) {
                    String shortName = rs.getString(5);
                    String fullName = rs.getString(6);
                    String fiscalCode = rs.getString(7);
                    String VAT = rs.getString(8);
                    String bankName = rs.getString(9);
                    String bankAccount = rs.getString(10);
                    Boolean isCompany = true;
                    String phoneNumber = rs.getString(3);
                    String address = rs.getString(4);
                    Integer id = rs.getInt(1);
                    contractorFromDB = new ContractorCompany(shortName, fullName, fiscalCode, VAT, bankName, bankAccount, id, isCompany, phoneNumber, address);
                } else if (rs.getInt(2) == 0) {
                    String name = rs.getString(11);
                    String surname = rs.getString(12);
                    Boolean isCompany = false;
                    String phoneNumber = rs.getString(3);
                    String address = rs.getString(4);
                    Integer id = rs.getInt(1);
                    contractorFromDB = new ContractorPerson(name, surname, id, isCompany, phoneNumber, address);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not FIND BY ID", ex);
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Rollback problem!", ex2);
            }
        } catch (IOException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Properties file exception!", ex);
        } finally {
            try {
                ds.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not close connection", ex);
            }
        }
        return contractorFromDB;
    }

    @Override
    public Collection<Contractor> findAll() {

        Contractor contractorFromDB = null;
        Collection<Contractor> contractors = new ArrayList();

        try {
            conn = ds.getConnection();

            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            String db = props.getProperty("jdbc.db");

            Statement stat = conn.createStatement();

            String sql = "SELECT * FROM `" + db + "`.`contractors`;";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                if (rs.getInt(2) == 1) {
                    String shortName = rs.getString(5);
                    String fullName = rs.getString(6);
                    String fiscalCode = rs.getString(7);
                    String VAT = rs.getString(8);
                    String bankName = rs.getString(9);
                    String bankAccount = rs.getString(10);
                    Boolean isCompany = true;
                    String phoneNumber = rs.getString(3);
                    String address = rs.getString(4);
                    Integer id = rs.getInt(1);
                    contractorFromDB = new ContractorCompany(shortName, fullName, fiscalCode, VAT, bankName, bankAccount, id, isCompany, phoneNumber, address);
                    contractors.add(contractorFromDB);
                } else if (rs.getInt(2) == 0) {
                    String name = rs.getString(11);
                    String surname = rs.getString(12);
                    Boolean isCompany = false;
                    String phoneNumber = rs.getString(3);
                    String address = rs.getString(4);
                    Integer id = rs.getInt(1);
                    contractorFromDB = new ContractorPerson(name, surname, id, isCompany, phoneNumber, address);
                    contractors.add(contractorFromDB);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not FIND BY ID", ex);
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Rollback problem!", ex2);
            }
        } catch (IOException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Properties file exception!", ex);
        } finally {
            try {
                ds.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not close connection", ex);
            }
        }

        return contractors;
    }

    @Override
    public Collection<ContractorPerson> findAllPersons() {

        ContractorPerson contractorFromDB = null;
        Collection<ContractorPerson> contractors = new ArrayList();

        try {
            conn = ds.getConnection();

            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            String db = props.getProperty("jdbc.db");

            Statement stat = conn.createStatement();

            String sql = "SELECT * FROM `" + db + "`.`contractors` WHERE `isCompany`=0;";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {

                String name = rs.getString(11);
                String surname = rs.getString(12);
                Boolean isCompany = false;
                String phoneNumber = rs.getString(3);
                String address = rs.getString(4);
                Integer id = rs.getInt(1);
                contractorFromDB = new ContractorPerson(name, surname, id, isCompany, phoneNumber, address);
                contractors.add(contractorFromDB);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not FIND BY ID", ex);
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Rollback problem!", ex2);
            }
        } catch (IOException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Properties file exception!", ex);
        } finally {
            try {
                ds.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not close connection", ex);
            }
        }

        return contractors;
    }

    @Override
    public Collection<ContractorCompany> findAllCompanies() {
        ContractorCompany contractorFromDB = null;
        Collection<ContractorCompany> contractors = new ArrayList();

        try {
            conn = ds.getConnection();

            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            String db = props.getProperty("jdbc.db");

            Statement stat = conn.createStatement();

            String sql = "SELECT * FROM `" + db + "`.`contractors` WHERE `isCompany`=1;";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String shortName = rs.getString(5);
                String fullName = rs.getString(6);
                String fiscalCode = rs.getString(7);
                String VAT = rs.getString(8);
                String bankName = rs.getString(9);
                String bankAccount = rs.getString(10);
                Boolean isCompany = true;
                String phoneNumber = rs.getString(3);
                String address = rs.getString(4);
                Integer id = rs.getInt(1);
                contractorFromDB = new ContractorCompany(shortName, fullName, fiscalCode, VAT, bankName, bankAccount, id, isCompany, phoneNumber, address);
                contractors.add(contractorFromDB);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not FIND BY ID", ex);
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Rollback problem!", ex2);
            }
        } catch (IOException ex) {
            Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Properties file exception!", ex);
        } finally {
            try {
                ds.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContractorDaoImpl.class.getName()).log(Level.SEVERE, "Could not close connection", ex);
            }
        }

        return contractors;
    }
}
