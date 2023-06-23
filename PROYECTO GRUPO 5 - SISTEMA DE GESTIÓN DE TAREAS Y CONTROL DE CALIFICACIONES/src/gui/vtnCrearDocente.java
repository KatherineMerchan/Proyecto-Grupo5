package gui;

import clases.Persona;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import metodos.GetDocenteTxt;
import metodos.GetEstudianteTxt;
import metodos.Seguridad;

/**
 *
 * @author jeanp
 */
public class vtnCrearDocente extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JPanel pnlSur;
    private JPanel pnlNorte;
    private JPanel pnlCentro;
    private JPanel pnlCentroDatos;
    private JButton btnCrear;
    private JButton btnRegresar;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblCedula;
    private JLabel pass;
    private JLabel lblEdad;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCedula;
    private JPasswordField txtPass;
    private JTextField txtEdad;
    private JTable tblDocente;
    private JScrollPane scrTabla;
    private static Scanner sc;

    Persona alumno = new Persona();
    GetDocenteTxt metodos = new GetDocenteTxt();
    DefaultTableModel mdlTabla;
    Vector vCabeceras = new Vector();

    public vtnCrearDocente() {
        initComponents();
        addListeners();
        mostrar();
    }

    public void initComponents() {
        setTitle("Crear Docente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 650);
        setLocationRelativeTo(null);
        Font negrita = new Font("Segoe UI", Font.BOLD, 32);
        Font normal = new Font("Segoe UI", Font.PLAIN, 15);
        Font light = new Font("Segoe UI Light", Font.PLAIN, 18);
        Border line = BorderFactory.createLineBorder(java.awt.Color.GRAY);
        Border empty = new EmptyBorder(0, 10, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        pnlSur = new JPanel();
        contentPane.add(pnlSur, BorderLayout.SOUTH);

        btnCrear = new JButton("Registrar Docente");
        btnCrear.setBorder(BorderFactory.createEmptyBorder(3, 15, 8, 15));
        btnCrear.setBackground(java.awt.Color.GRAY);
        btnCrear.setForeground(java.awt.Color.white);
        btnCrear.setFont(normal);
        pnlSur.add(btnCrear);
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBorder(BorderFactory.createEmptyBorder(3, 15, 8, 15));
        btnRegresar.setBackground(java.awt.Color.GRAY);
        btnRegresar.setForeground(java.awt.Color.white);
        btnRegresar.setFont(normal);
        pnlSur.add(btnRegresar);
        pnlNorte = new JPanel();
        contentPane.add(pnlNorte, BorderLayout.NORTH);
        lblTitulo = new JLabel("<html><center>Ingrese los datos para<br>registrar a un Docente</center></html>");
        lblTitulo.setFont(negrita);
        pnlNorte.add(lblTitulo);
        pnlCentro = new JPanel(new GridLayout(2, 0));
        contentPane.add(pnlCentro, BorderLayout.CENTER);

        pnlCentroDatos = new JPanel(new GridLayout(3, 2, 0, 10));
        pnlCentroDatos.setBorder(BorderFactory.createEmptyBorder(70, 10, 70, 20));
        pnlCentro.add(pnlCentroDatos);
        lblCedula = new JLabel("    Cedula: ");
        lblCedula.setFont(normal);
        pnlCentroDatos.add(lblCedula);
        txtCedula = new JTextField();
        txtCedula.setBorder(border);
        txtCedula.setFont(normal);
        pnlCentroDatos.add(txtCedula);
        lblNombre = new JLabel("    Nombres: ");
        lblNombre.setFont(normal);
        pnlCentroDatos.add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBorder(border);
        txtNombre.setFont(normal);
        pnlCentroDatos.add(txtNombre);
        lblApellido = new JLabel("    Apellidos: ");
        lblApellido.setFont(normal);
        pnlCentroDatos.add(lblApellido);
        txtApellido = new JTextField();
        txtApellido.setBorder(border);
        txtApellido.setFont(normal);
        pnlCentroDatos.add(txtApellido);
        lblEdad = new JLabel("    Edad: ");
        lblEdad.setFont(normal);
        pnlCentroDatos.add(lblEdad);
        txtEdad = new JTextField();
        txtEdad.setBorder(border);
        txtEdad.setFont(normal);
        pnlCentroDatos.add(txtEdad);
        pass = new JLabel("    Contraseña: ");
        pass.setFont(normal);
        pnlCentroDatos.add(pass);
        txtPass = new JPasswordField();
        txtPass.setFont(normal);
        pnlCentroDatos.add(txtPass);

        vCabeceras.addElement("Cedula");
        vCabeceras.addElement("Nombre");
        vCabeceras.addElement("Apellido");
        vCabeceras.addElement("Edad");
        vCabeceras.addElement("Contraseña");
        vCabeceras.addElement("Rol");
        mdlTabla = new DefaultTableModel(vCabeceras, 0);

        scrTabla = new JScrollPane();
        pnlCentro.add(scrTabla);
        tblDocente = new JTable();
        tblDocente.setModel(mdlTabla);
        tblDocente.setRowHeight(30);

        scrTabla.setViewportView(tblDocente);

    }

    public void addListeners() {
        btnCrear.addActionListener(this);
        btnRegresar.addActionListener((e) -> {
            vtnSistemaCreador vPrincipal = new vtnSistemaCreador();
            vPrincipal.setVisible(true);
            this.dispose();
        });
        validatorCedula(txtCedula);
        validatorEdad(txtEdad);
        validatorTXT(txtApellido);
        validatorTXT(txtNombre);
    }

    private void validatorCedula(JTextField t) {
        t.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
                if (t.getText().length() > 9) {
                    e.consume();
                }
            }
        });
    }

    private void validatorEdad(JTextField t) {
        t.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
                if (t.getText().length() > 1) {
                    e.consume();
                }
                if ("0".equals(t.getText())) {
                    t.setText("");
                    e.consume();
                }
            }
        });
    }

    private void validatorTXT(JTextField t) {
        t.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (("".equals(txtCedula.getText()) || "".equals(txtNombre.getText()) || "".equals(txtApellido.getText())
                || "".equals(txtEdad.getText()) || "".equals(txtPass.getText()))) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtCedula.getText().length() < 9) {
            JOptionPane.showMessageDialog(null, "Numero de cédula incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            txtCedula.setText("");
        } else if ("0".equals(txtEdad.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese una edad correcta", "Error", JOptionPane.ERROR_MESSAGE);
            txtEdad.setText("");
        } else {
            FileReader fr = null;
            try {
                int nLineas = 0;
                int i = 0;
                String[] usuarios = null;
                String linea;

                sc = new Scanner(new File("Persona.txt"));
                File f = new File("Persona.txt");
                fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                try {
                    while ((linea = br.readLine()) != null) {
                        nLineas++;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(vtnLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

                usuarios = new String[nLineas];
                while (sc.hasNextLine()) {
                    usuarios[i++] = sc.nextLine();
                }
                Seguridad s = new Seguridad();
                if (s.ifexist(usuarios, txtCedula.getText())) {
                    System.out.println("datos comparados " + usuarios + "-" + txtCedula.getText());
                    JOptionPane.showMessageDialog(null, "Numero de cédula existente", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println("NO EXISTE :DDD");
                    String cedula = txtCedula.getText();
                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    int edad = Integer.parseInt(txtEdad.getText());
                    String contraseña = txtPass.getText();
                    String rol = "Docente";

                    alumno.setCedula(cedula);
                    alumno.setNombre(nombre);
                    alumno.setApellido(apellido);
                    alumno.setEdad(edad);
                    alumno.setPass(contraseña);
                    alumno.setRol(rol);

                    metodos.guardar(alumno);
                    metodos.guardarArchivo(alumno);

                    mostrar();

                    JOptionPane.showMessageDialog(null, "¡Docente registrado correctamente!");

                    txtCedula.setText("");
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtEdad.setText("");
                    txtPass.setText("");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(vtnLogin.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(vtnLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void mostrar() {
        tblDocente.setModel(metodos.listaDocentes());

    }
    
    public static void main(String[] args) {
        vtnCrearDocente vtnCD1 = new vtnCrearDocente();
        vtnCD1.setVisible(true);        
    }

}
