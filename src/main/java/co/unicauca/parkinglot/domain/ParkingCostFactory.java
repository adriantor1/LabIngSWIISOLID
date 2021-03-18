package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 * Selecciona la instancia de un vehiculo para calcular su costo segun el tipo.
 * @author ADRIAN CAMILO TORRES
 */
public class ParkingCostFactory {
    /**
     * Atributo que guarda el tipo de vehiculo
     */
    private Map<TypeEnum,IParkingCost> dictionary;
    /**
     * atributo que guarda una instancia de ParkingCostFactory
     */    
    private static ParkingCostFactory instance;
    /**
     * Constructor por defecto
     */
    private ParkingCostFactory(){
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }
    
    /**
     * Obtiene la instancia de ParkingCostFactory
     * @return ParkingCostFactory
     */
    public static ParkingCostFactory getInstance(){
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    /**
     * Obtiene la instancia de una clase que implementa IParkingCost
     * segun el tipo de vehiculo
     * @param veh Tipo de vehiculo
     * @return Objeto de la clase que implementa IParkingCost
     */
    public IParkingCost getParkingCost(TypeEnum veh){
        IParkingCost result = null;
        if (dictionary.containsKey(veh)) {
            result = dictionary.get(veh);
        }
        return result;
    }
}
