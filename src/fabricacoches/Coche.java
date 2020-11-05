
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

    Coche() {
        
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
    
    public synchronized void ponerPuerta(Coche coche){
        for (int i = 0; i < 5; i++) {
            System.out.println("Brazo de puertas poniendo puerta "+i);
            coche.setNumeroPuertas(coche.getNumeroPuertas()+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error en "+ex);
            }
        }
        System.out.println("Se ha acabado de poner puertas");
    }
    
    public synchronized void ponerCapo(Coche coche){
        if (coche.isMotor()) {
            coche.setCapo(true);
            System.out.println("Se ha puesto el capo al coche");
            notifyAll();
        }
        else{
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en "+ex);
            }
        }
    }
    
    public synchronized void ponerMotor(Coche coche){
        if (coche.getNumeroPuertas()==5) {
            coche.setMotor(true);
            System.out.println("Se va a añadir el motor al coche");
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en "+ex);
            }
        }
        
    }
    
    public synchronized void ponerPintura (Coche coche){
        if (coche.isCapo() && coche.isMotor() && coche.getNumeroPuertas()==5) {
            coche.setPintura(true);
            System.out.println("Se va a añadir la pintura al coche");
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en "+ex);
            }
        }
        
    }
    
}
