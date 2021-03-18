package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 * Implementa IParkingCost y el costo del parqueadero para carros
 * @author ADRIAN CAMILO TORRES
 */
public class CarParkingCost implements IParkingCost 
{

    /**
     * Constructor por defecto
     */
    public CarParkingCost(){
        
    }

    /**
     * Calcula el costo del parqueadero para un carro.
     * @param veh Vehiculo
     * @param input Fecha de ingreso
     * @param output Fecha de salida
     * @return Costo del parqueadero
     */
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        Utilities ut = new Utilities();
        int hours = ut.horasEntre2Fechas(input, output);
        int minutes = ut.minutosEntre2Fechas(input,output);
        long cost=2000;
        if (hours<0||(hours<=0&&minutes<0)||(hours<=0&&minutes<=0)) {
            return -1;
        }
        if (hours == 0 &&minutes>0) {   
            return cost;
        }
        if (minutes>0){
            hours-=1;
            cost+=1000*hours;
            cost+=(minutes*1000)/60;
        }
        cost =ut.redondear(cost);
        return cost;
    }
}