package Prueba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class pelota {
    private int x, y;
    private int dx = 4; // Cambio en la posición en el eje X
    private int dy = 5; // Cambio en la posición en el eje Y
    private int radio = 15; // Radio de la pelota
    private Color color = Color.WHITE; // Color de la pelota

    public pelota(int x, int y) {
        this.x = x;
        this.y = y;
    }
public int puntaje=0;
float velocidad=(float) 0.05;
 public int Verificacion=0;
    public void mover() {
        x += dx;
        y += dy;

        // Verifica colisión con los bordes del frame
        if (x < 0 || x > 670-30) {
            dx *= -1- velocidad; // Cambia la dirección en el eje X
            puntaje +=5;
        }
        if (y < 0 || y > 670-30) {
            dy *= -1- velocidad; // Cambia la dirección en el eje Y
             puntaje +=5;
        }
        if( y==670-30 && x >=0 ){
        Verificacion=1;
        }
    }

    public void cambiarDireccionY() {
        dy *= -1- velocidad; // Cambia la dirección en el eje Y
    }

    public void paint(Graphics g) {
        g.setColor(color); // Establece el color de la pelota
        g.fillOval(x, y, radio * 2, radio * 2);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, radio * 2, radio * 2);
    }


   public void incrementarPuntaje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
