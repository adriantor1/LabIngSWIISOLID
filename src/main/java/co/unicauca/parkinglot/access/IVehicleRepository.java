package co.unicauca.parkinglot.access;
import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 * Interfaz que declara los metodos a utilizar.
 * @author ADRIAN CAMILO TORRES
 * @author DANIEL NAVIA
 */
public interface IVehicleRepository {

    /**
     * Guarda un vehiculo en la base de datos
     * @param newVehicle Nuevo Vehiculo
     * @return true si se guardó correctamente o false si ocurrió una excepción.
     */
    public boolean save(Vehicle newVehicle);

    /**
     * Obtiene una lista de los vehiculos de la base de datos
     * @return Lista de vehiculos
     */
    public List<Vehicle> list();
}
