/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author ClaudioCésar
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SumaNumeros extends JFrame implements ActionListener{
    private JLabel mensaje;
    private JButton boton;
    private JTextField caja;
    private JTextField caja2;
    
    public SumaNumeros(){
        
    }
    
    private void configurarVentana(){
        this.setTitle("Suma Numeros");
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void crearComponente(){
        mensaje = new JLabel();
        mensaje.setText("SUMA DE DOS NUMEROS");
        mensaje.setBounds(80,10,100,30);
        this.add(mensaje);
        
        caja = new JTextField();
        caja.setBounds(50, 60, 50, 30);
        this.add(caja);
        
        caja2 = new JTextField();
        caja2.setBounds(50, 100, 50, 30);
        this.add(caja2);
        
        boton = new JButton();
        boton.setText("CALCULAR");
        boton.setBounds(150,90,100,30);
        boton.addActionListener(this);
        this.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String resultado = caja.getText();
        String resultado2 = caja2.getText();
        double suma = Double.parseDouble(resultado)+(Double.parseDouble(resultado2));
        String total = String.valueOf(suma);
        JOptionPane.showMessageDialog(this,"RESULTADO SUMA: "+total);
    }
    
    public static void main(String[] args){
        HelloWorld ventana = new HelloWorld();
        ventana.setVisible(true);
    }
    
}
