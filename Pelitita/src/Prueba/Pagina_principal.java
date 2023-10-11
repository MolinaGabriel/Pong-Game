package Prueba;
import javax.swing.JFrame;

public class Pagina_principal {
    public static void main(String[] args) {
        JFrame principal = new JFrame("Juego");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(700, 700);
        principal.setResizable(false);
        principal.setLocationRelativeTo(null);

        FondoPanel fondoPanel = new FondoPanel();
        principal.add(fondoPanel);

        principal.setVisible(true);
    }
}
