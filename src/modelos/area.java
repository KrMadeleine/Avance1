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
public class area {

    private IntegerProperty idArea;
    private StringProperty nombreArea;

    public area(int idArea, String nombreArea) {
        this.idArea = new SimpleIntegerProperty(idArea);
        this.nombreArea = new SimpleStringProperty(nombreArea);
    }

    //Metodos atributo: idArea
    public int getIdArea() {
        return idArea.get();
    }

    public void setIdArea(int idArea) {
        this.idArea = new SimpleIntegerProperty(idArea);
    }

    public IntegerProperty IdAreaProperty() {
        return idArea;
    }
    //Metodos atributo: nombreArea

    public String getNombreArea() {
        return nombreArea.get();
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = new SimpleStringProperty(nombreArea);
    }

    public StringProperty NombreAreaProperty() {
        return nombreArea;
    }
    //creacion de metodos

    public static void llenarInformacion(Connection connection, ObservableList<area> lista) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "SELECT idArea, nombreArea FROM area;"
                   // "SELECT idArea, nombreArea FROM area WHERE idArea='4';"
            );
            while (resultado.next()) {
                lista.add(new area(
                                resultado.getInt("idArea"),
                                resultado.getString("nombreArea")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
       
    @Override
    public String toString() {
        return nombreArea.get();
    }
}
