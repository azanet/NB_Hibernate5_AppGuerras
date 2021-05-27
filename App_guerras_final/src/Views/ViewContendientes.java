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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        ComboBoxSelectWar = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        comboBoxSelectCountryADDED = new javax.swing.JComboBox<>();
        jDC_updateBeginDate = new com.toedter.calendar.JDateChooser();
        lblUpdateDateBegin = new javax.swing.JLabel();
        CB_updateFechaAbandono = new javax.swing.JCheckBox();
        jDC_updateEndDate = new com.toedter.calendar.JDateChooser();
        btnUpdateDate = new javax.swing.JButton();
        btnDeleteSelectCountryADDED = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnInsertCountryToContender = new javax.swing.JButton();
        jDC_EndDate = new com.toedter.calendar.JDateChooser();
        CB_FechaAbandono = new javax.swing.JCheckBox();
        lblDateBeginCountryToContender = new javax.swing.JLabel();
        jDC_BeginDate = new com.toedter.calendar.JDateChooser();
        comboBoxSelectCountryToContender = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1237, 676));
        setMinimumSize(new java.awt.Dimension(1237, 676));
        setPreferredSize(new java.awt.Dimension(1237, 676));
        setResizable(false);
        setSize(new java.awt.Dimension(1237, 676));

        jPanel1.setMaximumSize(new java.awt.Dimension(1237, 676));
        jPanel1.setMinimumSize(new java.awt.Dimension(1237, 676));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1237, 676));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "GUERRA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIONE Guerra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(204, 255, 204))); // NOI18N
        jPanel9.setOpaque(false);

        ComboBoxSelectWar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerra1", "Guerra2", "Guerra3", " " }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxSelectWar, 0, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ComboBoxSelectWar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "CONTENDIENTES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel3.setMaximumSize(new java.awt.Dimension(1221, 272));
        jPanel3.setMinimumSize(new java.awt.Dimension(1221, 272));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(1221, 272));
        jPanel3.setLayout(null);

        panelSelecContend.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIONE Contendiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(255, 204, 102))); // NOI18N
        panelSelecContend.setLayout(null);

        comboBoxSelectContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un contendiente...", "Item 2", "Item 3", "Item 4" }));
        panelSelecContend.add(comboBoxSelectContender);
        comboBoxSelectContender.setBounds(138, 35, 334, 23);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contendiente Seleccionado (MODIFICAR / ELIMINAR)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(255, 204, 153))); // NOI18N
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

        jPanel3.add(panelSelecContend);
        panelSelecContend.setBounds(30, 30, 570, 230);

        panelCreateNewContender.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREAR Nuevo Contendiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(255, 204, 102))); // NOI18N

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
                .addGroup(panelCreateNewContenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel3.add(panelCreateNewContender);
        panelCreateNewContender.setBounds(630, 30, 570, 230);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAÍSES ALIADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel4.setMaximumSize(new java.awt.Dimension(1221, 226));
        jPanel4.setMinimumSize(new java.awt.Dimension(1221, 226));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(1221, 226));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIONE País Aliado (para MODIFICAR / ELIMINAR)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(153, 204, 255))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        comboBoxSelectCountryADDED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país aliado...", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(comboBoxSelectCountryADDED);
        comboBoxSelectCountryADDED.setBounds(120, 30, 360, 23);
        jPanel5.add(jDC_updateBeginDate);
        jDC_updateBeginDate.setBounds(90, 70, 160, 23);

        lblUpdateDateBegin.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateDateBegin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUpdateDateBegin.setText("F. Unión:");
        jPanel5.add(lblUpdateDateBegin);
        lblUpdateDateBegin.setBounds(10, 70, 70, 20);

        CB_updateFechaAbandono.setForeground(new java.awt.Color(255, 255, 255));
        CB_updateFechaAbandono.setText("F. Abandono:");
        CB_updateFechaAbandono.setContentAreaFilled(false);
        CB_updateFechaAbandono.setEnabled(false);
        CB_updateFechaAbandono.setFocusPainted(false);
        CB_updateFechaAbandono.setFocusable(false);
        CB_updateFechaAbandono.setVerifyInputWhenFocusTarget(false);
        jPanel5.add(CB_updateFechaAbandono);
        CB_updateFechaAbandono.setBounds(280, 71, 120, 20);
        jPanel5.add(jDC_updateEndDate);
        jDC_updateEndDate.setBounds(400, 70, 150, 23);

        btnUpdateDate.setText("MODIFICAR PAÍS ALIADO");
        btnUpdateDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(btnUpdateDate);
        btnUpdateDate.setBounds(330, 120, 190, 38);

        btnDeleteSelectCountryADDED.setText("ELIMINAR PAÍS ALIADO");
        btnDeleteSelectCountryADDED.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(btnDeleteSelectCountryADDED);
        btnDeleteSelectCountryADDED.setBounds(60, 120, 170, 37);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INSERTAR País a Contendiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(153, 204, 255))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        btnInsertCountryToContender.setText("INSERTAR PAIS a CONTENDIENTE");
        btnInsertCountryToContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.add(btnInsertCountryToContender);
        btnInsertCountryToContender.setBounds(160, 120, 250, 33);
        jPanel6.add(jDC_EndDate);
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
        jPanel6.add(CB_FechaAbandono);
        CB_FechaAbandono.setBounds(290, 70, 120, 21);

        lblDateBeginCountryToContender.setForeground(new java.awt.Color(255, 255, 255));
        lblDateBeginCountryToContender.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDateBeginCountryToContender.setText("F. Unión: ");
        jPanel6.add(lblDateBeginCountryToContender);
        lblDateBeginCountryToContender.setBounds(10, 70, 70, 20);
        jPanel6.add(jDC_BeginDate);
        jDC_BeginDate.setBounds(90, 70, 160, 23);

        comboBoxSelectCountryToContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país...", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(comboBoxSelectCountryToContender);
        comboBoxSelectCountryToContender.setBounds(110, 30, 379, 23);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusPainted(false);

        jButton1.setText("LIMPIAR PANTALLA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JButton btnUpdateDate;
    private javax.swing.JButton btnUpdateSelectedContender;
    private javax.swing.JComboBox<String> comboBoxSelectContender;
    private javax.swing.JComboBox<String> comboBoxSelectCountryADDED;
    private javax.swing.JComboBox<String> comboBoxSelectCountryToContender;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDC_BeginDate;
    private com.toedter.calendar.JDateChooser jDC_EndDate;
    private com.toedter.calendar.JDateChooser jDC_updateBeginDate;
    private com.toedter.calendar.JDateChooser jDC_updateEndDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblContenderName;
    private javax.swing.JLabel lblDateBeginCountryToContender;
    private javax.swing.JLabel lblUpdateContenderName;
    private javax.swing.JLabel lblUpdateDateBegin;
    private javax.swing.JPanel panelCreateNewContender;
    private javax.swing.JPanel panelSelecContend;
    private javax.swing.JTextField txtfInsertNewContender;
    private javax.swing.JTextField txtfUpdateSelectedContender;
    // End of variables declaration//GEN-END:variables
private void setWindow() {
        setTitle("CONTENDIENTES");
        setLocationRelativeTo(this);
    }

}
