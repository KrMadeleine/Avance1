/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author karen
 */
public class rol {
    private IntegerProperty idRol;
    private StringProperty nombreRol;

    public rol(int idRol, String nombreRol) {
        this.idRol = new SimpleIntegerProperty(idRol);
        this.nombreRol = new SimpleStringProperty(nombreRol);
    }

    //Metodos atributo: idRol
    public int getIdRol() {
        return idRol.get();
    }

    public void setIdRol(int idRol) {
        this.idRol = new SimpleIntegerProperty(idRol);
    }

    public IntegerProperty IdRolProperty() {
        return idRol;
    }
    //Metodos atributo: nombreArea

    public String getNombreRol() {
        return nombreRol.get();
    }

    public void setNombreRol (String nombreRol){
        this.nombreRol = new SimpleStringProperty(nombreRol);
    }

    public StringProperty NombreRolProperty() {
        return nombreRol;
    }
    //creacion de metodos

    public static void llenarInformacion(Connection connection, ObservableList<rol> lista) {
        try { 
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "SELECT idRol, nombreRol FROM rol;"
                   // "SELECT idArea, nombreArea FROM area WHERE idRol='4';"
            );
            while (resultado.next()) {
                lista.add(new rol(
                                resultado.getInt("idRol"),
                                resultado.getString("nombreRol")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
       
    @Override
    public String toString() {
        return nombreRol.get();
    }
}
