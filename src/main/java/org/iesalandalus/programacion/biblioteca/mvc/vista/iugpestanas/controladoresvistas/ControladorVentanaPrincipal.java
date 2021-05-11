package org.iesalandalus.programacion.biblioteca.mvc.vista.iugpestanas.controladoresvistas;

import java.io.IOException;
import java.util.List;

import org.iesalandalus.programacion.biblioteca.mvc.controlador.IControlador;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Curso;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Libro;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Prestamo;
import org.iesalandalus.programacion.biblioteca.mvc.vista.iugpestanas.recursos.LocalizadorRecursos;
import org.iesalandalus.programacion.biblioteca.mvc.vista.iugpestanas.utilidades.Dialogos;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorVentanaPrincipal {

	private IControlador controladorMVC;
	
	private ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
	private ObservableList<Prestamo> prestamospendientes = FXCollections.observableArrayList();
	private ObservableList<Prestamo> prestamosdevueltos = FXCollections.observableArrayList();
	private ObservableList<Libro> libros = FXCollections.observableArrayList();
	
	public void setControladorMVC(IControlador controladorMVC) {
		this.controladorMVC = controladorMVC;
	}
	
    @FXML private TableView<Prestamo> tvPrestamosEnCurso;
    @FXML private TableColumn<Prestamo, String> tcPCtipolibro;
    @FXML private TableColumn<Prestamo, String> tcPCtitulolibro;
    @FXML private TableColumn<Prestamo, String> tcPCalumno;
    @FXML private TableColumn<Prestamo, String> tcPCfechaprestamo;

    @FXML private TableView<Prestamo> tvPrestamosDevueltos;
    @FXML private TableColumn<Prestamo, String> tcPDtipolibro;
    @FXML private TableColumn<Prestamo, String> tcPDtitulolibro;
    @FXML private TableColumn<Prestamo, String> tcPDalumno;
    @FXML private TableColumn<Prestamo, String> tcPDfechaprestamo;
    @FXML private TableColumn<Prestamo, String> tcPDfechadevolucion;

    @FXML private TableView<Libro> tvLibros;
    @FXML private TableColumn<Libro, String> tcTLtipolibro;
    @FXML private TableColumn<Libro, String> tcTLtitulo;
    @FXML private TableColumn<Libro, String> tcTLautor;
    @FXML private TableColumn<Libro, String> tcTLpaginas;
    @FXML private TableColumn<Libro, String> tcTLduracion;
    @FXML private TableColumn<Libro, String> tcTLpuntos;


    @FXML private TableView<Alumno> tvAlumnos;
    @FXML private TableColumn<Alumno, String> tcTAnombre;
    @FXML private TableColumn<Alumno, String> tcTAcorreo;
    @FXML private TableColumn<Alumno, Curso> tcTAcurso;

    private Stage anadirAlumno;
    private ControladorAnadirAlumno cAnadirAlumno;
    
    @FXML
    private void initialize() {
    	
    	tcPCtipolibro.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getLibro().getClass().getSimpleName()));
    	tcPCtitulolibro.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getLibro().getTitulo()));
    	tcPCalumno.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getAlumno().getCorreo()));
    	tcPCfechaprestamo.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getFechaPrestamo().toString()));
    	tvPrestamosEnCurso.setItems(prestamospendientes);
    	
    	tcPDtipolibro.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getLibro().getClass().getSimpleName()));
    	tcPDtitulolibro.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getLibro().getTitulo()));
    	tcPDalumno.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getAlumno().getNombre()));
    	tcPDfechaprestamo.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getFechaPrestamo().toString()));
    	tcPDfechadevolucion.setCellValueFactory(prestamo -> new SimpleStringProperty(prestamo.getValue().getFechaDevolucion().toString()));
    	tvPrestamosDevueltos.setItems(prestamosdevueltos);
    	
    	/*
    	 * Falta ver como sacar el valor del tipo clase
    	 * tcTLtipolibro.setCellValueFactory(libro -> SimpleStringProperty());
    	 */
    	tcTLtitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    	tcTLautor.setCellValueFactory(new PropertyValueFactory<>("autor"));
    	tcTLpaginas.setCellValueFactory(new PropertyValueFactory<>("numPaginas"));
    	tcTLduracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
    	/*
    	 * Falta ver la puntuación que aporta cada libro
    	 * tcTLpuntos.setCellValueFactory(new PropertyValueFactory<>();
    	 */
    	tvLibros.setItems(libros);
    	
    	tcTAnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	tcTAcorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    	tcTAcurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
    	tvAlumnos.setItems(alumnos);
    }
    
    @FXML
    private void nuevoPrestamo() throws IOException {
    	VBox contenido = FXMLLoader.load(LocalizadorRecursos.class.getResource("vistas/AnadirPrestamo.fxml"));
    	Dialogos.mostrarDialogoInformacionPersonalizado("Nuevo Prestamo", contenido);
    }
    
    @FXML
    private void nuevoLibro() throws IOException {
    	
    }
    
    @FXML
    private void nuevoAlumno(ActionEvent event) throws IOException {
    	crearAnadirAlumno();
    	anadirAlumno.showAndWait();
    }
    
    @FXML
    private void buscarPrestamos() throws IOException {
    	
    }
    
    @FXML
    private void mostrarEstadisticas() {
    	/*
    	 * Falta crear el fxml 
    	 */
    }
    
    @FXML
    private void acercaDe() throws IOException {
    	AnchorPane contenido = FXMLLoader.load(LocalizadorRecursos.class.getResource("vistas/AcercaDe.fxml"));
    	Dialogos.mostrarDialogoInformacionPersonalizado("Acerca De", contenido);
    }
    
    public void actualizarPrestamosEnCurso() {
    	tvPrestamosEnCurso.getSelectionModel().clearSelection();
    	List<Prestamo> prestamos = controladorMVC.getPrestamos();
    	for (Prestamo prestamo : prestamos) {
    		if (prestamo.getFechaDevolucion() == null) {
    			prestamospendientes.add(prestamo);
    		}
    	}
    }
    
    public void actualizaPrestamosDevueltos() {
    	tvPrestamosEnCurso.getSelectionModel().clearSelection();
    	List<Prestamo> prestamos = controladorMVC.getPrestamos();
    	for (Prestamo prestamo : prestamos) {
    		if (prestamo.getFechaDevolucion() != null) {
    			prestamosdevueltos.add(prestamo);
    		}
    	}
    }
    
    public void actualizarLibros() {
    	tvLibros.getSelectionModel().clearSelection();
    	libros.setAll(controladorMVC.getLibros());
    }
    
    public void actualizarAlumnos() {
    	tvAlumnos.getSelectionModel().clearSelection();
    	alumnos.setAll(controladorMVC.getAlumnos());
    }
    
    private void crearAnadirAlumno() throws IOException {
    	if (anadirAlumno == null) {
    		anadirAlumno = new Stage();
    		FXMLLoader cargadorAnadirAlumno = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/AnadirAlumno.fxml"));
    		VBox raizAnadirAlumno = cargadorAnadirAlumno.load();
    		cAnadirAlumno = cargadorAnadirAlumno.getController();
    		cAnadirAlumno.setControladorMVC(controladorMVC);
    		cAnadirAlumno.setAlumnos(alumnos);
    		cAnadirAlumno.inicializa();
    		
    		Scene escenaAnadirAlumno = new Scene(raizAnadirAlumno);
    		anadirAlumno.setTitle("Añadir Alumno");
    		anadirAlumno.initModality(Modality.APPLICATION_MODAL);
    		anadirAlumno.setScene(escenaAnadirAlumno);
    	} else {
    		cAnadirAlumno.inicializa();
    	}
    }
    
}
