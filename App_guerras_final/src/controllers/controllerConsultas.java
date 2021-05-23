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
import Views.ViewConsultas;
import Views.ViewPrincipal;

/**
 *
 * @author davidf
 */
public final class controllerConsultas implements ActionListener {

    private ViewConsultas viewConsultas;
    private DAOGuerra DAOguerra;
    private FormatTextDetailsWarUtil formatTextDetailsWarUtil;
    private JTableModelGuerra tableModelGuerra;
    private Guerra guerra;
    
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;

    //Constructor
    public controllerConsultas(ViewPrincipal viewPrincipal) {

        //AGREGAR MODELs ***
        viewConsultas = new ViewConsultas(viewPrincipal, true);
        DAOguerra = new DAOGuerra();
        
        initComponents();
        initEvents();

        viewConsultas.setVisible(true);
    }//Fin del constructor

    
    public void initEvents() {
        //INICIALIZAR EVENTOS
        viewConsultas.getBtnSeeDetails().addActionListener(this);
        viewConsultas.getBtnClean().addActionListener(this);
        viewConsultas.getBtnSave().addActionListener(this);
        viewConsultas.getBtnExit().addActionListener(this);
        
          
            /*Agregamos un evento de ratón a la tabla para seleccionar
            los valores de una fila y almacenarlo en el OBJETO para ser utilizado
            para la consulta en caso de ser solicitado*/
            viewConsultas.getJtableWarList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                    setWarDTO();
                    viewConsultas.getBtnSeeDetails().setEnabled(true);
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

    private void initComponents()  {

        DAOguerra.selectAllGuerras();
        tableModelGuerra = new JTableModelGuerra(DAOguerra);
        formatTextDetailsWarUtil = new FormatTextDetailsWarUtil();
        viewConsultas.getJtableWarList().setModel(tableModelGuerra);
        
        viewConsultas.getBtnSeeDetails().setEnabled(false);
    }//Fin initComponents

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == viewConsultas.getBtnSeeDetails()) {

                viewConsultas.getTxtAreaDetailsWar().setText(formatTextDetailsWarUtil.formatDetails(DAOguerra.returnDetails(guerra)));

                initComponents();
         
            } else if (ae.getSource() == viewConsultas.getBtnClean()) {
            viewConsultas.getTxtAreaDetailsWar().setText("");
            viewConsultas.getTxtfFilterWar().setText("");
        } else if (ae.getSource() == viewConsultas.getBtnSave()) {
            Export();
        } else if (ae.getSource() == viewConsultas.getBtnExit()) {
            viewConsultas.dispose();
        }//Fin del else-if

    }//Fin de action performed

    private void Export() {
        try {
            JFileChooser archivo = new JFileChooser(System.getProperty("WarDetails.txt"));
            archivo.showSaveDialog(viewConsultas);
            if (archivo.getSelectedFile() != null) {
                try (FileWriter guardado = new FileWriter(archivo.getSelectedFile())) {
                    guardado.write(viewConsultas.getTxtAreaDetailsWar().getText());
                    JOptionPane.showMessageDialog(viewConsultas, "El archivo fue guardado con éxito en la ruta establecida");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(viewConsultas, ex.getMessage());
        }
    }

        private void setWarDTO() {
              int row = viewConsultas.getJtableWarList().getSelectedRow();
        if (row >= 0) {
            guerra = new Guerra();
            //Le pasaremos solo la ID del objeto que queremos Consultar Posteriormente, y con hibernate, haremos el resto del trabajo
            guerra.setIdGuerra(Integer.parseInt(String.valueOf(viewConsultas.getJtableWarList().getValueAt(row, 0))));
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
			DAOguerra.lightSearchGuerras(viewConsultas.getTxtfFilterWar().getText());
			tableModelGuerra.fireTableDataChanged();			
		}
            });
            
	    timerbuscar.setRepeats(false);
	    timerbuscar.start();
	}
	
    }
  
}//Fin de la clase principal
