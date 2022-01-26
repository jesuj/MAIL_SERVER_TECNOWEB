package Dato;

/**
 *
 * @author Oni
 */
public class Viatico {
    private int id;
    private int monto;
    private String date;
    private String razon;
    private int user_id;
    private String nombre;

    public Viatico(int id, int monto, String date, String razon, int user_id, String nombre) {
        this.id = id;
        this.monto = monto;
        this.date = date;
        this.razon = razon;
        this.user_id = user_id;
        this.nombre = nombre;
    }

    public Viatico() {
    }

    @Override
    public String toString() {
        return "<tr>" + 
                "<td>" + this.id + "</td>" +
                "<td>" + this.monto + "</td>" +
                "<td>" + this.date + "</td>" +
                "<td>" + this.razon + "</td>" +
                "<td>" + this.user_id + "</td>" +
                "<td>" + this.nombre + "</td>" + 
                "</tr>\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
