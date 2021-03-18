package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 * Implementa IParkingCost y el costo del parqueadero para motos
 * @author ADRIAN CAMILO TORRES
 */
public class MotoParkingCost implements IParkingCost {
    /**
     * Constructor por defecto
     */
    public MotoParkingCost(){
        
    }
    /**
     * Calcula el costo del parqueadero para una moto.
     * @param veh Vehiculo
     * @param input Fecha de ingreso
     * @param output Fecha de salida
     * @return Costo del parqueadero
     */
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        Utilities ut = new Utilities();
        int hours = ut.horasEntre2Fechas(input, output);
        int minutes = ut.minutosEntre2Fechas(input,output);
        long cost=1000;
        if (hours<0||(hours<=0&&minutes<0)||(hours<=0&&minutes<=0)) {
            return -1;
        }
        if (hours == 0 &&minutes>0) {   
            return cost;
        }
        if (minutes>0){
            hours-=1;
            cost+=500*hours;
            cost+=(minutes*500)/60;
        }
        cost =ut.redondear(cost);
        return cost;
    }
}
