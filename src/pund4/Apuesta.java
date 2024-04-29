/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;


public class Apuesta {

   /**
    * @author Alvaro
    * @return devuelve la cantidad de goles locales 
    */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * @author Alvaro
     * @param goles_local cantidad de goles locales
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

   /**
    * @author Alvaro
    * @return cantidad de goles visitantes
    */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * @author Alvaro
     * @param goles_visitante cantidad de goles visitantes
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * @author Alvaro
     * @return cantidad de dinero apostado
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * @author Alvaro
     * @param apostado cantidad de dinero apostado
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    public int dinero_disp;
    public int goles_local;
    public int goles_visitante;
    public int apostado;
    
    /**
     * @author Alvaro
     */
    /*Contructor por defecto*/
    public Apuesta() {
    }
    
    /**
     * @author Alvaro
     * @param dinero_disp cantidad de dinero disponible
     * @param goles_local cantidad de goles locales
     * @param goles_visitante cantidad de goles visitantes
     */
    /*Contructor con parámetros*/
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    
    /**
     * @author Alvaro
     * @return cantidad de dinero disponible
     */
    /*Método para obtener el valor del atributo dinero_disp*/

    public int getDinero_disp() {
        return dinero_disp;
    }
    
    /**
     * @author Alvaro
     * @param dinero_disp cantidad de dinero disponible
     */
    /*Método para modificar el valor del atributo dinero_disp*/

    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }
    
    
    /**
     * @author Alvaro
     * @param dinero cantidad de dinero que se apuesta
     * @throws Exception Excepción si se apuesta menos de uno o más del dinero que se tiene
     */
    /*Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
    /*Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * 
     */
    /**
     * @author Alvaro
     * @param local cantidad de goles locales
     * @param visitante cantidad de goles visitantes
     * @return se ha acertado o no
     * @throws Exception si el valor de los parametros es 0
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
    /* Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     */
    /**
     * @author Alvaro
     * @param cantidad_goles_local cantidad de goles locales
     * @param cantidad_goles_visit cantidad de goles visitantes
     * @throws Exception Si la apuesta es incorrecta, no se no se cobra
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}