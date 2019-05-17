/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorpalabras;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnalizadorPalabras extends JFrame implements ActionListener{
    private JLabel mensajePalabra,mensajePalindromo,mensajeLongitud,mensajeInversa,mensajeRepetida,respuestaPalabra,respuestaPalindromo,respuestaLong,respuestaInv;
    private JButton boton;
    private JTextField caja;
    public AnalizadorPalabras() {
	super();
	configurarVentana();
        crearComponentes();
	}
    private void configurarVentana(){
		this.setTitle("ANALIZADOR DE PALABRAS");
		this.setSize(430, 250);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearComponentes(){
		mensajePalabra = new JLabel("PALABRA");
		mensajePalabra.setBounds(10, 0, 100, 60);
		this.add(mensajePalabra);
		
		mensajePalindromo = new JLabel("Palindromo: ");
		mensajePalindromo.setBounds(30, 70, 75, 60);
		this.add(mensajePalindromo);

		mensajeLongitud = new JLabel("Longitud: ");
		mensajeLongitud.setBounds(30, 90, 60, 60);
		this.add(mensajeLongitud);
		
		mensajeInversa = new JLabel("Inversa: ");
		mensajeInversa.setBounds(30, 110, 60, 60);
		this.add(mensajeInversa);
		
		mensajeRepetida = new JLabel("Repetida: ");
		mensajeRepetida.setBounds(30, 130, 60, 60);
		this.add(mensajeRepetida);
		
		respuestaPalindromo = new JLabel("");
		respuestaPalindromo.setBounds(150, 135, 100, 10);
		this.add(respuestaPalindromo);
		
		respuestaPalabra = new JLabel("");
		respuestaPalabra.setBounds(150, 115, 60, 10);
		this.add(respuestaPalabra);
		
		respuestaLong = new JLabel("");
		respuestaLong.setBounds(150, 95, 60, 10);
		this.add(respuestaLong);
		
		respuestaInv = new JLabel("");
		respuestaInv.setBounds(150, 155, 60, 10);
		this.add(respuestaInv);
		
		caja = new JTextField();
		caja.setBounds(120,20,100,30);
		this.add(caja);
		
		boton = new JButton("Verificar");
		boton.setBounds(120,60,100,30);
		boton.addActionListener(this);
		this.add(boton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
            String palabraAnalizada = caja.getText();
            String palabraInversa;
            int longitudPalabra;		
            longitudPalabra = palabraAnalizada.length();
            respuestaPalabra.setText(Integer.toString(longitudPalabra));
            palabraInversa="";
            for(int x=(longitudPalabra-1);x>=0;x--) {
                palabraInversa += palabraAnalizada.charAt(x);
            }
            respuestaPalindromo.setText(palabraInversa);
            if(palabraAnalizada.replace(" ", "").equals(palabraInversa.replace(" ", ""))) {
                respuestaLong.setText("Si");
            }else {
                respuestaLong.setText("No");
            }
            char [] arregloLetras;
            int contadorRepeticion  = 0;
            char modaLetra;
            arregloLetras = palabraAnalizada.toCharArray();
            for(int i=0;i<palabraAnalizada.length();i++) {
                char letraActual = arregloLetras[i];
                int contador =0;
                for(int j=0;j<arregloLetras.length;j++) {
                    if(arregloLetras[j]==letraActual)
                        contador++;
                }
                if(contadorRepeticion < contador) {
                    contadorRepeticion = contador;
                    modaLetra = letraActual;
                    String letra = Character.toString(modaLetra);
                    respuestaInv.setText(letra);
                }
            }
        }
    public static void main(String[] args) {
        AnalizadorPalabras ventana = new AnalizadorPalabras();
        ventana.setVisible(true);
    }    
}
