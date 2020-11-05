
package fabricacoches;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anfur
 */
public class BrazoPuertasCapo extends Thread{
    private static  Coche coche;
    private boolean activo = true;
    Semaphore turnos = new Semaphore(1);

    BrazoPuertasCapo(Coche coche, Semaphore turnos) {
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
        if (coche.getNumeroPuertas()<5) {
            try {
            turnos.acquire();
            coche.ponerPuerta(coche);
            turnos.release();
            } catch (InterruptedException ex) {
            System.out.println("Error en "+ex);
            }
        System.out.println("El brazo segundo se quedará inactivo hasta que el motor se ponga");
        this.setActivo(false);
        }else{
            coche.ponerCapo(coche);
        }
    }
    
    
    
}
