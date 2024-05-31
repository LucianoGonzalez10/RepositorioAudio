import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class index {
    public static void main(String[] args) {
        Cancion cancion1 = new Cancion("CALL ME BABY", "Duki", "audio\\Call-Me-Baby.wav", "media/portadaCancion2.jpg");
        Cancion cancion2 = new Cancion("BAILE CHORRA SE TE CAEN LAS BALAS", "Aniasko", "audio\\pruebasAudio.wav", "media/portadaCancion1.jpg");
        Cancion cancion3 = new Cancion("SET LIVE MDQ", "Aniasko", "audio\\pruebasAudio.wav", "media/portadaCancion1.jpg");
        // HOLAAA GIULI
        // ARRAYLIST CANCIONES
        ArrayList<Cancion> canciones = new ArrayList<>();
        canciones.add(cancion1);
        canciones.add(cancion2);
        canciones.add(cancion3);
        // Crear algunas playlists de ejemplo
        ArrayList<Playlist> playlists = new ArrayList<>();
        Playlist playlist1 = new Playlist("Duki", "media/portadaPlaylist1.jpg");
        Playlist playlist2 = new Playlist("Aniasko", "media/portadaPlaylist2.jpg");


        // Agregar canciones a las playlist
        for(int i = 0; i<canciones.size(); i++){
            String cantante = canciones.get(i).getCantante();
            switch (cantante) {
                case "Duki":
                    playlist1.agregarCanciones(canciones.get(i));
                    break;
                case "Aniasko":
                playlist2.agregarCanciones(canciones.get(i));
                break;
                default:
                    break;
            }
        }
        playlists.add(playlist1);
        playlists.add(playlist2);

        SwingUtilities.invokeLater(() -> new PaginaPrincipal(playlists));
    }
}
