/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase que implementa metodos de utilidad para el calculo de el costo
 * del parqueadero de los vehiculos
 * @author ADRIAN CAMILO TORRES GOMEZ
 */
public class Utilities {

    /**
     * Constructor por defecto
     */
    public Utilities(){
        
    }
    
    /**
     * Calcula los minutos que hay entre los dos atributos de minutos de fechas
     * @param input Fecha de entrada
     * @param output Fecha de salida
     * @return Minutos entre los atributos de minutos de las fechas
     */
    public int minutosEntre2Fechas(LocalDateTime input,LocalDateTime output){
        long minutes = output.getMinute()-input.getMinute();
        return (int) minutes;
    }
    
    /**
     * Calcula las horas que hay entre dos fechas
     * @param input Fecha de entrada
     * @param output Fecha de salida
     * @return Horas entre las dos fechas
     */
    public int horasEntre2Fechas(LocalDateTime input,LocalDateTime output){
        long hours = ChronoUnit.HOURS.between(input, output);
        return (int) hours;
    }

    /**
     * Redondea un valor por encima de sus centenas.
     * @param cost Valor a redondear
     * @return Valor redondeado
     */
    public long redondear(long cost) {
        int mod = (int)cost%100;
        if (mod>0) {
            double dcost=(double)cost;
            dcost= dcost/100;
            dcost = Math.ceil(dcost);
            cost = (long)dcost*100;
        }
        return cost;
    }
}
