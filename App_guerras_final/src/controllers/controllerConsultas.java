/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.POJOs.Guerra;
import Models.Consult.FormatText_DetailsWar;
import Models.DAOs.Guerra_DAO;
import Models.JTableModels.JTableModel_War;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views.viewConsults;
import views.viewPrincipal;

/**
 *
 * @author grupo1
 */
public final class controllerConsultas implements ActionListener {

    viewConsults viewConsult;
    Guerra_DAO bussinessWar;
    FormatText_DetailsWar getFormatDetails;
    JTableModel_War warTable;
    Guerra wardto;
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;

    //Constructor
    public controllerConsultas(viewPrincipal viewPpal) {

        //AGREGAR MODELs ***
        viewConsult = new viewConsults(viewPpal, true);

        try {
            bussinessWar = new Guerra_DAO();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(controllerGuerra.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        initEvents();

        viewConsult.setVisible(true);
    }//Fin del constructor

    public void initEvents() {
        //INICIALIZAR EVENTOS
        viewConsult.getBtnSeeDetails().addActionListener(this);
        viewConsult.getBtnClean().addActionListener(this);
        viewConsult.getBtnSave().addActionListener(this);
        viewConsult.getBtnExit().addActionListener(this);
        
          
            /*Agregamos un evento de ratón a la tabla para seleccionar
            los valores de una fila y almacenarlo en el OBJETO para ser utilizado
            para la consulta en caso de ser solicitado*/
            viewConsult.getJtableWarList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                    setWarDTO();
                    viewConsult.getBtnSeeDetails().setEnabled(true);

            }

        }
        );
            
            
            	viewConsult.getTxtfFilterWar().getDocument().addDocumentListener(new DocumentListener() {
	    @Override
	    public void insertUpdate(DocumentEvent e) {
		if (e.getDocument() == viewConsult.getTxtfFilterWar().getDocument()) {
		    activoTimer();
		    
		}
	    }
	    
	    @Override
	    public void removeUpdate(DocumentEvent e) {
		if (e.getDocument() == viewConsult.getTxtfFilterWar().getDocument()) {
		    activoTimer();
		}
	    }
	    
	    @Override
	    public void changedUpdate(DocumentEvent e) {
		if (e.getDocument() == viewConsult.getTxtfFilterWar().getDocument()) {
		    activoTimer();
		    
		}
	    }
	});

    }//Fin initEvents

    private void initComponents()  {

        bussinessWar.queriesI();
        warTable = new JTableModel_War(bussinessWar);
        getFormatDetails = new FormatText_DetailsWar();
        viewConsult.getJtableWarList().setModel(warTable);
        
        viewConsult.getBtnSeeDetails().setEnabled(false);
    }//Fin initComponents

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == viewConsult.getBtnSeeDetails()) {
            try {
 //               bussinessWar.searchAllDataFromWar();

                viewConsult.getTxtAreaDetailsWar().setText(getFormatDetails.formatDetails(bussinessWar.returnDetails(wardto)));

                initComponents();
            } catch (SQLException ex) {
                System.out.println("Se produjo una SQLException: "+ex.getMessage());
            }
            
            } else if (ae.getSource() == viewConsult.getBtnClean()) {
            viewConsult.getTxtAreaDetailsWar().setText("");
            viewConsult.getTxtfFilterWar().setText("");
        } else if (ae.getSource() == viewConsult.getBtnSave()) {
            Export();
        } else if (ae.getSource() == viewConsult.getBtnExit()) {
            viewConsult.dispose();
        }//Fin del else-if

    }//Fin de action performed

    private void Export() {
        try {
            JFileChooser archivo = new JFileChooser(System.getProperty("WarDetails.txt"));
            archivo.showSaveDialog(viewConsult);
            if (archivo.getSelectedFile() != null) {
                try (FileWriter guardado = new FileWriter(archivo.getSelectedFile())) {
                    guardado.write(viewConsult.getTxtAreaDetailsWar().getText());
                    JOptionPane.showMessageDialog(viewConsult, "El archivo fue guardado con éxito en la ruta establecida");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(viewConsult, ex.getMessage());
        }
    }

        private void setWarDTO() {
              int row = viewConsult.getJtableWarList().getSelectedRow();
        if (row >= 0) {
            wardto = new Guerra();
            wardto.setIdGuerra(Integer.parseInt(String.valueOf(viewConsult.getJtableWarList().getValueAt(row, 0))));
//            wardto.setAnioInicio(String.valueOf(viewConsult.getJtableWarList().getValueAt(row, 1)));
//            wardto.setAnioFin(String.valueOf(viewConsult.getJtableWarList().getValueAt(row, 2)));
//            wardto.setNombre(String.valueOf(viewConsult.getJtableWarList().getValueAt(row, 3)));      
    
//              warTable = new JTableModel_War(bussinessWar);  
//              viewConsult.getJtableWarList().setModel(warTable);

//        
        }
    }

         private void activoTimer() {
	
	if ((timerbuscar != null) && timerbuscar.isRunning()) {
	    timerbuscar.restart();
	} else {
	    timerbuscar = new Timer(TIEMPOBUSCAR, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
		
			timerbuscar = null;
			bussinessWar.lightSearch(viewConsult.getTxtfFilterWar().getText());
			warTable.fireTableDataChanged();
		
			
		}
		
		
	    });
	    timerbuscar.setRepeats(false);
	    timerbuscar.start();
	}
	
    }
  
}//Fin de la clase principal
