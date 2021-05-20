/*
 * To change this license header choose License Headers in Project Properties.
 * To change this template file choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author davidf
 */
public class DetailsWarDTO {

    String nombre_guerra = "";
    String inicio_guerra = "";
    String fin_guerra = "";
    String nombre_contendiente = "";
    String ganador_contendiente = "";
    String nombre_pais = "";
    String inicio_independiente = "";
    String fin_independiente = "";
    String inicio_unioncont = "";
    String abandono_unioncont = "";

    public DetailsWarDTO(String nombre_guerra, String inicio_guerra, String fin_guerra, String nombre_contendiente, String ganador_contendiente, String nombre_pais, String inicio_independiente, String fin_independiente, String inicio_unioncont, String abandono_unioncont) {
        
        this.nombre_guerra = nombre_guerra;
        this.inicio_guerra = inicio_guerra;

        try {
            if (fin_guerra.length() > 0) {
                this.fin_guerra = fin_guerra;
            }
        } catch (NullPointerException e) {
            // System.out.println("=D");
        }

        this.nombre_contendiente = nombre_contendiente;
        this.ganador_contendiente = ganador_contendiente;
        this.nombre_pais = nombre_pais;

        

        try {
            if (inicio_independiente.length() > 0) {
                this.inicio_independiente = inicio_independiente;
            }
        } catch (NullPointerException e) {
            // System.out.println("=D");
        }
        
        
        try {
            if (fin_independiente.length() > 0) {
                this.fin_independiente = fin_independiente;
            }
        } catch (NullPointerException e) {
            // System.out.println("=D");
        }

        try {
            if (inicio_unioncont.length() > 0) {
                this.inicio_unioncont = inicio_unioncont;
            }
        } catch (NullPointerException e) {
            // System.out.println("=D");
        }

        try {
            if (abandono_unioncont.length() > 0) {
                this.abandono_unioncont = abandono_unioncont;
            }
        } catch (NullPointerException e) {
            // System.out.println("=D");
        }

 
    }

    public String getNombre_guerra() {
        return nombre_guerra;
    }

    public String getInicio_guerra() {
        return inicio_guerra;
    }

    public String getFin_guerra() {
        return fin_guerra;
    }

    public String getNombre_contendiente() {
        return nombre_contendiente;
    }

    public String getGanador_contendiente() {
        return ganador_contendiente;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public String getInicio_independiente() {
        return inicio_independiente;
    }

    public String getFin_independiente() {
        return fin_independiente;
    }

    public String getInicio_unioncont() {
        return inicio_unioncont;
    }

    public String getAbandono_unioncont() {
        return abandono_unioncont;
    }

}
