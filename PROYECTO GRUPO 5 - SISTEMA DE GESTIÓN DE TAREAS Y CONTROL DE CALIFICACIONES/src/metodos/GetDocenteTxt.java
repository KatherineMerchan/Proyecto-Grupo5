/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import clases.Persona;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class GetDocenteTxt {

    Vector vPrincipal = new Vector();

    public void guardar(Persona unDocente) {
        vPrincipal.addElement(unDocente);
    }

    public void guardarArchivo(Persona docente) {

        try {
            FileWriter fw = new FileWriter("Docentes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(docente.getCedula());
            pw.print("|" + docente.getNombre());
            pw.print("|" + docente.getApellido());
            pw.print("|" + docente.getEdad());
            pw.print("|" + docente.getPass());
            pw.println("|" + docente.getRol());
            pw.close();

            FileWriter fw1 = new FileWriter("Persona.txt", true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter(bw1);
            pw1.println();
            pw1.println(docente.getCedula());
            pw1.println(docente.getNombre());
            pw1.println(docente.getApellido());
            pw1.println(docente.getPass());
            pw1.println(docente.getRol());
            pw1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public DefaultTableModel listaDocentes() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("Cedula");
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Apellido");
        cabeceras.addElement("Edad");
        cabeceras.addElement("Contraseña");
        cabeceras.addElement("Rol");
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras, 0);
        try {
            FileReader fr = new FileReader("Docentes.txt");
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
