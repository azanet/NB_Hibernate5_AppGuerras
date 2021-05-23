/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.ConsultFormatTextUtils;

/**
 *
 * @author davidf
 */
public class ContenderAndResultDTO implements Comparable<ContenderAndResultDTO> {
    
    String name_contender;
    String winner;


    public ContenderAndResultDTO(String name_contender, String winner) {
        this.name_contender = name_contender;
        this.winner = winner;
    }

    public String getName_contender() {
        return name_contender;
    }

    public String getWinner() {
        return winner;
    }
    
    
    @Override
    public int compareTo(ContenderAndResultDTO o) {
        
        return name_contender.compareTo(o.name_contender);
    }//Fin del comparador
    
}//Fin de la clase OBJETO, COMPARABLE
