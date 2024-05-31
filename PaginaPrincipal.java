import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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

        setLayout(new BorderLayout());

        // Crear el panel de las playlists
        playlistsPanel = new JPanel(new GridLayout(0, 3, 10, 10)); // 3 columnas
        playlistsPanel.setBackground(Color.BLACK); // Fondo negro

        for (Playlist playlist : playlists) {
            // Panel para contener el botón de la playlist y la portada
            JPanel playlistPanel = new JPanel(new BorderLayout());
            playlistPanel.setBackground(Color.BLACK); // Fondo negro

            // Botón de la playlist
            JButton playlistButton = new JButton(playlist.getNombre());
            playlistButton.setBackground(Color.BLACK); // Fondo negro del botón
            playlistButton.setForeground(Color.GREEN); // Texto del botón verde
            playlistButton.setBorder(BorderFactory.createLineBorder(Color.GREEN)); // Borde verde
            playlistButton.addActionListener(this);
            playlistPanel.add(playlistButton, BorderLayout.NORTH);

            // Etiqueta para mostrar la portada
            JLabel portadaLabel = new JLabel();
            ImageIcon portadaIcon = new ImageIcon(playlist.getPortada());
            portadaLabel.setIcon(portadaIcon);
            portadaLabel.setBackground(Color.BLACK); // Fondo negro
            portadaLabel.setOpaque(true); // Hacer el fondo de la etiqueta visible
            playlistPanel.add(portadaLabel, BorderLayout.CENTER);

            // Agregar el panel de la playlist al panel principal
            playlistsPanel.add(playlistPanel);
        }

        JScrollPane scrollPane = new JScrollPane(playlistsPanel);
        scrollPane.getViewport().setBackground(Color.BLACK); // Fondo negro del scroll pane
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Borde amarillo del scroll pane
        add(scrollPane, BorderLayout.CENTER);

        // Añadir un listener para ajustar el layout al cambiar el tamaño de la ventana
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int columns = Math.max(1, width / 300); // Ajusta el valor 300 según el tamaño deseado para cada columna
                playlistsPanel.setLayout(new GridLayout(0, columns, 10, 10));
                playlistsPanel.revalidate();
            }
        });

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