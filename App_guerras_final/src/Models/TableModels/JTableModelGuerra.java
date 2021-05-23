/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.TableModels;

import Models.DAOs.DAOGuerra;
import Models.POJOs.Guerra;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author davidf
 */
public class JTableModelGuerra extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private final DAOGuerra DAOguerra;
    
    public JTableModelGuerra(DAOGuerra DAOguerra) {
        super();

        this.DAOguerra = DAOguerra;
 
    }

    @Override
    public int getRowCount() {
        return DAOguerra.getGuerraSizeList();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Guerra g = DAOguerra.getGuerraData(rowIndex);

        Object[] values = new Object[]{g.getIdGuerra(), g.getNombre(), g.getAnioInicio(), g.getAnioFin()};
        return values[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = new String[]{"ID GUERRA", "NOMBRE", "AÑO INICIO", "AÑO FIN"};
        return columnNames[column];
    }
    
    

}
