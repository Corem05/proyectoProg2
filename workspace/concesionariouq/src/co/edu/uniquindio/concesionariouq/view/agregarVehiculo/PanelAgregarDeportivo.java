package co.edu.uniquindio.concesionariouq.view.agregarVehiculo;

import static co.edu.uniquindio.concesionariouq.util.Utility.generarHBox;

import co.edu.uniquindio.concesionariouq.controllers.ControlVehiculos;
import co.edu.uniquindio.concesionariouq.model.Combustible;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.TipoCambio;
import co.edu.uniquindio.concesionariouq.util.Boton;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PanelAgregarDeportivo extends PanelConVolver {
	private EventHandler<? super MouseEvent> eventoVolver;
	private Combustible combustible;

	public PanelAgregarDeportivo(EventHandler<? super MouseEvent> eventoVolver) {
		this.eventoVolver = eventoVolver;
		initComponents();
	}

	@Override
	public void initComponents() {
		VBox box = new VBox();
		TextField tfPlaca = new TextField();
		TextField tfMarca = new TextField();
		TextField tfModelo = new TextField();
		TextField tfCilindraje = new TextField();
		TextField tfVelocidadMax = new TextField();
		Boton botonCombustible = new Boton("Combustible", e -> {
			ControlVehiculos.irACambiarCombustible(this, combustible);
		});
		ComboBox<String> cbEstadoVechiculo = new ComboBox<String>();
		ComboBox<String> cbTipoCambio = new ComboBox<String>();
		Spinner<Integer> tfNPasajeros = new Spinner<Integer>();
		Spinner<Integer> tfNBolsasAire = new Spinner<Integer>();
		Spinner<Integer> tfNPuertas = new Spinner<Integer>();
		TextField tfNCaballos = new TextField();
		TextField tfAlcanza100 = new TextField();

		box.getChildren().add(generarHBox("Ingresa la placa del vehiculo", tfPlaca));
		box.getChildren().add(generarHBox("Ingresa la marca del vehiculo", tfMarca));
		box.getChildren().add(generarHBox("Ingresa el modelo del vehiculo", tfModelo));
		box.getChildren().add(generarHBox("Ingresa el cilindraje del vehiculo", tfCilindraje));
		box.getChildren().add(generarHBox("Ingresa la velocidad maxima del vehiculo", tfVelocidadMax));
		box.getChildren().add(generarHBox("Seleccione el tipo de combustible", botonCombustible));
		box.getChildren().add(generarHBox("Seleccione el estado del vehiculo", cbEstadoVechiculo));
		box.getChildren().add(generarHBox("Seleccione el tipo de caja de cambios", cbTipoCambio));
		box.getChildren().add(generarHBox("Ingresa el numero de pasajeros", tfNPasajeros));
		box.getChildren().add(generarHBox("Ingresa el numero de bolsas de aire", tfNBolsasAire));
		box.getChildren().add(generarHBox("Ingresa el numero de puertas", tfNPuertas));
		box.getChildren().add(generarHBox("Ingresa el numero de caballos de fuerza", tfNCaballos));
		box.getChildren().add(generarHBox("Ingresa el tiempo que tarda en alcanzar los 100km/h", tfAlcanza100));

		cbEstadoVechiculo.setItems(FXCollections.observableArrayList(EstadoVehiculo.getTextValues()));
		cbTipoCambio.setItems(FXCollections.observableArrayList(TipoCambio.getTextValues()));

		setCenter(box);
		box.setId("centered-box");
		HBox hbox = new HBox();
		Boton botonVolver = new Boton("Volver", eventoVolver);
		Boton botonAgregar = new Boton("Aceptar", e -> {
			ControlVehiculos.agregarDeportivo(tfPlaca.getText().trim(), tfMarca.getText().trim(),
					tfModelo.getText().trim(), tfCilindraje.getText().trim(), tfVelocidadMax.getText().trim(),
					combustible, cbEstadoVechiculo.getValue().toString(), cbTipoCambio.getValue().toString(),
					tfNPasajeros.getValue().toString(), tfNBolsasAire.getValue().toString(),
					tfNPuertas.getValue().toString(), tfNCaballos.getText().trim(), tfAlcanza100.getText().trim());
		});
		hbox.getChildren().add(botonVolver);
		hbox.getChildren().add(botonAgregar);

		HBox.setMargin(botonAgregar, new Insets(0, 20, 20, 0));
		HBox.setMargin(botonVolver, new Insets(0, 20, 20, 20));

		HBox.setHgrow(botonVolver, Priority.ALWAYS);
		HBox.setHgrow(botonAgregar, Priority.ALWAYS);
		setBottom(hbox);
	}
}