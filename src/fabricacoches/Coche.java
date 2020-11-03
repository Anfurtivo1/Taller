/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacoches;

/**
 *
 * @author anfur
 */
public class Coche {
    private int numeroPuertas;
    private boolean capo;
    private boolean motor;
    private boolean pintura;

    public Coche(int numeroPuertas, boolean capo, boolean motor, boolean pintura) {
        this.numeroPuertas = numeroPuertas;
        this.capo = capo;
        this.motor = motor;
        this.pintura = pintura;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public boolean isCapo() {
        return capo;
    }

    public void setCapo(boolean capo) {
        this.capo = capo;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public boolean isPintura() {
        return pintura;
    }

    public void setPintura(boolean pintura) {
        this.pintura = pintura;
    }
    
    
    
}
