/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import clases.Persona;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class GetEstudianteTxt {

    Vector vPrincipal = new Vector();

    public void guardar(Persona unAlumno) {
        vPrincipal.addElement(unAlumno);
    }

    public void guardarArchivo(Persona alumno) {
        try {
            FileWriter fw = new FileWriter("Estudiantes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(alumno.getCedula());
            pw.print("|" + alumno.getNombre());
            pw.print("|" + alumno.getApellido());
            pw.print("|" + alumno.getEdad());
            pw.print("|" + alumno.getPass());
            pw.println("|" + alumno.getRol());
            pw.close();

            FileWriter fw1 = new FileWriter("Persona.txt", true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter(bw1);
            pw1.println();
            pw1.println(alumno.getCedula());
            pw1.println(alumno.getNombre());
            pw1.println(alumno.getApellido());
            pw1.println(alumno.getPass());
            pw1.println(alumno.getRol());
            pw1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public DefaultTableModel listaAlumnos() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("Cedula");
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Apellido");
        cabeceras.addElement("Edad");
        cabeceras.addElement("Contraseña");
        cabeceras.addElement("Rol");
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras, 0);
        try {
            FileReader fr = new FileReader("Estudiantes.txt");
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
