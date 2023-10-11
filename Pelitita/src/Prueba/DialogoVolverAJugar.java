import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoVolverAJugar extends JDialog {
    public DialogoVolverAJugar(JFrame parent) {
        super(parent, "Volver a Jugar", true);

        JButton volverAJugarButton = new JButton("Volver a Jugar");
        JButton cerrarButton = new JButton("Cerrar");

        volverAJugarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo
                reiniciarJuego();
            }
        });

        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        panel.add(volverAJugarButton);
        panel.add(cerrarButton);
        add(panel);

        pack();
        setLocationRelativeTo(parent);
    }
}
