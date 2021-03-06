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
import SessionFactory.HibernateUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Views.ViewContendientes;
import Views.ViewPrincipal;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.hibernate.exception.ConstraintViolationException;

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
    public controllerContendientes(ViewPrincipal viewPrincipal) {

        //AGREGAR MODELs ***
        viewContendientes = new ViewContendientes(viewPrincipal, true);
        DAOcontendiente = new DAOContendiente();
        DAOunionBandos = new DAOUnionBandos();
        DAOcomboBoxesFill = new DAOComboBoxesFill();

        initComponents();
        initEvents();
        resetComponents();

        if (HibernateUtil.isConnected()) {
            viewContendientes.getComboBoxSelectWar().setModel(DAOcomboBoxesFill.fillComboBoxGuerras());
        }

        viewContendientes.setVisible(true);
    }//Fin del constructor

    private void initComponents() {
        //ALFA= Transpatrencia (de 0 a 255)
        viewContendientes.getPanelGeneral().setBackground(new Color(255, 255, 255, 75));

        viewContendientes.getPanelGuerra().setBackground(new Color(0, 0, 0, 100));
        viewContendientes.getPanelSeleccionGuerra().setBackground(new Color(0, 0, 0, 100));

        viewContendientes.getPanelContendientes().setBackground(new Color(0, 0, 0, 100));
        viewContendientes.getPanelSelecContend().setBackground(new Color(0, 0, 0, 190));
        viewContendientes.getPanelCreateNewContender().setBackground(new Color(0, 0, 0, 190));

        viewContendientes.getPanelPaises().setBackground(new Color(0, 0, 0, 100));
        viewContendientes.getPanelUpdatePais().setBackground(new Color(0, 0, 0, 100));
        viewContendientes.getPanelInsertPais().setBackground(new Color(0, 0, 0, 100));

        viewContendientes.getComboBoxSelectContender().setEnabled(false);
        viewContendientes.getBtnDeleteSelectedContender().setEnabled(false);

        viewContendientes.getLblContenderName().setEnabled(false);
        viewContendientes.getTxtfInsertNewContender().setEnabled(false);
        viewContendientes.getBtnInsertNewContender().setEnabled(false);

        viewContendientes.getLblUpdateContenderName().setEnabled(false);
        viewContendientes.getTxtfUpdateSelectedContender().setEnabled(false);
        viewContendientes.getBtnUpdateSelectedContender().setEnabled(false);

        viewContendientes.getComboBoxSelectCountryADDED().setEnabled(false);
        viewContendientes.getBtnDeleteSelectCountryADDED().setEnabled(false);

        viewContendientes.getLblUpdateDateBegin().setEnabled(false);

        viewContendientes.getBtnUpdateDate().setEnabled(false);

        viewContendientes.getLblDateBeginCountryToContender().setEnabled(false);
        viewContendientes.getBtnInsertCountryToContender().setEnabled(false);
        viewContendientes.getComboBoxSelectCountryToContender().setEnabled(false);

        viewContendientes.getCb_Ganador().setEnabled(false);
        viewContendientes.getCb_GanadorInsert().setEnabled(false);

        viewContendientes.getjDC_BeginDate().setEnabled(false);
        viewContendientes.getjDC_EndDate().setEnabled(false);
        viewContendientes.getjDC_updateBeginDate().setEnabled(false);
        viewContendientes.getjDC_updateEndDate().setEnabled(false);

    }

    ///////////////////  
    private void resetComponents() {
        resetComboboxes();
        contenderInsertDeactivate();
        contenderUpdateDeactivate();
        countriesInsertDeactivate();
        countriesUpdateDeactivate();
        viewContendientes.getComboBoxSelectContender().setEnabled(false);
    }
///////////////////////

    private void initEvents() {

        viewContendientes.getBtnExit().addActionListener(this);
        viewContendientes.getBtnLimpiarPantalla().addActionListener(this);

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

        //COMBOBOX DE GUERRAS
        //COMBOBOX Seleccionar GUERRAS
        viewContendientes.getComboBoxSelectWar().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                //Comprobando CONEXION  
                if (HibernateUtil.isConnected()) {

                    //if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (viewContendientes.getComboBoxSelectWar().getSelectedIndex() > 0) {

                        viewContendientes.getComboBoxSelectContender().setEnabled(true);

                        String nombre = (String) viewContendientes.getComboBoxSelectWar().getSelectedItem();
                        viewContendientes.getComboBoxSelectContender().setModel(DAOcomboBoxesFill.fillComboBoxContendientes(nombre));

                        contenderInsertSetActive();
                        contenderUpdateDeactivate();

                        countriesUpdateDeactivate();
                        countriesInsertDeactivate();

                        cleanContenderForm();
                        cleanCountriesForm();
                        cleanUpdateContenderForm();
                        cleanUpdateCountriesForm();

                        viewContendientes.getComboBoxSelectCountryADDED().setEnabled(false);
                        viewContendientes.getComboBoxSelectCountryToContender().setEnabled(false);

                    } else {

                        viewContendientes.getComboBoxSelectContender().setEnabled(false);

                        contenderInsertDeactivate();

                        countriesUpdateDeactivate();
                        countriesInsertDeactivate();

                        cleanContenderForm();
                        cleanCountriesForm();
                        cleanUpdateContenderForm();
                        cleanUpdateCountriesForm();

                        refreshCountriesAddedComboBox();
                        contenderUpdateDeactivate();
                        viewContendientes.getComboBoxSelectCountryADDED().setEnabled(false);
                        viewContendientes.getComboBoxSelectCountryToContender().setEnabled(false);
                    }

                } else {
                    viewContendientes.dispose();
                }//Fin de IF comprobacionCONEXION

            }//Fin ItemStateChanged
        }
        );

        //COMBOBOX CONTENDER
        viewContendientes.getComboBoxSelectContender().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                //Comprobando CONEXION  
                if (HibernateUtil.isConnected()) {
                    countriesUpdateSetActive();

                    // if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (viewContendientes.getComboBoxSelectContender().getSelectedIndex() > 0) {

                        contenderUpdateSetActive();
                        contenderInsertDeactivate();
                        countriesUpdateSetActive();

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

                    } else {

                        viewContendientes.getComboBoxSelectCountryToContender().setSelectedIndex(0);
                        viewContendientes.getComboBoxSelectCountryADDED().setSelectedIndex(0);
                        viewContendientes.getComboBoxSelectCountryADDED().setEnabled(false);
                        viewContendientes.getComboBoxSelectCountryToContender().setEnabled(false);

                        contenderUpdateDeactivate();
                        contenderInsertSetActive();

                        countriesInsertDeactivate();
                        countriesUpdateDeactivate();

                    }//Fin del IF que COMPRUEBA EL INDICE SELECCIONADO

                } else {
                    viewContendientes.dispose();
                }//Fin de IF comprobacionCONEXION
            }
        });

        //COMBOBOX INSERTAR PAIS
        viewContendientes.getComboBoxSelectCountryToContender().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                //Comprobando CONEXION  
                if (HibernateUtil.isConnected()) {

                    //if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (viewContendientes.getComboBoxSelectCountryToContender().getSelectedIndex() > 0) {

                        countriesUpdateDeactivate();
                        countriesInsertSetActive();
                        contenderUpdateDeactivate();
                        viewContendientes.getjDC_BeginDate().setEnabled(true);
                        viewContendientes.getCB_FechaAbandono().setEnabled(true);
                        viewContendientes.getBtnInsertCountryToContender().setEnabled(true);

                    } else {
                        contenderUpdateSetActive();
                        //  aaaaa
                        countriesUpdateSetActive();
                        countriesInsertDeactivate();
                        viewContendientes.getComboBoxSelectCountryToContender().setEnabled(true);
                        //    viewContendientes.getComboBoxSelectCountryADDED().setEnabled(true);
                    }

                } else {
                    viewContendientes.dispose();
                }//Fin de IF comprobacionCONEXION
            }
        });

        //COMBOBOX MODIFICAR PAIS	
        viewContendientes.getComboBoxSelectCountryADDED().addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                Date date1 = null;
                Date date2;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                //Comprobando CONEXION  
                if (HibernateUtil.isConnected()) {

                    if (viewContendientes.getComboBoxSelectCountryADDED().getSelectedIndex() > 0) {

                        contenderUpdateDeactivate();

                        //       viewContendientes.getjDC_updateEndDate().setEnabled(true);
                        countriesInsertDeactivate();
                        countriesUpdateSetActive();
                        viewContendientes.getjDC_updateBeginDate().setEnabled(true);
                        viewContendientes.getCB_updateFechaAbandono().setEnabled(true);
                        viewContendientes.getBtnUpdateDate().setEnabled(true);
                        viewContendientes.getBtnDeleteSelectCountryADDED().setEnabled(true);

                        String fecha1;
                        String fecha2 = "";
                        String nombrePais = (String) viewContendientes.getComboBoxSelectCountryADDED().getSelectedItem();
                        String nombreContendiente = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();

                        UnionBandos unionBandos = DAOunionBandos.selectUnionBandos(nombreContendiente, nombrePais);

                        //parseo de fecha string a date
                        try {
                            fecha1 = unionBandos.getFechaUnion();
                            date1 = df.parse(fecha1);

                        } catch (Exception ex) {

                        }

                        viewContendientes.getjDC_updateBeginDate().setDate(date1);

                        try {
                            fecha2 = unionBandos.getFechaAbandono();
                            date2 = df.parse(fecha2);
                            viewContendientes.getjDC_updateEndDate().setDate(date2);

                        } catch (Exception ex) {
                            viewContendientes.getjDC_updateEndDate().setEnabled(false);

                        }

                        viewContendientes.getBtnDeleteSelectCountryADDED().setEnabled(true);

                        try {
                            if (!fecha2.equals("")) {
                                viewContendientes.getCB_updateFechaAbandono().setSelected(true);
                                viewContendientes.getjDC_updateEndDate().setEnabled(true);
                            } else {
                                viewContendientes.getjDC_updateEndDate().setEnabled(false);
                                viewContendientes.getCB_updateFechaAbandono().setSelected(false);
                            }
                        } catch (NullPointerException npe) {
                            viewContendientes.getjDC_updateEndDate().setEnabled(false);
                            viewContendientes.getCB_updateFechaAbandono().setSelected(false);

                        }

                    } else {

                        contenderUpdateSetActive();

                        countriesUpdateSetActive();

                        countriesInsertSetActive();
                        viewContendientes.getComboBoxSelectCountryToContender().setEnabled(true);

                    }// Fin de SELECTED Index

                } else {
                    viewContendientes.dispose();
                }//Fin de IF comprobacionCONEXION
            }
        });

        //Evento que detecta cambio en el checkbox para habilitar JDC fecha_abandono de insertar paises
        viewContendientes.getCB_FechaAbandono().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (viewContendientes.getCB_FechaAbandono().isSelected()) {
                    viewContendientes.getjDC_EndDate().setEnabled(true);
                } else {
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
                } else {
                    viewContendientes.getjDC_updateEndDate().setEnabled(false);
                }
            }
        });

    }//FIN DE InitEVENTS

    @Override
    public void actionPerformed(ActionEvent e) {

        //BOTON SALIR
        if (e.getSource() == viewContendientes.getBtnExit()) {
            viewContendientes.dispose();
        }

        //Comprobando CONEXION  
        if (HibernateUtil.isConnected()) {

            //LimpiarPantalla
            if (e.getSource() == viewContendientes.getBtnLimpiarPantalla()) {
                resetComponents();

            }

            //Insertar nuevo contendiente
            if (e.getSource() == viewContendientes.getBtnInsertNewContender()) {

                if (viewContendientes.getTxtfInsertNewContender().getText().trim().length() > 0) {

                    if (viewContendientes.getTxtfInsertNewContender().getText().trim().length() <= 50) {

                        int ganador;

                        if (viewContendientes.getCb_GanadorInsert().isSelected()) {
                            ganador = 1;
                        } else {
                            ganador = 0;
                        }

                        String nombreGuerra = (String) viewContendientes.getComboBoxSelectWar().getSelectedItem();

                        Contendiente contendiente = new Contendiente();
                        contendiente.setNombre(viewContendientes.getTxtfInsertNewContender().getText().trim());
                        contendiente.setGanador(ganador);

                        try {
                            DAOcontendiente.insertContendiente(contendiente, nombreGuerra); //Enviando el contendiente Seteado y el NOMBRE de la GUERRA
                     

                        cleanContenderForm();
                        refreshContenderComboBox();
                        } catch (ConstraintViolationException c) {
                            JOptionPane.showMessageDialog(viewContendientes, "Ya Existe Un Contendiente con este nombre", "ERROR entrada DUPLICADA", JOptionPane.WARNING_MESSAGE);
                            HibernateUtil.isConnected();
                            HibernateUtil.isConnected();
                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(viewContendientes, "El NOMBRE no puede ser superior a 50 car??cteres", "ERROR de NOMBRE", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(viewContendientes, "El NOMBRE no PUEDE estar vac??o", "ERROR", JOptionPane.WARNING_MESSAGE);
                }

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

                if (viewContendientes.getTxtfUpdateSelectedContender().getText().trim().length() > 0) {
                    if (viewContendientes.getTxtfUpdateSelectedContender().getText().trim().length() <= 50) {
                        int ganador;
                        Contendiente contendiente = new Contendiente();
                        String newContenderName = viewContendientes.getTxtfUpdateSelectedContender().getText().trim();
                        String oldContenderName = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
                        contendiente.setNombre(newContenderName);

                        if (viewContendientes.getCb_Ganador().isSelected()) {
                            ganador = 1;
                        } else {
                            ganador = 0;
                        }
                        contendiente.setGanador(ganador);

                        try {
                            DAOcontendiente.updateContendiente(contendiente, oldContenderName);
                        } catch (Exception c) {
                            JOptionPane.showMessageDialog(viewContendientes, "Ya Existe Un Contendiente con este nombre", "ERROR entrada DUPLICADA", JOptionPane.WARNING_MESSAGE);
                        }

                        refreshContenderComboBox();
                        cleanUpdateContenderForm();

                    } else {
                        JOptionPane.showMessageDialog(viewContendientes, "El NOMBRE no puede ser superior a 50 car??cteres", "ERROR de NOMBRE", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(viewContendientes, "El NOMBRE no PUEDE estar vac??o", "ERROR", JOptionPane.WARNING_MESSAGE);
                }

            }

            //Insertar pa??ses a contendientes
            if (e.getSource() == viewContendientes.getBtnInsertCountryToContender()) {
                String pais, contendiente, fecha_abandono = "";
                UnionBandos unionBandos = new UnionBandos();

                contendiente = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
                pais = (String) viewContendientes.getComboBoxSelectCountryToContender().getSelectedItem();

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = viewContendientes.getjDC_BeginDate().getDate();
                String fecha_union = df.format(date1);

                if (viewContendientes.getCB_FechaAbandono().isSelected()) {
                    //             viewContendientes.getjDC_EndDate().setEnabled(true);
                    Date date2 = viewContendientes.getjDC_EndDate().getDate();
                    fecha_abandono = df.format(date2);

                } else {
                    fecha_abandono = "";
                }

                unionBandos.setFechaAbandono(fecha_abandono);
                unionBandos.setFechaUnion(fecha_union);

                try {
                    DAOunionBandos.insertUnionBandos(unionBandos, contendiente, pais);
              

                cleanCountriesForm();
                if (viewContendientes.getComboBoxSelectCountryToContender().getSelectedIndex() == 0) {
                    countriesUpdateSetActive();
                }
                refreshCountriesAddedComboBox(); 
                
                } catch (ConstraintViolationException c) {
                    JOptionPane.showMessageDialog(viewContendientes, "Ya est?? vinculado este Pais a este contendiente", "ERROR entrada DUPLICADA", JOptionPane.WARNING_MESSAGE);
                  HibernateUtil.isConnected();
                  HibernateUtil.isConnected();
                
                }
            }

            //Eliminar pa??ses de contendientes
            if (e.getSource() == viewContendientes.getBtnDeleteSelectCountryADDED()) {
                String pais, contendiente;

                contendiente = (String) viewContendientes.getComboBoxSelectContender().getSelectedItem();
                pais = (String) viewContendientes.getComboBoxSelectCountryADDED().getSelectedItem();
                DAOunionBandos.deleteUnionBandos(contendiente, pais);
                refreshCountriesAddedComboBox();

            }

            //Actualizar pa??ses de contendientes
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
                } else {
                    unionBandos.setFechaAbandono(fecha_abandono);
                }
                unionBandos.setFechaUnion(fecha_union);

                try {
                    DAOunionBandos.updateUnionBandos(unionBandos, nombreContendiente, nombrePais);
                } catch (ConstraintViolationException c) {
                    JOptionPane.showMessageDialog(viewContendientes, "Ya est?? vinculado este Pais a este contendiente", "ERROR entrada DUPLICADA", JOptionPane.WARNING_MESSAGE);
                }

                refreshCountriesAddedComboBox();
                cleanUpdateCountriesForm();

            }

        } else {
            viewContendientes.dispose();
        }//Fin de IF comprobacionCONEXION

    }//Fin del ActionPERFORMED

    private void resetComboboxes() {
        viewContendientes.getComboBoxSelectWar().setSelectedIndex(0);
        viewContendientes.getComboBoxSelectContender().setSelectedIndex(0);
        viewContendientes.getComboBoxSelectCountryToContender().setSelectedIndex(0);
        viewContendientes.getComboBoxSelectCountryADDED().setSelectedIndex(0);

    }

    private void contenderInsertSetActive() {

        viewContendientes.getTxtfInsertNewContender().setBackground(Color.WHITE);
        viewContendientes.getCb_GanadorInsert().setBackground(Color.WHITE);

        viewContendientes.getLblContenderName().setEnabled(true);
        viewContendientes.getTxtfInsertNewContender().setEnabled(true);
        viewContendientes.getBtnInsertNewContender().setEnabled(true);
        viewContendientes.getCb_GanadorInsert().setEnabled(true);

    }

    private void contenderInsertDeactivate() {
        viewContendientes.getTxtfInsertNewContender().setDisabledTextColor(Color.darkGray);
        viewContendientes.getTxtfInsertNewContender().setBackground(Color.darkGray);

        viewContendientes.getLblContenderName().setEnabled(false);
        viewContendientes.getTxtfInsertNewContender().setEnabled(false);
        viewContendientes.getBtnInsertNewContender().setEnabled(false);
        viewContendientes.getCb_GanadorInsert().setEnabled(false);

    }

    private void contenderUpdateSetActive() {

        viewContendientes.getTxtfUpdateSelectedContender().setDisabledTextColor(Color.WHITE);
        viewContendientes.getTxtfUpdateSelectedContender().setBackground(Color.WHITE);

        viewContendientes.getLblUpdateContenderName().setEnabled(true);
        viewContendientes.getTxtfUpdateSelectedContender().setEnabled(true);
        viewContendientes.getBtnUpdateSelectedContender().setEnabled(true);
        viewContendientes.getBtnDeleteSelectedContender().setEnabled(true);
        viewContendientes.getCb_Ganador().setEnabled(true);

    }

    private void contenderUpdateDeactivate() {

        viewContendientes.getTxtfUpdateSelectedContender().setDisabledTextColor(Color.darkGray);
        viewContendientes.getTxtfUpdateSelectedContender().setBackground(Color.darkGray);
        viewContendientes.getTxtfUpdateSelectedContender().setText("");

        viewContendientes.getLblUpdateContenderName().setEnabled(false);
        viewContendientes.getTxtfUpdateSelectedContender().setEnabled(false);
        viewContendientes.getBtnUpdateSelectedContender().setEnabled(false);
        viewContendientes.getBtnDeleteSelectedContender().setEnabled(false);
        viewContendientes.getCb_Ganador().setEnabled(false);

    }

    private void countriesInsertSetActive() {

        viewContendientes.getCB_FechaAbandono().setBackground(Color.WHITE);
        viewContendientes.getjDC_EndDate().setBackground(Color.WHITE);

        viewContendientes.getLblDateBeginCountryToContender().setEnabled(true);
        viewContendientes.getBtnInsertCountryToContender().setEnabled(false);
        viewContendientes.getjDC_BeginDate().setEnabled(false);
        viewContendientes.getCB_FechaAbandono().setSelected(false);
        viewContendientes.getCB_FechaAbandono().setEnabled(false);
        viewContendientes.getjDC_EndDate().setEnabled(false);

    }

    private void countriesInsertDeactivate() {

        viewContendientes.getCB_FechaAbandono().setBackground(Color.darkGray);
        viewContendientes.getjDC_EndDate().setBackground(Color.darkGray);

        viewContendientes.getCB_FechaAbandono().setEnabled(false);
        viewContendientes.getLblDateBeginCountryToContender().setEnabled(false);
        viewContendientes.getBtnInsertCountryToContender().setEnabled(false);
        viewContendientes.getComboBoxSelectCountryToContender().setEnabled(false);

        viewContendientes.getjDC_BeginDate().setEnabled(false);
        viewContendientes.getjDC_EndDate().setEnabled(false);

    }

    private void countriesUpdateSetActive() {

        viewContendientes.getComboBoxSelectCountryADDED().setEnabled(true);
        viewContendientes.getLblUpdateDateBegin().setEnabled(true);
        viewContendientes.getBtnUpdateDate().setEnabled(false);
        viewContendientes.getBtnDeleteSelectCountryADDED().setEnabled(false);
        viewContendientes.getjDC_updateBeginDate().setEnabled(false);
        viewContendientes.getjDC_updateEndDate().setEnabled(false);
        viewContendientes.getCB_updateFechaAbandono().setSelected(false);
        viewContendientes.getCB_updateFechaAbandono().setEnabled(false);

    }

    private void countriesUpdateDeactivate() {

        viewContendientes.getLblUpdateDateBegin().setEnabled(false);

        viewContendientes.getBtnUpdateDate().setEnabled(false);
        viewContendientes.getBtnDeleteSelectCountryADDED().setEnabled(false);
        viewContendientes.getComboBoxSelectCountryADDED().setEnabled(false);

        viewContendientes.getjDC_updateBeginDate().setEnabled(false);
        viewContendientes.getjDC_updateEndDate().setEnabled(false);
        viewContendientes.getCB_updateFechaAbandono().setSelected(false);
        viewContendientes.getCB_updateFechaAbandono().setEnabled(false);

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

    private void refreshCountriesAddedComboBox() {
        viewContendientes.getComboBoxSelectCountryADDED().removeAllItems();
        viewContendientes.getComboBoxSelectCountryADDED().setModel(DAOcomboBoxesFill.fillComboBoxPaises((String) viewContendientes.getComboBoxSelectContender().getSelectedItem()));
    }

}//Fin clase proincipal
