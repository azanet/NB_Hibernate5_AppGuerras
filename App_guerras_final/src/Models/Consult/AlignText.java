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
public class AlignText {

    public AlignText() {
    }
    

    
    public String CenterText (String str) {
        
        int ancho = 60;//Tamaño del campo a ocupar por la cadena
        int lonText=str.length();//longitud del texto
        int tamañoCampo=(ancho/2)+(lonText/2);
        
        String lineFormat= String.format("%" + tamañoCampo + "s", str);
        lineFormat= String.format("%-" + ancho + "s", lineFormat);
        return lineFormat;
    }
    
    
    
    public String CenterTextLeftLvl1 (String str) {
        
       // int ancho = 60;//Tamaño del campo a ocupar por la cadena
        int lonText=str.length();//longitud del texto
        int tamañoCampo=18+lonText;//Seteamos espacios deseados A MANO
        
        String lineFormat= String.format("%" + tamañoCampo + "s", str);

        return lineFormat;
    }
    
        
    public String CenterTextLeftLvl2 (String str) {
        
        //int ancho = 60;//Tamaño del campo a ocupar por la cadena
        int lonText=str.length();//longitud del texto
        int tamañoCampo=22+lonText;//Seteamos espacios deseados A MANO
        
        String lineFormat= String.format("%" + tamañoCampo + "s", str);

        return lineFormat;
    }
    
    
    
    
    
    
}
