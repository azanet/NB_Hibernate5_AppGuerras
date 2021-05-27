/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.POJOs.Guerra;
import Models.TableModels.JTableModelGuerra;
import Models.DAOs.DAOGuerra;
import Models.TableModels.TableModelPaint;
import SessionFactory.HibernateUtil_SessionFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import Views.ViewPrincipal;
import Views.ViewGuerras;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author davidf
 */
public final class controllerGuerra implements ActionListener {

    private ViewGuerras viewGuerras;
    private final DAOGuerra DAOguerra;
    private JTableModelGuerra tableModelGuerra;

    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;

    
    public controllerGuerra(ViewPrincipal viewPrincipal) {

        viewGuerras = new ViewGuerras(viewPrincipal, true);
        DAOguerra = new DAOGuerra();

        initComponents();

        viewGuerras.setVisible(true);
    }
    
    
    private void initComponents() {
        
        
        
        resetViewComponents();
        

////////////////////INSERTANDO JTABLE TUNEADA Y JTableMODEL ///////////       
///////////////////////////////////////////////////////////////////////
        //Inicializando el TableModel
        tableModelGuerra = new JTableModelGuerra(DAOguerra);
        //Creando objeto de TableModelPaint, pasandole el MODELO que QUEREMOS ESTABLECERLE
        TableModelPaint  tableModelPaint = new TableModelPaint(tableModelGuerra);
        //Seteando la JTable de la vista, con la JTable TUNEADA que nos devuelve la clase TableModelPaint
        viewGuerras.setJtableWars(tableModelPaint.getJtable());
        //Seteando la JTable al ScrollPane, para que se vea, ya que si no NO PODRÄ MOSTRARLA
        viewGuerras.getjScrollPane1().setViewportView(viewGuerras.getJtableWars());
        //LISTO!, tabla tuning agregada
/////////////////////////////////////////////////////////////////// 

            
        //Llamada al método que refresca la JTable
        list();
        
        initEvents();
    }//Fin initComponents

    
    private void initEvents() {
        //INICIALIZAR EVENTOS
        viewGuerras.getAdd_button().addActionListener(this);
        viewGuerras.getDelete_button().addActionListener(this);
        viewGuerras.getEdit_button().addActionListener(this);
        viewGuerras.getExit_button().addActionListener(this);
        viewGuerras.getBtnLimpiarPantalla().addActionListener(this);

        /*Agregamos un evento de ratón a la tabla para seleccionar
        los valores de una fila y colocarlos en los cajones de texto*/
        viewGuerras.getJtableWars().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    selected_row();
                    viewGuerras.getEdit_button().setEnabled(true);
                    viewGuerras.getDelete_button().setEnabled(true);
                    viewGuerras.getAdd_button().setEnabled(false);

                }

            }

        }
        );

        viewGuerras.getTxtfFilterSearch().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (e.getDocument() == viewGuerras.getTxtfFilterSearch().getDocument()) {
                    activoTimer();

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (e.getDocument() == viewGuerras.getTxtfFilterSearch().getDocument()) {
                    activoTimer();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (e.getDocument() == viewGuerras.getTxtfFilterSearch().getDocument()) {
                    activoTimer();

                }
            }
        });

    }//Fin initEvents

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == viewGuerras.getExit_button()) {
            viewGuerras.dispose();
        }
        
        
        //Comprobando Conexion, en caso de ser Erronea Saldrá a la pantalla principal
        if(HibernateUtil_SessionFactory.isConnected()){
             
         
        //Boton Añadir Guerras
        if (ae.getSource() == viewGuerras.getAdd_button()) {

            insertarGuerra();
            list();

            //Boton Editar Guerras
        } else if (ae.getSource() == viewGuerras.getEdit_button()) {

            modificarGuerra();
            list();

            //Boton Eliminar Guerras
        } else if (ae.getSource() == viewGuerras.getDelete_button()) {

            eliminarGuerra();
            list();
            
          //Botón Limpiar Pantalla  
        } else if (ae.getSource() == viewGuerras.getBtnLimpiarPantalla()) {
              
            //Al final no lleva nada aquí porque siempre limpiaremos pantalla despues de alguna accion    
            
            //Botón Salir
        }//Fin del else-if
        
        resetViewComponents(); 
        
        }else{
            viewGuerras.dispose();
        }
        
        
    }//Fin de action performed

    
    private void selected_row() {
        
        int row = viewGuerras.getJtableWars().getSelectedRow();
        if (row >= 0) {
            viewGuerras.getId_text().setText(String.valueOf(viewGuerras.getJtableWars().getValueAt(row, 0)));
            viewGuerras.getName_text().setText(String.valueOf(viewGuerras.getJtableWars().getValueAt(row, 1)));
            viewGuerras.getStart_date_text().setText(String.valueOf(viewGuerras.getJtableWars().getValueAt(row, 2)));
            viewGuerras.getEnd_date_text().setText(String.valueOf(viewGuerras.getJtableWars().getValueAt(row, 3)));
        }
        
    }
    
    
    private void list() {
        
        DAOguerra.selectAllGuerras();
        tableModelGuerra.fireTableDataChanged();
        
    }
    
    
    //Limpiar TextFields y volver a SETEAR los estados de los botones
    private void resetViewComponents() {
        
        viewGuerras.getJtableWars().clearSelection();
        
        viewGuerras.getName_text().setText("");
        viewGuerras.getId_text().setText("");
        viewGuerras.getEnd_date_text().setText("");
        viewGuerras.getStart_date_text().setText("");

        viewGuerras.getId_text().setEnabled(false);
        viewGuerras.getEdit_button().setEnabled(false);
        viewGuerras.getDelete_button().setEnabled(false);
        viewGuerras.getAdd_button().setEnabled(true);
        
        
        viewGuerras.getId_text().setBackground(new Color(178, 191, 237));
        viewGuerras.getId_text().setDisabledTextColor(new Color(0, 0, 98));
        
    }



    private void activoTimer() {

        if ((timerbuscar != null) && timerbuscar.isRunning()) {
            timerbuscar.restart();
        } else {
            timerbuscar = new Timer(TIEMPOBUSCAR, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    timerbuscar = null;
                    DAOguerra.lightSearchGuerras(viewGuerras.getTxtfFilterSearch().getText());
                    tableModelGuerra.fireTableDataChanged();

                }

            });
            timerbuscar.setRepeats(false);
            timerbuscar.start();
        }

    }

    
    private void insertarGuerra() {
        
        if(viewGuerras.getName_text().getText().length()>0){
        Guerra guerra = new Guerra();
        guerra.setNombre(viewGuerras.getName_text().getText());
        guerra.setAnioInicio(viewGuerras.getStart_date_text().getText());
        guerra.setAnioFin(viewGuerras.getEnd_date_text().getText());
        DAOguerra.insertGuerras(guerra);
        }else {       
              JOptionPane.showMessageDialog(viewGuerras, "El NOMBRE no PUEDE estar vacío", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        
    }

    
    private void modificarGuerra() {
         if(viewGuerras.getName_text().getText().length()>0){
        Guerra guerra = new Guerra();
        guerra.setIdGuerra(Integer.parseInt(viewGuerras.getId_text().getText()));
        guerra.setNombre(viewGuerras.getName_text().getText());
        guerra.setAnioInicio(viewGuerras.getStart_date_text().getText());
        guerra.setAnioFin(viewGuerras.getEnd_date_text().getText());

        DAOguerra.updateGuerras(guerra);
       }else {       
              JOptionPane.showMessageDialog(viewGuerras, "El NOMBRE no PUEDE estar vacío", "ERROR", JOptionPane.WARNING_MESSAGE);
        }   
    }

    
    private void eliminarGuerra() {
        
        Guerra guerra = new Guerra();
        guerra.setIdGuerra(Integer.parseInt(viewGuerras.getId_text().getText()));

        DAOguerra.deleteGuerras(guerra);

    }

}//FIN DE LA CLASE
