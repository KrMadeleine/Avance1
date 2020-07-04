
/*
1 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javafx.collections.ObservableList;

/**
 *
 * @author practicas
 */
public class datospermiso {

    private StringProperty numeroOT;
    private StringProperty prog;
    private Date fechaSolicitud;
    private Time hora;
    private StringProperty lugar;
    private StringProperty descripcion;
    private StringProperty unidad;

    private kks kks;
    private empresa empresa;
    private area area;

    private StringProperty numeroPermiso;
    private jefaturasupervision jefaturasupervision;
    private responsablestrabajos responsablestrabajos;
    private operadores operadores;
    private cclima cclima;

    //private Personas personas;
    //Constructor Datos permiso
    public datospermiso(String numeroOT,
            String prog,
            Date fechaSolicitud,
            Time hora,
            String lugar,
            String descripcion,
            String unidad,
            kks kks,
            empresa empresa,
            area area,
            String numeroPermiso,
            jefaturasupervision jefaturasupervision,
            responsablestrabajos responsablestrabajos,
            operadores operadores,
            cclima cclima) {

        this.numeroOT = new SimpleStringProperty(numeroOT);
        this.prog = new SimpleStringProperty(prog);
        this.fechaSolicitud = fechaSolicitud;
        this.hora = hora;
        this.lugar = new SimpleStringProperty(lugar);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.unidad = new SimpleStringProperty(unidad);
        this.kks = kks;
        this.empresa = empresa;
        this.area = area;

        this.numeroPermiso = new SimpleStringProperty(numeroPermiso);
        this.jefaturasupervision = jefaturasupervision;
        this.responsablestrabajos = responsablestrabajos;
        this.operadores = operadores;
        this.cclima = cclima;

        //  System.out.println(hora);
        //  System.out.println(fechaSolicitud);
    }

    //Metodos atributo: numeroOT
    public String getNumeroOT() {
        return numeroOT.get();
    }

    public void setNumeroOT(String numeroOT) {
        this.numeroOT = new SimpleStringProperty(numeroOT);
    }

    public StringProperty NumeroOTProperty() {
        return numeroOT;
    }

    //Metodos atributo: prog
    public String getProg() {
        return prog.get();
    }

    public void setProg(String prog) {
        this.prog = new SimpleStringProperty(prog);
    }

    public StringProperty ProgProperty() {
        return prog;
    }

    //Metodos atributo: fechaSolicitud
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    //Metodos atributo: hora
    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    //Metodos atributo: lugar
    public String getLugar() {
        return lugar.get();
    }

    public void setLugar(String lugar) {
        this.lugar = new SimpleStringProperty(lugar);
    }

    public StringProperty LugarProperty() {
        return lugar;
    }

    //Metodos atributo: descripcion
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public StringProperty DescripcionProperty() {
        return descripcion;
    }

    //Metodos atributo: unidad
    public String getUnidad() {
        return unidad.get();
    }

    public void setUnidad(String unidad) {
        this.unidad = new SimpleStringProperty(unidad);
    }

    public StringProperty UnidadProperty() {
        return unidad;
    }

    // Metodos atributo: kks
    public kks getKks() {
        return kks;
    }

    public void setKks(kks kks) {
        this.kks = kks;
    }

    // Metodos atributo: empresa
    public empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(empresa empresa) {
        this.empresa = empresa;
    }

    // Metodos atributo: area
    public area getArea() {
        return area;
    }

    public void setArea(area area) {
        this.area = area;
    }

    //Metodos atributo: numeroPermiso
    public String getNumeroPermiso() {
        return numeroPermiso.get();
    }

    public void setNumeroPermiso(String numeroPermiso) {
        this.numeroPermiso = new SimpleStringProperty(numeroPermiso);
    }

    public StringProperty NumeroPermiso() {
        return numeroPermiso;
    }

    // Metodos atributo: jefaturasupervision
    public jefaturasupervision getJefaturasupervision() {
        return jefaturasupervision;
    }

    public void setJefaturasupervicion(jefaturasupervision jefaturasupervision) {
        this.jefaturasupervision = jefaturasupervision;
    }

    // Metodos atributo: responsablestrabajos
    public responsablestrabajos getResponsablestrabajos() {
        return responsablestrabajos;
    }

    public void setResponsablestrabajos(responsablestrabajos responsablestrabajos) {
        this.responsablestrabajos = responsablestrabajos;
    }

    // Metodos atributo: operadores
    public operadores getOperadores() {
        return operadores;
    }

    public void setResponsablestrabajos(operadores operadores) {
        this.operadores = operadores;
    }

    // Metodos atributo: cclima
    public cclima getCclima() {
        return cclima;
    }

    public void setCclima(cclima cclima) {
        this.cclima = cclima;
    }

    //creacion de método "guardarRegistro" al que se accede desde el controlador
    public int guardarRegistro(Connection connection) {
        try {
            //evitar inyeccion sql - preparacion de SQL
            PreparedStatement instruccion
                    = connection.prepareStatement("INSERT INTO `bitacora`.`datospermiso` (`numeroOT`, `prog`, `fechaSolicitud`, `hora`, `lugar`, `idArea_area`, `descripcion`, `id_kks_kks`, `rucEmpresa_empresa`,`unidad`,`numeroPermiso`, `dniSup`, `dniResp`, `dniOp`, `dniCCLim`) \n"
                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

            instruccion.setString(1, numeroOT.get());
            instruccion.setString(2, prog.get());
            instruccion.setDate(3, fechaSolicitud);
            instruccion.setTime(4, hora);
            instruccion.setString(5, lugar.get());
            instruccion.setInt(6, area.getIdArea());
            instruccion.setString(7, descripcion.get());
            instruccion.setString(8, kks.getId_kks());
            instruccion.setString(9, empresa.getRuc());
            instruccion.setString(10, unidad.get());
            instruccion.setString(11, numeroPermiso.get());
            instruccion.setInt(12, jefaturasupervision.getDniSup());
            instruccion.setInt(13, responsablestrabajos.getDniResp());
            instruccion.setInt(14, operadores.getDniOp());
            instruccion.setInt(15, cclima.getDniCCLim());
            //instruccion.setInt(16, Involucrados.getId());

            //intruccion.executeUpdate();
            //ejecución de instrucciones - public void a int
            return instruccion.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
            // Logger.getLogger(datospermiso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

// 
    public static void llenarInformacionPermiso(Connection connection, ObservableList<datospermiso> lista) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //interfaces Statement y Result set-no pueden ser instanciadas
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery(
                    "SELECT\n"
                    + "       dp.numeroOT AS numeroOT, dp.prog AS prog, dp.fechaSolicitud AS fechaSolicitud, dp.hora AS hora, dp.lugar AS lugar,\n"
                    + "                        e.ruc AS ruc, e.nombreEmpresa AS nombreEmpresa, e.direccion AS direccion, e.telefonoEmpresa AS telefonoEmpresa,\n"
                    + "                        a.idArea AS idArea, a.nombreArea AS nombreArea, \n"
                    + "                        k.id_kks AS id_kks, k.nombreEquipo AS nombreEquipo, k.ubicacionEquipo AS ubicacionEquipo,\n"
                    + "                        dp.descripcion AS descripcion, dp.unidad AS unidad, dp.numeroPermiso as numeroPermiso,\n"
                    + "                        j.dniSup as dniSup, j.nombresSup as nombresSup, j.apPaternoSup as apPaternoSup, j.apMaternoSup as apMaternoSup, j.telefonoPersonaSup as telefonoPersonaSup, j.idfuncion_Funcion2 as idFuncion,\n"
                    + "                        f2.nombreFuncion as nombreFuncion,\n"
                    + "                        rt.dniResp as dniResp, rt.nombresResp as nombresResp, rt.apPaternoResp as apPaternoResp, rt.apMaternoResp as apMaternoResp, rt.telefonoPersonaResp as telefonoPersonaResp, rt.idfuncion_Funcion3 as idFuncion,\n"
                    + "                        f3.nombreFuncion as nombreFuncion,\n"
                    + "                        op.dniOp as dniOp, op.nombresOp as nombresOp, op.apPaternoOp as apPaternoOp, op.apMaternoOp as apMaternoOp, op.telefonoPersonaOp as telefonoPersonaOp, op.idfuncion_Funcion4 as idFuncion,\n"
                    + "                    	f4.nombreFuncion as nombreFuncion,\n"
                    + "					    cc.dniCCLim as dniCCLim, cc.nombresCCLim as nombresCCLim, cc.apPaternoCCLim as apPaternoCCLim, cc.apMaternoCCLim as apMaternoCCLim, cc.telefonoPersonaCCLim as telefonoPersonaCCLim, cc.idfuncion_Funcion5 as idFuncion,\n"
                    + "                    	f5.nombreFuncion as nombreFuncion\n"
                    + "                        FROM datospermiso AS dp\n"
                    + "                        INNER JOIN area AS a ON dp.idArea_area=a.idArea\n"
                    + "                        INNER JOIN kks AS k ON dp.id_kks_kks= k.id_kks\n"
                    + "						INNER JOIN jefaturasupervision as j ON dp.dniSup = j.dniSup\n"
                    + "                        INNER JOIN responsablestrabajos as rt ON dp.dniResp = rt.dniResp\n"
                    + "                        INNER JOIN operadores as op ON dp.dniOp = op.dniOp\n"
                    + "                        INNER JOIN cclima  as cc ON dp.dniCCLim = cc.dniCCLim \n"
                    + "                        INNER JOIN funcion as f2 ON j.idfuncion_Funcion2 = f2.idfuncion\n"
                    + "                        INNER JOIN funcion as f3 ON rt.idfuncion_Funcion3 = f3.idfuncion\n"
                    + "                    	INNER JOIN funcion as f4 ON op.idfuncion_Funcion4 = f4.idfuncion\n"
                    + "                    	INNER JOIN funcion as f5 ON cc.idfuncion_Funcion5 = f5.idfuncion\n"
                    + "                        INNER JOIN empresa AS e ON dp.rucEmpresa_empresa=e.ruc;"
            );
            //Recorrer el ResulSet , agregar a la lista cada registro
            while (resultado.next()) {
                lista.add(
                        new datospermiso(
                                resultado.getString("numeroOT"),
                                resultado.getString("prog"),
                                resultado.getDate("fechaSolicitud"),
                                resultado.getTime("hora"),
                                resultado.getString("lugar"),
                                resultado.getString("descripcion"),
                                resultado.getString("unidad"),
                                //instanciar clases
                                new kks(resultado.getString("id_kks"), resultado.getString("nombreEquipo"), resultado.getString("ubicacionEquipo")),
                                new empresa(resultado.getString("ruc"), resultado.getString("nombreEmpresa"), resultado.getString("direccion"), resultado.getInt("telefonoEmpresa")),
                                new area(resultado.getInt("idArea"), resultado.getString("nombreArea")),
                                resultado.getString("numeroPermiso"),
                                new jefaturasupervision(resultado.getInt("dniSup"), resultado.getString("nombresSup"), resultado.getString("apPaternoSup"), resultado.getString("apMaternoSup"), resultado.getInt("telefonoPersonaSup"),
                                        new funcion(resultado.getInt("idfuncion"), resultado.getString("nombreFuncion"))),
                                new responsablestrabajos(resultado.getInt("dniResp"), resultado.getString("nombresResp"), resultado.getString("apPaternoResp"), resultado.getString("apMaternoResp"), resultado.getInt("telefonoPersonaResp"),
                                        new funcion(resultado.getInt("idfuncion"), resultado.getString("nombreFuncion"))),
                                new operadores(resultado.getInt("dniOp"), resultado.getString("nombresOp"), resultado.getString("apPaternoOp"), resultado.getString("apMaternoOp"), resultado.getInt("telefonoPersonaOp"),
                                        new funcion(resultado.getInt("idfuncion"), resultado.getString("nombreFuncion"))),
                                new cclima(resultado.getInt("dniCCLim"), resultado.getString("nombresCCLim"), resultado.getString("apPaternoCCLim"), resultado.getString("apMaternoCCLim"), resultado.getInt("telefonoPersonaCCLim"),
                                        new funcion(resultado.getInt("idfuncion"), resultado.getString("nombreFuncion")))
                        )
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int eliminarRegistro(Connection connection) {
        try {
            PreparedStatement instruccion = connection.prepareStatement(
                    "DELETE FROM datospermiso "
                            + "WHERE numeroOT =?"
            );
            instruccion.setString(1, numeroOT.get());
            return instruccion.executeUpdate();
          
        } catch (SQLException e) {
            e.printStackTrace();
              return 0;
        }
    }

}
