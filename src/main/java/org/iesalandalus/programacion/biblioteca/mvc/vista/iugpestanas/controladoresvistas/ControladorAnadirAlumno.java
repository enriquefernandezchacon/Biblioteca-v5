package org.iesalandalus.programacion.biblioteca.mvc.vista.iugpestanas.controladoresvistas;

import java.awt.Button;

import org.iesalandalus.programacion.biblioteca.mvc.controlador.IControlador;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ControladorAnadirAlumno {
	
	private static String ER_NOMBRE = "[a-zA-ZÁáÉéÍíÓóÚúÑñ]+[\\s]+[a-zA-ZÁáÉéÍíÓóÚúÑñ\\s]*";
	private static String ER_CORREO = "\\w+[.]?\\w+[@]\\w+[.]\\w{2,5}";
	
	private IControlador controladorMVC;
	private ObservableList<Alumno> alumnos;
	
	@FXML private TextField tfCorreo;
	@FXML private TextField tfNombre;
	@FXML private RadioButton rbPrimero;
	@FXML private RadioButton rbSegundo;
	@FXML private RadioButton rbTercero;
	@FXML private RadioButton rbCuarto;
	@FXML private Button btAtras;
	@FXML private Button btAnadir;
	
	private ToggleGroup tgCurso = new ToggleGroup();

	@FXML
	private void initialize() {
		rbPrimero.setToggleGroup(tgCurso);
		rbSegundo.setToggleGroup(tgCurso);
		rbTercero.setToggleGroup(tgCurso);
		rbCuarto.setToggleGroup(tgCurso);
	}
	
	public void setControladorMVC(IControlador controladorMVC) {
		this.controladorMVC = controladorMVC;
	}
	
	public void setAlumnos(ObservableList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	@FXML
	void anadir() {

	}

	@FXML
	void atras() {
		
	}
	
	
	public void inicializa() {
		tfNombre.setText("");
		comprobarTexto(ER_NOMBRE, tfNombre);
		tfCorreo.setText("");
		comprobarTexto(ER_CORREO, tfCorreo);
		tgCurso.selectToggle(rbPrimero);
	}
	
	private void comprobarTexto(String er, TextField campo) {
		String texto = campo.getText();
		if (texto.matches(er)) {
			campo.setStyle("-fx-border-color: green");
		} else {
			campo.setStyle("-fx-border-color: red");
		}
	}
	
}
