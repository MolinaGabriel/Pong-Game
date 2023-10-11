package Prueba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class rectangulo {
    private int x, y;
    private int velocidadX = 15; // Velocidad de movimiento en el eje X
    private int ancho = 100; // Ancho del cuadrado
    private int alto = 25; // Alto del cuadrado
    private Color color = Color.WHITE; // Color del cuadrado

    public rectangulo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moverIzquierda() {
        if (x > 0) {
            x -= velocidadX;
        }
    }

    public void moverDerecha() {
        if (x < 685 - ancho) {
            x += velocidadX;
        }
    }

    public void paint(Graphics g) {
        g.setColor(color); // Establece el color del cuadrado
        g.fillRect(x, y, ancho, alto);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ancho, alto);
    }
}
