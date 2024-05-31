import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaginaPrincipal extends JFrame implements ActionListener {
    private ArrayList<Playlist> playlists;
    private JPanel playlistsPanel;

    public PaginaPrincipal(ArrayList<Playlist> playlists) {
        this.playlists = playlists;

        setTitle("Spotify");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Configurar el ícono de la ventana y la barra de tareas
        ImageIcon icono = new ImageIcon("media\\iconoPrograma.png"); // Ruta del ícono
        setIconImage(icono.getImage()); // Establecer el ícono de la ventana

        setLayout(new GridLayout(0, 1));

        playlistsPanel = new JPanel(new GridLayout(0, 1)); // Layout para las playlists y sus portadas

        for (Playlist playlist : playlists) {
            // Panel para contener el botón de la playlist y la portada
            JPanel playlistPanel = new JPanel(new BorderLayout());

            // Botón de la playlist
            JButton playlistButton = new JButton(playlist.getNombre());
            playlistButton.addActionListener(this);
            playlistPanel.add(playlistButton, BorderLayout.NORTH);

            // Etiqueta para mostrar la portada
            JLabel portadaLabel = new JLabel();
            ImageIcon portadaIcon = new ImageIcon(playlist.getPortada());
            portadaLabel.setIcon(portadaIcon);
            playlistPanel.add(portadaLabel, BorderLayout.CENTER);

            // Agregar el panel de la playlist al panel principal
            playlistsPanel.add(playlistPanel);
        }

        add(new JScrollPane(playlistsPanel), BorderLayout.CENTER);

        // Establecer la ventana en modo de pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String playlistName = clickedButton.getText();

        for (Playlist playlist : playlists) {
            if (playlist.getNombre().equals(playlistName)) {
                new PaginaPlaylist(playlist);
                break;
            }
        }
    }
}
