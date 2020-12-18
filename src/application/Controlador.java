package application;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class Controlador {
	
	private int numero;
	
	private int intentos = 3;
	
	@FXML
	private Label respuesta;
	@FXML
	private Label rango1;
	@FXML
	private Label rango2;
	@FXML
	private Button casilla1;
	@FXML
	private Button casilla2;
	@FXML
	private Button casilla3;
	@FXML
	private Label intentosLabel;
	@FXML
	private Button botonGenerar;
	@FXML
	private FlowPane panel;
	
	public void cerrar(ActionEvent e){
		System.exit(0);
	}

	public void inicio(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(((Button)e.getSource()).getText().equals("De nuevo!")) {
			
			intentos = 3;
			botonGenerar.setText("Generar");
			respuesta.setText(" ");
			panel.setStyle("-fx-background-color: #fff;");
			
		}
		
		SecureRandom ran = new SecureRandom();
		
		numero = ran.nextInt(200)+1;
		
		rango1.setText(String.valueOf(numero - ran.nextInt(50)));
		
		rango2.setText(String.valueOf(numero + ran.nextInt(50)));

		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(numero);
		
		numeros.add(numero - ran.nextInt(50));
		
		numeros.add(numero + ran.nextInt(50));
		
		Collections.shuffle(numeros);
		
		casilla1.setText(String.valueOf(numeros.get(0)));
		
		casilla2.setText(String.valueOf(numeros.get(1)));
		
		casilla3.setText(String.valueOf(numeros.get(2)));
		
		intentosLabel.setText(" "+intentos+" intentos!");
		
		//respuesta.setText(String.valueOf(numero));
		
		
		
	}
	
	public void seleccion(ActionEvent e) {
		
		String src = ((Button)e.getSource()).getText();
		
		if (src.equals("-")) return;
		
		if(numero == Integer.parseInt(src)) {
			
			respuesta.setText("GANASTE!");
			
			botonGenerar.setText("De nuevo!");
			
			panel.setStyle("-fx-background-color: #42f548;");
			
		}else {
			intentos--;
			
			respuesta.setText("NO!");
			
			inicio(e);
			
			if(intentos==0) {
				
				respuesta.setText("PERDISTE!");
				
				rango1.setText("-");
				
				rango2.setText("-");
				
				casilla1.setText("-");
				
				casilla2.setText("-");
				
				casilla3.setText("-");
				
				intentosLabel.setText("-");
				
				botonGenerar.setText("De nuevo!");
				
				panel.setStyle("-fx-background-color: #f54242;");
				
			
				
			}
			intentosLabel.setText(" "+intentos+" intentos!");
			
		}
		
		
	}
	
}
