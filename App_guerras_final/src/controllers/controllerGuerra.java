/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.POJOs.Guerra;
import Models.TableModels.JTableModelGuerra;
import Models.DAOs.DAOGuerra;
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
        initEvents();

        tableModelGuerra = new JTableModelGuerra(DAOguerra);
        viewGuerras.getJtableWars().setModel(tableModelGuerra);
        list();
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
                if (me.getClickCount() == 2) {
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
              
            resetViewComponents();         
            
            //Botón Salir
        } else if (ae.getSource() == viewGuerras.getExit_button()) {
            viewGuerras.dispose();
        }//Fin del else-if

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
        Guerra guerra = new Guerra();

        guerra.setNombre(viewGuerras.getName_text().getText());
        guerra.setAnioInicio(viewGuerras.getStart_date_text().getText());
        guerra.setAnioFin(viewGuerras.getEnd_date_text().getText());
        DAOguerra.insertGuerras(guerra);
    }

    
    private void modificarGuerra() {
        Guerra guerra = new Guerra();
        guerra.setIdGuerra(Integer.parseInt(viewGuerras.getId_text().getText()));
        guerra.setNombre(viewGuerras.getName_text().getText());
        guerra.setAnioInicio(viewGuerras.getStart_date_text().getText());
        guerra.setAnioFin(viewGuerras.getEnd_date_text().getText());

        DAOguerra.updateGuerras(guerra);
    }

    
    private void eliminarGuerra() {
        Guerra guerra = new Guerra();
        guerra.setIdGuerra(Integer.parseInt(viewGuerras.getId_text().getText()));

        DAOguerra.deleteGuerras(guerra);

    }

}//FIN DE LA CLASE
