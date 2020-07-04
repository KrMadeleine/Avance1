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
public class jefaturasupervision {

    private IntegerProperty dniSup;
    private StringProperty nombresSup;
    private StringProperty apPaternoSup;
    private StringProperty apMaternoSup;
    private IntegerProperty telefonoPersonaSup;

    private funcion funcion;

    public jefaturasupervision(int dniSup, String nombresSup, String apPaternoSup, String apMaternoSup, int telefonoPersonaSup, funcion funcion) {

        this.dniSup = new SimpleIntegerProperty(dniSup);
        this.nombresSup = new SimpleStringProperty(nombresSup);
        this.apPaternoSup = new SimpleStringProperty(apPaternoSup);
        this.apMaternoSup = new SimpleStringProperty(apMaternoSup);
        this.telefonoPersonaSup = new SimpleIntegerProperty(telefonoPersonaSup);

        this.funcion = funcion;
    }

    //Metodos atributo: dni
    public int getDniSup() {
        return dniSup.get();
    }

    public void setDniSup(int dniSup) {
        this.dniSup = new SimpleIntegerProperty(dniSup);
    }

    public IntegerProperty DniSupProperty() {
        return dniSup;
    }
    //Metodos atributo: nombres

    public String getNombresSup() {
        return nombresSup.get();
    }

    public void setNombresSup(String nombresSup) {
        this.nombresSup = new SimpleStringProperty(nombresSup);
    }

    public StringProperty NombresSupProperty() {
        return nombresSup;
    }
    //Metodos atributo: apPaterno

    public String getApPaternoSup() {
        return apPaternoSup.get();
    }

    public void setApPaternoSup(String apPaternoSup) {
        this.apPaternoSup = new SimpleStringProperty(apPaternoSup);
    }

    public StringProperty ApPaternoSupProperty() {
        return apPaternoSup;
    }
    //Metodos atributo: apMaterno

    public String getApMaternoSup() {
        return apMaternoSup.get();
    }

    public void setApMaterno(String apMaternoSup) {
        this.apMaternoSup = new SimpleStringProperty(apMaternoSup);
    }

    public StringProperty ApMaternoSupProperty() {
        return apMaternoSup;
    }
    //Metodos atributo: telefonoPersona

    public int getTelefonoSupPersona() {
        return telefonoPersonaSup.get();
    }

    public void setTelefonoPersonaSup(int telefonoPersonaSup) {
        this.telefonoPersonaSup = new SimpleIntegerProperty(telefonoPersonaSup);
    }

    public IntegerProperty TelefonoPersonaSupProperty() {
        return telefonoPersonaSup;
    }

    //Metodos atributo: Funcion
    public funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(funcion funcion) {
        this.funcion = funcion;
    }

    public static void llenarInformacion(Connection connection, ObservableList<jefaturasupervision> listaSup) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "SELECT \n"
                    + "j.dniSup as dniSup,\n"
                    + "j.nombresSup as nombresSup,\n"
                    + "j.apPaternoSup as apPaternoSup, \n"
                    + "j.apMaternoSup as apMaternoSup, \n"
                    + "j.telefonoPersonaSup as telefonoPersonaSup,\n"
                    + "j.idfuncion_Funcion2 as idFuncion,\n"
                    + "f.nombreFuncion as nombreFuncion\n"
                    + "FROM jefaturasupervision as j\n"
                    + "INNER JOIN funcion as f ON j.idfuncion_Funcion2 = f.idfuncion;"
            );
            while (resultado.next()) {
                listaSup.add(
                        new jefaturasupervision(
                                resultado.getInt("dniSup"),
                                resultado.getString("nombresSup"),
                                resultado.getString("apPaternoSup"),
                                resultado.getString("apMaternoSup"),
                                resultado.getInt("telefonoPersonaSup"),
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
        return nombresSup.get() + " " + apPaternoSup.get();
    }
}
