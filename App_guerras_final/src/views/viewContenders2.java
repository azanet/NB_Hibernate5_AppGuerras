package views;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sonia Castro (soniacastromartel@gmail.com)
 */
public class viewContenders2 extends javax.swing.JDialog {

    /**
     * Creates new form viewContenders1
     */
           imagenPanel fondo = new imagenPanel();
    public viewContenders2(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
        
         this.setContentPane(fondo);
	initComponents();
	setWindow();
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


    public JLabel getLblInsertNewContender() {
	return lblInsertNewContender;
    }

    public void setLblInsertNewContender(JLabel lblInsertNewContender) {
	this.lblInsertNewContender = lblInsertNewContender;
    }

    public JLabel getLblInsertNewCountry() {
	return lblInsertNewCountry;
    }

    public void setLblInsertNewCountry(JLabel lblInsertNewCountry) {
	this.lblInsertNewCountry = lblInsertNewCountry;
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

    public JLabel getLblUpdateDateEnd() {
	return lblUpdateDateEnd;
    }

    public void setLblUpdateDateEnd(JLabel lblUpdateDateEnd) {
	this.lblUpdateDateEnd = lblUpdateDateEnd;
    }

    public JLabel getLblUpdateSelectedContender() {
	return lblUpdateSelectedContender;
    }

    public void setLblUpdateSelectedContender(JLabel lblUpdateSelectedContender) {
	this.lblUpdateSelectedContender = lblUpdateSelectedContender;
    }

    public JLabel getLblUpdateSelectedCountry() {
	return lblUpdateSelectedCountry;
    }

    public void setLblUpdateSelectedCountry(JLabel lblUpdateSelectedCountry) {
	this.lblUpdateSelectedCountry = lblUpdateSelectedCountry;
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
        ComboBoxSelectWar = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        lblUpdateSelectedContender = new javax.swing.JLabel();
        lblUpdateContenderName = new javax.swing.JLabel();
        txtfInsertNewContender = new javax.swing.JTextField();
        Cb_GanadorInsert = new javax.swing.JCheckBox();
        lblInsertNewContender = new javax.swing.JLabel();
        lblContenderName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        comboBoxSelectContender = new javax.swing.JComboBox<>();
        txtfUpdateSelectedContender = new javax.swing.JTextField();
        Cb_Ganador = new javax.swing.JCheckBox();
        btnDeleteSelectedContender = new javax.swing.JButton();
        btnInsertNewContender = new javax.swing.JButton();
        btnUpdateSelectedContender = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblInsertNewCountry = new javax.swing.JLabel();
        comboBoxSelectCountryToContender = new javax.swing.JComboBox<>();
        btnInsertCountryToContender = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblUpdateDateBegin = new javax.swing.JLabel();
        lblUpdateDateEnd = new javax.swing.JLabel();
        lblUpdateSelectedCountry = new javax.swing.JLabel();
        comboBoxSelectCountryADDED = new javax.swing.JComboBox<>();
        lblDateBeginCountryToContender = new javax.swing.JLabel();
        btnUpdateDate = new javax.swing.JButton();
        btnDeleteSelectCountryADDED = new javax.swing.JButton();
        jDC_BeginDate = new com.toedter.calendar.JDateChooser();
        jDC_EndDate = new com.toedter.calendar.JDateChooser();
        jDC_updateBeginDate = new com.toedter.calendar.JDateChooser();
        jDC_updateEndDate = new com.toedter.calendar.JDateChooser();
        CB_FechaAbandono = new javax.swing.JCheckBox();
        CB_updateFechaAbandono = new javax.swing.JCheckBox();
        btnExit = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "CONTENDIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setOpaque(false);

        ComboBoxSelectWar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerra1", "Guerra2", "Guerra3", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(ComboBoxSelectWar, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ComboBoxSelectWar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "CONTENDIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUpdateSelectedContender.setBackground(new java.awt.Color(204, 204, 204));
        lblUpdateSelectedContender.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateSelectedContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateSelectedContender.setText("MODIFICAR");
        lblUpdateSelectedContender.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblUpdateSelectedContender.setOpaque(true);
        jPanel3.add(lblUpdateSelectedContender, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 181, 128, -1));

        lblUpdateContenderName.setForeground(new java.awt.Color(204, 204, 204));
        lblUpdateContenderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateContenderName.setText("Nombre");
        jPanel3.add(lblUpdateContenderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 220, 89, -1));
        jPanel3.add(txtfInsertNewContender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 290, -1));

        Cb_GanadorInsert.setForeground(new java.awt.Color(204, 204, 204));
        Cb_GanadorInsert.setText("Ganador");
        Cb_GanadorInsert.setFocusPainted(false);
        jPanel3.add(Cb_GanadorInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        lblInsertNewContender.setBackground(new java.awt.Color(204, 204, 204));
        lblInsertNewContender.setForeground(new java.awt.Color(255, 255, 255));
        lblInsertNewContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsertNewContender.setText("AGREGAR");
        lblInsertNewContender.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblInsertNewContender.setOpaque(true);
        jPanel3.add(lblInsertNewContender, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 27, 118, -1));

        lblContenderName.setForeground(new java.awt.Color(204, 204, 204));
        lblContenderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContenderName.setText("Nombre");
        jPanel3.add(lblContenderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 72, 103, 26));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 610, 10));

        comboBoxSelectContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un contendiente...", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboBoxSelectContender, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 180, 250, -1));
        jPanel3.add(txtfUpdateSelectedContender, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 220, 284, -1));

        Cb_Ganador.setForeground(new java.awt.Color(204, 204, 204));
        Cb_Ganador.setText("Ganador");
        Cb_Ganador.setFocusPainted(false);
        jPanel3.add(Cb_Ganador, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        btnDeleteSelectedContender.setText("ELIMINAR");
        btnDeleteSelectedContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteSelectedContender.setMaximumSize(new java.awt.Dimension(61, 20));
        btnDeleteSelectedContender.setMinimumSize(new java.awt.Dimension(61, 20));
        btnDeleteSelectedContender.setPreferredSize(new java.awt.Dimension(61, 20));
        jPanel3.add(btnDeleteSelectedContender, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 93, 35));

        btnInsertNewContender.setText("INSERTAR");
        btnInsertNewContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(btnInsertNewContender, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 82, 33));

        btnUpdateSelectedContender.setText("MODIFICAR");
        btnUpdateSelectedContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(btnUpdateSelectedContender, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 88, 36));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAÍSES ALIADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel4.setOpaque(false);

        lblInsertNewCountry.setBackground(new java.awt.Color(204, 204, 204));
        lblInsertNewCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblInsertNewCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsertNewCountry.setText("AGREGAR");
        lblInsertNewCountry.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblInsertNewCountry.setOpaque(true);

        comboBoxSelectCountryToContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país...", "Item 2", "Item 3", "Item 4" }));

        btnInsertCountryToContender.setText("INSERTAR");
        btnInsertCountryToContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 15));

        lblUpdateDateBegin.setForeground(new java.awt.Color(204, 204, 204));
        lblUpdateDateBegin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateDateBegin.setText("Fecha Unión");

        lblUpdateDateEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateDateEnd.setText("Fecha Abandono");

        lblUpdateSelectedCountry.setBackground(new java.awt.Color(204, 204, 204));
        lblUpdateSelectedCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateSelectedCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateSelectedCountry.setText("MODIFICAR");
        lblUpdateSelectedCountry.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblUpdateSelectedCountry.setOpaque(true);

        comboBoxSelectCountryADDED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país aliado...", "Item 2", "Item 3", "Item 4" }));

        lblDateBeginCountryToContender.setForeground(new java.awt.Color(204, 204, 204));
        lblDateBeginCountryToContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDateBeginCountryToContender.setText("Fecha Unión");

        btnUpdateDate.setText("MODIFICAR");
        btnUpdateDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDeleteSelectCountryADDED.setText("ELIMINAR");
        btnDeleteSelectCountryADDED.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        CB_FechaAbandono.setForeground(new java.awt.Color(204, 204, 204));
        CB_FechaAbandono.setText("Fecha Abandono");

        CB_updateFechaAbandono.setForeground(new java.awt.Color(204, 204, 204));
        CB_updateFechaAbandono.setText("Fecha Abandono");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblUpdateSelectedCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnDeleteSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblUpdateDateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDC_updateBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CB_updateFechaAbandono)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblUpdateDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDC_updateEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblInsertNewCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(comboBoxSelectCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblDateBeginCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDC_BeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CB_FechaAbandono)
                                .addGap(12, 12, 12)
                                .addComponent(jDC_EndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsertCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInsertNewCountry)
                    .addComponent(comboBoxSelectCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDateBeginCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CB_FechaAbandono)
                        .addComponent(jDC_BeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDC_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnInsertCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUpdateSelectedCountry)
                    .addComponent(comboBoxSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUpdateDateEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUpdateDateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDC_updateBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDC_updateEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(CB_updateFechaAbandono)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap())
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
    private com.toedter.calendar.JDateChooser jDC_BeginDate;
    private com.toedter.calendar.JDateChooser jDC_EndDate;
    private com.toedter.calendar.JDateChooser jDC_updateBeginDate;
    private com.toedter.calendar.JDateChooser jDC_updateEndDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblContenderName;
    private javax.swing.JLabel lblDateBeginCountryToContender;
    private javax.swing.JLabel lblInsertNewContender;
    private javax.swing.JLabel lblInsertNewCountry;
    private javax.swing.JLabel lblUpdateContenderName;
    private javax.swing.JLabel lblUpdateDateBegin;
    private javax.swing.JLabel lblUpdateDateEnd;
    private javax.swing.JLabel lblUpdateSelectedContender;
    private javax.swing.JLabel lblUpdateSelectedCountry;
    private javax.swing.JTextField txtfInsertNewContender;
    private javax.swing.JTextField txtfUpdateSelectedContender;
    // End of variables declaration//GEN-END:variables
private void setWindow() {
        setTitle("CONTENDIENTES");
        setLocationRelativeTo(this);
    }

}
