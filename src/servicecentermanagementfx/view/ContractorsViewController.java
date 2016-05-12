/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecentermanagementfx.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import servicecentermanagementfx.dao.impl.ContractorDaoImpl;
import servicecentermanagementfx.datamodels.ContractorsViewModel;
import servicecentermanagementfx.entities.Contractor;
import servicecentermanagementfx.entities.ContractorCompany;
import servicecentermanagementfx.entities.ContractorPerson;
import servicecentermanagementfx.view.alerts.Alert;

/**
 * FXML Controller class
 *
 * @author Vitalie
 */
public class ContractorsViewController implements Initializable {

    private short isCompany() {
        return 1;
    }

    private short isPerson() {
        return 0;
    }
    ContractorDaoImpl dao = new ContractorDaoImpl();
    HashMap contractorDetails = new HashMap();
    private final ObservableList<ContractorsViewModel> tableData = FXCollections.observableArrayList();

    FilteredList<ContractorsViewModel> filteredData = new FilteredList<>(tableData, p -> true);

    ChangeListener<String> nameListener = (observable, oldValue, newValue) -> {
        filteredData.setPredicate(contractor -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if (contractor.getShortName().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (contractor.getFiscalCode().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (contractor.getVat().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            return false; // Does not match.
        });
    };

    ChangeListener<String> nameListenerPersons = (observable, oldValue, newValue) -> {
        filteredData.setPredicate(contractor -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = newValue.toLowerCase();
//                System.out.println(contractor);
            if (contractor.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches last name.
            } else if (contractor.getSurname().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (contractor.getPhoneNumber().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            return false; // Does not match.
        });
    };

    private static Integer idOfContratorBeingEdited = null;
    @FXML
    Label dbActionsLabel;
    @FXML
    TextField shortName;
    @FXML
    TextField fullName;
    @FXML
    TextField fiscalCode;
    @FXML
    TextField vat;
    @FXML
    TextField bankName;
    @FXML
    TextField bankAccount;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField address;
    @FXML
    TextField phoneNumberPerson;
    @FXML
    TextField filterTableTextfield;
    @FXML
    TextField addressPerson;
    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    Button add;
    @FXML
    Button edit;
    @FXML
    Button remove;
    @FXML
    TableView table;
    @FXML
    RadioButton all;

    @FXML
    RadioButton persons;
    @FXML
    ToggleButton company;
    @FXML
    ToggleButton person;
    @FXML
    VBox companyForm;
    @FXML
    VBox personForm;
    @FXML
    Button addOrUpdatePersonButton;
    @FXML
    Button addOrUpdateCompanyButton;
    @FXML
    Button choose;

    @FXML
    private void chooseContractor(){
        System.out.println("Id of contractor being edited:"+idOfContratorBeingEdited);
    }
    
    @FXML
    private void companyToggleButtonAction() {
        filterTableTextfield.clear();
        showCompanies();
        //companyForm.setVisible(true);
        //personForm.setVisible(false);
    }

    @FXML
    private void personToggleButtonAction() {
        filterTableTextfield.clear();
        showPersons();
        //companyForm.setVisible(false);
        //personForm.setVisible(true);
    }

    @FXML
    private void fillFormWithData() {
        emptyIdOfContractorBeingEdited();
        ContractorsViewModel contractor = (ContractorsViewModel) table.getSelectionModel().getSelectedItem();
//        System.out.println(contractor);
        try {
            idOfContratorBeingEdited = contractor.getIdValue();

//        System.out.println(idOfContratorBeingEdited);
            Contractor contractorFromDB = null;
            contractorFromDB = dao.findById(idOfContratorBeingEdited);

            if (contractorFromDB instanceof ContractorCompany) {
                personForm.setVisible(false);
                companyForm.setVisible(true);
                clearCompanyForm();
                shortName.setText(((ContractorCompany) contractorFromDB).getShortName());
                fullName.setText(((ContractorCompany) contractorFromDB).getFullName());
                fiscalCode.setText(((ContractorCompany) contractorFromDB).getFiscalCode());
                vat.setText(((ContractorCompany) contractorFromDB).getVAT());
                bankName.setText(((ContractorCompany) contractorFromDB).getBankName());
                bankAccount.setText(((ContractorCompany) contractorFromDB).getBankAccount());
                phoneNumber.setText(((ContractorCompany) contractorFromDB).getPhoneNumber());
                address.setText(((ContractorCompany) contractorFromDB).getAddress());
                addOrUpdateCompanyButton.setText("Update");
            } else if ((contractorFromDB instanceof ContractorPerson)) {
                companyForm.setVisible(false);
                personForm.setVisible(true);
                clearPersonForm();
                name.setText(((ContractorPerson) contractorFromDB).getName());
                surname.setText(((ContractorPerson) contractorFromDB).getSurname());
                phoneNumberPerson.setText(((ContractorPerson) contractorFromDB).getPhoneNumber());
                addressPerson.setText(((ContractorPerson) contractorFromDB).getAddress());
                addOrUpdatePersonButton.setText("Update");
            }
        } catch (NullPointerException ex) {
            System.out.println("apasat pe alaturi");
        }

    }

    public void emptyIdOfContractorBeingEdited() {
        if (idOfContratorBeingEdited != null) {
            idOfContratorBeingEdited = null;
        }
    }

    @FXML
    private void showCompanies() {
        //loading content for companies view
        updateTableData(true);

        //creating columns
        TableColumn idColumn = new TableColumn("ID");
        idColumn.setMinWidth(Double.valueOf("40"));
        idColumn.setMaxWidth(Double.valueOf("60"));
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        TableColumn shortNameColumn = new TableColumn("Short name");
        shortNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("shortName"));

        TableColumn fiscalCodeColumn = new TableColumn("Fiscal code");
        fiscalCodeColumn.setCellValueFactory(
                new PropertyValueFactory<>("fiscalCode"));

        TableColumn vatColumn = new TableColumn("VAT");
        vatColumn.setCellValueFactory(
                new PropertyValueFactory<>("vat"));

        //removing all current columns
        table.getColumns().clear();
        //adding required columns
        table.getColumns().addAll(idColumn, shortNameColumn, fiscalCodeColumn, vatColumn);
        //loading data to table
//        table.setItems(tableData);

        StringProperty observableField = filterTableTextfield.textProperty();
        observableField.removeListener(nameListenerPersons);
        observableField.addListener(nameListener);
//        observableField.removeListener(nameListener);

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<ContractorsViewModel> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table.setItems(sortedData);

    }

    @FXML
    private void showPersons() {
        //loading content for persons view
        updateTableData(false);
        //creating columns
        TableColumn idColumn = new TableColumn("ID");
        idColumn.setMinWidth(Double.valueOf("40"));
        idColumn.setMaxWidth(Double.valueOf("60"));
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        TableColumn surNameColumn = new TableColumn("Surname");
        surNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("surname"));
        TableColumn phoneNumberColumn = new TableColumn("Phone number");
        phoneNumberColumn.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber"));
        //removing all current columns
        table.getColumns().clear();
        //adding required columns
        table.getColumns().addAll(idColumn, nameColumn, surNameColumn, phoneNumberColumn);
        //loading data to table
//        table.setItems(tableData);
//        FilteredList<ContractorsViewModel> filteredData = new FilteredList<>(tableData, p -> true);
//        filterTableTextfield.textProperty().
        filterTableTextfield.textProperty().removeListener(nameListener);
        filterTableTextfield.textProperty().addListener(nameListenerPersons);

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<ContractorsViewModel> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table.setItems(sortedData);
    }

    private void clearCompanyForm() {

        for (Node node : companyForm.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setText("");
            }
        }
    }

    private void clearPersonForm() {

        for (Node node : personForm.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).setText("");
            }
        }
    }

    @FXML
    private void newCompanyButtonActionHandler() {
        showCompanies();
        companyForm.setVisible(true);
        clearCompanyForm();
        personForm.setVisible(false);
        emptyIdOfContractorBeingEdited();
        addOrUpdateCompanyButton.setText("Add");
    }

    @FXML
    private void newPersonButtonActionHandler() {
        showPersons();
        personForm.setVisible(true);
        clearPersonForm();
        companyForm.setVisible(false);
        emptyIdOfContractorBeingEdited();
        addOrUpdatePersonButton.setText("Add");
    }

    @FXML
    private void emptyFields() {
        if (companyForm.isVisible()) {
            clearCompanyForm();
        } else if (personForm.isVisible()) {
            clearPersonForm();
        }
    }

    @FXML
    private void removeButtonActionHandler() {
        Contractor contractorToBeRemoved = dao.findById(idOfContratorBeingEdited);
        dao.delete(contractorToBeRemoved);
        if (contractorToBeRemoved instanceof ContractorCompany) {
            Alert.resultOfDBOperation(dbActionsLabel, "Removed company!");
            newCompanyButtonActionHandler();
        } else if (contractorToBeRemoved instanceof ContractorPerson) {
            Alert.resultOfDBOperation(dbActionsLabel, "Removed company!");
            newPersonButtonActionHandler();
        }

    }

    @FXML
    private void addButtonActionHandler() throws IOException {
        Contractor contractorToBeAdded;
        if (idOfContratorBeingEdited != null) {
            contractorToBeAdded = dao.findById(idOfContratorBeingEdited);
//            System.out.println(contractorToBeAdded);
            if (contractorToBeAdded instanceof ContractorCompany) {
                ((ContractorCompany) contractorToBeAdded).setIsCompany(Boolean.TRUE);
                ((ContractorCompany) contractorToBeAdded).setShortName(shortName.getText());
                ((ContractorCompany) contractorToBeAdded).setFullName(fullName.getText());
                ((ContractorCompany) contractorToBeAdded).setFiscalCode(fiscalCode.getText());
                ((ContractorCompany) contractorToBeAdded).setVAT(vat.getText());
                ((ContractorCompany) contractorToBeAdded).setBankName(bankName.getText());
                ((ContractorCompany) contractorToBeAdded).setBankAccount(bankAccount.getText());
                ((ContractorCompany) contractorToBeAdded).setPhoneNumber(phoneNumber.getText());
                ((ContractorCompany) contractorToBeAdded).setAddress(address.getText());
                dao.update(contractorToBeAdded);
                Alert.resultOfDBOperation(dbActionsLabel, "Updated company!");
                showCompanies();
            } else if (contractorToBeAdded instanceof ContractorPerson) {
                ((ContractorPerson) contractorToBeAdded).setIsCompany(Boolean.FALSE);
                ((ContractorPerson) contractorToBeAdded).setName(name.getText());
                ((ContractorPerson) contractorToBeAdded).setSurname(surname.getText());
                ((ContractorPerson) contractorToBeAdded).setPhoneNumber(phoneNumberPerson.getText());
                ((ContractorPerson) contractorToBeAdded).setAddress(addressPerson.getText());
                dao.update(contractorToBeAdded);
                Alert.resultOfDBOperation(dbActionsLabel, "Updated person!");
                showPersons();
            }
        } else if (idOfContratorBeingEdited == null) {
            if (companyForm.isVisible()) {

                contractorToBeAdded = new ContractorCompany(shortName.getText(), fullName.getText(), fiscalCode.getText(), vat.getText(), bankName.getText(), bankAccount.getText(), Boolean.TRUE, phoneNumber.getText(), address.getText());
                try {
                    idOfContratorBeingEdited = dao.create(contractorToBeAdded);
                    Alert.resultOfDBOperation(dbActionsLabel, "Added company!");
                } catch (SQLException ex) {
                    Logger.getLogger(ContractorsViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                showCompanies();
                addOrUpdateCompanyButton.setText("Update");
            } else if (personForm.isVisible()) {
                contractorToBeAdded = new ContractorPerson(name.getText(), surname.getText(), Boolean.FALSE, phoneNumberPerson.getText(), addressPerson.getText());
                try {
                    idOfContratorBeingEdited = dao.create(contractorToBeAdded);
                    Alert.resultOfDBOperation(dbActionsLabel, "Added person!");
                } catch (SQLException ex) {
                    Logger.getLogger(ContractorsViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                showPersons();
                addOrUpdatePersonButton.setText("Update");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCompanies();

//        trebuie de terminat cu sortarea !!!!!!!!!
    }

    public void updateTableData(boolean isCompany) {
        tableData.clear();
        if (isCompany) {
            Collection<ContractorCompany> foundContractors;
            foundContractors = dao.findAllCompanies();
            for (ContractorCompany foundContractor : foundContractors) {
                ContractorsViewModel contractor;
                contractor = new ContractorsViewModel(foundContractor.getId(), foundContractor.getShortName(), foundContractor.getFiscalCode(), foundContractor.getVAT(), foundContractor.getPhoneNumber());
                tableData.add(contractor);
            }
        } else {
            Collection<ContractorPerson> foundContractors;
            foundContractors = dao.findAllPersons();
            for (ContractorPerson foundContractor : foundContractors) {
                ContractorsViewModel contractor;
                contractor = new ContractorsViewModel(foundContractor.getId(), foundContractor.getName(), foundContractor.getSurname(), foundContractor.getPhoneNumber());
                tableData.add(contractor);
            }
        }
    }
}
