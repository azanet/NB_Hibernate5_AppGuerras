package CONVERT_a_POJOS;

/**
 *
 * @author grupo1
 */
public class ContenderDTO {
    private int id_contendiente;
    private int ganador;
    private String nombre;
    private int id_guerra;

    public ContenderDTO() {
        
    }

    public ContenderDTO(int id_contendiente, int ganador, String nombre, int id_guerra) {
        this.id_contendiente = id_contendiente;
        this.ganador = ganador;
        this.nombre = nombre;
        this.id_guerra = id_guerra;
    }

    public int getId_contendiente() {
        return id_contendiente;
    }

    public void setId_contendiente(int id_contendiente) {
        this.id_contendiente = id_contendiente;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_guerra() {
        return id_guerra;
    }

    public void setId_guerra(int id_guerra) {
        this.id_guerra = id_guerra;
    }

    @Override
    public String toString() {
        return "ContenderDTO{" + "id_contendiente=" + id_contendiente + ", ganador=" + ganador + ", nombre=" + nombre + ", id_guerra=" + id_guerra + '}';
    }
    
    
    
    
    
}
