
package fabricacoches;

import java.util.concurrent.Semaphore;

/**
 *
 * @author anfur
 */
public class FabricaCoches {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //int contadorCoches=0;
        //while (true) {
            //System.out.println("Coche "+contadorCoches);
            Coche coche = new Coche(0,false,false,false);
            Semaphore turnos = new Semaphore(1);
            BrazoPuertasCapo brazoPuertas = new BrazoPuertasCapo(coche,turnos);
            BrazoPuertasCapo brazoCapo = new BrazoPuertasCapo(coche,turnos);
            BrazoMotor brazoMotor = new BrazoMotor(coche,turnos);
            BrazoPintura brazoPintura = new BrazoPintura(coche,turnos);
            
            brazoPuertas.start();
            brazoMotor.start();
            brazoPuertas.join();
            brazoCapo.start();
            brazoPintura.start();
            //contadorCoches++;
        //}
        
    }
    
}
