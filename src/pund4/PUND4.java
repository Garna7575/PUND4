/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pund4;

/**
 *
 * @author javie
 */
public class PUND4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Apuesta laApuesta;

        laApuesta = new Apuesta(1000, 4, 2);
        operativaApuesta(laApuesta, 0);
    }

    public static void operativaApuesta(Apuesta laApuesta, int dinero) {
        int mi_dinero;
        try {
            System.out.println("Apostando...");
            laApuesta.apostar(25);
        } catch (Exception e) {
            System.out.println("Fallo al realizar la Apuesta");
        }
        try {
            System.out.println("Intento cobrar apuesta segun el resultado del partido");
            laApuesta.cobrar_apuesta(2, 3);
        } catch (Exception e) {
            System.out.println("Fallo al cobrar la apuesta");
        }
        mi_dinero = laApuesta.getDinero_disp();
        System.out.println("El dinero que tengo tras las apuestas es " + mi_dinero);
    }
    
}
