
package Models.TableModels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author davidf
 * 
 * 
 * 
 * Inicializar Un Objeto de esta clase,
 * Crea una nueva JTABLE
 * Se le añade el JTABLEMODEL correspondiente AQUI
 * y setea los colores,tamaños(propiedades) de la tabla.
 * 
 * Llamar al metodo "getJtable para setearle ESTA JTABLE a la JTABLE de la VISTA"
 * 
 * ////////////////////////////////////////////////////////////////////////////////
 * 
 * EJEMPLO que iría en el CONTROLADOR (en el supuesto que esta clase se llama "TableModelPaint")
 * 
 
////////////////////INSERTANDO JTABLE TUNEADA Y JTableMODEL ///////////       
///////////////////////////////////////////////////////////////////////

        //Inicializando el TableModel
        tableModelGuerra = new JTableModelGuerra(DAOguerra);
        
        //Creando objeto de TableModelPaint, pasandole el MODELO que QUEREMOS ESTABLECERLE
        TableModelPaint  tableModelPaint = new TableModelPaint(tableModelGuerra);
        
        //Seteando la JTable de la vista, con la JTable TUNEADA que nos devuelve la clase TableModelPaint
        viewGuerras.setJtableWars(tableModelPaint.getJtable());
        
        //Seteando la JTable al ScrollPane, para que se vea, ya que si no NO PODRÄ MOSTRARLA
        viewGuerras.getjScrollPane1().setViewportView(viewGuerras.getJtableWars());
        
        //LISTO!, tabla tuning agregada
        
///////////////////////////////////////////////////////////////////    
 
 *          EXPLICACIÖN RÄPIDA DE LOS METODOS DISPONIBLES
 ***************************************************************************** 
 * 
 *           ----METODOS PUBLICOS-----
 *      
 *      getJTable() ===> Devuelve el JTable 
 *  
 * *************************************
 *           ---------METODOS PRIVADOS------
 * 
 *      setJtableHeaders()  =======> Metodo en el que se EDITAN LOS HeaderS(TITULOS) de la JTABLE 
 *          (Se PINTA el Background y foreground de los HEADERS, y AQUI le INDICAMOS que LAS COLUMNAS NO PUEDAN MOVERSE(reordenarse))
 * 
 *      initDefaultTableModel() ===> Metodo que inicializa el "modelo" de la tabla (en este BLOQUEAMOS LA EDICION de las celdas,)
 * 
 * 
 */


public class TableModelPaint {

    private JTableHeader header;
    private JTable table;
    
    
    /**
     * AÑADIENDO LOS "JTableModels" para las tablas de la vista aquí 
     * LOS DEJO PARA VERLOS Y SABER QUE VAN AQUÍ, Porque estos definidos nose utilizan,
     * El constructor utiliza en que viene del controlador directamente.
     */
    
//    private JTableModelGuerra tableModelGuerra ;
//    private JTableModelPais tableModelPais ;




    
    public TableModelPaint(JTableModelGuerra tableModelGuerra) {
        
//        this.tableModelGuerra = tableModelGuerra;
        
        initJtable(tableModelGuerra);
           
        setJtableHeaders();

        //////Necesario estableces el tema de la UI de windows, GTK o Metal, para que se puedan PINTAR LOS HEADERS DE LA TABLA
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (InstantiationException ex) {
             System.out.println(ex.getMessage());        
        } catch (IllegalAccessException ex) {
             System.out.println(ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex){
            System.out.println(ex.getMessage());        
        }

    } //Fin del constructor

    
    
    public TableModelPaint(JTableModelPais tableModelPais) {
        
//        this.tableModelPais = tableModelPais;
        
        initJtable(tableModelPais);
           
        setJtableHeaders();

        //////Necesario estableces el tema de la UI de windows, GTK o Metal, para que se puedan PINTAR LOS HEADERS DE LA TABLA
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (InstantiationException ex) {
             System.out.println(ex.getMessage());        
        } catch (IllegalAccessException ex) {
             System.out.println(ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex){
            System.out.println(ex.getMessage());        
        }

    } //Fin del constructor
    
    
    
    
     ///////////////////////////////////////////////
    //Obtener el JTABLE que configuramos aquí para pasarlo al JTABLE que mostraremos
    public JTable getJtable() {

        return this.table;
    }
    
    
    
    /**
     * Este Metodo, RECIBE un "Object" que deberá ser un "AbstracTableModel" o cambiar a "TableModel" 
     * Será el JTableModel que queramos establecerle a nuestra JTABLE. 
     * 
     * @param tableModel 
     * 
     * Inicializando la jtable Y PINTANDO LAS CELDAS    
     */
    private void initJtable(Object tableModel) {
        
             table = new JTable((AbstractTableModel) tableModel) {
            
            private static final long serialVersionUID = 1L;    
       
            ///Pintando las CELDAS de la JTABLE    
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);

                if (row % 2 == 0) {
                    ((JComponent) c).setBackground(Color.GREEN);
                } else {
                    ((JComponent) c).setBackground(Color.YELLOW);
                }
                return c;
            }
        };
               
        //Seteando altura de las CELDAS
        table.setRowHeight(40);
        //Seteando que NO puedan ser seleccionadas las celdas
        table.setFocusable(true);
        
    }//Fin de initJtable

    
    

    
    
//    
// //////////////////////////////////////////////////////   
//  //INICIALIZANDO EL "MODEL" PARA APLICARLE A LA TABLA
//    private void initDefaultTableModel(){
//    model = new DefaultTableModel(data, columnNames) {
//        private static final long serialVersionUID = 1L;
//
//        @Override
//        public Class<?> getColumnClass(int column) {
//            return getValueAt(0, column).getClass();
//        }
//
//        @Override
//        public boolean isCellEditable(int row, int column) {
//            // Aquí devolvemos true o false según queramos que una celda
//            // identificada por fila,columna (row,column), sea o no editable
//            return false;
//        }
//
//        
//    };
//    }//Fin de defaultTableModel
//
//    
//    
/////////////////////////////////////////////    
   //PINTANDO EL HEADER(TITULO) DE LA JTABLE 
    private void setJtableHeaders() {
        
        header = table.getTableHeader();

        //Indicandole que las COLUMNAS NO SE MUEVAN
        header.setReorderingAllowed(false);

        //Estableciendo TAMAÑO para los HEADER (titulos) de la JTable
        table.getTableHeader().setPreferredSize(new Dimension(table.getPreferredSize().width, 35));

        final TableCellRenderer hr = table.getTableHeader().getDefaultRenderer();
        header.setDefaultRenderer(new TableCellRenderer() {
            private JLabel lbl;

            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {

                lbl = (JLabel) hr.getTableCellRendererComponent(table, value,
                        false, false, row, column);
                lbl.setBorder(BorderFactory.createCompoundBorder(
                        lbl.getBorder(),
                        BorderFactory.createEmptyBorder(1, 1, 1, 1)));
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setBackground(Color.ORANGE);

                // lbl.setForeground(header.getForeground());
                lbl.setForeground(Color.BLACK);

                /*return (value == selectedColumn) ? hr.getTableCellRendererComponent(
table, value, true, true, row, column) : hr.getTableCellRendererComponent(
table, value, false, false, row, column);*/
                lbl.setOpaque(true);
                return lbl;
            }
        });
        
    }//Fin de setJTableHeaders
    
    
    
}
