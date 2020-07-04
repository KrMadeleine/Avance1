/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitacora2;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.event.ActionEvent;

import java.sql.Date;
import java.sql.Time;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import modelos.Conexion;
import modelos.area;
import modelos.datospermiso;
import modelos.empresa;
import modelos.kks;

import modelos.jefaturasupervision;
import modelos.responsablestrabajos;
import modelos.operadores;
import modelos.cclima;
//import modelos.personas_ot;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Karen
 */
public class FXMLDocumentController implements Initializable {

    //Table Views
    @FXML
    private TableView<datospermiso> tblDatosPermiso;
    

    //Columnas tableview:datospermiso
    @FXML private TableColumn<datospermiso, String> clmnOT;
    @FXML private TableColumn<datospermiso, String> clmnprog;
    @FXML private TableColumn<datospermiso, Date> clmnfechaSolicitud;
    @FXML private TableColumn<datospermiso, Time> clmnhora;
    @FXML private TableColumn<datospermiso, empresa> clmnruc_Empresa_empresa;
    @FXML private TableColumn<datospermiso, area> clmnidArea_area;
    @FXML private TableColumn<datospermiso, kks> clmnidkks_kks;
    @FXML private TableColumn<datospermiso, String> clmnlugar;
    @FXML private TableColumn<datospermiso, String> clmndescripcion;
    
    @FXML private TableColumn<datospermiso, jefaturasupervision> clmnSupervisor;
    @FXML private TableColumn<datospermiso, responsablestrabajos> clmnResponsable;
    @FXML private TableColumn<datospermiso, cclima> clmnCCLima;
    
    @FXML private TableColumn<datospermiso, String> clmnNumeroPermiso;
    
 //   @FXML private TreeTableColumn<datospermiso, String> clmnNumeroPermiso;
    
    @FXML private TableColumn<datospermiso, operadores> clmnOperaciones;

    //Componentes de la interfaz- registrarpermiso-datospermiso
    @FXML private Label detalleOT;
    @FXML private RadioButton rbtprog;
    @FXML private RadioButton rbtnoprog;
    @FXML private ToggleGroup progNoProg;
    @FXML private TextField txtnumeroOT;
    @FXML private TextField txtNumeroPermiso;
    @FXML private TextField txtlugar;
    @FXML private TextArea txtdescripcion;
    @FXML private JFXTimePicker timepickerHora;
    @FXML private TextField txtUnidad;
    @FXML private JFXDatePicker datepickerFecha;

    //ComboBox de Registrar Permiso
    @FXML private ComboBox<empresa> ComboBox_Empresas;
    @FXML private ComboBox<area> ComboBox_Areas;
    @FXML private ComboBox<kks> ComboBox_Sistema;
    @FXML private ComboBox<kks> ComboBox_Codigo;
    @FXML private JFXComboBox<?> ComboBoxUbicacion;
    
    @FXML private ComboBox<jefaturasupervision> ComboBox_Supervisor;
    @FXML private ComboBox<responsablestrabajos> ComboBox_ResponsableTrabajo;
    @FXML private ComboBox<operadores> ComboBox_Operador;
    @FXML private ComboBox<cclima> ComboBox_CCLima;
    
    @FXML private ComboBox<responsablestrabajos> ComboBox_Involucrado1;
    @FXML private ComboBox<?> ComboBox_Involucrado3;
    @FXML private ComboBox<?> ComboBox_Involucrado2;
    @FXML private ComboBox<?> ComboBox_Involucrado4;
    @FXML private ComboBox<?> ComboBox_Involucrado5;
    @FXML private ComboBox<?> ComboBox_Involucrado6;
   

    @FXML private Text TextNombreCCLima;
    //Botones - RegitrarPermiso
    @FXML private JFXButton btnRegistrarPermiso;
    @FXML private JFXButton btnRegistros;
    @FXML private JFXButton btnPersonal;

    @FXML private Pane paneRegistrarPermiso;
    @FXML private Pane paneRegistros;
    @FXML private Pane panePersonal;

    //OBSERVABLE LIST
    private ObservableList<datospermiso> listapermiso;//referencia a tabla
    private ObservableList<empresa> listaEmpresas; //referencia a componete
    private ObservableList<area> listaAreas;
    private ObservableList<kks> listakks;

    private ObservableList<jefaturasupervision> listaSup;
    private ObservableList<responsablestrabajos> listaResp;
    private ObservableList<operadores> listaOp;
    private ObservableList<cclima> listaCCLim;
    private Conexion conexion;

    @FXML private JFXButton btnLimpiar;
    @FXML private JFXButton btnEditar;
    @FXML private JFXButton btnEliminar;
    @FXML private JFXButton btnGuardar;
    @FXML
    private Text TextJefeSupervisor;
    @FXML
    private Text TextResponsableTrabajo;
    @FXML
    private Label txtPersonalnvolucrado;
    @FXML
    private Text TextOperador;
    @FXML
    private Label NumeroPermiso;
    @FXML
    private Label Observaciones;
    @FXML
    private Label DocumentosAdjuntos;
    @FXML
    private Label BloqueoyEtiquetado;
    @FXML
    private Pane PaneItem3;
    @FXML
    private JFXButton btnItem3;

 


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        conexion = new Conexion();
        conexion.establecerConexion();

        //inicializar listas de UI datos permiso
        listapermiso = FXCollections.observableArrayList();
        listaEmpresas = FXCollections.observableArrayList();
        listaAreas = FXCollections.observableArrayList();
        listakks = FXCollections.observableArrayList();

        //inicializar listas - 
        listaSup = FXCollections.observableArrayList();
        listaResp = FXCollections.observableArrayList();
        listaOp = FXCollections.observableArrayList();
        listaCCLim =FXCollections.observableArrayList();
        //listaCCLim = FXCollections.observableArrayList();
        //listaInv = FXCollections.observableArrayList();
        
        //llenar Listas : registro permiso - DATOS DE MODELOS
        datospermiso.llenarInformacionPermiso(conexion.getConnection(), listapermiso);
        empresa.llenarInformacion(conexion.getConnection(), listaEmpresas);
        area.llenarInformacion(conexion.getConnection(), listaAreas);
        kks.llenarInformacion(conexion.getConnection(), listakks);
        
        //llenar listas : personas    
        jefaturasupervision.llenarInformacion(conexion.getConnection(), listaSup);
        responsablestrabajos.llenarInformacion(conexion.getConnection(), listaResp);
        operadores.llenarInformacion(conexion.getConnection(), listaOp);
        cclima.llenarInformacion(conexion.getConnection(),listaCCLim);
        //personas1.llenarInformacionCCLim(conexion.getConnection(), listaCCLim);
        //lugar
        String[] posiblesLugares = {"casa de máquinas", "cámara de carga"};
        TextFields.bindAutoCompletion(txtlugar, posiblesLugares);
        //unidad
        String[] posibleUnidad = {"Unidad 1", "Unidad 2", "Unidad 1 y 2", "Serv.Comunes"};
        TextFields.bindAutoCompletion(txtUnidad, posibleUnidad);

        //Enlazar listas (ComboBox t tableview)-registro permisos
        tblDatosPermiso.setItems(listapermiso);
        // tblDatosPermiso.setItems(listapersonas_ot);

        ComboBox_Empresas.setItems(listaEmpresas);
        ComboBox_Areas.setItems(listaAreas);
        ComboBox_Sistema.setItems(listakks);

        ComboBox_Supervisor.setItems(listaSup);
        ComboBox_ResponsableTrabajo.setItems(listaResp);
        ComboBox_Operador.setItems(listaOp);
        ComboBox_CCLima.setItems(listaCCLim);
        
        ComboBox_Involucrado1.setItems(listaResp);
   
        //Enlazar Columnas y Atributos
        clmnOT.setCellValueFactory(new PropertyValueFactory<datospermiso, String>("numeroOT"));
        clmnprog.setCellValueFactory(new PropertyValueFactory<datospermiso, String>("prog"));

        clmnfechaSolicitud.setCellValueFactory(new PropertyValueFactory<datospermiso, Date>("fechaSolicitud"));
        clmnhora.setCellValueFactory(new PropertyValueFactory<datospermiso, Time>("hora"));

        clmnruc_Empresa_empresa.setCellValueFactory(new PropertyValueFactory<datospermiso, empresa>("empresa"));
        clmnidArea_area.setCellValueFactory(new PropertyValueFactory<datospermiso, area>("area"));
        clmnidkks_kks.setCellValueFactory(new PropertyValueFactory<datospermiso, kks>("kks"));

        clmnlugar.setCellValueFactory(new PropertyValueFactory<datospermiso, String>("lugar"));
        clmndescripcion.setCellValueFactory(new PropertyValueFactory<datospermiso, String>("descripcion"));

        clmnSupervisor.setCellValueFactory(new PropertyValueFactory<datospermiso, jefaturasupervision>("jefaturasupervision"));
        clmnResponsable.setCellValueFactory(new  PropertyValueFactory<datospermiso , responsablestrabajos>("responsablestrabajos"));
        clmnCCLima.setCellValueFactory(new PropertyValueFactory<datospermiso, cclima>("cclima"));
        clmnOperaciones.setCellValueFactory(new PropertyValueFactory<datospermiso, operadores>("operadores"));
        
        clmnNumeroPermiso.setCellValueFactory(new PropertyValueFactory<datospermiso, String>("numeroPermiso"));
        
        gestionarEventos();
        conexion.cerrarConexion();
        // TODO
    }

    @FXML
    public void gestionarEventos() {

        tblDatosPermiso.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<datospermiso>() {
            @Override
            public void changed(ObservableValue<? extends datospermiso> observable,
                    datospermiso oldValue, datospermiso newValue) {
                if (newValue != null) {

                    txtnumeroOT.setText(newValue.getNumeroOT());

                    if (newValue.getProg().equals("no programado")) {
                        rbtprog.setSelected(false);
                        rbtnoprog.setSelected(true);
                    } else if (newValue.getProg().equals("programado")) {
                        rbtprog.setSelected(true);
                        rbtnoprog.setSelected(false);
                    }
                    
                    datepickerFecha.setValue(newValue.getFechaSolicitud().toLocalDate());
                    timepickerHora.setValue(newValue.getHora().toLocalTime());
                    ComboBox_Areas.setValue(newValue.getArea());
                    ComboBox_Empresas.setValue(newValue.getEmpresa());
                    txtlugar.setText(newValue.getLugar());
                    
                    txtdescripcion.setText(newValue.getDescripcion());
                    ComboBox_Sistema.setValue(newValue.getKks());    
                    ComboBox_Supervisor.setValue(newValue.getJefaturasupervision());
                    ComboBox_ResponsableTrabajo.setValue(newValue.getResponsablestrabajos());
                    ComboBox_Operador.setValue(newValue.getOperadores());
                    ComboBox_CCLima.setValue(newValue.getCclima());
                    txtNumeroPermiso.setText(newValue.getNumeroPermiso());
                    
                    txtUnidad.setText(newValue.getUnidad());
                    btnGuardar.setDisable(true);
                    btnEditar.setDisable(false);
                    btnEliminar.setDisable(false);
                    btnEditar.setDisable(true);

                }
            }
        }
        );

    }

    @FXML
    private void RegistrarPermisoOnAction(ActionEvent event) {
        paneRegistrarPermiso.toFront();
    }

    @FXML
    private void RegistrosOnAction(ActionEvent event) {
        paneRegistros.toFront();
    }

    @FXML
    private void item3OnAction(ActionEvent event) {
        PaneItem3.toFront();
    }

    @FXML
    private void PersonalOnAction(ActionEvent event) {
        panePersonal.toFront();

    }

    @FXML
    public void limpiarComponentes() {
        //limpiar datospermiso
        txtnumeroOT.setText(null);
        rbtprog.setSelected(false);
        rbtnoprog.setSelected(false);
        datepickerFecha.setValue(null);
        timepickerHora.setValue(null);

        //dtpkrFecha.setValue(null);
        //txthora.setText(null);
        txtNumeroPermiso.setText(null);
        ComboBox_Empresas.setValue(null);
        ComboBox_Areas.setValue(null);
        ComboBox_CCLima.setValue(null);
        
        txtlugar.setText(null);
        txtdescripcion.setText(null);
        txtUnidad.setText(null);
         
        txtNumeroPermiso.setText(null);
        ComboBox_Supervisor.setValue(null);
        ComboBox_Operador.setValue(null);
        ComboBox_ResponsableTrabajo.setValue(null);
        
        ComboBox_Involucrado1.setValue(null);
        ComboBox_Involucrado2.setValue(null);
        ComboBox_Involucrado3.setValue(null);
        ComboBox_Involucrado4.setValue(null);
        ComboBox_Involucrado5.setValue(null);
        ComboBox_Involucrado6.setValue(null);

        //limpiar datospermiso_personas_ot
        // personas_comboBox.setValue(null);
        //rol_comboBox.setValue(null);
        //botones
        btnGuardar.setDisable(false);
        btnEditar.setDisable(true);
        btnEliminar.setDisable(true);

    }

    @FXML
    public void guardarRegistro() {

        datospermiso dp = new datospermiso(
                txtnumeroOT.getText(),
                rbtprog.isSelected() ? "programado" : "no programado",//condicion
                Date.valueOf(datepickerFecha.getValue()),
                Time.valueOf(timepickerHora.getValue()),
                txtlugar.getText(),
                txtdescripcion.getText(), 
                txtUnidad.getText(),
                ComboBox_Sistema.getSelectionModel().getSelectedItem(), //kks
                ComboBox_Empresas.getSelectionModel().getSelectedItem(),
                ComboBox_Areas.getSelectionModel().getSelectedItem(),                            
                txtNumeroPermiso.getText(),
                ComboBox_Supervisor.getSelectionModel().getSelectedItem(),
                ComboBox_ResponsableTrabajo.getSelectionModel().getSelectedItem(),
                ComboBox_Operador.getSelectionModel().getSelectedItem(),
                ComboBox_CCLima.getSelectionModel().getSelectedItem()
        );
        //llamar a metodo guardar registro de la clase datopermiso
        conexion.establecerConexion();
        int resultado = dp.guardarRegistro(conexion.getConnection());
        conexion.cerrarConexion();

        if (resultado == 1) {
            listapermiso.add(dp);
            //   listapersonas_ot.add(ps);

            //JDK 8update>40
            Alert mensaje = new Alert(AlertType.INFORMATION);
            mensaje.setTitle("Registro agregado");
            mensaje.setContentText("Se agrego registro correctamente");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }

    }
    @FXML
    public void  eliminarRegistro(){
        conexion.establecerConexion();
        int resultado =  tblDatosPermiso.getSelectionModel().getSelectedItem().eliminarRegistro(conexion.getConnection());
        conexion.cerrarConexion();
        
        if (resultado == 1){
            listapermiso.remove(tblDatosPermiso.getSelectionModel().getSelectedItem());
            Alert mensaje = new Alert (AlertType.INFORMATION);
            mensaje.setTitle("Registro eliminado");
            mensaje.setContentText("Se ha eliminado el Registro exitosamente :´(");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
    }
    public  void editarRegistro(){
     }

    @FXML
    private void detalleOTs(MouseEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/detalleOT.fxml"));
            Parent root3 = (Parent) fXMLLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Orden de Trabajo - Detalle");
            stage.setScene(new Scene(root3));
            stage.show();
        } catch (IOException e) {
            System.out.println("Incorrecto");
        }

    }

    @FXML
    private void ObservacionesClick(MouseEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/Observaciones.fxml"));
            Parent root2 = (Parent) fXMLLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Observaciones");
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (IOException e) {
            System.out.println("Incorrecto");
        }
    }

    @FXML
    private void DocumentosAdjuntosClick(MouseEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/DocumentosAdjuntos.fxml"));
            Parent root4 = (Parent) fXMLLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Documentos Adjuntos");
            stage.setScene(new Scene(root4));
            stage.show();
        } catch (IOException e) {
            System.out.println("Incorrecto");
        }
    }

    @FXML
    private void BloqueoyEtiquetadoClick(MouseEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/BloqueoEtiquetado.fxml"));
            Parent root5 = (Parent) fXMLLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Bloqueo y Etiquetado");
            stage.setScene(new Scene(root5));
            stage.show();
        } catch (IOException e) {
            System.out.println("Incorrecto");
        }
    }

}
