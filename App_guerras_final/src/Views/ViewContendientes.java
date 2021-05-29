package Views;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author davidf
 */
public class ViewContendientes extends javax.swing.JDialog {

    /**
     * Creates new form viewContenders1
     */
           ImagenPanel fondo = new ImagenPanel();
    public ViewContendientes(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
        
         this.setContentPane(fondo);
	initComponents();
	setWindow();
    }

    public JPanel getPanelContendientes() {
        return panelContendientes;
    }

    public JPanel getPanelGuerra() {
        return panelGuerra;
    }

    public JPanel getPanelPaises() {
        return panelPaises;
    }
    
    
    

    public JPanel getPanelInsertPais() {
        return panelInsertPais;
    }

    public JPanel getPanelUpdatePais() {
        return panelUpdatePais;
    }

    public JPanel getPanelSeleccionGuerra() {
        return panelSeleccionGuerra;
    }

    public JPanel getPanelGeneral() {
        return panelGeneral;
    }

    public JButton getBtnLimpiarPantalla() {
        return btnLimpiarPantalla;
    }

    
    
    public JPanel getPanelCreateNewContender() {
        return panelCreateNewContender;
    }

    
    
    public JPanel getPanelSelecContend() {
       return panelSelecContend;
    }

 
    public JCheckBox getCB_updateFechaAbandono() {
        return CB_updateFechaAbandono;
    }

    
    public JCheckBox getCb_Ganador() {
	return Cb_Ganador;
    }

    public void setCb_Ganador(JCheckBox Cb_Ganador) {
	this.Cb_Ganador = Cb_Ganador;
    }

    public JCheckBox getCb_GanadorInsert() {
	return Cb_GanadorInsert;
    }

    public void setCb_GanadorInsert(JCheckBox Cb_GanadorInsert) {
	this.Cb_GanadorInsert = Cb_GanadorInsert;
    }

    public JComboBox<String> getComboBoxSelectWar() {
	return ComboBoxSelectWar;
    }

    public void setComboBoxSelectWar(JComboBox<String> ComboBoxSelectWar) {
	this.ComboBoxSelectWar = ComboBoxSelectWar;
    }

    public JButton getBtnDeleteSelectCountryADDED() {
	return btnDeleteSelectCountryADDED;
    }

    public void setBtnDeleteSelectCountryADDED(JButton btnDeleteSelectCountryADDED) {
	this.btnDeleteSelectCountryADDED = btnDeleteSelectCountryADDED;
    }

    public JButton getBtnDeleteSelectedContender() {
	return btnDeleteSelectedContender;
    }

    public void setBtnDeleteSelectedContender(JButton btnDeleteSelectedContender) {
	this.btnDeleteSelectedContender = btnDeleteSelectedContender;
    }

    public JButton getBtnExit() {
	return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
	this.btnExit = btnExit;
    }

    public JButton getBtnInsertCountryToContender() {
	return btnInsertCountryToContender;
    }

    public void setBtnInsertCountryToContender(JButton btnInsertCountryToContender) {
	this.btnInsertCountryToContender = btnInsertCountryToContender;
    }

    public JButton getBtnInsertNewContender() {
	return btnInsertNewContender;
    }

    public void setBtnInsertNewContender(JButton btnInsertNewContender) {
	this.btnInsertNewContender = btnInsertNewContender;
    }

    public JButton getBtnUpdateDate() {
	return btnUpdateDate;
    }

    public void setBtnUpdateDate(JButton btnUpdateDate) {
	this.btnUpdateDate = btnUpdateDate;
    }

    public JButton getBtnUpdateSelectedContender() {
	return btnUpdateSelectedContender;
    }

    public void setBtnUpdateSelectedContender(JButton btnUpdateSelectedContender) {
	this.btnUpdateSelectedContender = btnUpdateSelectedContender;
    }

    public JComboBox<String> getComboBoxSelectContender() {
	return comboBoxSelectContender;
    }

    public void setComboBoxSelectContender(JComboBox<String> comboBoxSelectContender) {
	this.comboBoxSelectContender = comboBoxSelectContender;
    }

    public JComboBox<String> getComboBoxSelectCountryADDED() {
	return comboBoxSelectCountryADDED;
    }

    public void setComboBoxSelectCountryADDED(JComboBox<String> comboBoxSelectCountryADDED) {
	this.comboBoxSelectCountryADDED = comboBoxSelectCountryADDED;
    }

    public JComboBox<String> getComboBoxSelectCountryToContender() {
	return comboBoxSelectCountryToContender;
    }

    public void setComboBoxSelectCountryToContender(JComboBox<String> comboBoxSelectCountryToContender) {
	this.comboBoxSelectCountryToContender = comboBoxSelectCountryToContender;
    }

    public JLabel getLblContenderName() {
	return lblContenderName;
    }

    public void setLblContenderName(JLabel lblContenderName) {
	this.lblContenderName = lblContenderName;
    }

    public JLabel getLblDateBeginCountryToContender() {
	return lblDateBeginCountryToContender;
    }

    public void setLblDateBeginCountryToContender(JLabel lblDateBeginCountryToContender) {
	this.lblDateBeginCountryToContender = lblDateBeginCountryToContender;
    }

    public JLabel getLblUpdateContenderName() {
	return lblUpdateContenderName;
    }

    public void setLblUpdateContenderName(JLabel lblUpdateContenderName) {
	this.lblUpdateContenderName = lblUpdateContenderName;
    }

    public JLabel getLblUpdateDateBegin() {
	return lblUpdateDateBegin;
    }

    public void setLblUpdateDateBegin(JLabel lblUpdateDateBegin) {
	this.lblUpdateDateBegin = lblUpdateDateBegin;
    }



    public JTextField getTxtfInsertNewContender() {
	return txtfInsertNewContender;
    }

    public void setTxtfInsertNewContender(JTextField txtfInsertNewContender) {
	this.txtfInsertNewContender = txtfInsertNewContender;
    }

    public JTextField getTxtfUpdateSelectedContender() {
	return txtfUpdateSelectedContender;
    }

    public void setTxtfUpdateSelectedContender(JTextField txtfUpdateSelectedContender) {
	this.txtfUpdateSelectedContender = txtfUpdateSelectedContender;
    }

    public JDateChooser getjDC_BeginDate() {
	return jDC_BeginDate;
    }

    public void setjDC_BeginDate(JDateChooser jDC_BeginDate) {
	this.jDC_BeginDate = jDC_BeginDate;
    }

    public JDateChooser getjDC_EndDate() {
	return jDC_EndDate;
    }

    public void setjDC_EndDate(JDateChooser jDC_EndDate) {
	this.jDC_EndDate = jDC_EndDate;
    }

    public JDateChooser getjDC_updateBeginDate() {
	return jDC_updateBeginDate;
    }

    public void setjDC_updateBeginDate(JDateChooser jDC_updateBeginDate) {
	this.jDC_updateBeginDate = jDC_updateBeginDate;
    }

    public JDateChooser getjDC_updateEndDate() {
	return jDC_updateEndDate;
    }

    public void setjDC_updateEndDate(JDateChooser jDC_updateEndDate) {
	this.jDC_updateEndDate = jDC_updateEndDate;
    }

    public JCheckBox getCB_FechaAbandono() {
	return CB_FechaAbandono;
    }

    public void setCB_FechaAbandono(JCheckBox CB_FechaAbandono) {
	this.CB_FechaAbandono = CB_FechaAbandono;
    }

    
    
    

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        panelGeneral = new javax.swing.JPanel();
        panelGuerra = new javax.swing.JPanel();
        panelSeleccionGuerra = new javax.swing.JPanel();
        ComboBoxSelectWar = new javax.swing.JComboBox<>();
        panelContendientes = new javax.swing.JPanel();
        panelSelecContend = new javax.swing.JPanel();
        comboBoxSelectContender = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        txtfUpdateSelectedContender = new javax.swing.JTextField();
        lblUpdateContenderName = new javax.swing.JLabel();
        btnDeleteSelectedContender = new javax.swing.JButton();
        btnUpdateSelectedContender = new javax.swing.JButton();
        Cb_Ganador = new javax.swing.JCheckBox();
        panelCreateNewContender = new javax.swing.JPanel();
        btnInsertNewContender = new javax.swing.JButton();
        Cb_GanadorInsert = new javax.swing.JCheckBox();
        txtfInsertNewContender = new javax.swing.JTextField();
        lblContenderName = new javax.swing.JLabel();
        panelPaises = new javax.swing.JPanel();
        panelUpdatePais = new javax.swing.JPanel();
        comboBoxSelectCountryADDED = new javax.swing.JComboBox<>();
        jDC_updateBeginDate = new com.toedter.calendar.JDateChooser();
        lblUpdateDateBegin = new javax.swing.JLabel();
        CB_updateFechaAbandono = new javax.swing.JCheckBox();
        jDC_updateEndDate = new com.toedter.calendar.JDateChooser();
        btnUpdateDate = new javax.swing.JButton();
        btnDeleteSelectCountryADDED = new javax.swing.JButton();
        panelInsertPais = new javax.swing.JPanel();
        btnInsertCountryToContender = new javax.swing.JButton();
        jDC_EndDate = new com.toedter.calendar.JDateChooser();
        CB_FechaAbandono = new javax.swing.JCheckBox();
        lblDateBeginCountryToContender = new javax.swing.JLabel();
        jDC_BeginDate = new com.toedter.calendar.JDateChooser();
        comboBoxSelectCountryToContender = new javax.swing.JComboBox<>();
        btnLimpiarPantalla = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1237, 676));
        setResizable(false);
        setSize(new java.awt.Dimension(1237, 676));

        panelGeneral.setMaximumSize(new java.awt.Dimension(1237, 676));
        panelGeneral.setMinimumSize(new java.awt.Dimension(1237, 676));
        panelGeneral.setPreferredSize(new java.awt.Dimension(1237, 676));
        panelGeneral.setLayout(null);

        panelGuerra.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "GUERRA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 102, 0))); // NOI18N
        panelGuerra.setForeground(new java.awt.Color(255, 255, 255));

        panelSeleccionGuerra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIONE Guerra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14), new java.awt.Color(204, 255, 204))); // NOI18N

        ComboBoxSelectWar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerra1", "Guerra2", "Guerra3", " " }));

        javax.swing.GroupLayout panelSeleccionGuerraLayout = new javax.swing.GroupLayout(panelSeleccionGuerra);
        panelSeleccionGuerra.setLayout(panelSeleccionGuerraLayout);
        panelSeleccionGuerraLayout.setHorizontalGroup(
            panelSeleccionGuerraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeleccionGuerraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxSelectWar, 0, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSeleccionGuerraLayout.setVerticalGroup(
            panelSeleccionGuerraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeleccionGuerraLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ComboBoxSelectWar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGuerraLayout = new javax.swing.GroupLayout(panelGuerra);
        panelGuerra.setLayout(panelGuerraLayout);
        panelGuerraLayout.setHorizontalGroup(
            panelGuerraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGuerraLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(panelSeleccionGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelGuerraLayout.setVerticalGroup(
            panelGuerraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGuerraLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(panelSeleccionGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        panelGeneral.add(panelGuerra);
        panelGuerra.setBounds(330, 20, 564, 120);

        panelContendientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "CONTENDIENTES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 102, 0))); // NOI18N
        panelContendientes.setMaximumSize(new java.awt.Dimension(1221, 272));
        panelContendientes.setMinimumSize(new java.awt.Dimension(1221, 272));
        panelContendientes.setPreferredSize(new java.awt.Dimension(1221, 272));
        panelContendientes.setLayout(null);

        panelSelecContend.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIONE Contendiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14), new java.awt.Color(255, 204, 102))); // NOI18N
        panelSelecContend.setLayout(null);

        comboBoxSelectContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un contendiente...", "Item 2", "Item 3", "Item 4" }));
        panelSelecContend.add(comboBoxSelectContender);
        comboBoxSelectContender.setBounds(138, 35, 334, 23);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contendiente Seleccionado (MODIFICAR / ELIMINAR)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14), new java.awt.Color(255, 204, 153))); // NOI18N
        jPanel7.setOpaque(false);
        jPanel7.setLayout(null);
        jPanel7.add(txtfUpdateSelectedContender);
        txtfUpdateSelectedContender.setBounds(112, 45, 296, 23);

        lblUpdateContenderName.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateContenderName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUpdateContenderName.setText("Nombre:");
        lblUpdateContenderName.setFocusable(false);
        lblUpdateContenderName.setInheritsPopupMenu(false);
        lblUpdateContenderName.setRequestFocusEnabled(false);
        lblUpdateContenderName.setVerifyInputWhenFocusTarget(false);
        jPanel7.add(lblUpdateContenderName);
        lblUpdateContenderName.setBounds(29, 48, 77, 17);

        btnDeleteSelectedContender.setText("ELIMINAR CONTENDIENTE");
        btnDeleteSelectedContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteSelectedContender.setMaximumSize(new java.awt.Dimension(61, 20));
        btnDeleteSelectedContender.setMinimumSize(new java.awt.Dimension(61, 20));
        btnDeleteSelectedContender.setPreferredSize(new java.awt.Dimension(61, 20));
        jPanel7.add(btnDeleteSelectedContender);
        btnDeleteSelectedContender.setBounds(21, 85, 190, 35);

        btnUpdateSelectedContender.setText("MODIFICAR CONTENDIENTE");
        btnUpdateSelectedContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.add(btnUpdateSelectedContender);
        btnUpdateSelectedContender.setBounds(302, 84, 190, 36);

        Cb_Ganador.setForeground(new java.awt.Color(255, 255, 255));
        Cb_Ganador.setText("Ganador");
        Cb_Ganador.setContentAreaFilled(false);
        Cb_Ganador.setEnabled(false);
        Cb_Ganador.setFocusPainted(false);
        Cb_Ganador.setFocusable(false);
        Cb_Ganador.setRequestFocusEnabled(false);
        Cb_Ganador.setVerifyInputWhenFocusTarget(false);
        jPanel7.add(Cb_Ganador);
        Cb_Ganador.setBounds(414, 46, 100, 21);

        panelSelecContend.add(jPanel7);
        jPanel7.setBounds(30, 80, 520, 131);

        panelContendientes.add(panelSelecContend);
        panelSelecContend.setBounds(30, 30, 570, 230);

        panelCreateNewContender.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREAR Nuevo Contendiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14), new java.awt.Color(255, 204, 102))); // NOI18N

        btnInsertNewContender.setText("INSERTAR NUEVO CONTENDIENTE");
        btnInsertNewContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Cb_GanadorInsert.setForeground(new java.awt.Color(255, 255, 255));
        Cb_GanadorInsert.setText("Ganador");
        Cb_GanadorInsert.setContentAreaFilled(false);
        Cb_GanadorInsert.setEnabled(false);
        Cb_GanadorInsert.setFocusPainted(false);
        Cb_GanadorInsert.setFocusable(false);
        Cb_GanadorInsert.setRequestFocusEnabled(false);
        Cb_GanadorInsert.setRolloverEnabled(false);
        Cb_GanadorInsert.setVerifyInputWhenFocusTarget(false);

        lblContenderName.setForeground(new java.awt.Color(255, 255, 255));
        lblContenderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContenderName.setText("Nombre Contendiente:");

        javax.swing.GroupLayout panelCreateNewContenderLayout = new javax.swing.GroupLayout(panelCreateNewContender);
        panelCreateNewContender.setLayout(panelCreateNewContenderLayout);
        panelCreateNewContenderLayout.setHorizontalGroup(
            panelCreateNewContenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateNewContenderLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelCreateNewContenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCreateNewContenderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(panelCreateNewContenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Cb_GanadorInsert)
                        .addGroup(panelCreateNewContenderLayout.createSequentialGroup()
                            .addComponent(lblContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtfInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        panelCreateNewContenderLayout.setVerticalGroup(
            panelCreateNewContenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCreateNewContenderLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(Cb_GanadorInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCreateNewContenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCreateNewContenderLayout.createSequentialGroup()
                        .addComponent(txtfInsertNewContender)
                        .addGap(1, 1, 1)))
                .addGap(28, 28, 28)
                .addComponent(btnInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        panelContendientes.add(panelCreateNewContender);
        panelCreateNewContender.setBounds(630, 30, 570, 230);

        panelGeneral.add(panelContendientes);
        panelContendientes.setBounds(10, 160, 1215, 272);

        panelPaises.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAÍSES ALIADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 102, 0))); // NOI18N
        panelPaises.setMaximumSize(new java.awt.Dimension(1221, 226));
        panelPaises.setMinimumSize(new java.awt.Dimension(1221, 226));
        panelPaises.setPreferredSize(new java.awt.Dimension(1221, 226));

        panelUpdatePais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIONE País Aliado (para MODIFICAR / ELIMINAR)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14), new java.awt.Color(153, 204, 255))); // NOI18N
        panelUpdatePais.setForeground(new java.awt.Color(255, 255, 255));
        panelUpdatePais.setLayout(null);

        comboBoxSelectCountryADDED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país aliado...", "Item 2", "Item 3", "Item 4" }));
        panelUpdatePais.add(comboBoxSelectCountryADDED);
        comboBoxSelectCountryADDED.setBounds(120, 30, 360, 23);
        panelUpdatePais.add(jDC_updateBeginDate);
        jDC_updateBeginDate.setBounds(90, 70, 160, 23);

        lblUpdateDateBegin.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateDateBegin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUpdateDateBegin.setText("F. Unión:");
        panelUpdatePais.add(lblUpdateDateBegin);
        lblUpdateDateBegin.setBounds(10, 70, 70, 20);

        CB_updateFechaAbandono.setForeground(new java.awt.Color(255, 255, 255));
        CB_updateFechaAbandono.setText("F. Abandono:");
        CB_updateFechaAbandono.setContentAreaFilled(false);
        CB_updateFechaAbandono.setEnabled(false);
        CB_updateFechaAbandono.setFocusPainted(false);
        CB_updateFechaAbandono.setFocusable(false);
        CB_updateFechaAbandono.setVerifyInputWhenFocusTarget(false);
        panelUpdatePais.add(CB_updateFechaAbandono);
        CB_updateFechaAbandono.setBounds(280, 71, 120, 20);
        panelUpdatePais.add(jDC_updateEndDate);
        jDC_updateEndDate.setBounds(400, 70, 150, 23);

        btnUpdateDate.setText("MODIFICAR PAÍS ALIADO");
        btnUpdateDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelUpdatePais.add(btnUpdateDate);
        btnUpdateDate.setBounds(330, 120, 190, 38);

        btnDeleteSelectCountryADDED.setText("ELIMINAR PAÍS ALIADO");
        btnDeleteSelectCountryADDED.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelUpdatePais.add(btnDeleteSelectCountryADDED);
        btnDeleteSelectCountryADDED.setBounds(60, 120, 170, 37);

        panelInsertPais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INSERTAR País a Contendiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14), new java.awt.Color(153, 204, 255))); // NOI18N
        panelInsertPais.setLayout(null);

        btnInsertCountryToContender.setText("INSERTAR PAIS a CONTENDIENTE");
        btnInsertCountryToContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelInsertPais.add(btnInsertCountryToContender);
        btnInsertCountryToContender.setBounds(160, 120, 250, 33);
        panelInsertPais.add(jDC_EndDate);
        jDC_EndDate.setBounds(410, 70, 140, 23);

        CB_FechaAbandono.setForeground(new java.awt.Color(255, 255, 255));
        CB_FechaAbandono.setText("F. Abandono:");
        CB_FechaAbandono.setContentAreaFilled(false);
        CB_FechaAbandono.setEnabled(false);
        CB_FechaAbandono.setFocusPainted(false);
        CB_FechaAbandono.setFocusable(false);
        CB_FechaAbandono.setRequestFocusEnabled(false);
        CB_FechaAbandono.setRolloverEnabled(false);
        CB_FechaAbandono.setVerifyInputWhenFocusTarget(false);
        panelInsertPais.add(CB_FechaAbandono);
        CB_FechaAbandono.setBounds(290, 70, 120, 21);

        lblDateBeginCountryToContender.setForeground(new java.awt.Color(255, 255, 255));
        lblDateBeginCountryToContender.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDateBeginCountryToContender.setText("F. Unión: ");
        panelInsertPais.add(lblDateBeginCountryToContender);
        lblDateBeginCountryToContender.setBounds(10, 70, 70, 20);
        panelInsertPais.add(jDC_BeginDate);
        jDC_BeginDate.setBounds(90, 70, 160, 23);

        comboBoxSelectCountryToContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país...", "Item 2", "Item 3", "Item 4" }));
        panelInsertPais.add(comboBoxSelectCountryToContender);
        comboBoxSelectCountryToContender.setBounds(110, 30, 379, 23);

        javax.swing.GroupLayout panelPaisesLayout = new javax.swing.GroupLayout(panelPaises);
        panelPaises.setLayout(panelPaisesLayout);
        panelPaisesLayout.setHorizontalGroup(
            panelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPaisesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelUpdatePais, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(panelInsertPais, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPaisesLayout.setVerticalGroup(
            panelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPaisesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelInsertPais, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelUpdatePais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGeneral.add(panelPaises);
        panelPaises.setBounds(10, 450, 1215, 214);

        btnLimpiarPantalla.setText("LIMPIAR PANTALLA");
        panelGeneral.add(btnLimpiarPantalla);
        btnLimpiarPantalla.setBounds(70, 70, 197, 47);

        jPanel1.setOpaque(false);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setDefaultCapable(false);
        btnExit.setFocusPainted(false);
        btnExit.setFocusable(false);
        btnExit.setRequestFocusEnabled(false);
        btnExit.setRolloverEnabled(false);
        btnExit.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panelGeneral.add(jPanel1);
        jPanel1.setBounds(990, 40, 157, 102);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CB_FechaAbandono;
    private javax.swing.JCheckBox CB_updateFechaAbandono;
    private javax.swing.JCheckBox Cb_Ganador;
    private javax.swing.JCheckBox Cb_GanadorInsert;
    private javax.swing.JComboBox<String> ComboBoxSelectWar;
    private javax.swing.JButton btnDeleteSelectCountryADDED;
    private javax.swing.JButton btnDeleteSelectedContender;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsertCountryToContender;
    private javax.swing.JButton btnInsertNewContender;
    private javax.swing.JButton btnLimpiarPantalla;
    private javax.swing.JButton btnUpdateDate;
    private javax.swing.JButton btnUpdateSelectedContender;
    private javax.swing.JComboBox<String> comboBoxSelectContender;
    private javax.swing.JComboBox<String> comboBoxSelectCountryADDED;
    private javax.swing.JComboBox<String> comboBoxSelectCountryToContender;
    private com.toedter.calendar.JDateChooser jDC_BeginDate;
    private com.toedter.calendar.JDateChooser jDC_EndDate;
    private com.toedter.calendar.JDateChooser jDC_updateBeginDate;
    private com.toedter.calendar.JDateChooser jDC_updateEndDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblContenderName;
    private javax.swing.JLabel lblDateBeginCountryToContender;
    private javax.swing.JLabel lblUpdateContenderName;
    private javax.swing.JLabel lblUpdateDateBegin;
    private javax.swing.JPanel panelContendientes;
    private javax.swing.JPanel panelCreateNewContender;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelGuerra;
    private javax.swing.JPanel panelInsertPais;
    private javax.swing.JPanel panelPaises;
    private javax.swing.JPanel panelSelecContend;
    private javax.swing.JPanel panelSeleccionGuerra;
    private javax.swing.JPanel panelUpdatePais;
    private javax.swing.JTextField txtfInsertNewContender;
    private javax.swing.JTextField txtfUpdateSelectedContender;
    // End of variables declaration//GEN-END:variables
private void setWindow() {
        setTitle("CONTENDIENTES");
        setLocationRelativeTo(this);
    }

}
