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
import Views.ViewContendientes;
import Views.ViewPrincipal;

/**
 *
 * @author davidf
 */
class controllerContendientes implements ActionListener {
    
    /////////////////////////////////////
    private ViewContendientes viewContendientes;
    private DAOContendiente DAOcontendiente;
    private DAOUnionBandos DAOunionBandos;
    private DAOComboBoxesFill DAOcomboBoxesFill;
    
    //AGREGAR MODELs *** 

    //Constructor
    public controllerContendientes(ViewPrincipal viewPrincipal){

	//AGREGAR MODELs ***
	viewContendientes = new ViewContendientes(viewPrincipal, true);
	DAOcontendiente = new DAOContendiente();
        DAOunionBandos = new DAOUnionBandos();
        DAOcomboBoxesFill = new DAOComboBoxesFill();
	initComponents();
	initEvents();

	viewContendientes.setVisible(true);
    }//Fin del constructor

    private void initComponents() {
	viewContendientes.getComboBoxSelectContender().setEnabled(false);
	viewContendientes.getBtnDeleteSelectedContender().setEnabled(false);

	viewContendientes.getLblInsertNewContender().setEnabled(false);
	viewContendientes.getLblContenderName().setEnabled(false);
	viewContendientes.getTxtfInsertNewContender().setEnabled(false);
	viewContendientes.getBtnInsertNewContender().setEnabled(false);

	viewContendientes.getLblUpdateSelectedContender().setEnabled(false);
	viewContendientes.getLblUpdateContenderName().setEnabled(false);
	viewContendientes.getTxtfUpdateSelectedContender().setEnabled(false);
	viewContendientes.getBtnUpdateSelectedContender().setEnabled(false);

	viewContendientes.getComboBoxSelectCountryADDED().setEnabled(false);
	viewContendientes.getBtnDeleteSelectCountryADDED().setEnabled(false);

	viewContendientes.getLblInsertNewCountry().setEnabled(false);
	viewContendientes.getLblUpdateDateBegin().setEnabled(false);
	viewContendientes.getLblUpdateDateEnd().setEnabled(false);
	viewContendientes.getBtnUpdateDate().setEnabled(false);

	viewContendientes.getLblUpdateSelectedCountry().setEnabled(false);
	viewContendientes.getLblDateBeginCountryToContender().setEnabled(false);
	viewContendientes.getBtnInsertCountryToContender().setEnabled(false);
	viewContendientes.getComboBoxSelectCountryToContender().setEnabled(false);

	viewContendientes.getCb_Ganador().setEnabled(false);
	viewContendientes.getCb_GanadorInsert().setEnabled(false);

	viewContendientes.getjDC_BeginDate().setEnabled(false);
	viewContendientes.getjDC_EndDate().setEnabled(false);

    }

    private void initEvents() {
	viewContendientes.getBtnInsertNewContender().addActionListener(this);
	viewContendientes.getBtnInsertCountryToContender().addActionListener(this);

	viewContendientes.getBtnDeleteSelectedContender().addActionListener(this);
	viewContendientes.getBtnDeleteSelectCountryADDED().addActionListener(this);

	viewContendientes.getBtnUpdateDate().addActionListener(this);
	viewContendientes.getBtnUpdateSelectedContender().addActionListener(this);

	viewContendientes.getCb_Ganador().addActionListener(this);
	viewContendientes.getCb_GanadorInsert().addActionListener(this);
	viewContendientes.getCB_FechaAbandono().addActionListener(this);
	viewContendientes.getCB_updateFechaAbandono().addActionListener(this);

//IMPLEMENTAR AQUÍ VACIADO DE TODO EL FORMULARIO AL CLICKAR FUERA
	viewContendientes.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		resetComboboxes();
		initComponents();

	    }
	});

	viewContendientes.getBtnExit().addActionListener(this);

        
        
        
	 //COMBOBOX DE GUERRAS
	viewContendientes.getComboBoxSelectWar().setModel(DAOcomboBoxesFill.fillComboBoxGuerras());
        
	viewContendientes.getComboBoxSelectWar().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    System.out.println(e.getItem().toString());
                    System.out.println(e.getID());
                    
		    viewContendientes.getComboBoxSelectContender().setEnabled(true);
		  
			String nombre = (String) viewContendientes.getComboBoxSelectWar().getSelectedItem();
			viewContendientes.getComboBoxSelectContender().setModel(DAOcomboBoxesFill.fillComboBoxContendientes(nombre));
		
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
	viewContendientes.getComboBoxSelectContender().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
                    
                    
		    viewContendientes.getLblInsertNewCountry().setEnabled(true);
		    viewContendientes.getComboBoxSelectCountryADDED().setEnabled(true);
		    viewContendientes.getComboBoxSelectCountryToContender().setEnabled(true);
		    String nombre = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
		    viewContendientes.getTxtfUpdateSelectedContender().setText(nombre);
		    //marcar checkbox ganador
		    int ganador = 0;
		   
			ganador = DAOcontendiente.isWinnerContender(nombre);
	
		    if (ganador == 1) {
			viewContendientes.getCb_Ganador().setSelected(true);
		    } else {
			viewContendientes.getCb_Ganador().setSelected(false);
		    }
			viewContendientes.getComboBoxSelectCountryADDED().setModel(DAOcomboBoxesFill.fillComboBoxPaises(nombre));
			viewContendientes.getComboBoxSelectCountryToContender().setModel(DAOcomboBoxesFill.fillComboBoxAllPaises());


		    contenderUpdateSetActive();
		    contenderInsertDeactivate();

		}
	    }
	});

	//COMBOBOX INSERTAR PAIS
	viewContendientes.getComboBoxSelectCountryToContender().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

                    System.out.println(e.getItem().toString());
                    
                    
		    countriesUpdateDeactivate();
		    countriesInsertSetActive();
		    contenderUpdateDeactivate();

		}
	    }
	});

	//COMBOBOX MODIFICAR PAIS	
	viewContendientes.getComboBoxSelectCountryADDED().addItemListener(new ItemListener() {
            
            
	    @Override
	    public void itemStateChanged(ItemEvent e) {
                
		Date date1 = null;
		Date date2;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (e.getStateChange() == e.SELECTED) {
		    String fecha1;
		    String fecha2="";
		    String nombrePais = (String) viewContendientes.getComboBoxSelectCountryADDED().getSelectedItem();
		    String nombreContendiente = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
                    
                     UnionBandos unionBandos = DAOunionBandos.selectUnionBandos(nombreContendiente, nombrePais);

                    
                                     

			//parseo de fecha string a date
			try {
                            fecha1 = unionBandos.getFechaUnion();
			    date1 = df.parse(fecha1);

			} catch (Exception ex) {

			 viewContendientes.getjDC_updateBeginDate().setEnabled(false);
			}
         
			viewContendientes.getjDC_updateBeginDate().setDate(date1);
                        
                        
                        

			try {
                            fecha2 = unionBandos.getFechaAbandono();
			    date2 = df.parse(fecha2);
                            viewContendientes.getjDC_updateEndDate().setDate(date2);
		
                           	} catch (Exception ex) {
			   // date2 = df.parse("0001-01-01");
                            viewContendientes.getjDC_updateEndDate().setEnabled(false);
			 //   viewContender.getjDC_updateEndDate().setEnabled(false);
			}
			
                       
		
		    countriesInsertDeactivate();
		    countriesUpdateSetActive();
		    viewContendientes.getBtnDeleteSelectCountryADDED().setEnabled(true);
                    
                    try{
                        if(!fecha2.equals("")){
                         viewContendientes.getCB_updateFechaAbandono().setSelected(true);
                        viewContendientes.getjDC_updateEndDate().setEnabled(true);
                    }else{
                        viewContendientes.getjDC_updateEndDate().setEnabled(false);
                        viewContendientes.getCB_updateFechaAbandono().setSelected(false);
                        }
                    }catch(NullPointerException npe){
                        viewContendientes.getjDC_updateEndDate().setEnabled(false);
                        viewContendientes.getCB_updateFechaAbandono().setSelected(false);
                        
                    }
		}
	    }
	});

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == viewContendientes.getBtnExit()) {
	    viewContendientes.dispose();
	}

	//Insertar nuevo contendiente
	if (e.getSource() == viewContendientes.getBtnInsertNewContender()) {
	  
		int ganador;
                
                if (viewContendientes.getCb_GanadorInsert().isSelected()) {
		    ganador = 1;
		} else {
		    ganador = 0;
		}

                String nombreGuerra = (String) viewContendientes.getComboBoxSelectWar().getSelectedItem();
                
                Contendiente contendiente = new Contendiente();
                contendiente.setNombre(viewContendientes.getTxtfInsertNewContender().getText());
                contendiente.setGanador(ganador);
         
                DAOcontendiente.insertContendiente(contendiente, nombreGuerra); //Enviando el contendiente Seteado y el NOMBRE de la GUERRA
                
		cleanContenderForm();
		refreshContenderComboBox();

	
	}

	//Eliminar contendiente seleccionado
	if (e.getSource() == viewContendientes.getBtnDeleteSelectedContender()) {
	    String contenderName = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
	    Contendiente contendiente = new Contendiente();
	    contendiente.setNombre(contenderName);
	
		DAOcontendiente.deleteContendiente(contendiente);
		refreshContenderComboBox();
		cleanUpdateContenderForm();


	}

	//Actualizar contendiente seleccionado
	if (e.getSource() == viewContendientes.getBtnUpdateSelectedContender()) {
      
                int ganador;
                Contendiente contendiente = new Contendiente();
                String newContenderName = viewContendientes.getTxtfUpdateSelectedContender().getText();
                String oldContenderName = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
                contendiente.setNombre(newContenderName);
                
                if (viewContendientes.getCb_Ganador().isSelected()) {
                    ganador = 1;
                } else {
                    ganador = 0;
                }
                contendiente.setGanador(ganador);
                
                
                DAOcontendiente.updateContendiente(contendiente, oldContenderName);
                refreshContenderComboBox();
                cleanUpdateContenderForm();
       

	}

	//Insertar países a contendientes
	if (e.getSource() == viewContendientes.getBtnInsertCountryToContender()) {
	    String pais, contendiente, fecha_abandono = "";
	    UnionBandos unionBandos = new UnionBandos();
	
		contendiente = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
		pais = (String) viewContendientes.getComboBoxSelectCountryToContender().getSelectedItem();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = viewContendientes.getjDC_BeginDate().getDate();
		String fecha_union = df.format(date1);

		if (viewContendientes.getCB_FechaAbandono().isSelected()) {
		    viewContendientes.getjDC_EndDate().setEnabled(true);
		    Date date2 = viewContendientes.getjDC_EndDate().getDate();
		    fecha_abandono = df.format(date2);

		} else {
		    fecha_abandono = "";
		}
   
		unionBandos.setFechaAbandono(fecha_abandono);
		unionBandos.setFechaUnion(fecha_union);

                DAOunionBandos.insertUnionBandos(unionBandos,contendiente,pais);
                
		cleanCountriesForm();
		if (viewContendientes.getComboBoxSelectCountryToContender().getSelectedIndex() == 0) {
		    countriesUpdateSetActive();
		}
		refreshCountriesAddedComboBox();
	}

	//Eliminar países de contendientes
	if (e.getSource() == viewContendientes.getBtnDeleteSelectCountryADDED()) {
	    String pais, contendiente;
	
	
		contendiente = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
		pais = (String) viewContendientes.getComboBoxSelectCountryADDED().getSelectedItem();
	        DAOunionBandos.deleteUnionBandos(contendiente, pais);
		refreshCountriesAddedComboBox();
	
	}

	
	//Evento que detecta cambio en el checkbox para habilitar JDC fecha_abandono de insertar paises
	viewContendientes.getCB_FechaAbandono().addChangeListener(new ChangeListener() {
	    @Override
	    public void stateChanged(ChangeEvent e) {
		if (viewContendientes.getCB_FechaAbandono().isSelected()) {
		    viewContendientes.getjDC_EndDate().setEnabled(true);
		}else{
		    viewContendientes.getjDC_EndDate().setEnabled(false);
		}
	    }
	});
        
        
        //Evento que detecta cambio en el checkbox para habilitar JDC fecha_abandono de updateContendiente paises
	viewContendientes.getCB_updateFechaAbandono().addChangeListener(new ChangeListener() {
	    @Override
	    public void stateChanged(ChangeEvent e) {
		if (viewContendientes.getCB_updateFechaAbandono().isSelected()) {
		    viewContendientes.getjDC_updateEndDate().setEnabled(true);
		}else{
		    viewContendientes.getjDC_updateEndDate().setEnabled(false);
		}
	    }
	});



	//Actualizar países de contendientes
	if (e.getSource() == viewContendientes.getBtnUpdateDate()) {
	    String nombrePais, nombreContendiente;
	    UnionBandos unionBandos = new UnionBandos();
	
		nombreContendiente = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
		nombrePais = (String) viewContendientes.getComboBoxSelectCountryADDED().getSelectedItem();


		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = viewContendientes.getjDC_updateBeginDate().getDate();
		String fecha_union = df.format(date1);
		Date date2 = viewContendientes.getjDC_updateEndDate().getDate();
		String fecha_abandono = df.format(date2);      
                if (!viewContendientes.getCB_updateFechaAbandono().isSelected()) {
		    fecha_abandono = "";
                    unionBandos.setFechaAbandono(fecha_abandono);
		}else{
                    unionBandos.setFechaAbandono(fecha_abandono);
                }
		unionBandos.setFechaUnion(fecha_union);		
                
		DAOunionBandos.updateUnionBandos(unionBandos,nombreContendiente,nombrePais);                
              
		refreshCountriesAddedComboBox();
		cleanUpdateCountriesForm();
	
	}
    }

    private void resetComboboxes() {
	viewContendientes.getComboBoxSelectWar().setSelectedIndex(0);
	viewContendientes.getComboBoxSelectContender().setSelectedIndex(0);
	viewContendientes.getComboBoxSelectCountryToContender().setSelectedIndex(0);
	viewContendientes.getComboBoxSelectCountryADDED().setSelectedIndex(0);

    }

    private void contenderInsertSetActive() {
	viewContendientes.getLblInsertNewContender().setEnabled(true);
	viewContendientes.getLblContenderName().setEnabled(true);
	viewContendientes.getTxtfInsertNewContender().setEnabled(true);
	viewContendientes.getBtnInsertNewContender().setEnabled(true);
	viewContendientes.getCb_GanadorInsert().setEnabled(true);

    }

    private void contenderInsertDeactivate() {
	viewContendientes.getLblInsertNewContender().setEnabled(false);
	viewContendientes.getLblContenderName().setEnabled(false);
	viewContendientes.getTxtfInsertNewContender().setEnabled(false);
	viewContendientes.getBtnInsertNewContender().setEnabled(false);
	viewContendientes.getCb_GanadorInsert().setEnabled(false);
    }

    private void contenderUpdateSetActive() {
	viewContendientes.getLblUpdateSelectedContender().setEnabled(true);
	viewContendientes.getLblUpdateContenderName().setEnabled(true);
	viewContendientes.getTxtfUpdateSelectedContender().setEnabled(true);
	viewContendientes.getBtnUpdateSelectedContender().setEnabled(true);
	viewContendientes.getBtnDeleteSelectedContender().setEnabled(true);
	viewContendientes.getCb_Ganador().setEnabled(true);

    }

    private void contenderUpdateDeactivate() {
	viewContendientes.getLblUpdateSelectedContender().setEnabled(false);
	viewContendientes.getLblUpdateContenderName().setEnabled(false);
	viewContendientes.getTxtfUpdateSelectedContender().setEnabled(false);
	viewContendientes.getBtnUpdateSelectedContender().setEnabled(false);
	viewContendientes.getBtnDeleteSelectedContender().setEnabled(false);
	viewContendientes.getCb_Ganador().setEnabled(false);
   
    }

    private void countriesInsertSetActive() {
	viewContendientes.getLblDateBeginCountryToContender().setEnabled(true);
	viewContendientes.getBtnInsertCountryToContender().setEnabled(true);
	viewContendientes.getjDC_BeginDate().setEnabled(true);
	viewContendientes.getCB_FechaAbandono().setSelected(false);
	viewContendientes.getjDC_EndDate().setEnabled(false);

    }

    private void countriesInsertDeactivate() {
	viewContendientes.getLblDateBeginCountryToContender().setEnabled(false);
	viewContendientes.getBtnInsertCountryToContender().setEnabled(false);
	viewContendientes.getComboBoxSelectCountryToContender().setEnabled(false);
	viewContendientes.getLblInsertNewCountry().setEnabled(false);
	viewContendientes.getjDC_BeginDate().setEnabled(false);
	viewContendientes.getjDC_EndDate().setEnabled(false);

    }

    private void countriesUpdateSetActive() {
	viewContendientes.getComboBoxSelectCountryADDED().setEnabled(true);
	viewContendientes.getLblUpdateSelectedCountry().setEnabled(true);
	viewContendientes.getLblUpdateDateBegin().setEnabled(true);
	viewContendientes.getBtnUpdateDate().setEnabled(true);
	viewContendientes.getjDC_updateBeginDate().setEnabled(true);
                
        viewContendientes.getLblUpdateDateEnd().setEnabled(true);
	viewContendientes.getjDC_updateEndDate().setEnabled(false);
        viewContendientes.getCB_updateFechaAbandono().setSelected(false);


    }

    private void countriesUpdateDeactivate() {
	viewContendientes.getLblUpdateDateBegin().setEnabled(false);
	viewContendientes.getLblUpdateDateEnd().setEnabled(false);
	viewContendientes.getBtnUpdateDate().setEnabled(false);
	viewContendientes.getBtnDeleteSelectCountryADDED().setEnabled(false);
	viewContendientes.getComboBoxSelectCountryADDED().setEnabled(false);
	viewContendientes.getLblUpdateSelectedCountry().setEnabled(false);
	viewContendientes.getjDC_updateBeginDate().setEnabled(false);
	viewContendientes.getjDC_updateEndDate().setEnabled(false);
        viewContendientes.getCB_updateFechaAbandono().setSelected(false);


    }

    public controllerContendientes() {
    }

    private void cleanContenderForm() {
	viewContendientes.getTxtfInsertNewContender().setText("");
	viewContendientes.getCb_GanadorInsert().setSelected(false);
    }

    private void cleanUpdateContenderForm() {
	viewContendientes.getTxtfUpdateSelectedContender().setText("");
	viewContendientes.getCb_Ganador().setSelected(false);
    }

    private void cleanCountriesForm() {
	viewContendientes.getjDC_BeginDate().setDate(new Date());
	viewContendientes.getjDC_EndDate().setDate(new Date());
	viewContendientes.getComboBoxSelectCountryToContender().setSelectedIndex(0);
    }

    private void cleanUpdateCountriesForm() {
	viewContendientes.getjDC_updateBeginDate().setDate(new Date());
	viewContendientes.getjDC_updateEndDate().setDate(new Date());
    }

    private void refreshContenderComboBox() {
	viewContendientes.getComboBoxSelectContender().removeAllItems();
	viewContendientes.getComboBoxSelectContender().setModel(DAOcomboBoxesFill.fillComboBoxContendientes((String) viewContendientes.getComboBoxSelectWar().getSelectedItem()));
    }

    private void refreshCountriesAddedComboBox()  {
	viewContendientes.getComboBoxSelectCountryADDED().removeAllItems();
	viewContendientes.getComboBoxSelectCountryADDED().setModel(DAOcomboBoxesFill.fillComboBoxPaises((String) viewContendientes.getComboBoxSelectContender().getSelectedItem()));
    }

}//Fin clase proincipal
