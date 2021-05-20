/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Consult;

import Models.DetailsWarDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


/**
 *
 * @author davidf
 */
public class GetFormatDetailsWar {

    public GetFormatDetailsWar() {
    }

    public String formatDetails(ArrayList<DetailsWarDTO> detailsWarList) {

        //ITERADOR TRADICIONAL para la Coleccion "LIST"
        Iterator<DetailsWarDTO> it = detailsWarList.iterator(); //Creamos el iterador del Objeto a Iterar

        AlignText alignText=new AlignText();
        
        String nombreGuerra = "";
        String duracion = "";

        TreeSet<ContenderAndResult> contenderAndResultSet = new TreeSet<>();

        String result = "";
        int count = 1;

        //Iteraremos la lista mientras existan datos.
        while (it.hasNext()) {
            DetailsWarDTO obj = it.next(); //Cogemos el "siguiente" elemento

            if (nombreGuerra.equalsIgnoreCase("")) {
                nombreGuerra = obj.getNombre_guerra();
            }

            if (duracion.equalsIgnoreCase("")) {
                duracion = "(" + obj.getInicio_guerra() + " -- " + obj.getFin_guerra() + ")";
            }

            ContenderAndResult contenedrAndResult = new ContenderAndResult(obj.getNombre_contendiente(), obj.getGanador_contendiente());
            contenderAndResultSet.add(contenedrAndResult);
        }//Fin del While
        
        
        result += "\n\n"+alignText.CenterText(nombreGuerra) ;
        result += "\n"+ alignText.CenterText(duracion);
        result += "\n\n"+ alignText.CenterText(("Nº de Contendientes: " + contenderAndResultSet.size()));
        
        //ITERADOR TRADICIONAL para la Coleccion "SET"
        Iterator<ContenderAndResult> itSet = contenderAndResultSet.iterator(); //Creamos el iterador del CONJUNTO a Iterar
        //Iteraremos la lista mientras existan datos.

        while (itSet.hasNext()) {
            result += "\n\n"+alignText.CenterText("============================================================\n");
            
            ContenderAndResult contenderAndResult = itSet.next(); //Cogemos el "siguiente" elemento   
            
            result += (alignText.CenterText("# CONTENDIENTE " + count + " #")+"\n");

            String aux = "";
            if (contenderAndResult.getWinner().equalsIgnoreCase("1")) {
                aux = "{GANADOR}";
            } else {
                aux = "{PERDEDOR}";
            }
            result += alignText.CenterText(aux);
            result += "\n"+alignText.CenterText("**[" + contenderAndResult.getName_contender() + "]**");
            result += "\n\n"+alignText.CenterText("--------PARTICIPAN--------");

            it = detailsWarList.iterator();
            
            while (it.hasNext()) {
                 
                DetailsWarDTO obj = it.next(); //Cogemos el "siguiente" elemento
                
                if (obj.getNombre_contendiente().equalsIgnoreCase(contenderAndResult.getName_contender())) {
                    
                    String result_aux="";
                    result_aux += ">> "+ obj.getNombre_pais();

                    if (obj.getInicio_independiente().length() > 0) {
                        result_aux += "  (Independiente: " + obj.getInicio_independiente();

                        if (obj.getFin_independiente().length() > 0) {

                            result_aux += "-" + obj.getFin_independiente();
                        }

                        result_aux += ")";
                    }
                    
                    result+="\n\n"+alignText.CenterTextLeftLvl1(result_aux);
                            
                            
                    result += "\n"+alignText.CenterTextLeftLvl2("Union:    " + obj.getInicio_unioncont());

                    if (obj.getAbandono_unioncont().length() > 0) {
                        result += "\n"+alignText.CenterTextLeftLvl2("Abandono: " + obj.getAbandono_unioncont());
                    }

                }
            }

            result += "\n\n";
            count++;

        } //Fin del While

        
        

        
        
        return result;
    }

   
}



