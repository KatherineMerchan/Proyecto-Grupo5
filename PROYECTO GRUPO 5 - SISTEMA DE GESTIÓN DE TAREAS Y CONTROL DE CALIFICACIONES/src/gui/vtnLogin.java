package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.scene.paint.Color;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import metodos.Seguridad;

/**
 *
 * @author jeanp
 */
public class vtnLogin extends JFrame {

    private JPanel contentPane;
    private JPanel pnlNorte;
    private JPanel pnlSur;
    private JPanel pnlCentro;
//    private JPanel pnlCentro1;
//    private JPanel pnlCentro2;
    private JLabel lblTitulo;
    private JLabel lblCedula;
    private JLabel lblPass;
    public JPasswordField pswPass;
    public static JTextField txtCedula;
    private JButton btnIngresar;

    private static Scanner sc;
    private static int trys;
    private static String user, pass;

    public vtnLogin() {
        initComponents();
        addListeners();
    }

    public void addListeners() {
        btnIngresar.addActionListener((e) -> {
            ingresar();
        });

    }

    public void initComponents() {
        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 370);
        setLocationRelativeTo(null);
        setResizable(false);
        Font negrita = new Font("Segoe UI", Font.BOLD, 38);
        Font normal = new Font("Segoe UI", Font.PLAIN, 15);
        Font light = new Font("Segoe UI Light", Font.PLAIN, 18);
        Border line = BorderFactory.createLineBorder(java.awt.Color.GRAY);
        Border empty = new EmptyBorder(0, 10, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        pnlNorte = new JPanel();
        pnlNorte.setBorder(new EmptyBorder(0, 0, 50, 0));
        contentPane.add(pnlNorte, BorderLayout.NORTH);
        lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setFont(negrita);
        pnlNorte.add(lblTitulo);

        pnlSur = new JPanel();
        pnlSur.setBorder(new EmptyBorder(0, 0, 50, 0));
        contentPane.add(pnlSur, BorderLayout.SOUTH);
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(3, 15, 8, 15));
        btnIngresar.setBackground(java.awt.Color.GRAY);
        btnIngresar.setForeground(java.awt.Color.white);
        btnIngresar.setFont(normal);
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlSur.add(btnIngresar);

        pnlCentro = new JPanel(new GridLayout(3, 2, 0, 20));
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

        contentPane.add(pnlCentro, BorderLayout.CENTER);

        lblCedula = new JLabel("Usuario:");
        lblCedula.setFont(normal);
        pnlCentro.add(lblCedula);
        txtCedula = new JTextField();
        txtCedula.setBorder(border);
        txtCedula.setFont(normal);

        pnlCentro.add(txtCedula);
        lblPass = new JLabel("Contraseña:");
        lblPass.setFont(normal);
        pnlCentro.add(lblPass);
        pswPass = new JPasswordField();
        pswPass.setBorder(border);
        pnlCentro.add(pswPass);

        txtCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ev) {
                if (ev.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (ingresar() == false) {
                        txtCedula.setText("");
                    }
                }
            }
        });
        pswPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ev) {
                if (ev.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (ingresar() == false) {
                        pswPass.setText("");
                    }
                }
            }
        });
        btnIngresar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ev) {
                if (ev.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (ingresar() == false) {
                        pswPass.setText("");
                        txtCedula.setText("");
                    }
                }
            }
        });
    }

    public JLabel getLblCedula() {
        return lblCedula;
    }

    public void setLblCedula(JLabel lblCedula) {
        this.lblCedula = lblCedula;
    }

    public JLabel getLblPass() {
        return lblPass;
    }

    public void setLblPass(JLabel lblPass) {
        this.lblPass = lblPass;
    }

    public JPasswordField getPswPass() {
        return pswPass;
    }

    public void setPswPass(JPasswordField pswPass) {
        this.pswPass = pswPass;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(JButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public boolean ingresar() {
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

            trys++;
            user = txtCedula.getText();
            pass = pswPass.getText();

            Seguridad s = new Seguridad();
            if (s.validarUsuario(usuarios, user, pass, trys) == true) {
                this.dispose();
                return true;
            } else {
                return false;
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
        return false;
    }
    
    
    //MAIN PARA MOSTRAR LA VENTANA LOGIN
    public static void main(String[] args) {
        vtnLogin vtnL1 = new vtnLogin();
        vtnL1.setVisible(true);        
    }
}
