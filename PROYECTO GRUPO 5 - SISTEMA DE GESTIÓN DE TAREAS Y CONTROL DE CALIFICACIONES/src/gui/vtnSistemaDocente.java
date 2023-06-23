package gui;

import java.awt.BorderLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import listeners.vtnSistemaDocenteListener;
import metodos.Seguridad;

/**
 *
 * @author jeanp
 */
public class vtnSistemaDocente extends JFrame {

    private JPanel contentPane;
    private JPanel pnlSur;
    private JButton btnAsignarT;
    private JPanel pnlCentro;
    private JPanel pnlCentroFlow;
    private JPanel pnlCentro1;
    private JPanel pnlCentro2;
    private JTable tblVisualizacionTareas;
    private JLabel lblDocente;
    private JScrollPane scrTabla;

    public vtnSistemaDocente() {
        initComponents();
        addListeners();
    }

    public void addListeners() {
        btnAsignarT.addActionListener(new vtnSistemaDocenteListener(this));
    }

    public void initComponents() {
        setTitle("Sistema Docente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 400);
        setLocationRelativeTo(null);
        Font negrita = new Font("Segoe UI", Font.BOLD, 38);
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

        btnAsignarT = new JButton("Asignar Tarea");
        pnlSur.add(btnAsignarT);

        pnlCentro = new JPanel(new GridLayout(2, 0));
        contentPane.add(pnlCentro, BorderLayout.CENTER);

        pnlCentro1 = new JPanel(new GridLayout(2, 0));
        pnlCentro.add(pnlCentro1);

        pnlCentroFlow = new JPanel(new FlowLayout());
        pnlCentro1.add(pnlCentroFlow);
        Seguridad s = new Seguridad();
        String nombre = s.getNombre();
        String apellido = s.getApellido();
        lblDocente = new JLabel("¡Bienvenido, Docente " + nombre.toUpperCase() + " " + apellido.toUpperCase() + "!");
        lblDocente.setFont(negrita);
        pnlCentroFlow.add(lblDocente);

        scrTabla = new JScrollPane();
        pnlCentro.add(scrTabla);
        //pnlCentro2 = new JPanel();
        //pnlCentro.add(pnlCentro2); 
        tblVisualizacionTareas = new JTable();
        tblVisualizacionTareas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Tarea", "Estudiante", "Estado", "Calificacion"
                }
        ));
        tblVisualizacionTareas.setRowHeight(20);
        scrTabla.setViewportView(tblVisualizacionTareas);
    }
    
    
    
    //MAIN PARA LLAMAR A LA VENTANA SISTEMA DOCETE
    public static void main(String[] args) {
        vtnSistemaDocente vtnSD1 = new vtnSistemaDocente();
        vtnSD1.setVisible(true);        
    }
}
