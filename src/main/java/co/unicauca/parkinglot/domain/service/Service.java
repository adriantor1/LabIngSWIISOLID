package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controla que los vehiculos tengan informacion correcta y obtienen el costo
 * segun su tipo
 * @author ADRIAN CAMILO TORRES GOMEZ
 */
public class Service {
    
    /**
     * Atributo que guarda una instancia de la clase IVehicleRepository
     */
    private IVehicleRepository repository;
    
    /**
     * Constructor parametrizado
     * @param repository Objeto de la clase IVehicleRepository
     */
    public Service(IVehicleRepository repository){
        this.repository = repository;
    }
    
    /**
     * Verifica las fechas de entrada y salida, que el vehiculo exista y calcula el costo del parqueadero
     * @param veh Vehiculo
     * @param input Fecha de entrada
     * @param output Fecha de salida
     * @return Costo del parqueadero
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        Utilities ut = new Utilities();
        int hours = ut.horasEntre2Fechas(input, output);
        if (veh == null || hours < 0 ) {
            return -1;
        }
        IParkingCost parking = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
        long result = parking.calculateCost(veh,input,output);
        return result;
    }
    
    /**
     * Verifica la informacion del vehiculo y lo guarda mediante el atributo repository
     * @param veh Vehiculo
     * @return True si se pudo guardar el vehiculo y false si ocurrió una excepción
     */
    public boolean saveVehicle(Vehicle veh){
        //Validar Vehiculo
        if (veh == null || veh.getPlate().isBlank()|| veh.getType() == null) {
            return false;
        }
        repository.save(veh);
        return true;
    }
    
    /**
     * Obtiene mediante el atributo repository una lista de los vehiculos
     * @return Lista de vehiculos
     */
    public List<Vehicle> listVehicles(){
        List<Vehicle> products = new ArrayList<>();
        products = repository.list();
        return products;
    }
}
