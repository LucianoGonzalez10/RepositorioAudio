import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaginaPlaylist extends JFrame implements ActionListener {
    private Playlist playlist;
    private JPanel cancionesPanel;

    public PaginaPlaylist(Playlist playlist) {
        this.playlist = playlist;

        setTitle(playlist.getNombre());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Permitir cerrar esta ventana sin cerrar la aplicación
        setLayout(new BorderLayout());

        cancionesPanel = new JPanel(new GridLayout(0, 1)); // Layout para las canciones

        for (Cancion cancion : playlist.getCanciones()) {
            JButton cancionButton = new JButton(cancion.getNombre());
            cancionButton.addActionListener(this);
            cancionesPanel.add(cancionButton);
        }

        add(new JScrollPane(cancionesPanel), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String cancionName = clickedButton.getText();
        
        for (Cancion cancion : playlist.getCanciones()) {
            if (cancion.getNombre().equals(cancionName)) {
                ArrayList<Cancion> canciones = new ArrayList<>();
                canciones.add(cancion);
                new ReproductorMusica(canciones); // Reproducir la canción seleccionada
                break;
            }
        }
    }
}
