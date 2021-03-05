package co.unicauca.parkinglot.domain;
/**
 * Vehiculo del parqueadero: Carro, Moto, Camion
 * @author ADRIAN CAMILO TORRES GOMEZ
 * @author DANIEL NAVIA
 */
public class Vehicle 
{
    /**
     * Atributo que guarda la placa del vehiculo
     */
    private String plate;
    
    /**
     * Atributo que guarda el tipo de vehiculo
     */
    private TypeEnum type;
    
    
    /**
     * Constructor parametrizado
     * @param Plate Placa del vehiculo
     * @param tipo Tipo del vehiculo
     */
    public Vehicle(String Plate, TypeEnum tipo)
    {
        this.plate = Plate;
        this.type = tipo;
    }

    /**
     * Constructor por defecto
     */
    public Vehicle() 
    {
    }

    /**
     * Metodo GET que obtiene la placa
     * @return Placa del vehiculo
     */
    public String getPlate() 
    {
        return plate;
    }

    /**
     * Metodo SET que modifica el valor de la placa
     * @param Placa La placa del vehiculo
     */
    public void setPlate(String Placa) 
    {
        this.plate = Placa;
    }

    /**
     * Metodo GET que obtiene el Tipo
     * @return Tipo de vehiculo
     */
    public TypeEnum getType() 
    {
        return type;
    }

    /**
     * Metodo SET que modifica el valor del tipo de vehiculo
     * @param Tipo Tipo de vehiculo
     */
    public void setType(TypeEnum Tipo) 
    {
        this.type = Tipo;
    }
    /**
     * Metodo que obtiene en un String la informacion del vehiculo
     * @return Cadena de la informacion del vehiculo
     */
    @Override
    public String toString(){
        return "-Placa: "+plate+" -Tipo: "+type.toString();
    }
}
    
    