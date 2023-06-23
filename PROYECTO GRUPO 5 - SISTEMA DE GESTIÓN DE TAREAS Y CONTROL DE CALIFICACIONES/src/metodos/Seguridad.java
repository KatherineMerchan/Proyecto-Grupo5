/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import gui.vtnLogin;
import gui.vtnSistemaCreador;
import gui.vtnSistemaDocente;
import gui.vtnSistemaEstudiante;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Moreira
 */
public class Seguridad {

    String msg;
    private static Scanner scanner;

    public boolean validarUsuario(String usuarios[], String user, String pwd, int trys) {
        boolean found = false;
        try {
            for (int i = 0; i < usuarios.length; i++) {
                if ((usuarios[i].equals(user) && usuarios[i + 3].equals(pwd))) {
                    String Rol = usuarios[i + 4];
                    String Nombre = usuarios[i + 1];
                    msg = "¡Bienvenido " + Nombre + " :)!";
                    if ("Administrador".equals(Rol)) {
                        JOptionPane.showMessageDialog(null, msg + "\nUsted a ingresado como " + Rol, "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
                        vtnSistemaCreador vtnAdmin = new vtnSistemaCreador();
                        vtnAdmin.setVisible(true);
                    }
                    if ("Docente".equals(Rol)) {
                        JOptionPane.showMessageDialog(null, msg + "\nUsted a ingresado como " + Rol, "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
                        vtnSistemaDocente vtnDocente = new vtnSistemaDocente();
                        vtnDocente.setVisible(true);
                    }
                    if ("Estudiante".equals(Rol)) {
                        JOptionPane.showMessageDialog(null, msg + "\nUsted a ingresado como " + Rol, "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
                        vtnSistemaEstudiante vtnEstudiante = new vtnSistemaEstudiante();
                        vtnEstudiante.setVisible(true);
                    }

                    trys = 0;
                    return found = true;
                }
            }
        } catch (Exception e) {
        }

        if (found == false) {
            msg = "Clave y/o Usuarios erroneos " + trys + " intentos fallidos";
            JOptionPane.showMessageDialog(null, msg, "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
        }
        if (trys > 2) {
            JOptionPane.showMessageDialog(null, "Mas de 3 intentos fallidos, se procedera a cerrar", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return false;
    }

    public boolean ifexist(String usuarios[], String cedula) {
        boolean found = false;
        for (int i = 0; i < usuarios.length; i++) {
            if ((usuarios[i].equals(cedula))) {
                return found = true;
            }
        }
        return found;
    }

    public String getNombre() {
        FileReader filer = null;
        String usuario = null;
        try {
            int nLineas = 0;
            int i = 0;
            String[] usuarios = null;
            String linea;

            scanner = new Scanner(new File("Persona.txt"));
            File file = new File("Persona.txt");
            filer = new FileReader(file);
            BufferedReader br = new BufferedReader(filer);

            try {
                while ((linea = br.readLine()) != null) {
                    nLineas++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
            }

            usuarios = new String[nLineas];
            while (scanner.hasNextLine()) {
                usuarios[i++] = scanner.nextLine();
            }
            for (int u = 0; u < usuarios.length; u++) {
                if (vtnLogin.txtCedula.getText().equals(usuarios[u])) {
                    usuario = usuarios[u + 1];
                    return usuario;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
            return usuario;
        } finally {
            try {
                filer.close();
            } catch (IOException ex) {
                Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return usuario;
    }

    public String getApellido() {
        FileReader filer = null;
        String usuario = null;
        try {
            int nLineas = 0;
            int i = 0;
            String[] usuarios = null;
            String linea;

            scanner = new Scanner(new File("Persona.txt"));
            File file = new File("Persona.txt");
            filer = new FileReader(file);
            BufferedReader br = new BufferedReader(filer);

            try {
                while ((linea = br.readLine()) != null) {
                    nLineas++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
            }

            usuarios = new String[nLineas];
            while (scanner.hasNextLine()) {
                usuarios[i++] = scanner.nextLine();
            }
            for (int u = 0; u < usuarios.length; u++) {
                if (vtnLogin.txtCedula.getText().equals(usuarios[u])) {
                    usuario = usuarios[u + 2];
                    return usuario;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
            return usuario;
        } finally {
            try {
                filer.close();
            } catch (IOException ex) {
                Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }
}
