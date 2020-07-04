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

//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author karen
 */
public class kks {

    private StringProperty id_kks;
    private StringProperty nombreEquipo;
    private StringProperty ubicacionEquipo;


    public kks(String id_kks, String nombreEquipo, String ubicacionEquipo) {
        
        this.id_kks = new SimpleStringProperty(id_kks);
        this.nombreEquipo = new SimpleStringProperty(nombreEquipo);
        this.ubicacionEquipo = new SimpleStringProperty(ubicacionEquipo);
        
    }
    
    //Metodos atributo: id_kks

    public String getId_kks() {
        return id_kks.get();
    }

    public void setId_kks(String id_kks) {
        this.id_kks = new SimpleStringProperty(id_kks);
    }

    public StringProperty Id_kks() {
        return id_kks;
    }
    //Metodos atributo: nombreEquipo

    public String getNombreEquipo() {
        return nombreEquipo.get();
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = new SimpleStringProperty(nombreEquipo);
    }

    public StringProperty NombreEquipo(){
        return nombreEquipo;
    }
       //Metodos atributo: nombreEquipo

    public String getUbicacionEquipo() {
        return ubicacionEquipo.get();
    }

    public void setUbicacionEquipo(String ubicacionEquipo) {
        this.ubicacionEquipo = new SimpleStringProperty(ubicacionEquipo);
    }

    public StringProperty UbicacionEquipo(){
        return ubicacionEquipo;
    }

    
    public static void llenarInformacion(Connection connection, ObservableList<kks> lista) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "select id_kks,"
                            + "nombreEquipo,"
                            + "ubicacionEquipo "
                            + "FROM kks"
            );
            while (resultado.next()) {
                lista.add(new kks(
                                resultado.getString("id_kks"),
                                resultado.getString("nombreEquipo"),
                                resultado.getString("ubicacionEquipo")
                              )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString(){
    return nombreEquipo.get();  
    }
    /*
    public Integer toInt(){
      return id_kks.get();  
    }*/
    /*public String toString() {
        return id_unidad_unidad.get() + "." + id_sistema_sistema.get() + "." + id_subsistema_subsistema.get() + "." + id_equipo_equipo.get();
       
    }*/

}
