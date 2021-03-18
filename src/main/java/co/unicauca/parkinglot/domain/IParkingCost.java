package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * Interfaz para calcular el costo del parqueadero de cualquier tipo de
 * vehiculo: carro, moto, camión
 * @author ADRIAN CAMILO TORRES
 */
public interface IParkingCost 
{

    /**
     * Metodo que calcula el costo del parqueadero de un vehiculo.
     * @param veh Vehiculo
     * @param input Fecha de ingreso
     * @param output Fecha de salida
     * @return Costo del parqueadero
     */
    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}