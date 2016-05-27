/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecentermanagementfx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Vitalie
 */
public class ServiceCenterManagementFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
        /**
         * @param args the command line arguments
         */
    public static void main(String[] args) {
            launch(args);


    }

}
