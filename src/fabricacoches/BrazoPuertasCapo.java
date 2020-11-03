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
public class BrazoPuertasCapo extends Thread{
    
    
    
    public synchronized void ponerPuerta(Coche coche){
        if (coche.getNumeroPuertas()<5) {
            coche.setNumeroPuertas(coche.getNumeroPuertas()+1);
        }
        else{
            System.out.println("El brazo se quedará inactivo");
            //this.isActivo=false;
        }
    }
}
