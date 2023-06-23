/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.vtnSistemaDocente;
import gui.vtnSistemaTarea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jeanp
 */
public class vtnSistemaDocenteListener implements ActionListener{
    private vtnSistemaDocente vtnSistListener;
    
    public vtnSistemaDocenteListener(){}
    public vtnSistemaDocenteListener(vtnSistemaDocente vtnSistListener) {
        this.vtnSistListener = vtnSistListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarVtnTarea();
    }
    
    public void mostrarVtnTarea(){
        vtnSistemaTarea vtnPrueba = new vtnSistemaTarea();
        vtnPrueba.setVisible(true);
    }
    
}
