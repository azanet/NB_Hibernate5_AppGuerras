/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Consult;

/**
 *
 * @author davidf
 */
public class ContenderAndResult implements Comparable<ContenderAndResult> {
    
    String name_contender;
    String winner;


    public ContenderAndResult(String name_contender, String winner) {
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
    public int compareTo(ContenderAndResult o) {
        
        return name_contender.compareTo(o.name_contender);
    }//Fin del comparador
    
}//Fin de la clase OBJETO, COMPARABLE
