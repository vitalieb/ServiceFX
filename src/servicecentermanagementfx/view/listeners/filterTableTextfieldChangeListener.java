/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecentermanagementfx.view.listeners;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Vitalie
 */
public class filterTableTextfieldChangeListener implements ChangeListener {
    
    private ObservableValue observable;
    private Object oldValue;
    private Object newValue;
    
    public filterTableTextfieldChangeListener(ObservableValue observable, Object oldValue, Object newValue) {
        this.observable = observable;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
    
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
    
        
        
    }

    
}
