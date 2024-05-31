import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class index {
    public static void main(String[] args) {
        Cancion cancion1 = new Cancion("CALL ME BABY", "Duki", "audio\\Call-Me-Baby.wav", "media/portadaCancion2.jpg");
        Cancion cancion2 = new Cancion("BAILE CHORRA SE TE CAEN LAS BALAS", "Aniasko", "audio\\pruebasAudio.wav", "media/portadaCancion1.jpg");
        Cancion cancion3 = new Cancion("SET LIVE MDQ", "Aniasko", "audio\\pruebasAudio.wav", "media/portadaCancion1.jpg");
        Cancion cancion4 = new Cancion("Don KBRN Frrestyle", "Eladio Carrion","audio\\Call-Me-Baby.wav", "media/portadaCancion3.jpg");

        // ARRAYLIST CANCIONES
        ArrayList<Cancion> canciones = new ArrayList<>();
        canciones.add(cancion1);
        canciones.add(cancion2);
        canciones.add(cancion3);
        canciones.add(cancion4);
        // Crear algunas playlists de ejemplo
        ArrayList<Playlist> playlists = new ArrayList<>();
        Playlist playlist1 = new Playlist("Duki", "media/portadaCancion2.jpg");
        Playlist playlist2 = new Playlist("Aniasko", "media/portadaCancion1.jpg");
        Playlist playlist3 = new Playlist("Eladio Carrion", "media/portadaCancion3.jpg");
        Playlist playlist4 = new Playlist("Eladio Carrion", "media/portadaCancion3.jpg");
        Playlist playlist5 = new Playlist("Eladio Carrion", "media/portadaCancion3.jpg");
        Playlist playlist6 = new Playlist("Duki", "media/portadaCancion2.jpg");
        Playlist playlist7 = new Playlist("Aniasko", "media/portadaCancion1.jpg");
        Playlist playlist8 = new Playlist("Eladio Carrion", "media/portadaCancion3.jpg");
        Playlist playlist9 = new Playlist("Eladio Carrion", "media/portadaCancion3.jpg");
        Playlist playlist10 = new Playlist("Eladio Carrion", "media/portadaCancion3.jpg");
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
                case "Eladio Carrion":
                playlist3.agregarCanciones(canciones.get(i));
                break;
                default:
                    break;
            }
        }
        playlists.add(playlist1);
        playlists.add(playlist2);
        playlists.add(playlist3);
        playlists.add(playlist4);
        playlists.add(playlist5);
        playlists.add(playlist6);
        playlists.add(playlist7);
        playlists.add(playlist8);
        playlists.add(playlist9);
        playlists.add(playlist10);
        SwingUtilities.invokeLater(() -> new PaginaPrincipal(playlists));
    }
}
