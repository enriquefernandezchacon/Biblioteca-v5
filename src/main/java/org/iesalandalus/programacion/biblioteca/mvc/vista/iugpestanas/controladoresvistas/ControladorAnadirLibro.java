package org.iesalandalus.programacion.biblioteca.mvc.vista.iugpestanas.controladoresvistas;

import org.iesalandalus.programacion.biblioteca.mvc.controlador.IControlador;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.AudioLibro;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Libro;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.LibroEscrito;
import org.iesalandalus.programacion.biblioteca.mvc.vista.iugpestanas.utilidades.Dialogos;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControladorAnadirLibro {

	private IControlador controladorMVC;
	private ObservableList<Libro> libros;
	
    @FXML    private TextField tfAutor;
    
    @FXML    private TextField tfNombre;
    @FXML    private RadioButton rbEscrito;
    @FXML    private RadioButton rbAudio;
    @FXML    private TextField tfNumeroPaginas;
    @FXML    private TextField tfDuracion;
    @FXML    private Button btAtras;
    @FXML    private Button btAnadir;

    private ToggleGroup tgTipoLibro = new ToggleGroup();
    
    @FXML
    private void initialize() {
    	rbEscrito.setToggleGroup(tgTipoLibro);
    	rbAudio.setToggleGroup(tgTipoLibro);
    	tgTipoLibro.selectedToggleProperty().addListener((ob, ov, nv) -> comprobarBoton());
    	tfDuracion.selectedTextProperty().addListener((ob, ov, nv) -> comprobarNumero(tfDuracion));
    	tfNumeroPaginas.selectedTextProperty().addListener((ob, ov, nv) -> comprobarNumero(tfNumeroPaginas));
    }
    
    public void setControladorMVC(IControlador controladorMVC) {
    	this.controladorMVC = controladorMVC;
    }
    
    public void setLibros(ObservableList<Libro> libros) {
    	this.libros = libros;
    }
    
    @FXML
    void anadirLibro() {
    	Libro libro = null;
    	try {
    		libro = getLibro();
    		controladorMVC.insertar(libro);
    		libros.setAll(controladorMVC.getLibros());
    		Stage propietario = ((Stage) btAnadir.getScene().getWindow());
    		Dialogos.mostrarDialogoInformacion("Añadir Libro", "Libro añadido de forma correcta", propietario);
    	} catch (Exception e) {
    		Dialogos.mostrarDialogoError("Añadir Libro", e.getMessage());
    	}
    }

    @FXML
    void atras() {
    	((Stage) btAtras.getScene().getWindow()).close();
    }

    public void inicializa() {
		tfNombre.setText("");
		tfAutor.setText("");
		tgTipoLibro.selectToggle(rbEscrito);
		comprobarBoton();
		tfDuracion.setText("");
		comprobarNumero(tfDuracion);
		tfNumeroPaginas.setText("");
		comprobarNumero(tfNumeroPaginas);
		
	}
    
    private void comprobarBoton() {
    	if (rbEscrito.isSelected()) {
    		tfDuracion.setDisable(true);
    		tfNumeroPaginas.setDisable(false);
    	} else if (rbAudio.isSelected()) {
    		tfDuracion.setDisable(false);
    		tfNumeroPaginas.setDisable(true);
    	}
    }
    
    private void comprobarNumero(TextField campo) {
    	try {
    		Integer.parseInt(campo.getText());
    		campo.setStyle("-fx-border-color: green");
    		btAnadir.setDisable(false);
    	} catch (Exception e){
    		campo.setStyle("-fx-border-color: red");
    		btAnadir.setDisable(true);
    	}
    }
    
    private Libro getLibro() {
    	AudioLibro audioLibro = null;
		LibroEscrito libroEscrito = null;
    	String titulo = tfNombre.getText();
    	String autor = tfAutor.getText();
    	int paginas = Integer.parseInt(tfNumeroPaginas.getText());
    	int duracion = Integer.parseInt(tfDuracion.getText());
    	if (rbAudio.isSelected()) {
    		audioLibro = new AudioLibro(titulo, autor, duracion);
    		return audioLibro;
    	} else {
    		libroEscrito = new LibroEscrito(titulo, autor, paginas);
    		return libroEscrito;
    	}
    }
    
}

