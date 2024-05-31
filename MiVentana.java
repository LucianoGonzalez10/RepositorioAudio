import javax.swing.*;
import java.awt.*;

public class MiVentana extends JFrame {
    public MiVentana() {
        super("Mi Aplicación"); // Título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configuración del ícono de la ventana
        ImageIcon icono = new ImageIcon("ruta/al/icono.png"); // Ruta del ícono
        setIconImage(icono.getImage()); // Establecer el ícono de la ventana
        
        // Configuración de otros componentes de la ventana
        // ...
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
