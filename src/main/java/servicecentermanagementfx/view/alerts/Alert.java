/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecentermanagementfx.view.alerts;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author Vitalie
 */
public class Alert {

    public static void resultOfDBOperation(Label dbActionsLabel,String message) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                dbActionsLabel.setText(message);
                            }
                        }
                ),
                new KeyFrame(Duration.seconds(3),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                dbActionsLabel.setText("");
                            }
                        })
        );
        timeline.setCycleCount(1);
        timeline.play();
    }
}
