/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import clases.Persona;
import clases.Tarea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class getTarea {

    Vector vPrincipal = new Vector();

    public void guardar(Tarea tarea) {
        vPrincipal.addElement(tarea);
    }

    public void guardarArchivo(Tarea tarea) {
        try {
            FileWriter fw = new FileWriter("Tareas.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(tarea.getCodigo());
            pw.print("|" + tarea.getNombre());
            pw.print("|" + Arrays.toString(tarea.getArchivo()));
            pw.print("|" + tarea.getFechaC());
            pw.print("|" + tarea.getFechaE());
            pw.print("|" + tarea.getDesc());
            pw.print("|" + tarea.getProfesor());
            pw.println("|" + tarea.getEstado());

            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public DefaultTableModel listaTareas() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("Codigo");
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Archivo");
        cabeceras.addElement("Fecha Creacion");
        cabeceras.addElement("Fecha Entrega");
        cabeceras.addElement("Descripcion");
        cabeceras.addElement("Profesor");
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras, 0);
        try {
            FileReader fr = new FileReader("Tareas.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(d, "|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()) {
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return mdlTabla;
    }
}
