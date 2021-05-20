/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.Country.Country_HibJTableModel;
import Models.Country.Country_DAO;
import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views.viewCountries;
import views.viewPrincipal;

/**
 *
 * @author grupo1
 */
public final class controllerCountry implements ActionListener {

    
    private Country_HibJTableModel country_TableView;
    
    viewCountries viewCountrie;
   
    Country_DAO businness;
    Pais countryDTO;
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    //AGREGAR MODELs *** 

    //Constructor
    public controllerCountry(viewPrincipal viewPpal) throws ClassNotFoundException, SQLException {

        //AGREGAR MODELs ***
        viewCountrie = new viewCountries(viewPpal, true);
        businness = new Country_DAO();
        initComponents();
        initEvents();

        viewCountrie.setVisible(true);
    }//Fin del constructor

    private void initComponents() {

        viewCountrie.getBtnUpdate().setEnabled(false);
        viewCountrie.getBtnDelete().setEnabled(false);
        viewCountrie.getBtnInsert().setEnabled(true);
        viewCountrie.getTF_CountryId().setEnabled(false);
        viewCountrie.getCheckBoxIndependent().setSelected(false);
        setIndependent();

    }//Fin initComponents

    public void initEvents() throws SQLException {
        //INICIALIZAR EVENTOS
        viewCountrie.getBtnInsert().addActionListener(this);
        viewCountrie.getBtnUpdate().addActionListener(this);
        viewCountrie.getBtnDelete().addActionListener(this);
        viewCountrie.getBtnExit().addActionListener(this);
        viewCountrie.getCheckBoxIndependent().addActionListener(this);

//////// JTABLEEE HIBERNATE!!
        businness.queriesI();
        country_TableView = new Country_HibJTableModel(businness);
        viewCountrie.getJtableCountries().setModel(country_TableView);
 ////////////////////////////////////////////////////////  
   
 
        viewCountrie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewCountrie.getJtableCountries().clearSelection();
                clearTextFields();
                initComponents();

            }

        });
        /*Agregamos un evento de ratón a la tabla para seleccionar
        los valores de una fila y colocarlos en los cajones de texto*/
        viewCountrie.getJtableCountries().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    selected_row();
                    viewCountrie.getBtnUpdate().setEnabled(true);
                    viewCountrie.getBtnDelete().setEnabled(true);
                    viewCountrie.getBtnInsert().setEnabled(false);
                    if (!viewCountrie.getTxtfDateBegin().getText().isEmpty() && !viewCountrie.getTxtfDateBegin().getText().equalsIgnoreCase("null")) {
                        viewCountrie.getCheckBoxIndependent().doClick();
                        setIndependent();

                    }

                }
            }

        }
        );

        viewCountrie.getTxtfSearch().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (e.getDocument() == viewCountrie.getTxtfSearch().getDocument()) {
                    activoTimer();

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (e.getDocument() == viewCountrie.getTxtfSearch().getDocument()) {
                    activoTimer();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (e.getDocument() == viewCountrie.getTxtfSearch().getDocument()) {
                    activoTimer();

                }
            }
        });

    }//Fin initEvents

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == viewCountrie.getBtnInsert()) {
            
            //insert pais con independencia
            if (viewCountrie.getCheckBoxIndependent().isSelected() == true) {
                countryDTO = new Pais();
                countryDTO.setNombre(viewCountrie.getTxtfCountryName().getText());
                
                businness.insert(countryDTO);
		
                if(viewCountrie.getTxtfDateBegin().getText().length()>0){
                         
                    PeriodoIndependecia pi= new PeriodoIndependecia();
                    pi.setAnioInicio(Integer.parseInt(viewCountrie.getTxtfDateBegin().getText()));
                    pi.setAnioFin(Integer.parseInt(viewCountrie.getTxtfDateEnd().getText())); 
                    
                    //Añadiendo al objeto el periodo de independencia
                    countryDTO.getPeriodoIndependecias().add(pi);
                    businness.insertIndependencePeriod(countryDTO);
		
                }
                list();
                    
                                    
            //insert de pais solo
            } else {
             
                    countryDTO = new Pais();
                    countryDTO.setNombre(viewCountrie.getTxtfCountryName().getText());
                    businness.insert(countryDTO);
                    list();
               
            }

            //update
        } else if (ae.getSource() == viewCountrie.getBtnUpdate()) {
            countryDTO = setCountryDTO();

            if (viewCountrie.getCheckBoxIndependent().isSelected() == true) {

                try {
                    businness.update(countryDTO);
                    //////////////////
                    
                    if(viewCountrie.getTxtfDateBegin().getText().length()>0){
                         
                    PeriodoIndependecia pi= new PeriodoIndependecia();
                    pi.setAnioInicio(Integer.parseInt(viewCountrie.getTxtfDateBegin().getText()));
                    pi.setAnioFin(Integer.parseInt(viewCountrie.getTxtfDateEnd().getText())); 
                    
                    //Añadiendo al objeto el periodo de independencia
                    countryDTO.getPeriodoIndependecias().add(pi);
                    
                    businness.updateIndependencePeriod(countryDTO);
                }
                    
                   
                    /////////////7
                    
                    list();
                } catch (SQLException ex) {
                    System.out.println("falló update de pais solo");
                }

            } else {

                try {
                    businness.update(countryDTO);
                    businness.deleteIndependencePeriod(countryDTO);
                    list();
                } catch (SQLException ex) {
                    Logger.getLogger(controllerCountry.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //Delete
        } else if (ae.getSource() == viewCountrie.getBtnDelete()) {
          
                countryDTO = new Pais();
                countryDTO.setIdPais(Integer.parseInt(viewCountrie.getTF_CountryId().getText()));
                businness.delete(countryDTO);
                list();
		clearTextFields();
        
        } else if (ae.getSource() == viewCountrie.getBtnExit()) {
            viewCountrie.dispose();
        } else if (ae.getSource() == viewCountrie.getCheckBoxIndependent()) {
            setIndependent();
        }//Fin del else-if

    }//Fin de action performed

    //Seteara las etiquetas acorde al CheckBox
    private void setIndependent() {
        boolean aux = viewCountrie.getCheckBoxIndependent().isSelected();
        viewCountrie.getLblDateBegin().setEnabled(aux);
        viewCountrie.getTxtfDateBegin().setEnabled(aux);
        viewCountrie.getLblDateEnd().setEnabled(aux);
        viewCountrie.getTxtfDateEnd().setEnabled(aux);
    }//Fin set independent

    private void clearTextFields() {
        viewCountrie.getTF_CountryId().setText("");
        viewCountrie.getTxtfCountryName().setText("");
        viewCountrie.getTxtfDateBegin().setText("");
        viewCountrie.getTxtfDateEnd().setText("");
    }

    private void selected_row() {
        int row = viewCountrie.getJtableCountries().getSelectedRow();
        if (row >= 0) {
            viewCountrie.getTF_CountryId().setText(String.valueOf(viewCountrie.getJtableCountries().getValueAt(row, 0)));
            viewCountrie.getTxtfCountryName().setText(String.valueOf(viewCountrie.getJtableCountries().getValueAt(row, 1)));
            
            if (viewCountrie.getJtableCountries().getValueAt(row, 3)==null){
                viewCountrie.getTxtfDateBegin().setText("");        
            }else{
                viewCountrie.getTxtfDateBegin().setText(String.valueOf(viewCountrie.getJtableCountries().getValueAt(row, 3)));      
            }
            
            if (viewCountrie.getJtableCountries().getValueAt(row, 4)==null){
                viewCountrie.getTxtfDateEnd().setText("");        
            }else{
                viewCountrie.getTxtfDateEnd().setText(String.valueOf(viewCountrie.getJtableCountries().getValueAt(row, 4)));      
            }
          
        }
    }

    private void list()  {
        businness.queriesI();
        country_TableView.fireTableDataChanged();
    }

    //Settear el objeto
    private Pais setCountryDTO() {
        countryDTO = new Pais();
        countryDTO.setIdPais(Integer.parseInt(viewCountrie.getTF_CountryId().getText()));
        countryDTO.setNombre(viewCountrie.getTxtfCountryName().getText());

        return countryDTO;
    }

    
    
    
    
    
    
    
    
    private void activoTimer() {

        if ((timerbuscar != null) && timerbuscar.isRunning()) {
            timerbuscar.restart();
        } else {
            timerbuscar = new Timer(TIEMPOBUSCAR, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   
                        timerbuscar = null;
                        businness.lightSearch(viewCountrie.getTxtfSearch().getText());
                        country_TableView.fireTableDataChanged();
                   
                }

            });
            timerbuscar.setRepeats(false);
            timerbuscar.start();
        }

    }
}//Fin de clase principal
