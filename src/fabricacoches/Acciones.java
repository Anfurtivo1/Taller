
package fabricacoches;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Acciones {
    
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
