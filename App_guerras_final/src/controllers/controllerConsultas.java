/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.POJOs.Guerra;
import Models.ConsultFormatTextUtils.FormatTextDetailsWarUtil;
import Models.DAOs.DAOGuerra;
import Models.TableModels.JTableModelGuerra;
import Models.TableModels.TableModelPaint;
import SessionFactory.HibernateUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import Views.ViewConsultas;
import Views.ViewPrincipal;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author davidf
 */
public final class controllerConsultas implements ActionListener {

    private ViewConsultas viewConsultas;
    private final DAOGuerra DAOguerra;
    private final FormatTextDetailsWarUtil formatTextDetailsWarUtil;
    private JTableModelGuerra tableModelGuerra;
    private Guerra guerra;

    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;

    //Constructor
    public controllerConsultas(ViewPrincipal viewPrincipal) {

        //AGREGAR MODELs ***
        viewConsultas = new ViewConsultas(viewPrincipal, true);
        DAOguerra = new DAOGuerra();
        formatTextDetailsWarUtil = new FormatTextDetailsWarUtil();

        initComponents();

        viewConsultas.setVisible(true);

    }//Fin del constructor

    private void initComponents() {

        DAOguerra.selectAllGuerras();
       
///Tabla modo NORMAL ////FUE SUSTITUIDA
//        tableModelGuerra = new JTableModelGuerra(DAOguerra);
//        viewConsultas.getJtableWarList().setModel(tableModelGuerra);


////////////////////INSERTANDO JTABLE TUNEADA Y JTableMODEL ///////////       
///////////////////////////////////////////////////////////////////////
        //Inicializando el TableModel
        tableModelGuerra = new JTableModelGuerra(DAOguerra);
        //Creando objeto de TableModelPaint, pasandole el MODELO que QUEREMOS ESTABLECERLE
        TableModelPaint  tableModelPaint = new TableModelPaint(tableModelGuerra);
        //Seteando la JTable de la vista, con la JTable TUNEADA que nos devuelve la clase TableModelPaint
        viewConsultas.setJtableWarList(tableModelPaint.getJtable());
        //Seteando la JTable al ScrollPane, para que se vea, ya que si no NO PODRÄ MOSTRARLA
        viewConsultas.getjScrollPane1().setViewportView(viewConsultas.getJtableWarList());
        //LISTO!, tabla tuning agregada
///////////////////////////////////////////////////////////////////   

   
        initEvents();

    }//Fin initComponents

    public void initEvents() {

        //INICIALIZAR EVENTOS
    
        viewConsultas.getBtnClean().addActionListener(this);
        viewConsultas.getBtnSave().addActionListener(this);
        viewConsultas.getBtnExit().addActionListener(this);

        /**
         * Agregamos un EVENTO DE RATÓN A LA JTABLE para seleccionar
         * los valores de una fila y llamar al método que recopilará 
         * toda la informacion sobre esta GUERRA para mostrarla en el TextArea.
         **/
        viewConsultas.getJtableWarList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                //Comprobando Conexion, en caso de ser Erronea Saldrá a la pantalla principal
                if(HibernateUtil.isConnected()){
          
                
                int row = viewConsultas.getJtableWarList().getSelectedRow();
                if (row >= 0) {
                    guerra = new Guerra();
                    //Le pasaremos solo la ID del objeto que queremos Consultar Posteriormente, y con hibernate, haremos el resto del trabajo
                    guerra.setIdGuerra(Integer.parseInt(String.valueOf(viewConsultas.getJtableWarList().getValueAt(row, 0))));
                }
            //////FORMATEANDO EL "Texto a mostrar en el TextAREA"/////////////////////
                viewConsultas.getTxtAreaDetailsWar().setText(formatTextDetailsWarUtil.formatDetails(DAOguerra.returnDetails(guerra)));
                viewConsultas.getTxtAreaDetailsWar().setCaretPosition(0); //Posicionando el "Caret" al principio del TextArea
                
                
                }else{
                    viewConsultas.dispose();
                }//Fin de If-Else que COMPRUEBA LA CONEXION
            }
        }
        );

        viewConsultas.getTxtfFilterWar().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (e.getDocument() == viewConsultas.getTxtfFilterWar().getDocument()) {
                    activoTimer();

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (e.getDocument() == viewConsultas.getTxtfFilterWar().getDocument()) {
                    activoTimer();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (e.getDocument() == viewConsultas.getTxtfFilterWar().getDocument()) {
                    activoTimer();

                }
            }
        });

    }//Fin initEvents

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        //BOTON LIMPIAR PANTALLA
       
         
        //BOTON GUARDAR
         if (ae.getSource() == viewConsultas.getBtnSave()) {

            Export();
            //Cambiando el SOURCE del EVENTO a uno que no exista, para que cuando vuelva no vuelva a reconocer el evento(devuelto inevitablemente por el JfileChooser y Heredado por nuestro botón "guardar" que es su padre)
            ae.setSource(viewConsultas.getJtableWarList());
            
        //BOTON SALIR    
        } else if (ae.getSource() == viewConsultas.getBtnExit()) {
            viewConsultas.dispose();
        }
            
            
        //Comprobando Conexion, en caso de ser Erronea Saldrá a la pantalla principal
        if(HibernateUtil.isConnected()){
          
        
        if (ae.getSource() == viewConsultas.getBtnClean()) {

            viewConsultas.getTxtAreaDetailsWar().setText("");
            viewConsultas.getTxtfFilterWar().setText("");
            viewConsultas.getJtableWarList().clearSelection();
            //REFRESCANDO TABLA DE GUERRAS (actualizando por si hubiese algun cambio en ella)
            DAOguerra.selectAllGuerras();
            tableModelGuerra.fireTableDataChanged();
        }//Fin del else-if
        
        }else{
            viewConsultas.dispose();
            
        }
        
        

    }//Fin de action performed

    
    
    public void Export() {

        //Creamos el objeto JFileChooser
        JFileChooser fc = new JFileChooser();

        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion = fc.showSaveDialog(viewConsultas);

        //Si el usuario, pincha en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            //Seleccionamos el fichero
            File fichero = fc.getSelectedFile();

            try (FileWriter fw = new FileWriter(fichero)) {

                //Escribimos el texto en el fichero
                fw.write(viewConsultas.getTxtAreaDetailsWar().getText());
                JOptionPane.showMessageDialog(viewConsultas, "El archivo fue guardado con éxito en la ruta establecida");
                fw.close();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(viewConsultas, "Error al crear el fichero: " + e.getMessage());
            }

        }//FIN DEL IF

    }

    
    private void activoTimer() {

        if ((timerbuscar != null) && timerbuscar.isRunning()) {
            timerbuscar.restart();
        } else {
            timerbuscar = new Timer(TIEMPOBUSCAR, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    timerbuscar = null;
                    DAOguerra.lightSearchGuerras(viewConsultas.getTxtfFilterWar().getText());
                    tableModelGuerra.fireTableDataChanged();
                }
            });

            timerbuscar.setRepeats(false);
            timerbuscar.start();
        }

    }

}//Fin de la clase principal
