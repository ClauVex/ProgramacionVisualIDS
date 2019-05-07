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
public class IVACalculo extends JFrame implements ActionListener{
    private JLabel mensaje;
    private JButton boton;
    private JTextField caja;
    private JTextField caja2;
    private JComboBox iva;
    public String selectIva;
    
    public IVACalculo(){
        super();
        configurarVentana();
        crearComponente();
    }
    
    private void configurarVentana(){
        this.setTitle("Hello World");
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void crearComponente(){
        mensaje = new JLabel();
        mensaje.setText("CALCULO DEL IVA");
        mensaje.setBounds(80,10,100,30);
        this.add(mensaje);
        
        caja = new JTextField();
        caja.setBounds(50, 60, 50, 30);
        this.add(caja);
        
        caja2 = new JTextField();
        caja2.setBounds(50, 100, 50, 30);
        this.add(caja2);
        
        String[] ivalist = new String[]{"iva","16","8"};
        final JComboBox<String> iva = new JComboBox<>(ivalist);
        iva.setBounds(150,60,100,25);
        iva.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               selectIva = iva.getItemAt(iva.getSelectedIndex());
               System.out.print("El valor del iva es: " + selectIva);
           }
        });
        this.add(iva);
        
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
        double calc1 = Double.parseDouble(resultado)*(Double.parseDouble(resultado2)/100);
        double calc2 = Double.parseDouble(resultado)+calc1;
        String total = String.valueOf(calc2);
        JOptionPane.showMessageDialog(this,"RESULTADO: "+total);
    }
    
    public static void main(String[] args){
        IVACalculo ventana = new IVACalculo();
        ventana.setVisible(true);
    }
}
