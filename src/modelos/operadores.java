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
public class operadores {

    private IntegerProperty dniOp;
    private StringProperty nombresOp;
    private StringProperty apPaternoOp;
    private StringProperty apMaternoOp;
    private IntegerProperty telefonoPersonaOp;

    private funcion funcion;

    public operadores(int dniOp, String nombresOp, String apPaternoOp,
            String apMaternoOp, int telefonoPersonaOp, funcion funcion) {
        this.dniOp = new SimpleIntegerProperty(dniOp);
        this.nombresOp = new SimpleStringProperty(nombresOp);
        this.apPaternoOp = new SimpleStringProperty(apPaternoOp);
        this.apMaternoOp = new SimpleStringProperty(apMaternoOp);
        this.telefonoPersonaOp = new SimpleIntegerProperty(telefonoPersonaOp);

        this.funcion = funcion;
    }

    //Metodos atributo: dniOp
    public int getDniOp() {
        return dniOp.get();
    }

    public void setDniOp(int dniOp) {
        this.dniOp = new SimpleIntegerProperty(dniOp);
    }

    public IntegerProperty DniOpProperty() {
        return dniOp;
    }
    //Metodos atributo: nombresOp

    public String getNombresOp() {
        return nombresOp.get();
    }

    public void setNombresOp(String nombresOp) {
        this.nombresOp = new SimpleStringProperty(nombresOp);
    }

    public StringProperty NombresOpProperty() {
        return nombresOp;
    }
    //Metodos atributo: apPaternoOp

    public String getApPaternoOp() {
        return apPaternoOp.get();
    }

    public void setApPaterno(String apPaternoOp) {
        this.apPaternoOp = new SimpleStringProperty(apPaternoOp);
    }

    public StringProperty ApPaternoOpProperty() {
        return apPaternoOp;
    }
    //Metodos atributo: apMaternoOp

    public String getApMaternoOp() {
        return apMaternoOp.get();
    }

    public void setApMaternoOp(String apMaternoOp) {
        this.apMaternoOp = new SimpleStringProperty(apMaternoOp);
    }

    public StringProperty ApMaternoOpProperty() {
        return apMaternoOp;
    }
    //Metodos atributo: telefonoPersonaOp

    public int getTelefonoPersonaOp() {
        return telefonoPersonaOp.get();
    }

    public void setTelefonoPersonaOp(int telefonoPersonaOp) {
        this.telefonoPersonaOp = new SimpleIntegerProperty(telefonoPersonaOp);
    }

    public IntegerProperty TelefonoPersonaOpProperty() {
        return telefonoPersonaOp;
    }

    //Metodos atributo: Funcion
    public funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(funcion funcion) {
        this.funcion = funcion;
    }

    public static void llenarInformacion(Connection connection, ObservableList<operadores> listaOp) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    " SELECT\n"
                    + "op.dniOp as dniOp,\n "
                    + "op.nombresOp as nombresOp,\n"
                    + "op.apPaternoOp as apPaternoOp,\n "
                    + "op.apMaternoOp as apMaternoOp,\n"
                    + "op.telefonoPersonaOp as telefonoPersonaOp,\n"
                    + "op.idfuncion_Funcion4 as idFuncion,\n"
                    + "f.nombreFuncion as nombreFuncion\n"
                    + "FROM operadores AS op\n"
                    + "INNER JOIN funcion as f ON op.idfuncion_funcion4 = f.idfuncion;"
            );
            while (resultado.next()) {
                listaOp.add(
                        new operadores(
                                resultado.getInt("dniOp"),
                                resultado.getString("nombresOp"),
                                resultado.getString("apPaternoOp"),
                                resultado.getString("apMaternoOp"),
                                resultado.getInt("telefonoPersonaOp"),
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
        return nombresOp.get() + " " + apPaternoOp.get();
    }
}
