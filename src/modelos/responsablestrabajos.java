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
 * @author User
 */
public class responsablestrabajos {

    private IntegerProperty dniResp;
    private StringProperty nombresResp;
    private StringProperty apPaternoResp;
    private StringProperty apMaternoResp;
    private IntegerProperty telefonoPersonaResp;

    private funcion funcion;

    public responsablestrabajos(int dniResp, String nombresResp, String apPaternoResp,
            String apMaternoResp, int telefonoPersonaResp, funcion funcion) {
        this.dniResp = new SimpleIntegerProperty(dniResp);
        this.nombresResp = new SimpleStringProperty(nombresResp);
        this.apPaternoResp = new SimpleStringProperty(apPaternoResp);
        this.apMaternoResp = new SimpleStringProperty(apMaternoResp);
        this.telefonoPersonaResp = new SimpleIntegerProperty(telefonoPersonaResp);

        this.funcion = funcion;
    }

    //Metodos atributo: dni
    public int getDniResp() {
        return dniResp.get();
    }

    public void setDniResp(int dniResp) {
        this.dniResp = new SimpleIntegerProperty(dniResp);
    }

    public IntegerProperty DniRespProperty() {
        return dniResp;
    }
    //Metodos atributo: nombres

    public String getNombresResp() {
        return nombresResp.get();
    }

    public void setNombresResp(String nombresResp) {
        this.nombresResp = new SimpleStringProperty(nombresResp);
    }

    public StringProperty NombresRespProperty() {
        return nombresResp;
    }
    //Metodos atributo: apPaterno

    public String getApPaternoResp() {
        return apPaternoResp.get();
    }

    public void setApPaternoResp(String apPaternoResp) {
        this.apPaternoResp = new SimpleStringProperty(apPaternoResp);
    }

    public StringProperty ApPaternoRespProperty() {
        return apPaternoResp;
    }
    //Metodos atributo: apMaterno

    public String getApMaternoResp() {
        return apMaternoResp.get();
    }

    public void setApMaternoResp(String apMaternoResp) {
        this.apMaternoResp = new SimpleStringProperty(apMaternoResp);
    }

    public StringProperty ApMaternoRespProperty() {
        return apMaternoResp;
    }
    //Metodos atributo: telefonoPersona

    public int getTelefonoPersonaResp() {
        return telefonoPersonaResp.get();
    }

    public void setTelefonoPersonaResp(int telefonoPersonaResp) {
        this.telefonoPersonaResp= new SimpleIntegerProperty(telefonoPersonaResp);
    }

    public IntegerProperty TelefonoPersonaRespProperty() {
        return telefonoPersonaResp;
    }

    //Metodos atributo: Funcion
    public funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(funcion funcion) {
        this.funcion = funcion;
    }

    public static void llenarInformacion(Connection connection, ObservableList<responsablestrabajos> listaResp) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "SELECT \n"
                    + "rt.dniResp as dniResp,\n"
                    + "rt.nombresResp as nombresResp,\n"
                    + "rt.apPaternoResp as apPaternoResp, \n"
                    + "rt.apMaternoResp as apMaternoResp, \n"
                    + "rt.telefonoPersonaResp as telefonoPersonaResp,\n"
                    + "rt.idfuncion_Funcion3 as idFuncion,\n"
                    + "f.nombreFuncion as nombreFuncion\n"
                    + "FROM responsablestrabajos as rt\n"
                    + "INNER JOIN funcion as f ON rt.idfuncion_Funcion3 = f.idfuncion;"
            );
            while (resultado.next()) {
                listaResp.add(
                        new responsablestrabajos(
                                resultado.getInt("dniResp"),
                                resultado.getString("nombresResp"),
                                resultado.getString("apPaternoResp"),
                                resultado.getString("apMaternoResp"),
                                resultado.getInt("telefonoPersonaResp"),
                                new funcion(resultado.getInt("idfuncion"),
                                        resultado.getString("nombreFuncion"))
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return nombresResp.get() + " " + apPaternoResp.get();
    }
}
