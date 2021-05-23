/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.TableModels;

import Models.DAOs.DAOPais;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author davidf
 * 
 */

public class JTableModel_Pais extends AbstractTableModel{



    private static final long serialVersionUID = 2L;
    private final DAOPais business;
    
    public JTableModel_Pais(DAOPais business)
    {
        super();
     
        this.business= business;


    }

    @Override
    public int getRowCount()
    {
        return business.getPaisAllDataSizeList();
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
       
            Object[] values = business.getPaisAllData(rowIndex);
            
   
            return values[columnIndex];
            
  
    }

    @Override
    public String getColumnName(int column)
    {
        String[] columnNames=new String[]{"ID PAIS","NOMBRE","ID PERIODO","AÑO INICIO","AÑO FIN"};
        return columnNames[column];
    }

}
