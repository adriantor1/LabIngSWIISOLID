package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 * Implementa IParkingCost y el costo del parqueadero para camiones
 * @author ADRIAN CAMILO TORRES
 */
public class TruckParkingCost implements IParkingCost{
    /**
     * Constructor por defecto
     */
    public TruckParkingCost(){
        
    }
    /**
     * Calcula el costo del parqueadero para un camion.
     * @param veh Vehiculo
     * @param input Fecha de ingreso
     * @param output Fecha de salida
     * @return Costo del parqueadero
     */
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        Utilities ut = new Utilities();
        int hours = ut.horasEntre2Fechas(input, output);
        int minutes = ut.minutosEntre2Fechas(input,output);
        long cost=10000;
        if (hours<0||(hours<=0&&minutes<0)||(hours<=0&&minutes<=0)) {
            return -1;
        }
        if (hours <=12&&minutes!=0) {   
            return cost;
        }
        if (hours>12 && hours <=24) {
            return cost=15000;
        }
        double days = hours/24;
        days= Math.floor(days);
        hours = (hours-(int)(days*24));
        if (days>0){
            cost=0;
            cost+=15000*days;
            cost+=(hours*15000)/24;
        }
        cost =ut.redondear(cost);
        return cost;
    }
}
