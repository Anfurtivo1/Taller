
package fabricacoches;
import fabricacoches.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author anfur
 */
public class BrazoMotor extends Thread{
    private static Coche coche;
    private boolean activo = true;
    Semaphore turnos = new Semaphore(1);

    BrazoMotor(Coche coche, Semaphore turnos) {
        this.coche=coche;
        this.turnos=turnos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    @Override
    public void run(){
        try {
                turnos.acquire();
                coche.ponerMotor(coche);
                Thread.sleep(3000);
                turnos.release();
                this.setActivo(false);
            
        } catch (InterruptedException ex) {
            System.out.println("Error en "+ex);
        }
    }
    
    
    
}
