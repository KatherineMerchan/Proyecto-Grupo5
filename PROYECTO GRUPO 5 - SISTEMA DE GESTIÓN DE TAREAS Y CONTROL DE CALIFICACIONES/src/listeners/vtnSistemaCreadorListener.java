
package listeners;

import gui.vtnCrearDocente;
import gui.vtnCrearEstudiante;
import gui.vtnSistemaCreador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jeanp
 */
public class vtnSistemaCreadorListener implements ActionListener{
    private vtnSistemaCreador vtnListener; 
    
    public vtnSistemaCreadorListener(){}
    public vtnSistemaCreadorListener(vtnSistemaCreador vtnListener) {
        this.vtnListener = vtnListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object obj = e.getSource();
       if(obj == vtnListener.getBtnCrearEstudiante()){
           crearEstudiante();        
           return;            
       }
       if(obj == vtnListener.getBtnCrearDocente()){
           crearDocente();
       }
    }
    
    public void crearEstudiante(){
        vtnCrearEstudiante vtnCrearE = new vtnCrearEstudiante();
        vtnCrearE.setVisible(true);
        
    }
    public void crearDocente(){
        vtnCrearDocente vtnCrearD = new vtnCrearDocente();
        vtnCrearD.setVisible(true);
    }
    
}
