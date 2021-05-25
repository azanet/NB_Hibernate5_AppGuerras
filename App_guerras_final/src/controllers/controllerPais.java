/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.TableModels.JTableModelPais;
import Models.DAOs.DAOPais;
import Models.DAOs.DAOPeriodoIndependecia;
import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import Models.TableModels.TableModelPaint;
import SessionFactory.HibernateUtil_SessionFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import Views.ViewPaises;
import Views.ViewPrincipal;
import java.awt.Color;

/**
 *
 * @author davidf
 */
public final class controllerPais implements ActionListener {

    private ViewPaises viewPais;
    private final DAOPais DAOpais;
    private final DAOPeriodoIndependecia DAOperiodoIndependencia;
    private JTableModelPais tableModelPais;

    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    //AGREGAR MODELs *** 

    
    //Constructor
    public controllerPais(ViewPrincipal viewPrincipal) {

        //AGREGAR MODELs ***
        viewPais = new ViewPaises(viewPrincipal, true);
        DAOpais = new DAOPais();
        DAOperiodoIndependencia = new DAOPeriodoIndependecia();

        initComponents();
        viewPais.setVisible(true);

    }//Fin del constructor

    
    private void initComponents() {
        resetViewComponents();
        

        
//        viewPais.getJtableCountries().setModel(tableModelPais);
//        
        //Inicializando el TableModel
        tableModelPais = new JTableModelPais(DAOpais);
        
        //Creando objeto de TableModelPaint, pasandole el MODELO que QUEREMOS ESTABLECERLE
        TableModelPaint  tableModelPaint = new TableModelPaint(tableModelPais);
        
        //Seteando la JTable de la vista, con la JTable TUNEADA que nos devuelve la clase TableModelPaint
        viewPais.setJtableCountries(tableModelPaint.getJtable());
        
        //Seteando la JTable al ScrollPane, para que se vea, ya que si no NO PODRÄ MOSTRARLA
        viewPais.getjScrollPane1().setViewportView(viewPais.getJtableCountries());    
        //LISTO!, tabla tuning agregada
  
        list();
        
        initEvents();

    }//Fin initComponents

    
    private void initEvents() {
        //INICIALIZAR EVENTOS
        viewPais.getBtnInsert().addActionListener(this);
        viewPais.getBtnUpdate().addActionListener(this);
        viewPais.getBtnDelete().addActionListener(this);
        viewPais.getBtnExit().addActionListener(this);
        viewPais.getCheckBoxIndependent().addActionListener(this);
        viewPais.getBtnLimpiarPantalla().addActionListener(this);

        /*Agregamos un evento de ratón a la tabla para seleccionar
        los valores de una fila y colocarlos en los cajones de texto*/
        viewPais.getJtableCountries().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    selected_row();

                    //SETEANDO ELEMENTOS DE LA VISTA
                    viewPais.getBtnUpdate().setEnabled(true);
                    viewPais.getBtnDelete().setEnabled(true);
                    viewPais.getBtnInsert().setEnabled(false);
                    viewPais.getCheckBoxIndependent().setSelected(false);
                    setIndependent();

                    //COMPROBANDO Y SETEANDO EL "CHECKbox" SEGÚN SI EXISTE FECHA DE Independencia O NO
                    if (!viewPais.getTxtfDateBegin().getText().isEmpty()) {
                        viewPais.getCheckBoxIndependent().setSelected(true);
                        setIndependent();
                    }
                }
            }
        });

        viewPais.getTxtfSearch().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (e.getDocument() == viewPais.getTxtfSearch().getDocument()) {
                    activoTimer();

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (e.getDocument() == viewPais.getTxtfSearch().getDocument()) {
                    activoTimer();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (e.getDocument() == viewPais.getTxtfSearch().getDocument()) {
                    activoTimer();

                }
            }
        });

    }//Fin initEvents

    
    @Override
    public void actionPerformed(ActionEvent ae) {

        
        if (ae.getSource() == viewPais.getBtnExit()) {

            viewPais.dispose();

            //CheckBox Independencia    
        }
        
        
        
        if(HibernateUtil_SessionFactory.isConnected()){
        
        
        //BOTON INSERT
        if (ae.getSource() == viewPais.getBtnInsert()) {

            insertarPais();
            list();

            //BOTON UPDATE
        } else if (ae.getSource() == viewPais.getBtnUpdate()) {

            modificarPais();
            list();

            //BOTON DELETE
        } else if (ae.getSource() == viewPais.getBtnDelete()) {

            eliminarPais();
            list();

            //BOTON LimpiarPantalla
        } else if (ae.getSource() == viewPais.getBtnLimpiarPantalla()) {

            resetViewComponents();

            //BOTON EXIT
        }  else if (ae.getSource() == viewPais.getCheckBoxIndependent()) {

            setIndependent();
        }
        
        
        }else{
            viewPais.dispose();
        }
        
        

    }//Fin de action performed

    
    private void list() {
        DAOpais.selectAllPaises();
        tableModelPais.fireTableDataChanged();
        resetViewComponents();
    }

    
    private void resetViewComponents() {

        viewPais.getJtableCountries().clearSelection();

        viewPais.getTF_CountryId().setText("");
        viewPais.getTxtfCountryName().setText("");
        viewPais.getTxtfDateBegin().setText("");
        viewPais.getTxtfDateEnd().setText("");

        viewPais.getBtnUpdate().setEnabled(false);
        viewPais.getBtnDelete().setEnabled(false);
        viewPais.getBtnInsert().setEnabled(true);
        viewPais.getTF_CountryId().setEnabled(false);
        viewPais.getTF_CountryId().setBackground(new Color(178, 191, 237));
        viewPais.getTF_CountryId().setDisabledTextColor(new Color(0, 0, 98));

        viewPais.getCheckBoxIndependent().setSelected(false);

        setIndependent();
    }

    
    //Seteara las etiquetas acorde al CheckBox
    private void setIndependent() {
        boolean aux = viewPais.getCheckBoxIndependent().isSelected();
        viewPais.getLblDateBegin().setEnabled(aux);
        viewPais.getTxtfDateBegin().setEnabled(aux);
        viewPais.getLblDateEnd().setEnabled(aux);
        viewPais.getTxtfDateEnd().setEnabled(aux);
        if (aux == true) {

            viewPais.getTxtfDateBegin().setBackground(Color.WHITE);
            viewPais.getTxtfDateEnd().setBackground(Color.WHITE);

        } else {
            viewPais.getTxtfDateBegin().setBackground(new Color(178, 191, 237));
            viewPais.getTxtfDateBegin().setDisabledTextColor(new Color(178, 191, 237));
            viewPais.getTxtfDateEnd().setBackground(new Color(178, 191, 237));
            viewPais.getTxtfDateEnd().setDisabledTextColor(new Color(178, 191, 237));
        }

    }//Fin set independent

    
    private void selected_row() {
        int row = viewPais.getJtableCountries().getSelectedRow();
        if (row >= 0) {
            viewPais.getTF_CountryId().setText(String.valueOf(viewPais.getJtableCountries().getValueAt(row, 0)));
            viewPais.getTxtfCountryName().setText(String.valueOf(viewPais.getJtableCountries().getValueAt(row, 1)));

            if (viewPais.getJtableCountries().getValueAt(row, 3) == null) {
                viewPais.getTxtfDateBegin().setText("");
            } else {
                viewPais.getTxtfDateBegin().setText(String.valueOf(viewPais.getJtableCountries().getValueAt(row, 3)));
            }

            if (viewPais.getJtableCountries().getValueAt(row, 4) == null) {
                viewPais.getTxtfDateEnd().setText("");
            } else {
                viewPais.getTxtfDateEnd().setText(String.valueOf(viewPais.getJtableCountries().getValueAt(row, 4)));
            }

        }
    }

    
    //Timer que DISPARA "LA BUSQUEDA SUAVE"
    private void activoTimer() {

        if ((timerbuscar != null) && timerbuscar.isRunning()) {
            timerbuscar.restart();
        } else {
            timerbuscar = new Timer(TIEMPOBUSCAR, (ActionEvent evt) -> {
                timerbuscar = null;
                DAOpais.lightSearchPaises(viewPais.getTxtfSearch().getText());
                tableModelPais.fireTableDataChanged();
            });
            timerbuscar.setRepeats(false);
            timerbuscar.start();
        }

    }
    

    private void eliminarPais() {

        Pais pais = new Pais();
        pais.setIdPais(Integer.parseInt(viewPais.getTF_CountryId().getText()));
        DAOpais.deletePais(pais);
    }

    
    private void modificarPais() {

        Pais pais = new Pais();

        pais.setIdPais(Integer.parseInt(viewPais.getTF_CountryId().getText()));
        pais.setNombre(viewPais.getTxtfCountryName().getText());

        //SI EL CHECKBOX !!SII¡¡ Esta marcado y EXISTE "Fecha de INICIO", Updatearemos o Crearemos EL PERIODO DE INDEPENDENCIA     
        if (viewPais.getCheckBoxIndependent().isSelected() == true) {

            //Updateando el PAIS (Solo su nombre)
            DAOpais.updatePais(pais);

            if (viewPais.getTxtfDateBegin().getText().length() > 0) {

                PeriodoIndependecia pi = new PeriodoIndependecia();

                try {
                    pi.setAnioInicio(Integer.parseInt(viewPais.getTxtfDateBegin().getText()));
                } catch (NumberFormatException nfe) {
                    pi.setAnioInicio(null);
                }

                try {
                    pi.setAnioFin(Integer.parseInt(viewPais.getTxtfDateEnd().getText()));
                } catch (NumberFormatException nfe) {
                    pi.setAnioFin(null);
                }

                //Añadiendo al objeto el periodo de independencia
                pais.getPeriodoIndependecias().add(pi);

                //UPDATEANDO PeriodoIndependencia  (En el DAO comprobará si se MODIFICA o INSERTA el REGISTRO según EXISTA O NO)
                DAOperiodoIndependencia.updatePeriodoIndependencia(pais);
            }

            //SI EL CHECKBOX !!NOO¡¡ Esta marcado, ELIMINAREMOS EL PERIODO DE INDEPENDENCIA (en caso de que exista)    
        } else {

            //Updateando el PAIS (Solo su nombre)
            DAOpais.updatePais(pais);
            //BORRANDO PeriodoIndependencia
            DAOperiodoIndependencia.deletePeriodoIndependencia(pais);

        }
    }

    
    private void insertarPais() {
        Pais pais = new Pais();
        //insert pais con independencia
        if (viewPais.getCheckBoxIndependent().isSelected() == true) {

            pais.setNombre(viewPais.getTxtfCountryName().getText());

            DAOpais.insertPais(pais);

            if (viewPais.getTxtfDateBegin().getText().length() > 0) {

                PeriodoIndependecia pi = new PeriodoIndependecia();
                pi.setAnioInicio(Integer.parseInt(viewPais.getTxtfDateBegin().getText()));
                pi.setAnioFin(Integer.parseInt(viewPais.getTxtfDateEnd().getText()));

                //Añadiendo al objeto el periodo de independencia
                pais.getPeriodoIndependecias().add(pi);
                //
                DAOperiodoIndependencia.insertPeriodoIndependencia(pais);
            }

            //insert de pais solo
        } else {

            pais.setNombre(viewPais.getTxtfCountryName().getText());
            DAOpais.insertPais(pais);

        }
    }

}//Fin de clase principal
