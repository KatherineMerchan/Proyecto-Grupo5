package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.Year;
//import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import listeners.vtnSistemaCreadorListener;
import metodos.Seguridad;

/**
 *
 * @author jeanp
 */
public class vtnSistemaCreador extends JFrame {

    private JPanel contentPane;
    private JPanel pnlCentro;
    private JPanel pnlNorte;
    private JButton btnCrearEstudiante;
    private JButton btnCrearDocente;
    private JLabel lblTexto;
    private JLabel usuario;
    private String getNombre = "";
    private String getApellido = "";

    public vtnSistemaCreador() {
        initComponents();
        addListeners();
    }

    public void addListeners() {
        btnCrearEstudiante.addActionListener(new vtnSistemaCreadorListener(this));
        btnCrearEstudiante.addActionListener((e) -> {
            this.dispose();
        });
        btnCrearDocente.addActionListener(new vtnSistemaCreadorListener(this));
        btnCrearDocente.addActionListener((e) -> {
            this.dispose();
        });
    }

    public void initComponents() {
        setTitle("Sistema Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        Font negrita = new Font("Segoe UI", Font.BOLD, 28);
        Font normal = new Font("Segoe UI", Font.PLAIN, 18);
        Font light = new Font("Segoe UI Light", Font.PLAIN, 18);
        Border line = BorderFactory.createLineBorder(java.awt.Color.GRAY);
        Border empty = new EmptyBorder(0, 10, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);

        //reemplazo el contentPane por defecto
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 40));
        setContentPane(contentPane);

        //agrego el panel al centro del contentPane
        pnlCentro = new JPanel();
        Color blanco = new Color(0, 0, 0, 0);
        contentPane.add(pnlCentro, BorderLayout.CENTER);

        //agrego el botón en el panel del centro
        btnCrearEstudiante = new JButton("Crear usuario Estudiante");
        btnCrearEstudiante.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        btnCrearEstudiante.setBackground(java.awt.Color.GRAY);
        btnCrearEstudiante.setForeground(java.awt.Color.white);
        btnCrearEstudiante.setFont(normal);
        btnCrearEstudiante.setFocusable(false);
        btnCrearEstudiante.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlCentro.add(btnCrearEstudiante);

        btnCrearDocente = new JButton("Crear usuario Docente");
        btnCrearDocente.setBorder(BorderFactory.createEmptyBorder(10, 23, 10, 23));
        btnCrearDocente.setBackground(java.awt.Color.GRAY);
        btnCrearDocente.setForeground(java.awt.Color.white);
        btnCrearDocente.setFont(normal);
        btnCrearDocente.setFocusable(false);
        btnCrearDocente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlCentro.add(btnCrearDocente);

        pnlNorte = new JPanel();
        pnlNorte.setLayout(new BoxLayout(pnlNorte, BoxLayout.Y_AXIS));
        contentPane.add(pnlNorte, BorderLayout.NORTH);
        lblTexto = new JLabel("Sistema Administrador");
        lblTexto.setFont(negrita);
        lblTexto.setAlignmentX(CENTER_ALIGNMENT);
        pnlNorte.add(lblTexto);

        String bienvenido = "Bienvenido ";
        Seguridad s = new Seguridad();
        getNombre = s.getNombre();
        usuario = new JLabel("¡" + bienvenido + getNombre + "!");
        usuario.setFont(normal);
        usuario.setAlignmentX(CENTER_ALIGNMENT);
        pnlNorte.add(usuario);
    }

    public JButton getBtnCrearEstudiante() {
        return btnCrearEstudiante;
    }

    public void setBtnCrearEstudiante(JButton btnCrearEstudiante) {
        this.btnCrearEstudiante = btnCrearEstudiante;
    }

    public JButton getBtnCrearDocente() {
        return btnCrearDocente;
    }

    public void setBtnCrearDocente(JButton btnCrearDocente) {
        this.btnCrearDocente = btnCrearDocente;
    }

    
    //MAIN PARA LA VENTANA SISTEMA CREADOR
    public static void main(String[] args) {
        vtnSistemaCreador vtnSC1 = new vtnSistemaCreador();
        vtnSC1.setVisible(true);        
    }
}
