package org.iesalandalus.programacion.biblioteca.mvc.vista.iugpestanas.controladoresvistas;

import org.iesalandalus.programacion.biblioteca.mvc.controlador.IControlador;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Libro;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Prestamo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorVentanaPrincipal {

	private IControlador controladorMVC;
	
	private ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
	
	public void setControladorMVC(IControlador controladorMVC) {
		this.controladorMVC = controladorMVC;
	}
	
    @FXML private TableView<Prestamo> tprestamosencurso;
    @FXML private TableColumn<Prestamo, String> tpptipolibro;
    @FXML private TableColumn<Prestamo, String> tpptitulolibro;
    @FXML private TableColumn<Prestamo, String> tppalumno;
    @FXML private TableColumn<Prestamo, String> tppfechaprestamo;

    @FXML private TableView<Prestamo> tprestamosdevueltos;
    @FXML private TableColumn<Prestamo, String> tpdtipolibro;
    @FXML private TableColumn<Prestamo, String> tpdtitulolibro;
    @FXML private TableColumn<Prestamo, String> tpdalumno;
    @FXML private TableColumn<Prestamo, String> tpdfechaprestamo;
    @FXML private TableColumn<Prestamo, String> tpdfechadevolucion;

    @FXML private TableView<Libro> tlibrosescritos;
    @FXML private TableColumn<Libro, String> tlltitulo;
    @FXML private TableColumn<Libro, String> tllautor;
    @FXML private TableColumn<Libro, String> tllnumpag;
    @FXML private TableColumn<Libro, String> tllpuntos;

    @FXML private TableView<?> taudiolibros;
    @FXML private TableColumn<Libro, String> tlatitulo;
    @FXML private TableColumn<Libro, String> tlaautor;
    @FXML private TableColumn<Libro, String> tladuracion;
    @FXML private TableColumn<Libro, String> tlapuntos;

    @FXML private TableView<Alumno> talumnos;
    @FXML private TableColumn<Alumno, String> tanombre;
    @FXML private TableColumn<Alumno, String> tacorreo;
    @FXML private TableColumn<Alumno, String> tacurso;

    @FXML
    private void initializate() {
    	tanombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	tacorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    	tacurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
    	talumnos.setItems(alumnos);
    }
    
    public void actualizarAlumnos() {
    	alumnos.setAll(controladorMVC.getAlumnos());
    }
    
}
