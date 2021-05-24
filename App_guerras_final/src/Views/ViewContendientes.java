package Views;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
        jPanel7 = new javax.swing.JPanel();
        comboBoxSelectContender = new javax.swing.JComboBox<>();
        lblUpdateSelectedContender = new javax.swing.JLabel();
        lblUpdateContenderName = new javax.swing.JLabel();
        txtfUpdateSelectedContender = new javax.swing.JTextField();
        btnDeleteSelectedContender = new javax.swing.JButton();
        btnUpdateSelectedContender = new javax.swing.JButton();
        Cb_Ganador = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        btnInsertNewContender = new javax.swing.JButton();
        Cb_GanadorInsert = new javax.swing.JCheckBox();
        txtfInsertNewContender = new javax.swing.JTextField();
        lblContenderName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblUpdateSelectedCountry = new javax.swing.JLabel();
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
        lblInsertNewCountry = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "GUERRA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setOpaque(false);

        ComboBoxSelectWar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerra1", "Guerra2", "Guerra3", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(ComboBoxSelectWar, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ComboBoxSelectWar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "CONTENDIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("SELECCIONAR CONTENDIENTE"));
        jPanel7.setOpaque(false);

        comboBoxSelectContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un contendiente...", "Item 2", "Item 3", "Item 4" }));

        lblUpdateSelectedContender.setBackground(new java.awt.Color(204, 204, 204));
        lblUpdateSelectedContender.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateSelectedContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateSelectedContender.setText("MODIFICAR");
        lblUpdateSelectedContender.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblUpdateSelectedContender.setOpaque(true);

        lblUpdateContenderName.setForeground(new java.awt.Color(204, 204, 204));
        lblUpdateContenderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateContenderName.setText("Nombre");

        btnDeleteSelectedContender.setText("ELIMINAR");
        btnDeleteSelectedContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteSelectedContender.setMaximumSize(new java.awt.Dimension(61, 20));
        btnDeleteSelectedContender.setMinimumSize(new java.awt.Dimension(61, 20));
        btnDeleteSelectedContender.setPreferredSize(new java.awt.Dimension(61, 20));

        btnUpdateSelectedContender.setText("MODIFICAR");
        btnUpdateSelectedContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Cb_Ganador.setForeground(new java.awt.Color(204, 204, 204));
        Cb_Ganador.setText("Ganador");
        Cb_Ganador.setFocusPainted(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblUpdateContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtfUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cb_Ganador)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(btnDeleteSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)
                                .addComponent(btnUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(comboBoxSelectContender, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(comboBoxSelectContender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(lblUpdateSelectedContender)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblUpdateContenderName))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtfUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cb_Ganador)))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateSelectedContender, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 510, 220));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("CREAR NUEVO CONTENDIENTE"));
        jPanel8.setOpaque(false);

        btnInsertNewContender.setText("INSERTAR");
        btnInsertNewContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Cb_GanadorInsert.setForeground(new java.awt.Color(204, 204, 204));
        Cb_GanadorInsert.setText("Ganador");
        Cb_GanadorInsert.setFocusPainted(false);

        lblContenderName.setForeground(new java.awt.Color(204, 204, 204));
        lblContenderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContenderName.setText("Nombre");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(Cb_GanadorInsert)
                                .addGap(132, 132, 132)
                                .addComponent(btnInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cb_GanadorInsert)
                    .addComponent(btnInsertNewContender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 510, 220));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("CONTENDIENTES");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAÍSES ALIADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel4.setOpaque(false);

        lblUpdateSelectedCountry.setBackground(new java.awt.Color(204, 204, 204));
        lblUpdateSelectedCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateSelectedCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateSelectedCountry.setText("MODIFICAR");
        lblUpdateSelectedCountry.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblUpdateSelectedCountry.setOpaque(true);

        comboBoxSelectCountryADDED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país aliado...", "Item 2", "Item 3", "Item 4" }));

        lblUpdateDateBegin.setForeground(new java.awt.Color(204, 204, 204));
        lblUpdateDateBegin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUpdateDateBegin.setText("Fecha Unión");

        CB_updateFechaAbandono.setForeground(new java.awt.Color(204, 204, 204));
        CB_updateFechaAbandono.setText("Fecha Abandono");

        btnUpdateDate.setText("MODIFICAR");
        btnUpdateDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDeleteSelectCountryADDED.setText("ELIMINAR");
        btnDeleteSelectCountryADDED.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblUpdateDateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDC_updateBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblUpdateSelectedCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnDeleteSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(CB_updateFechaAbandono)
                        .addGap(18, 18, 18)
                        .addComponent(jDC_updateEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUpdateSelectedCountry)
                    .addComponent(comboBoxSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUpdateDateBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDC_updateBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDC_updateEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_updateFechaAbandono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteSelectCountryADDED, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        btnInsertCountryToContender.setText("INSERTAR");
        btnInsertCountryToContender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        CB_FechaAbandono.setForeground(new java.awt.Color(204, 204, 204));
        CB_FechaAbandono.setText("Fecha Abandono");

        lblDateBeginCountryToContender.setForeground(new java.awt.Color(204, 204, 204));
        lblDateBeginCountryToContender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDateBeginCountryToContender.setText("Fecha Unión");

        comboBoxSelectCountryToContender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione país...", "Item 2", "Item 3", "Item 4" }));

        lblInsertNewCountry.setBackground(new java.awt.Color(204, 204, 204));
        lblInsertNewCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblInsertNewCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsertNewCountry.setText("AGREGAR");
        lblInsertNewCountry.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblInsertNewCountry.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblInsertNewCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(comboBoxSelectCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDateBeginCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_FechaAbandono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDC_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDC_BeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInsertNewCountry)
                    .addComponent(comboBoxSelectCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDC_BeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateBeginCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CB_FechaAbandono)
                            .addComponent(jDC_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnInsertCountryToContender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusPainted(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblContenderName;
    private javax.swing.JLabel lblDateBeginCountryToContender;
    private javax.swing.JLabel lblInsertNewCountry;
    private javax.swing.JLabel lblUpdateContenderName;
    private javax.swing.JLabel lblUpdateDateBegin;
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
