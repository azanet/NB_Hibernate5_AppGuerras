/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.JTableModels;

import Models.DAOs.Pais_DAO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author davidf
 * 
 */

public class JTableModel_Country extends AbstractTableModel{



    private static final long serialVersionUID = 2L;
    private final Pais_DAO business;
    
    public JTableModel_Country(Pais_DAO business)
    {
        super();
     
        this.business= business;


    }

    @Override
    public int getRowCount()
    {
        return business.getSizeList();
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
       
            Object[] values = business.getCountryData(rowIndex);
            
   
            return values[columnIndex];
            
  
    }

    @Override
    public String getColumnName(int column)
    {
        String[] columnNames=new String[]{"ID PAIS","NOMBRE","ID PERIODO","AÑO INICIO","AÑO FIN"};
        return columnNames[column];
    }

}
