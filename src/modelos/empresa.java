package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class empresa {
    //private IntegerProperty ruc;
    //private BigInteger ruc;
    private StringProperty ruc;
    private StringProperty nombreEmpresa;
    private StringProperty direccion;
    private IntegerProperty telefonoEmpresa;

    public empresa(String ruc, String nombreEmpresa, String direccion, int telefonoEmpresa) {
       // this.ruc = new SimpleIntegerProperty(ruc);
        this.ruc = new SimpleStringProperty(ruc);
        this.nombreEmpresa = new SimpleStringProperty(nombreEmpresa);
        this.direccion = new SimpleStringProperty(direccion);
        this.telefonoEmpresa = new SimpleIntegerProperty(telefonoEmpresa);
    }

    //Metodos atributo: ruc
    public String getRuc() {
        return ruc.get();
    }

    public void setRuc(String ruc) {
        this.ruc = new SimpleStringProperty(ruc);
    }

    public StringProperty RucProperty() {
        return ruc;
    }
    //Metodos atributo: nombreEmpresa

    public String getNombreEmpresa() {
        return nombreEmpresa.get();
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = new SimpleStringProperty(nombreEmpresa);
    }

    public StringProperty NombreEmpresaProperty() {
        return nombreEmpresa;
    }
    //Metodos atributo: direccion

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion = new SimpleStringProperty(direccion);
    }

    public StringProperty DireccionProperty() {
        return direccion;
    }
    //Metodos atributo: numeroContacto

    public int getTelefonoEmpresa() {
        return telefonoEmpresa.get();
    }

    public void setTelefonoEmpresa(int telefonoEmpresa) {
        this.telefonoEmpresa = new SimpleIntegerProperty(telefonoEmpresa);
    }

    public IntegerProperty TelefonoEmpresaProperty() {
        return telefonoEmpresa;
    }
    //acceder al metodo sin crear instancias....

    public static void llenarInformacion(Connection connection, ObservableList<empresa> lista) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "SELECT ruc, "
                    + "nombreEmpresa,"
                    + " direccion,"
                    + " telefonoEmpresa"
                    + " FROM empresa"
            );
            while (resultado.next()) {
                lista.add(
                        new empresa(
                                resultado.getString("ruc"),
                                resultado.getString("nombreEmpresa"),
                                resultado.getString("direccion"),
                                resultado.getInt("telefonoEmpresa")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return nombreEmpresa.get();
    }

}
