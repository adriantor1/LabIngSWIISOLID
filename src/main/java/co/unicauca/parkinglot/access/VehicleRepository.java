package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implemeta IVehicleRepository y tiene como funcion implementar el modelo de conexion a la base de datos
 * @author ADRIAN CAMILO TORRES
 * @author DANIEL NAVIA
 */
public class VehicleRepository implements IVehicleRepository {
    /**
    * Atributo que guarda la conexion con la base de datos
    */
    private Connection conn;

    /**
     * Constructor parametrizado
     * @param conn Conexion con la base de datos
     */
    public VehicleRepository(Connection conn) {
        this.conn = conn;
    }
    
    /**
     * Constructor por defecto.
     */
    public VehicleRepository(){
        initDatabase();
    }
    
    @Override
    public boolean save(Vehicle newVehicle){
        try {
            //Validar Vehiculo
            if (newVehicle == null || newVehicle.getPlate().isBlank()|| newVehicle.getType() == null) {
                return false;
            }            
            if (conn.isClosed()) {
                this.connect();
            }
            String sql = "INSERT INTO Vehicle ( vehPlate, vehType ) "
                    + "VALUES ( ?, ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);           
            pstmt.setString(1, newVehicle.getPlate());
            pstmt.setString(2, newVehicle.getType().name());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } 
        catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public List<Vehicle> list(){
        List<Vehicle> products = new ArrayList<>();
        try {

            String sql = "SELECT vehPlate, vehType FROM Vehicle";
            if (conn.isClosed()) {
                this.connect();
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newProduct = new Vehicle();
                newProduct.setPlate(rs.getString("vehPlate"));
                TypeEnum Tipo = TypeEnum.valueOf(rs.getString("vehType"));
                newProduct.setType(Tipo);
                products.add(newProduct);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    /**
     * Inicializa la base de datos
     */
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	vehPlate text NOT NULL,\n"
                + "	vehType text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Realiza la conexion con la base de datos
     */
    public void connect() {
        //SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Realiza la desconexion con la base de datos
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
