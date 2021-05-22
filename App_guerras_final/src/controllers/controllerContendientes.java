/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.DAOs.DAOContendiente;
import Models.DAOs.DAOComboBoxesFill;
import Models.DAOs.DAOUnionBandos;
import Models.POJOs.Contendiente;
import Models.POJOs.UnionBandos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import views.viewContendientes;
import views.viewPrincipal;

/**
 *
 * @author davidf
 */
class controllerContendientes implements ActionListener {
    
    /////////////////////////////////////
    private viewContendientes viewContender;
    private DAOContendiente businness;
    private DAOUnionBandos DAOunionBandos;
    private DAOComboBoxesFill DAOcomboBoxesFill;
    
    //AGREGAR MODELs *** 

    //Constructor
    public controllerContendientes(viewPrincipal viewPpal){

	//AGREGAR MODELs ***
	viewContender = new viewContendientes(viewPpal, true);
	businness = new DAOContendiente();
        DAOunionBandos = new DAOUnionBandos();
        DAOcomboBoxesFill = new DAOComboBoxesFill();
	initComponents();
	initEvents();

	viewContender.setVisible(true);
    }//Fin del constructor

    private void initComponents() {
	viewContender.getComboBoxSelectContender().setEnabled(false);
	viewContender.getBtnDeleteSelectedContender().setEnabled(false);

	viewContender.getLblInsertNewContender().setEnabled(false);
	viewContender.getLblContenderName().setEnabled(false);
	viewContender.getTxtfInsertNewContender().setEnabled(false);
	viewContender.getBtnInsertNewContender().setEnabled(false);

	viewContender.getLblUpdateSelectedContender().setEnabled(false);
	viewContender.getLblUpdateContenderName().setEnabled(false);
	viewContender.getTxtfUpdateSelectedContender().setEnabled(false);
	viewContender.getBtnUpdateSelectedContender().setEnabled(false);

	viewContender.getComboBoxSelectCountryADDED().setEnabled(false);
	viewContender.getBtnDeleteSelectCountryADDED().setEnabled(false);

	viewContender.getLblInsertNewCountry().setEnabled(false);
	viewContender.getLblUpdateDateBegin().setEnabled(false);
	viewContender.getLblUpdateDateEnd().setEnabled(false);
	viewContender.getBtnUpdateDate().setEnabled(false);

	viewContender.getLblUpdateSelectedCountry().setEnabled(false);
	viewContender.getLblDateBeginCountryToContender().setEnabled(false);
	viewContender.getBtnInsertCountryToContender().setEnabled(false);
	viewContender.getComboBoxSelectCountryToContender().setEnabled(false);

	viewContender.getCb_Ganador().setEnabled(false);
	viewContender.getCb_GanadorInsert().setEnabled(false);

	viewContender.getjDC_BeginDate().setEnabled(false);
	viewContender.getjDC_EndDate().setEnabled(false);

    }

    private void initEvents() {
	viewContender.getBtnInsertNewContender().addActionListener(this);
	viewContender.getBtnInsertCountryToContender().addActionListener(this);

	viewContender.getBtnDeleteSelectedContender().addActionListener(this);
	viewContender.getBtnDeleteSelectCountryADDED().addActionListener(this);

	viewContender.getBtnUpdateDate().addActionListener(this);
	viewContender.getBtnUpdateSelectedContender().addActionListener(this);

	viewContender.getCb_Ganador().addActionListener(this);
	viewContender.getCb_GanadorInsert().addActionListener(this);
	viewContender.getCB_FechaAbandono().addActionListener(this);
	viewContender.getCB_updateFechaAbandono().addActionListener(this);

//IMPLEMENTAR AQUÍ VACIADO DE TODO EL FORMULARIO AL CLICKAR FUERA
	viewContender.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		resetComboboxes();
		initComponents();

	    }
	});

	viewContender.getBtnExit().addActionListener(this);

	 //COMBOBOX DE GUERRAS
	viewContender.getComboBoxSelectWar().setModel(DAOcomboBoxesFill.fillComboBoxModelWar());
        
	viewContender.getComboBoxSelectWar().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == e.SELECTED) {
		    viewContender.getComboBoxSelectContender().setEnabled(true);
		  
			String nombre = (String) viewContender.getComboBoxSelectWar().getSelectedItem();
			viewContender.getComboBoxSelectContender().setModel(DAOcomboBoxesFill.fillComboBoxContender(nombre));
		
		    contenderInsertSetActive();
		    countriesUpdateDeactivate();
		    cleanContenderForm();
		    cleanCountriesForm();
		    cleanUpdateContenderForm();
		    cleanUpdateCountriesForm();
		
			refreshCountriesAddedComboBox();
		
		}
	    }
	}
	);

	//COMBOBOX CONTENDER
	viewContender.getComboBoxSelectContender().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == e.SELECTED) {
                    
                    
		    viewContender.getLblInsertNewCountry().setEnabled(true);
		    viewContender.getComboBoxSelectCountryADDED().setEnabled(true);
		    viewContender.getComboBoxSelectCountryToContender().setEnabled(true);
		    String nombre = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		    viewContender.getTxtfUpdateSelectedContender().setText(nombre);
		    //marcar checkbox ganador
		    int ganador = 0;
		   
			ganador = businness.select_Winner(nombre);
	
		    if (ganador == 1) {
			viewContender.getCb_Ganador().setSelected(true);
		    } else {
			viewContender.getCb_Ganador().setSelected(false);
		    }
			viewContender.getComboBoxSelectCountryADDED().setModel(DAOcomboBoxesFill.fillComboBoxCountry(nombre));
			viewContender.getComboBoxSelectCountryToContender().setModel(DAOcomboBoxesFill.fillAllCountriesCombobox());


		    contenderUpdateSetActive();
		    contenderInsertDeactivate();

		}
	    }
	});

	//COMBOBOX INSERTAR PAIS
	viewContender.getComboBoxSelectCountryToContender().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == e.SELECTED) {

		    countriesUpdateDeactivate();
		    countriesInsertSetActive();
		    contenderUpdateDeactivate();

		}
	    }
	});

	//COMBOBOX MODIFICAR PAIS	
	viewContender.getComboBoxSelectCountryADDED().addItemListener(new ItemListener() {
            
            
	    @Override
	    public void itemStateChanged(ItemEvent e) {
                
		Date date1 = null;
		Date date2;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (e.getStateChange() == e.SELECTED) {
		    String fecha1;
		    String fecha2;
		    String nombrePais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();
		    String nombreContendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();


			fecha1 = DAOunionBandos.select_BeginDate(nombreContendiente, nombrePais);
			fecha2 = DAOunionBandos.select_EndDate(nombreContendiente, nombrePais);                 

			//parseo de fecha string a date
			try {
			    date1 = df.parse(fecha1);

			} catch (Exception ex) {
////                        try {
////                            date1 = df.parse("0001-01-01");
////                        } catch (ParseException ex1) {
////                            Logger.getLogger(controllerContendientes.class.getName()).log(Level.SEVERE, null, ex1);
////                        }
			 viewContender.getjDC_updateBeginDate().setEnabled(false);
			}
         
			viewContender.getjDC_updateBeginDate().setDate(date1);
                        
                        
                        

			try {
			    date2 = df.parse(fecha2);
                            viewContender.getjDC_updateEndDate().setDate(date2);
			} catch (Exception ex) {
			   // date2 = df.parse("0001-01-01");
                            viewContender.getjDC_updateEndDate().setEnabled(false);
			 //   viewContender.getjDC_updateEndDate().setEnabled(false);
			}
			

		
		    countriesInsertDeactivate();
		    countriesUpdateSetActive();
		    viewContender.getBtnDeleteSelectCountryADDED().setEnabled(true);
                    
                    try{
                        if(!fecha2.equals("")){
                         viewContender.getCB_updateFechaAbandono().setSelected(true);
                        viewContender.getjDC_updateEndDate().setEnabled(true);
                    }else{
                        viewContender.getjDC_updateEndDate().setEnabled(false);
                        viewContender.getCB_updateFechaAbandono().setSelected(false);
                        }
                    }catch(NullPointerException npe){
                        viewContender.getjDC_updateEndDate().setEnabled(false);
                        viewContender.getCB_updateFechaAbandono().setSelected(false);
                        
                    }
		}
	    }
	});

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == viewContender.getBtnExit()) {
	    viewContender.dispose();
	}

	//Insertar nuevo contendiente
	if (e.getSource() == viewContender.getBtnInsertNewContender()) {
	  
		int ganador;
                
                if (viewContender.getCb_GanadorInsert().isSelected()) {
		    ganador = 1;
		} else {
		    ganador = 0;
		}

                String nombreGuerra = (String) viewContender.getComboBoxSelectWar().getSelectedItem();
                
                Contendiente contendiente = new Contendiente();
                contendiente.setNombre(viewContender.getTxtfInsertNewContender().getText());
                contendiente.setGanador(ganador);
         
                businness.insert(contendiente, nombreGuerra); //Enviando el contendiente Seteado y el NOMBRE de la GUERRA
                
		cleanContenderForm();
		refreshContenderComboBox();

	
	}

	//Eliminar contendiente seleccionado
	if (e.getSource() == viewContender.getBtnDeleteSelectedContender()) {
	    String contenderName = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
	    Contendiente contendiente = new Contendiente();
	    contendiente.setNombre(contenderName);
	
		businness.delete(contendiente);
		refreshContenderComboBox();
		cleanUpdateContenderForm();


	}

	//Actualizar contendiente seleccionado
	if (e.getSource() == viewContender.getBtnUpdateSelectedContender()) {
      
                int ganador;
                Contendiente contendiente = new Contendiente();
                String newContenderName = viewContender.getTxtfUpdateSelectedContender().getText();
                String oldContenderName = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
                contendiente.setNombre(newContenderName);
                
                if (viewContender.getCb_Ganador().isSelected()) {
                    ganador = 1;
                } else {
                    ganador = 0;
                }
                contendiente.setGanador(ganador);
                
                
                businness.update(contendiente, oldContenderName);
                refreshContenderComboBox();
                cleanUpdateContenderForm();
       

	}

	//Insertar países a contendientes
	if (e.getSource() == viewContender.getBtnInsertCountryToContender()) {
	    String pais, contendiente, fecha_abandono = "";
	    UnionBandos unionBandos = new UnionBandos();
	
		contendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		pais = (String) viewContender.getComboBoxSelectCountryToContender().getSelectedItem();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = viewContender.getjDC_BeginDate().getDate();
		String fecha_union = df.format(date1);

		if (viewContender.getCB_FechaAbandono().isSelected()) {
		    viewContender.getjDC_EndDate().setEnabled(true);
		    Date date2 = viewContender.getjDC_EndDate().getDate();
		    fecha_abandono = df.format(date2);

		} else {
		    fecha_abandono = "";
		}
   
		unionBandos.setFechaAbandono(fecha_abandono);
		unionBandos.setFechaUnion(fecha_union);

                DAOunionBandos.insert_country(unionBandos,contendiente,pais);
                
		cleanCountriesForm();
		if (viewContender.getComboBoxSelectCountryToContender().getSelectedIndex() == 0) {
		    countriesUpdateSetActive();
		}
		refreshCountriesAddedComboBox();
	}

	//Eliminar países de contendientes
	if (e.getSource() == viewContender.getBtnDeleteSelectCountryADDED()) {
	    String pais, contendiente;
	
	
		contendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		pais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();
	        DAOunionBandos.delete_country(contendiente, pais);
		refreshCountriesAddedComboBox();
	
	}

	
	//Evento que detecta cambio en el checkbox para habilitar JDC fecha_abandono de insertar paises
	viewContender.getCB_FechaAbandono().addChangeListener(new ChangeListener() {
	    @Override
	    public void stateChanged(ChangeEvent e) {
		if (viewContender.getCB_FechaAbandono().isSelected()) {
		    viewContender.getjDC_EndDate().setEnabled(true);
		}else{
		    viewContender.getjDC_EndDate().setEnabled(false);
		}
	    }
	});
        
        
        //Evento que detecta cambio en el checkbox para habilitar JDC fecha_abandono de update paises
	viewContender.getCB_updateFechaAbandono().addChangeListener(new ChangeListener() {
	    @Override
	    public void stateChanged(ChangeEvent e) {
		if (viewContender.getCB_updateFechaAbandono().isSelected()) {
		    viewContender.getjDC_updateEndDate().setEnabled(true);
		}else{
		    viewContender.getjDC_updateEndDate().setEnabled(false);
		}
	    }
	});



	//Actualizar países de contendientes
	if (e.getSource() == viewContender.getBtnUpdateDate()) {
	    String nombrePais, nombreContendiente;
	    UnionBandos unionBandos = new UnionBandos();
	
		nombreContendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		nombrePais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();


		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = viewContender.getjDC_updateBeginDate().getDate();
		String fecha_union = df.format(date1);
		Date date2 = viewContender.getjDC_updateEndDate().getDate();
		String fecha_abandono = df.format(date2);      
                if (!viewContender.getCB_updateFechaAbandono().isSelected()) {
		    fecha_abandono = "";
                    unionBandos.setFechaAbandono(fecha_abandono);
		}else{
                    unionBandos.setFechaAbandono(fecha_abandono);
                }
		unionBandos.setFechaUnion(fecha_union);		
                
		DAOunionBandos.update_country(unionBandos,nombreContendiente,nombrePais);                
              
		refreshCountriesAddedComboBox();
		cleanUpdateCountriesForm();
	
	}
    }

    private void resetComboboxes() {
	viewContender.getComboBoxSelectWar().setSelectedIndex(0);
	viewContender.getComboBoxSelectContender().setSelectedIndex(0);
	viewContender.getComboBoxSelectCountryToContender().setSelectedIndex(0);
	viewContender.getComboBoxSelectCountryADDED().setSelectedIndex(0);

    }

    private void contenderInsertSetActive() {
	viewContender.getLblInsertNewContender().setEnabled(true);
	viewContender.getLblContenderName().setEnabled(true);
	viewContender.getTxtfInsertNewContender().setEnabled(true);
	viewContender.getBtnInsertNewContender().setEnabled(true);
	viewContender.getCb_GanadorInsert().setEnabled(true);

    }

    private void contenderInsertDeactivate() {
	viewContender.getLblInsertNewContender().setEnabled(false);
	viewContender.getLblContenderName().setEnabled(false);
	viewContender.getTxtfInsertNewContender().setEnabled(false);
	viewContender.getBtnInsertNewContender().setEnabled(false);
	viewContender.getCb_GanadorInsert().setEnabled(false);
    }

    private void contenderUpdateSetActive() {
	viewContender.getLblUpdateSelectedContender().setEnabled(true);
	viewContender.getLblUpdateContenderName().setEnabled(true);
	viewContender.getTxtfUpdateSelectedContender().setEnabled(true);
	viewContender.getBtnUpdateSelectedContender().setEnabled(true);
	viewContender.getBtnDeleteSelectedContender().setEnabled(true);
	viewContender.getCb_Ganador().setEnabled(true);

    }

    private void contenderUpdateDeactivate() {
	viewContender.getLblUpdateSelectedContender().setEnabled(false);
	viewContender.getLblUpdateContenderName().setEnabled(false);
	viewContender.getTxtfUpdateSelectedContender().setEnabled(false);
	viewContender.getBtnUpdateSelectedContender().setEnabled(false);
	viewContender.getBtnDeleteSelectedContender().setEnabled(false);
	viewContender.getCb_Ganador().setEnabled(false);
   
    }

    private void countriesInsertSetActive() {
	viewContender.getLblDateBeginCountryToContender().setEnabled(true);
	viewContender.getBtnInsertCountryToContender().setEnabled(true);
	viewContender.getjDC_BeginDate().setEnabled(true);
	viewContender.getCB_FechaAbandono().setSelected(false);
	viewContender.getjDC_EndDate().setEnabled(false);

    }

    private void countriesInsertDeactivate() {
	viewContender.getLblDateBeginCountryToContender().setEnabled(false);
	viewContender.getBtnInsertCountryToContender().setEnabled(false);
	viewContender.getComboBoxSelectCountryToContender().setEnabled(false);
	viewContender.getLblInsertNewCountry().setEnabled(false);
	viewContender.getjDC_BeginDate().setEnabled(false);
	viewContender.getjDC_EndDate().setEnabled(false);

    }

    private void countriesUpdateSetActive() {
	viewContender.getComboBoxSelectCountryADDED().setEnabled(true);
	viewContender.getLblUpdateSelectedCountry().setEnabled(true);
	viewContender.getLblUpdateDateBegin().setEnabled(true);
	viewContender.getBtnUpdateDate().setEnabled(true);
	viewContender.getjDC_updateBeginDate().setEnabled(true);
                
        viewContender.getLblUpdateDateEnd().setEnabled(true);
	viewContender.getjDC_updateEndDate().setEnabled(false);
        viewContender.getCB_updateFechaAbandono().setSelected(false);


    }

    private void countriesUpdateDeactivate() {
	viewContender.getLblUpdateDateBegin().setEnabled(false);
	viewContender.getLblUpdateDateEnd().setEnabled(false);
	viewContender.getBtnUpdateDate().setEnabled(false);
	viewContender.getBtnDeleteSelectCountryADDED().setEnabled(false);
	viewContender.getComboBoxSelectCountryADDED().setEnabled(false);
	viewContender.getLblUpdateSelectedCountry().setEnabled(false);
	viewContender.getjDC_updateBeginDate().setEnabled(false);
	viewContender.getjDC_updateEndDate().setEnabled(false);
        viewContender.getCB_updateFechaAbandono().setSelected(false);


    }

    public controllerContendientes() {
    }

    private void cleanContenderForm() {
	viewContender.getTxtfInsertNewContender().setText("");
	viewContender.getCb_GanadorInsert().setSelected(false);
    }

    private void cleanUpdateContenderForm() {
	viewContender.getTxtfUpdateSelectedContender().setText("");
	viewContender.getCb_Ganador().setSelected(false);
    }

    private void cleanCountriesForm() {
	viewContender.getjDC_BeginDate().setDate(new Date());
	viewContender.getjDC_EndDate().setDate(new Date());
	viewContender.getComboBoxSelectCountryToContender().setSelectedIndex(0);
    }

    private void cleanUpdateCountriesForm() {
	viewContender.getjDC_updateBeginDate().setDate(new Date());
	viewContender.getjDC_updateEndDate().setDate(new Date());
    }

    private void refreshContenderComboBox() {
	viewContender.getComboBoxSelectContender().removeAllItems();
	viewContender.getComboBoxSelectContender().setModel(DAOcomboBoxesFill.fillComboBoxContender((String) viewContender.getComboBoxSelectWar().getSelectedItem()));
    }

    private void refreshCountriesAddedComboBox()  {
	viewContender.getComboBoxSelectCountryADDED().removeAllItems();
	viewContender.getComboBoxSelectCountryADDED().setModel(DAOcomboBoxesFill.fillComboBoxCountry((String) viewContender.getComboBoxSelectContender().getSelectedItem()));
    }

}//Fin clase proincipal
