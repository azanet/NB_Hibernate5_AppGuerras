/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import CONVERT_a_POJOS.AllyDTO;
import Models.Contender.Contender_Businness;
import CONVERT_a_POJOS.ContenderDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import views.viewContenders2;
import views.viewPrincipal;

/**
 *
 * @author grupo1
 */
class controllerContender implements ActionListener {

    viewContenders2 viewContender;
    Contender_Businness businness;
    ContenderDTO contenderDTO;
    AllyDTO allyDTO;
    //AGREGAR MODELs *** 

    //Constructor
    public controllerContender(viewPrincipal viewPpal) throws ClassNotFoundException, SQLException {

	//AGREGAR MODELs ***
	viewContender = new viewContenders2(viewPpal, true);
	businness = new Contender_Businness();
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

	try {
	    //COMBOBOX DE GUERRAS
	    viewContender.getComboBoxSelectWar().setModel(businness.fillComboBoxModelWar());
	} catch (SQLException ex) {
	    System.out.println("fallo al cargar combo guerras");
	}

	viewContender.getComboBoxSelectWar().addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == e.SELECTED) {
		    viewContender.getComboBoxSelectContender().setEnabled(true);
		    try {
			String nombre = (String) viewContender.getComboBoxSelectWar().getSelectedItem();
			viewContender.getComboBoxSelectContender().setModel(businness.fillComboBoxContender(nombre));
		    } catch (SQLException ex) {
			System.out.println("fallo al cargar combo contendientes");
		    }
		    contenderInsertSetActive();
		    countriesUpdateDeactivate();
		    cleanContenderForm();
		    cleanCountriesForm();
		    cleanUpdateContenderForm();
		    cleanUpdateCountriesForm();
		    try {
			refreshCountriesAddedComboBox();
		    } catch (SQLException ex) {
			Logger.getLogger(controllerContender.class.getName()).log(Level.SEVERE, null, ex);
		    }
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
		    try {
			ganador = businness.select_Winner(nombre);
		    } catch (SQLException ex) {
			System.out.println("Fallo al obtener ganador");

		    }
		    if (ganador == 1) {
			viewContender.getCb_Ganador().setSelected(true);
		    } else {
			viewContender.getCb_Ganador().setSelected(false);
		    }
		    try {
			viewContender.getComboBoxSelectCountryADDED().setModel(businness.fillComboBoxCountry(nombre));
			viewContender.getComboBoxSelectCountryToContender().setModel(businness.fillAllCountriesCombobox());

		    } catch (SQLException ex) {
			ex.printStackTrace(System.out);
		    }

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
		Date date1;
		Date date2;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (e.getStateChange() == e.SELECTED) {
		    String fecha1 = "0001-01-01";
		    String fecha2 = "";
		    String nombrePais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();
		    String nombreContendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();

		    try {
//			AllyDTO allyDTO = new AllyDTO();
			fecha1 = businness.select_BeginDate(nombreContendiente, nombrePais);
			fecha2 = businness.select_EndDate(nombreContendiente, nombrePais);                 

			//parseo de fecha string a date
			try {
			    date1 = df.parse(fecha1);

			} catch (Exception ex) {
			    date1 = df.parse("0001-01-01");
			    viewContender.getjDC_updateBeginDate().setEnabled(false);
			}
//			String newFecha1=df.format(date1);
			viewContender.getjDC_updateBeginDate().setDate(date1);

			try {
			    date2 = df.parse(fecha2);
                            viewContender.getjDC_updateEndDate().setDate(date2);
			} catch (Exception ex) {
			   // date2 = df.parse("0001-01-01");
                            viewContender.getjDC_updateEndDate().setEnabled(false);
			 //   viewContender.getjDC_updateEndDate().setEnabled(false);
			}
			

		    } catch (ParseException ex) {
			System.out.println("fallo al parsear fecha");

		    } catch (SQLException ex) {
			System.out.println("fallo al obtener fecha de unión y/o fecha de abandono");
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
	    try {
		int ganador = 0;
		String guerra = (String) viewContender.getComboBoxSelectWar().getSelectedItem();
		contenderDTO = new ContenderDTO();
		contenderDTO.setId_guerra(businness.select_idguerra(guerra));
		contenderDTO.setNombre(viewContender.getTxtfInsertNewContender().getText());
		if (viewContender.getCb_GanadorInsert().isSelected()) {
		    ganador = 1;
		} else {
		    ganador = 0;
		}

		contenderDTO.setGanador(ganador);
		businness.insert(contenderDTO);
		cleanContenderForm();
		refreshContenderComboBox();

	    } catch (SQLException ex) {
		System.out.println("Fallo al insertar nuevo contendiente");
	    }
	}

	//Eliminar contendiente seleccionado
	if (e.getSource() == viewContender.getBtnDeleteSelectedContender()) {
	    String contenderName = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
	    contenderDTO = new ContenderDTO();
	    contenderDTO.setNombre(contenderName);
	    try {
		businness.delete(contenderDTO);
		refreshContenderComboBox();
		cleanUpdateContenderForm();
	    } catch (SQLException ex) {
		System.out.println("Fallo al eliminar contendiente");
	    }

	}

	//Actualizar contendiente seleccionado
	if (e.getSource() == viewContender.getBtnUpdateSelectedContender()) {
	    int ganador;
	    contenderDTO = new ContenderDTO();
	    String newContenderName = viewContender.getTxtfUpdateSelectedContender().getText();
	    String oldContenderName = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
	    contenderDTO.setNombre(newContenderName);
	    if (viewContender.getCb_Ganador().isSelected()) {
		ganador = 1;
	    } else {
		ganador = 0;
	    }
	    contenderDTO.setGanador(ganador);
	    try {
		businness.update(contenderDTO, oldContenderName);
		refreshContenderComboBox();
		cleanUpdateContenderForm();
	    } catch (SQLException ex) {
		System.out.println("Fallo al actualizar contendiente");
	    }
	}

	//Insertar países a contendientes
	if (e.getSource() == viewContender.getBtnInsertCountryToContender()) {
	    String pais, contendiente, fecha_abandono = "";
	    allyDTO = new AllyDTO();
	    try {
		contendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		pais = (String) viewContender.getComboBoxSelectCountryToContender().getSelectedItem();
		allyDTO.setId_pais(businness.select_idPais(pais));
		allyDTO.setId_contendiente(businness.select_idContendiente(contendiente));

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
		allyDTO.setFecha_abandono(fecha_abandono);
		allyDTO.setFecha_union(fecha_union);
		businness.insert_country(allyDTO);
		cleanCountriesForm();
		if (viewContender.getComboBoxSelectCountryToContender().getSelectedIndex() == 0) {
		    countriesUpdateSetActive();
		}
		refreshCountriesAddedComboBox();
	    } catch (SQLException ex) {
		System.out.println("Fallo al insertar nuevo aliado");
	    }
	}

	//Eliminar países de contendientes
	if (e.getSource() == viewContender.getBtnDeleteSelectCountryADDED()) {
	    String pais, contendiente;
	    allyDTO = new AllyDTO();
	    try {
		contendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		pais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();
		allyDTO.setId_pais(businness.select_idPais(pais));
		allyDTO.setId_contendiente(businness.select_idContendiente(contendiente));
		businness.delete_country(allyDTO);
		refreshCountriesAddedComboBox();
	    } catch (SQLException ex) {
		System.out.println("Fallo al eliminar aliado");
	    }
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
	    String pais, contendiente;
	    allyDTO = new AllyDTO();
	    try {
		contendiente = (String) viewContender.getComboBoxSelectContender().getSelectedItem();
		pais = (String) viewContender.getComboBoxSelectCountryADDED().getSelectedItem();
		allyDTO.setId_pais(businness.select_idPais(pais));
		allyDTO.setId_contendiente(businness.select_idContendiente(contendiente));

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = viewContender.getjDC_updateBeginDate().getDate();
		String fecha_union = df.format(date1);
		Date date2 = viewContender.getjDC_updateEndDate().getDate();
		String fecha_abandono = df.format(date2);

                
                if (!viewContender.getCB_updateFechaAbandono().isSelected()) {
		    fecha_abandono = "";
                    allyDTO.setFecha_abandono(fecha_abandono);
		}else{
                    allyDTO.setFecha_abandono(fecha_abandono);
                }
		allyDTO.setFecha_union(fecha_union);		
		businness.update_country(allyDTO);
		refreshCountriesAddedComboBox();
		cleanUpdateCountriesForm();
	    } catch (SQLException ex) {
		System.out.println("Fallo al actualizar aliado");
	    }
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

    public controllerContender() {
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

    private void refreshContenderComboBox() throws SQLException {
	viewContender.getComboBoxSelectContender().removeAllItems();
	viewContender.getComboBoxSelectContender().setModel(businness.fillComboBoxContender((String) viewContender.getComboBoxSelectWar().getSelectedItem()));
    }

    private void refreshCountriesAddedComboBox() throws SQLException {
	viewContender.getComboBoxSelectCountryADDED().removeAllItems();
	viewContender.getComboBoxSelectCountryADDED().setModel(businness.fillComboBoxCountry((String) viewContender.getComboBoxSelectContender().getSelectedItem()));
    }

}//Fin clase proincipal
