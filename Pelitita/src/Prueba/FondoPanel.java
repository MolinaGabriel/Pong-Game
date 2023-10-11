package Prueba;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FondoPanel extends JPanel {
    private Image fondoImage;
    private JButton jugarButton, sinLimitesButton, salirButton;

    public FondoPanel(JFrame ventanaActual) {
        fondoImage = new ImageIcon(getClass().getResource("/imagenes/Pagina_fondo.jpg")).getImage();
        setLayout(null);

        jugarButton = new JButton();
        sinLimitesButton = new JButton();
        salirButton = new JButton();

        jugarButton.setIcon(new ImageIcon(getClass().getResource("/imagenes/Jugar.png")));
        sinLimitesButton.setIcon(new ImageIcon(getClass().getResource("/imagenes/Sin limites.png")));
        salirButton.setIcon(new ImageIcon(getClass().getResource("/imagenes/Salir.png")));

        jugarButton.setBounds(170, 220, 350, 100);
        sinLimitesButton.setBounds(170, 320, 350, 100);
        salirButton.setBounds(170, 420, 350, 100);

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloca aquí la lógica para el botón "Jugar"
            }
        });

        sinLimitesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloca aquí la lógica para el botón "Sin Limites"
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloca aquí la lógica para el botón "Salir"
            }
        });

        add(jugarButton);
        add(sinLimitesButton);
        add(salirButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondoImage, 0, 0, getWidth(), getHeight(), this);
        Image tituloImage = new ImageIcon(getClass().getResource("/imagenes/ping pong.png")).getImage();
        g.drawImage(tituloImage, 130, 50, 450, 120, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(700, 700);
    }
}
