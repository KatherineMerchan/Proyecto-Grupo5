
package gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jeanp
 */
public class vtnEntrega extends JFrame{
    private JPanel contentPane; 
    private JPanel pnlNorte;
    private JPanel pnlEste;
    private JPanel pnlCentro;
    private JScrollPane scrPnlSur;
    private JScrollPane scrPnlCentro;
    private JList lstTareas;
    private DefaultListModel modelo;
    private JButton btnSalir;
    private JLabel lblEntregas;
    private JPanel pnlScrCentro;
    private JLabel lblCodTarea;
    private JLabel lblTitTarea;
    private JLabel lblEspecificaciones;
    private JLabel lblFechCreacion;
    private JLabel lblFechEntrega;
    private JLabel lblDescrip;
    private JButton btnSubirTarea;
    
    public vtnEntrega(){
        initComponents();
        addListeners();
    }
    
    public void addListeners(){
        
    }
    
    public void initComponents(){
        setTitle("Entregas Pendientes !!");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 400);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        scrPnlSur = new JScrollPane();
        contentPane.add(scrPnlSur, BorderLayout.SOUTH);
        lstTareas = new JList();
        lstTareas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        modelo = new DefaultListModel();
        scrPnlSur.setViewportView(lstTareas);
        
        pnlEste = new JPanel();
        contentPane.add(pnlEste, BorderLayout.EAST);
        btnSalir = new JButton("SALIR");
        pnlEste.add(btnSalir);
        
        pnlNorte = new JPanel();
        contentPane.add(pnlNorte, BorderLayout.NORTH);
        lblEntregas = new JLabel("ENTREGAS...");
        pnlNorte.add(lblEntregas);
        
        pnlCentro = new JPanel(new GridLayout(7, 0));
        contentPane.add(pnlCentro, BorderLayout.CENTER);
        
        //pnlScrCentro = new JPanel(new GridLayout(6, 0));
        //scrPnlCentro.add(pnlScrCentro);
        lblCodTarea = new JLabel("CODIGO DE LA TAREA: "+"Trae la variable de la tarea");    //Eliminar lo que va despues del "+" 
        pnlCentro.add(lblCodTarea);
        lblTitTarea = new JLabel("TITULO DE LA TAREA: "+"Trae la variable de la tarea");    //Eliminar lo que va despues del "+"
        pnlCentro.add(lblTitTarea);
        lblEspecificaciones = new JLabel("ESPECIFICACIONES (PDF/JPG)"+"Trae ruta o nombre de la tarea");    //Eliminar lo que va despues del "+"
        pnlCentro.add(lblEspecificaciones);
        lblFechCreacion = new JLabel("FECHA CREACION: "+"FECHA GENERADA AUTOMATICAMENTE");    //Eliminar lo que va despues del "+"
        pnlCentro.add(lblFechCreacion);
        lblFechEntrega = new JLabel("FECHA ENTREGA: "+"Trae la variable de la tarea");    //Eliminar lo que va despues del "+"
        pnlCentro.add(lblFechEntrega);
        lblDescrip = new JLabel("DESCRIPCION: "+"Trae la variable de la tarea");    //Eliminar lo que va despues del "+"
        pnlCentro.add(lblDescrip);
        btnSubirTarea = new JButton("Subir Tarea");
        pnlCentro.add(btnSubirTarea);
    }
    
    
    //MAIN PARA PROBAR LA VENTANA ENTREGA
    public static void main(String[] args) {
        vtnEntrega prueba = new vtnEntrega();
        prueba.setVisible(true);
    }
}
