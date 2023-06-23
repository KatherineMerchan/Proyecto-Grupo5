
//package listeners;
//
//import clases.Persona;
//import giu.vtnCrearEstudiante;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import javax.swing.JTextField;
///**
// *
// * @author jeanp
// */
//public class vtnCrearEstudianteListener implements ActionListener{
//    private vtnCrearEstudiante vtnCrearListener;
//    
//    public vtnCrearEstudianteListener(){}
//    public vtnCrearEstudianteListener(vtnCrearEstudiante vtnCrearListener) {
//        this.vtnCrearListener = vtnCrearListener;
//        
//    }    
//    
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object obj = e.getSource();
//        if(obj == vtnCrearListener.getBtnCrear()){
//            crear();
//            return;
//        }
//        if(obj == vtnCrearListener.getBtnSalir()){
//            System.exit(0);
//            //regresar();
//        }
//    }
//    
//    ArrayList<Persona> lista = new ArrayList<Persona>();
//    public void crear(){
//        Persona person = new Persona(txtCedula.getText(), txtNombre.getText(), txtApellido.getText());
//        lista.add(person);
//        
//        mostrar();
//        //person.getCedula(txtCedula);
//    }
//    
//    public void mostrar(){
//        String matris [][]= new String[lista.size()][3];
//        
//        for (int i = 0; i < lista.size(); i++) {
//            matris[i][0]=lista.get(i).getCedula();
//            matris[i][1]=lista.get(i).getNombre(); 
//            matris[i][2]=lista.get(i).getApellido(); 
//        }
//        
//        tblEstudiante.setModel(new javax.swing.table.DefaultTableModel(
//                matris,
//                new String []{
//                    "Cedula","Nomres","Apellidos"
//                }
//        ));
//        
//    }
//}
