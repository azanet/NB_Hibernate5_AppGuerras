/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Country;

import Models.Country.Country_DAO;
import Models.POJOs.Pais;
import Models.POJOs.PeriodoIndependecia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author davidf
 * 
 */

public class Country_HibJTableModel extends AbstractTableModel{



    private static final long serialVersionUID = 2L;
    private final Country_DAO business;
    
    public Country_HibJTableModel(Country_DAO business)
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
       
            Pais p=business.getCountryDTO(rowIndex);
            
            List<PeriodoIndependecia> piList = new ArrayList<>(p.getPeriodoIndependecias());
            PeriodoIndependecia pi = new PeriodoIndependecia();
            for (PeriodoIndependecia periodoIndependecia : piList) {
                pi= periodoIndependecia;
            }
            
            Object[] values=new Object[]{p.getIdPais(), p.getNombre(),pi.getIdPeriodo(),pi.getAnioInicio(),pi.getAnioFin()};
            
            return values[columnIndex];
            
  
    }

    @Override
    public String getColumnName(int column)
    {
        String[] columnNames=new String[]{"ID PAIS","NOMBRE","ID PERIODO","AÑO INICIO","AÑO FIN"};
        return columnNames[column];
    }

}
