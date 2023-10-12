package Prueba;

import Prueba.pelota;
import Prueba.rectangulo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class juegov2 extends JPanel implements KeyListener {
    private pelota pel; // Pelota se inicializará en el constructor
    private rectangulo rect = new rectangulo(300, 600);
    private Image fondo;
    private int tiempoTranscurrido; // Variable para almacenar el tiempo transcurrido en segundos
    private int vidas = 3; // Número inicial de vidas (puedes ajustarlo)
    int veri = 0;
    int aux=0;
    private JFrame miVentana; // Referencia a la ventana principal
    private boolean juegoTerminado = false; // Bandera para verificar si el juego ha terminado

   
    Timer timerContador = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tiempoTranscurrido++; // Incrementa el tiempo en cada segundo
        }
    });

    Timer timerPelota;
    

    public juegov2() {
          aux=vidas; // Establece el número de vidas a aux, las vidas inicialmente ingresadas

        pel = new pelota(); // Inicializa la pelota en la parte superior de la pantalla
        timerPelota = new Timer(20, new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
               
                if (juegoTerminado) {
                    return; // Si el juego ha terminado, no realices ninguna acción
                }

                pel.mover(); // Mueve la pelota cada 20 milisegundos
                // Verifica colisión y otras acciones relacionadas con la pelota aquí
                if (pel.getBounds().intersects(rect.getBounds())) {
                    // Cambia la dirección de la pelota en el eje Y
                    pel.cambiarDireccionY();
                }
                if (pel.Verificacion == 1 && vidas > 0) {
                    JOptionPane.showMessageDialog(juegov2.this, "Perdiste una vida\nTiempo transcurrido: " + tiempoTranscurrido + " segundos");
                    veri = 1;
                    reiniciarJuego();
                }
                if (veri == 1) {
                    vidas = vidas - 1;
                    veri = 0;
                }
                if (vidas == 0) {
                    // Muestra un mensaje de "Juego terminado" con dos botones: "Jugar de Nuevo" y "Salir"
                    int option = JOptionPane.showOptionDialog(juegov2.this, "Juego terminado\nTiempo transcurrido: " + tiempoTranscurrido + " segundos", "Juego Terminado",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Jugar de Nuevo", "Salir"}, "Jugar de Nuevo");

                    if (option == JOptionPane.OK_OPTION) {
                        // El usuario elige jugar de nuevo
                        reiniciarJuego();
                        vidas=aux;
                    } else {
                        // El usuario elige salir
                        miVentana.dispose(); // Cierra la ventana principal
                        juegoTerminado = true; // Marca el juego como terminado
                    }
                }
                repaint();
            }
        });

        timerContador.start();
        timerPelota.start();
        setFocusable(true);
        addKeyListener(this);
        // Cargar la imagen del fondo
        fondo = new ImageIcon(getClass().getResource("/imagenes/80.jpg")).getImage();
        tiempoTranscurrido = 0; // Inicializa el tiempo en 0
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar el fondo
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

        pel.paint(g);
        rect.paint(g);
        dibujarContador(g);
    }

    private void dibujarContador(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + pel.puntaje, 270, 20);

        // Dibuja el contador de tiempo en la esquina superior derecha
        g.drawString("Tiempo: " + tiempoTranscurrido + " segundos", getWidth() - 200, 20);


        // Dibuja el contador de vidas en la esquina superior izquierda
        g.drawString("Vidas: " + vidas, 10, 20);
    }

    public static void main(String[] args) {
        juegov2 game = new juegov2();

        // Permite al usuario ingresar el número de vidas
        String input = JOptionPane.showInputDialog("Ingrese el número de vidas:");
        try {
            game.vidas = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Se usará el valor predeterminado (3) para las vidas.");
        }

        JFrame miVentana = new JFrame("Juego");
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.add(game);
        miVentana.setSize(700, 700);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);

        // Asigna la referencia de la ventana principal
        game.miVentana = miVentana;
        
   
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            rect.moverIzquierda();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            rect.moverDerecha();
        }
        repaint(); // Repintar el cuadrado cuando se mueva
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void reiniciarJuego() {
        pel = new pelota()
        ; // Restablece la posición inicial de la pelota
        tiempoTranscurrido = 0; // Reinicia el tiempo

        // Detiene el temporizador actual y comienza uno nuevo
        timerPelota.stop();
        timerContador.restart();

        // Reinicia el temporizador
        timerPelota.start();
    }
}