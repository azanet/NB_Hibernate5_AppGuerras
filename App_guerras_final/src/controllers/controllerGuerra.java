/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import Models.POJOs.Guerra;
import Models.JTableModels.JTableModel_War;
import Models.DAOs.Guerra_DAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views.viewPrincipal;
import views.viewWars;

/**
 *
 * @author grupo1
 */
public final class controllerGuerra implements ActionListener {

    viewWars viewWar;
    JTableModel_War warTableView;//= new JTableModel_War();
    Guerra_DAO bussinessWar;
    Guerra wardto;
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;

    public controllerGuerra(viewPrincipal viewPpal) {
        viewWar = new viewWars(viewPpal, true);

    
            bussinessWar = new Guerra_DAO();
   
        initComponents();
        initEvents();

        viewWar.setVisible(true);
    }

    private void initComponents() {
        viewWar.getId_text().setEnabled(false);
        viewWar.getEdit_button().setEnabled(false);
        viewWar.getDelete_button().setEnabled(false);
        viewWar.getAdd_button().setEnabled(true);

    }//Fin initComponents

    public void initEvents() {
        //INICIALIZAR EVENTOS
        viewWar.getAdd_button().addActionListener(this);
        viewWar.getDelete_button().addActionListener(this);
        viewWar.getEdit_button().addActionListener(this);
        viewWar.getExit_button().addActionListener(this);


//            //AQUI INICIAMOS LA JTABLE ETC ETC
        bussinessWar.queriesI();
        warTableView = new JTableModel_War(bussinessWar);
        viewWar.getJtableWars().setModel(warTableView);
  /////////     ///////////////////              ////////////       
  
     /////Dotando de EVENTOS a LA JTABLE
        viewWar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewWar.getJtableWars().clearSelection();
                clearTextFields();
                initComponents();

            }
        });
        /*Agregamos un evento de ratón a la tabla para seleccionar
        los valores de una fila y colocarlos en los cajones de texto*/
        viewWar.getJtableWars().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    selected_row();
                    viewWar.getEdit_button().setEnabled(true);
                    viewWar.getDelete_button().setEnabled(true);
                    viewWar.getAdd_button().setEnabled(false);

                }

            }

        }
        );
	
		viewWar.getTxtfFilterSearch().getDocument().addDocumentListener(new DocumentListener() {
	    @Override
	    public void insertUpdate(DocumentEvent e) {
		if (e.getDocument() == viewWar.getTxtfFilterSearch().getDocument()) {
		    activoTimer();
		    
		}
	    }
	    
	    @Override
	    public void removeUpdate(DocumentEvent e) {
		if (e.getDocument() == viewWar.getTxtfFilterSearch().getDocument()) {
		    activoTimer();
		}
	    }
	    
	    @Override
	    public void changedUpdate(DocumentEvent e) {
		if (e.getDocument() == viewWar.getTxtfFilterSearch().getDocument()) {
		    activoTimer();
		    
		}
	    }
	});

    }//Fin initEvents

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Boton Añadir Guerras
        if (ae.getSource() == viewWar.getAdd_button()) {
            wardto = new Guerra();
   
                wardto.setNombre(viewWar.getName_text().getText());
                wardto.setAnioInicio(viewWar.getStart_date_text().getText());
                wardto.setAnioFin(viewWar.getEnd_date_text().getText());
                bussinessWar.insert(wardto);
                list();
                System.out.println("INSERT Pais SOLO, METER LAS LLAMADAS A MODELO AQUI");

  
            //Boton Editar Guerras
        } else if (ae.getSource() == viewWar.getEdit_button()) {
            wardto = new Guerra();
            wardto.setIdGuerra(Integer.parseInt(viewWar.getId_text().getText()));
            wardto.setNombre(viewWar.getName_text().getText());
            wardto.setAnioInicio(viewWar.getStart_date_text().getText());
            wardto.setAnioFin(viewWar.getEnd_date_text().getText());
           
     
                bussinessWar.update(wardto);
                list();

            //Boton Eliminar Guerras
        } else if (ae.getSource() == viewWar.getDelete_button()) {
            wardto = new Guerra();
            wardto.setIdGuerra(Integer.parseInt(viewWar.getId_text().getText()));
            
            bussinessWar.delete(wardto);
          
                list();
    
            System.out.println("REALIZANDO DELETE, METER LAS LLAMADAS A MODELO AQUI");
            //Botón Salir
        } else if (ae.getSource() == viewWar.getExit_button()) {
            viewWar.dispose();
        }//Fin del else-if

    }//Fin de action performed

    private void selected_row() {
        int row = viewWar.getJtableWars().getSelectedRow();
        if (row >= 0) {
            viewWar.getId_text().setText(String.valueOf(viewWar.getJtableWars().getValueAt(row, 0)));
            viewWar.getName_text().setText(String.valueOf(viewWar.getJtableWars().getValueAt(row, 1)));
            viewWar.getStart_date_text().setText(String.valueOf(viewWar.getJtableWars().getValueAt(row, 2)));
            viewWar.getEnd_date_text().setText(String.valueOf(viewWar.getJtableWars().getValueAt(row, 3)));
        }
    }

    //Limpiar TextFields
    private void clearTextFields() {
        viewWar.getName_text().setText("");
        viewWar.getId_text().setText("");
        viewWar.getEnd_date_text().setText("");
        viewWar.getStart_date_text().setText("");

    }
    
    private void list() {
        bussinessWar.queriesI();
        warTableView.fireTableDataChanged();
    }
    
     private void activoTimer() {
	
	if ((timerbuscar != null) && timerbuscar.isRunning()) {
	    timerbuscar.restart();
	} else {
	    timerbuscar = new Timer(TIEMPOBUSCAR, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
	
			timerbuscar = null;
			bussinessWar.lightSearch(viewWar.getTxtfFilterSearch().getText());
			warTableView.fireTableDataChanged();
		
		}
		
	    });
	    timerbuscar.setRepeats(false);
	    timerbuscar.start();
	}
	
    }

}
