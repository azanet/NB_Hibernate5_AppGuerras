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

public class JTableModelPais extends AbstractTableModel{



    private static final long serialVersionUID = 2L;
    private final DAOPais DAOpais;
    
    public JTableModelPais(DAOPais DAOpais)
    {
        super();
     
        this.DAOpais= DAOpais;


    }

    @Override
    public int getRowCount()
    {
        return DAOpais.getPaisAllDataSizeList();
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
       
            Object[] values = DAOpais.getPaisAllData(rowIndex);
            
   
            return values[columnIndex];
            
  
    }

    @Override
    public String getColumnName(int column)
    {
        String[] columnNames=new String[]{"ID PAIS","NOMBRE","ID PERIODO","AÑO INICIO","AÑO FIN"};
        return columnNames[column];
    }

}
