
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import metodos.Seguridad;

/**
 *
 * @author jeanp
 */
public class vtnSistemaEstudiante extends JFrame{
    private JPanel contentPane; 
    private JPanel pnlSur; 
    //private JPanel pnlNorte; 
    private JPanel pnlCentro; 
    private JPanel pnlCentroComponentes; 
    private JScrollPane pnlCentroScrTabla; 
    private JLabel lblEstudiante;
    private JLabel txtEstudiante;
    private JButton btnEntregaTarea;
    private JButton btnCerrarSesion;
    private JTable tblBandeja;
    
    public vtnSistemaEstudiante(){
        initComponents();
        addListeners();
    }
    
    public void addListeners(){
        
    }
    
    public void initComponents(){
        setTitle("Sistema Estudian");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 400);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
//        pnlNorte = new JPanel();
//        contentPane.add(pnlNorte, BorderLayout.NORTH);
//        lblEstudiante = new JLabel();
//        pnlNorte.add(lblEstudiante);
        
        pnlCentro = new JPanel(new GridLayout(2,0));
        contentPane.add(pnlCentro, BorderLayout.CENTER);
        pnlCentroComponentes = new JPanel();
        pnlCentro.add(pnlCentroComponentes);
        lblEstudiante = new JLabel("Estudiante: ");//Etiqueta que dice Usuario 
        pnlCentroComponentes.add(lblEstudiante);
        Seguridad s = new Seguridad();
        txtEstudiante = new JLabel(s.getNombre().toUpperCase()+" "+s.getApellido().toUpperCase());//Aqui en vez de poner nombre aqui, va las variables recuperada de los txt de CrearDocente
        pnlCentroComponentes.add(txtEstudiante);
        
        pnlCentroScrTabla = new JScrollPane();
        pnlCentro.add(pnlCentroScrTabla);
        tblBandeja = new JTable();
        tblBandeja.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Tarea ","Enviada por", "Estado"
                }
        ));
        tblBandeja.setRowHeight(20);
        pnlCentroScrTabla.setViewportView(tblBandeja);
        
        pnlSur = new JPanel();
        contentPane.add(pnlSur, BorderLayout.SOUTH);
        btnEntregaTarea = new JButton("Entregar Tareas");
        pnlSur.add(btnEntregaTarea);
        btnCerrarSesion = new JButton("Cerrar Sesion");
        pnlSur.add(btnCerrarSesion);
        
        
        
    }
    
    public static void main(String[] args) {
        vtnSistemaEstudiante pruebaSE = new vtnSistemaEstudiante();
        pruebaSE.setVisible(true);
    }
}
