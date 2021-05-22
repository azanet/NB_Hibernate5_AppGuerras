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
public class JTableModel_Guerra extends AbstractTableModel{



    private static final long serialVersionUID = 1L;
    private final DAOGuerra business;
    
    public JTableModel_Guerra(DAOGuerra business)
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
             
        Guerra g = business.getWarDTO(rowIndex);
        
        Object[] values=new Object[]{g.getIdGuerra(), g.getNombre(),g.getAnioInicio(),g.getAnioFin()};
        return values[columnIndex];
    }

    
    @Override
    public String getColumnName(int column)
    {
        String[] columnNames=new String[]{"ID GUERRA","NOMBRE","AÑO INICIO","AÑO FIN"};        
        return columnNames[column];
    }

}

