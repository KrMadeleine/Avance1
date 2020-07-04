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
public class cclima {

    private IntegerProperty dniCCLim;
    private StringProperty nombresCCLim;
    private StringProperty apPaternoCCLim;
    private StringProperty apMaternoCCLim;
    private IntegerProperty telefonoPersonaCCLim;

    private funcion funcion;

    public cclima(int dniCCLim, String nombresCCLim, String apPaternoCCLim,
            String apMaternoCCLim, int telefonoPersonaCCLim, funcion funcion) {
        this.dniCCLim = new SimpleIntegerProperty(dniCCLim);
        this.nombresCCLim = new SimpleStringProperty(nombresCCLim);
        this.apPaternoCCLim = new SimpleStringProperty(apPaternoCCLim);
        this.apMaternoCCLim = new SimpleStringProperty(apMaternoCCLim);
        this.telefonoPersonaCCLim = new SimpleIntegerProperty(telefonoPersonaCCLim);

        this.funcion = funcion;
    }

    //Metodos atributo: dniCCLima
    public int getDniCCLim() {
        return dniCCLim.get();
    }

    public void setDniCCLim(int dniCCLim) {
        this.dniCCLim = new SimpleIntegerProperty(dniCCLim);
    }

    public IntegerProperty DniCCLimProperty() {
        return dniCCLim;
    }
    //Metodos atributo: nombresCCLima

    public String getNombresCCLim() {
        return nombresCCLim.get();
    }

    public void setNombresCCLim(String nombresCCLim) {
        this.nombresCCLim = new SimpleStringProperty(nombresCCLim);
    }

    public StringProperty NombresCCLimProperty() {
        return nombresCCLim;
    }
    //Metodos atributo: apPaternoCCLim

    public String getApPaternoCCLim() {
        return apPaternoCCLim.get();
    }

    public void setApPaternoCCLim(String apPaternoCCLim) {
        this.apPaternoCCLim = new SimpleStringProperty(apPaternoCCLim);
    }

    public StringProperty ApPaternoCCLimProperty() {
        return apPaternoCCLim;
    }
    //Metodos atributo: apMaternoCCLim

    public String getApMaternoCCLim() {
        return apMaternoCCLim.get();
    }

    public void setApMaternoCCLim(String apMaternoCCLim) {
        this.apMaternoCCLim = new SimpleStringProperty(apMaternoCCLim);
    }

    public StringProperty ApMaternoCCLimProperty() {
        return apMaternoCCLim;
    }
    //Metodos atributo: telefonoPersonaCCLima

    public int getTelefonoPersonaCCLim() {
        return telefonoPersonaCCLim.get();
    }

    public void setTelefonoPersonaCCLim(int telefonoPersonaCCLim) {
        this.telefonoPersonaCCLim = new SimpleIntegerProperty(telefonoPersonaCCLim);
    }

    public IntegerProperty TelefonoPersonaCCLimProperty() {
        return telefonoPersonaCCLim;
    }

    //Metodos atributo: Funcion
    public funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(funcion funcion) {
        this.funcion = funcion;
    }

    public static void llenarInformacion(Connection connection, ObservableList<cclima> listaCCLim) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    " SELECT \n"
                    + "cc.dniCCLim as dniCCLim,\n"
                    + "cc.nombresCCLim as nombresCCLim,\n "
                    + "cc.apPaternoCCLim as apPaternoCCLim,\n"
                    + "cc.apMaternoCCLim as apMaternoCCLim,\n "
                    + "cc.telefonoPersonaCCLim as telefonoPersonaCCLim,\n "
                    + "cc.idfuncion_Funcion5 as idFuncion,\n"
                    + "f.nombreFuncion as nombreFuncion \n"
                    + "FROM cclima AS cc \n"
                    + "INNER JOIN funcion as f ON cc.idfuncion_Funcion5 = f.idfuncion;"
            );
            while (resultado.next()) {
                listaCCLim.add(
                        new cclima(
                                resultado.getInt("dniCCLim"),
                                resultado.getString("nombresCCLim"),
                                resultado.getString("apPaternoCCLim"),
                                resultado.getString("apMaternoCCLim"),
                                resultado.getInt("telefonoPersonaCCLim"),
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
        return nombresCCLim.get() + " " + apPaternoCCLim.get();
    }
}
