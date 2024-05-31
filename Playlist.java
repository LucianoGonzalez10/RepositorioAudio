import java.util.ArrayList;

public class Playlist {
    private ArrayList<Cancion> canciones;
    private String nombre;
    private String portada;

    Playlist(String nombre, String portada){
        this.canciones = new ArrayList<>();
        this.nombre = nombre;
        this.portada = portada;

        System.out.println("Ruta de la portada para " + nombre + ": " + portada);

    }
    public void agregarCanciones(Cancion cancion){
        canciones.add(cancion);
    }
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPortada() {
        return portada;
    }
}
