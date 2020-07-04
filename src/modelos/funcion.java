/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author karen
 */
public class funcion {
    private IntegerProperty idfuncion;
    private StringProperty nombreFuncion;
    
    public funcion(int idfuncion, String nombreFuncion){
        this.idfuncion = new SimpleIntegerProperty(idfuncion);
        this.nombreFuncion = new SimpleStringProperty(nombreFuncion);
    }
    
    // Métodos del atributo : idfuncion
    public int getIdfuncion(){
        return idfuncion.get();
    }    
    
    public void setIdFuncion(int idfuncion){
        this.idfuncion = new SimpleIntegerProperty(idfuncion);
    }
    
    public IntegerProperty IdfuncionProperty(){
        return idfuncion;
    }
    
    // Métodos del atributo : nombrefuncion
    public String getNombreFuncion(){
        return nombreFuncion.get();
    }
    
    public void setNombreFuncion(String nombreFuncion){
        this.nombreFuncion = new SimpleStringProperty(nombreFuncion);
    }
    
    public StringProperty NombreFuncionProperty(){
        return nombreFuncion;
    } 
    //Creacion de metodos
    
    
    
    }
