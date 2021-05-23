/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.POJOs.Guerra;
import Models.ConsultFormatTextUtils.FormatTextDetailsWarUtil;
import Models.DAOs.DAOGuerra;
import Models.TableModels.JTableModel_Guerra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views.viewConsultas;
import views.viewPrincipal;

/**
 *
 * @author davidf
 */
public final class controllerConsultas implements ActionListener {

    viewConsultas viewConsult;
    DAOGuerra bussinessWar;
    FormatTextDetailsWarUtil getFormatDetails;
    JTableModel_Guerra warTable;
    Guerra wardto;
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;

    //Constructor
    public controllerConsultas(viewPrincipal viewPpal) {

        //AGREGAR MODELs ***
        viewConsult = new viewConsultas(viewPpal, true);
        bussinessWar = new DAOGuerra();
        
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

        bussinessWar.selectAllGuerras();
        warTable = new JTableModel_Guerra(bussinessWar);
        getFormatDetails = new FormatTextDetailsWarUtil();
        viewConsult.getJtableWarList().setModel(warTable);
        
        viewConsult.getBtnSeeDetails().setEnabled(false);
    }//Fin initComponents

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == viewConsult.getBtnSeeDetails()) {

                viewConsult.getTxtAreaDetailsWar().setText(getFormatDetails.formatDetails(bussinessWar.returnDetails(wardto)));

                initComponents();
         
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
            //Le pasaremos solo la ID del objeto que queremos Consultar Posteriormente, y con hibernate, haremos el resto del trabajo
            wardto.setIdGuerra(Integer.parseInt(String.valueOf(viewConsult.getJtableWarList().getValueAt(row, 0))));
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
			bussinessWar.lightSearchGuerras(viewConsult.getTxtfFilterWar().getText());
			warTable.fireTableDataChanged();			
		}
            });
            
	    timerbuscar.setRepeats(false);
	    timerbuscar.start();
	}
	
    }
  
}//Fin de la clase principal
