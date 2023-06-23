/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import listeners.vtnSistemaTareaListeners;

/**
 *
 * @author jeanp
 */
public class vtnSistemaTarea extends JFrame {

    private JPanel contentPane;
    private JPanel pnlSur;
    private JPanel pnlNorte;
    private JPanel pnlCentro;
    private JButton btnGuardar;
    private JButton btnCancelar;
    public JButton btnAddFichero;
    private JLabel lblTextoTitulo;
    private JLabel lblCodigo;
    private JLabel lblDocAdjuntar;
    private JLabel lblTituloTarea;
    private JLabel lblFechaCreacion;
    private JLabel lblFechaEntrega;
    private JLabel lblDescripcion;
    public JTextField txtCodigo;
    public JTextField txtTituloTarea;
    public JTextField txtFechaCreacion;
    public JTextField txtFechaEntrega;
    public JTextArea txtaDescripcion;

    public vtnSistemaTarea() {
        initComponents();
        addListeners();
    }

    public void addListeners() {
        btnAddFichero.addActionListener(new vtnSistemaTareaListeners(this));
        btnGuardar.addActionListener(new vtnSistemaTareaListeners(this));
        btnCancelar.addActionListener(new vtnSistemaTareaListeners(this));
        btnCancelar.addActionListener((e) -> {
            this.dispose();
        });
        btnGuardar.addActionListener((e) -> {
            this.dispose();
        });
    }

    public void initComponents() {
        setTitle("  Asignacion de Tarea");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 650);
        setLocationRelativeTo(null);
        Font negrita = new Font("Segoe UI", Font.BOLD, 38);
        Font normal = new Font("Segoe UI", Font.PLAIN, 15);
        Font light = new Font("Segoe UI Light", Font.PLAIN, 18);
        Border line = BorderFactory.createLineBorder(java.awt.Color.GRAY);
        Border empty = new EmptyBorder(0, 10, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 30));
        setContentPane(contentPane);

        pnlSur = new JPanel();
        contentPane.add(pnlSur, BorderLayout.SOUTH);

        btnGuardar = new JButton("Crear");
        btnGuardar.setBorder(BorderFactory.createEmptyBorder(3, 15, 8, 15));
        btnGuardar.setBackground(java.awt.Color.GRAY);
        btnGuardar.setForeground(java.awt.Color.white);
        btnGuardar.setFont(normal);
        btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlSur.add(btnGuardar);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBorder(BorderFactory.createEmptyBorder(3, 15, 8, 15));
        btnCancelar.setBackground(java.awt.Color.GRAY);
        btnCancelar.setForeground(java.awt.Color.white);
        btnCancelar.setFont(normal);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlSur.add(btnCancelar);

        pnlNorte = new JPanel();
        contentPane.add(pnlNorte, BorderLayout.NORTH);
        lblTextoTitulo = new JLabel("Creación de Tarea");
        lblTextoTitulo.setFont(negrita);
        pnlNorte.add(lblTextoTitulo);

        pnlCentro = new JPanel(new GridLayout(6, 2, 20, 40));
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        contentPane.add(pnlCentro);

        //Variable para generar numeros random
        int numRandom;

        Random r = new Random();
        numRandom = r.nextInt(9999999);
        lblCodigo = new JLabel("Codigo de la tarea: ");
        lblCodigo.setFont(normal);
        pnlCentro.add(lblCodigo);
        txtCodigo = new JTextField("" + numRandom); //Los pongo en el txt para que genere el codigo de tarea aleatorio 
        txtCodigo.setEditable(false);
        txtCodigo.setBorder(border);
        pnlCentro.add(txtCodigo);

        lblDocAdjuntar = new JLabel("<html>Adjuntar Especificaciones de la tarea (.PDF / .JPG):</html> ");
        lblDocAdjuntar.setFont(normal);
        pnlCentro.add(lblDocAdjuntar);
        btnAddFichero = new JButton("Subir Archivo");
        btnAddFichero.setBackground(java.awt.Color.GRAY);
        btnAddFichero.setForeground(java.awt.Color.white);
        btnAddFichero.setFont(normal);
        btnAddFichero.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlCentro.add(btnAddFichero);

        lblTituloTarea = new JLabel("Título de la tarea: ");
        lblTituloTarea.setFont(normal);
        pnlCentro.add(lblTituloTarea);
        txtTituloTarea = new JTextField();
        txtTituloTarea.setBorder(border);
        pnlCentro.add(txtTituloTarea);

        lblFechaCreacion = new JLabel("<html>Fecha/Creación de la tarea: </html>");
        lblFechaCreacion.setFont(normal);
        pnlCentro.add(lblFechaCreacion);
        txtFechaCreacion = new JTextField();
        txtFechaCreacion.setBorder(border);
        pnlCentro.add(txtFechaCreacion);

        lblFechaEntrega = new JLabel("Fecha/Entrega de la tarea: ");
        lblFechaEntrega.setFont(normal);
        pnlCentro.add(lblFechaEntrega);
        txtFechaEntrega = new JTextField();
        txtFechaEntrega.setBorder(border);
        pnlCentro.add(txtFechaEntrega);

        lblDescripcion = new JLabel("Descripcion de la tarea: ");
        lblDescripcion.setFont(normal);
        pnlCentro.add(lblDescripcion);
        txtaDescripcion = new JTextArea();
        pnlCentro.add(txtaDescripcion);
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnAddFichero() {
        return btnAddFichero;
    }

    public void setBtnAddFichero(JButton btnAddFichero) {
        this.btnAddFichero = btnAddFichero;
    }

    
    
    //MAIN PARA LA VENTANA SISTEMA TAREA
    public static void main(String[] args) {
        vtnSistemaTarea vtnPruebaST = new vtnSistemaTarea();
        vtnPruebaST.setVisible(true);
    }
    
    
}
