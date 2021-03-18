package co.unicauca.parkinglot.access;

/**
 * Fabrica de repositorios donde se van a guardar los vehiculos.
 * @author ADRIAN CAMILO TORRES
 */
public class RepositoryFactory {
    
    private static RepositoryFactory instance;
    /**
    * Contructor por defecto
    */
    private RepositoryFactory(){
        
    }
    
    /**
     * Obtiene una instancia del repositorio actual.
     * @return Instancia del repositorio actual.
     */
    public static RepositoryFactory getInstance(){
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    /**
     * Obtiene un objeto de la clase que imprementa IVehicleRepository.
     * @param type Tipo de vehiculo
     * @return Objeto que implementa IVehicleRepository
     */
    public IVehicleRepository getRepository(String type){
        IVehicleRepository result = null;
        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }
        return result;
    }
}
