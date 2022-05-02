
package introJDBC;

public class persona {
    private int id;
    private String nombre;
    private int edad;
    
    public persona(){
    }
     public persona(int id){
         this.id = id;
    }

    public persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "persona{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + '}';
    }
     
     
}
