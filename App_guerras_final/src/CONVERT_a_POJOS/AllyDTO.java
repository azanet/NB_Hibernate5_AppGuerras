/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONVERT_a_POJOS;

/**
 *
 * @author davidf
 */
public class AllyDTO {
    private int id_contendiente;
    private int id_pais;
    private String fecha_union;
    private String fecha_abandono;

    public AllyDTO() {
        
    }

    public AllyDTO(int id_contendiente, int id_pais, String fecha_union, String fecha_abandono) {
        this.id_contendiente = id_contendiente;
        this.id_pais = id_pais;
        this.fecha_union = fecha_union;
        this.fecha_abandono = fecha_abandono;
    }

    public int getId_contendiente() {
        return id_contendiente;
    }

    public void setId_contendiente(int id_contendiente) {
        this.id_contendiente = id_contendiente;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getFecha_union() {
        return fecha_union;
    }

    public void setFecha_union(String fecha_union) {
        this.fecha_union = fecha_union;
    }

    public String getFecha_abandono() {
        return fecha_abandono;
    }

    public void setFecha_abandono(String fecha_abandono) {
        try{
        this.fecha_abandono = fecha_abandono;
        }catch(NullPointerException npe){
            this.fecha_abandono=null;
        }
    }

    @Override
    public String toString() {
        return "AllyDTO{" + "id_contendiente=" + id_contendiente + ", id_pais=" + id_pais + ", fecha_union=" + fecha_union + ", fecha_abandono=" + fecha_abandono + '}';
    }
    
    
    
    
}