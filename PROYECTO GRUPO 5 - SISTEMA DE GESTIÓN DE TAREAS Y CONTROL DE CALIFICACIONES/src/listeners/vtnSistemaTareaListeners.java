package listeners;

import clases.Tarea;
import gui.vtnSistemaDocente;
import gui.vtnSistemaTarea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import metodos.Seguridad;
import metodos.getTarea;

/**
 *
 * @author jeanp
 */
public class vtnSistemaTareaListeners implements ActionListener {

    private vtnSistemaTarea vtnST;
    Tarea t = new Tarea();
    getTarea metodos = new getTarea();
    static File archivo;

    public vtnSistemaTareaListeners() {

    }

    public vtnSistemaTareaListeners(vtnSistemaTarea vtnST) {
        this.vtnST = vtnST;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == vtnST.getBtnAddFichero()) {
            adjuntarArchivo();
            return;
        }
        if (obj == vtnST.getBtnGuardar()) {
            int codigo = Integer.parseInt(vtnST.txtCodigo.getText());
            String nombre = vtnST.txtTituloTarea.getText();
            byte[] tarea = leerArchivo(archivo.getAbsoluteFile());
            String fechaC = vtnST.txtFechaCreacion.getText();
            String fechaE = vtnST.txtFechaEntrega.getText();
            String Desc = vtnST.txtaDescripcion.getText();
            Seguridad s = new Seguridad();            
            String profesor = s.getNombre().toUpperCase()+" "+s.getApellido().toUpperCase();

            t.setCodigo(codigo);
            t.setNombre(nombre);
            t.setArchivo(tarea);
            t.setFechaC(fechaC);
            t.setFechaE(fechaE);
            t.setDesc(Desc);
            t.setProfesor(profesor);
            t.setEstado("Sin Calificar");

            metodos.guardar(t);
            metodos.guardarArchivo(t);

            JOptionPane.showMessageDialog(null, "¡Tarea registrada correctamente!");            
            return;
        }
        if (obj == vtnST.getBtnCancelar()) {
            JOptionPane.showMessageDialog(vtnST, "Cambios no asignados");
            //System.exit(0);
            //mostrarVtnSistemaDocente();
        }
    }

    private void mostrarVtnSistemaDocente() {

    }

    private void adjuntarArchivo() {
        Scanner entrada = null;
        //Se crea el JFileChooser y se le indica que la ventana se abra en el directorio actual                    
        JFileChooser fileChooser = new JFileChooser(".");
        //Se crea el filtro. El primer parámetro es el mensaje que se muestra,
        //el segundo es la extensión de los ficheros que se van a mostrar      
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos PDF (.pdf)", "PDF");
        FileNameExtensionFilter filtro1 = new FileNameExtensionFilter("Arhivos JPG (.jpg)", "jpg");
        //Se le asigna al JFileChooser el filtro
        fileChooser.setFileFilter((javax.swing.filechooser.FileFilter) filtro);
        fileChooser.setFileFilter((javax.swing.filechooser.FileFilter) filtro1);
        //se muestra la ventana
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
            System.out.println("ruta: " + fileChooser.getCurrentDirectory());
            System.out.println("archivo: " + archivo.getName());
            vtnST.btnAddFichero.setText(archivo.getName());
            vtnST.btnAddFichero.setToolTipText(archivo.getName());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún fichero");
        }

    }

    public void guardar_archivo(int codigo, String nombre, byte[] archivo) {

    }

    public byte[] leerArchivo(File tarea) {
        try {
            byte[] icono = new byte[(int) tarea.length()];
            InputStream input = new FileInputStream(tarea);
            input.read(icono);
            return icono;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
            return null;
        }
    }

}
