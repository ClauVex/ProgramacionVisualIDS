/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablapractica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
public class TablaPractica extends JFrame implements ActionListener {
    JFrame ventana;
    private JFrame frame;
    private DefaultTableModel model;
    private JTable tabla;
    private JLabel mensajeNombre,mensajePrecio,mensajeEditar;
    private JTextField resultadoA,resultadoB,resultadoC;
    private JButton editar,eliminar,agregar;
    
    public TablaPractica(){
        ventana = new JFrame();
	String data[][] = { {"1","Tacos","$12.00"}, {"2","Tamales","$10.00"}, {"3","Tortas","$35.00"}, {"4","Cochito","$45.00"}   };
	String label[] = {"ID", "NOMBRE", "PRECIO"};	
	model =   new DefaultTableModel(data,label);
        tabla = new JTable(model);	
	mensajeNombre = new JLabel("AGREGAR PRODUCTO:");
        mensajeNombre.setBounds(10, 490, 150, 60);
        mensajeNombre.setForeground(Color.white);
        ventana.add(mensajeNombre);
        
        resultadoA = new JTextField();
        resultadoA.setBounds(170, 500, 80, 40);
        ventana.add(resultadoA);
        
        mensajePrecio = new JLabel("AGREGAR PRECIO$$$:");
        mensajePrecio.setBounds(10, 540, 150, 60);
        mensajePrecio.setForeground(Color.white);
        ventana.add(mensajePrecio);
        
        mensajeEditar = new JLabel("PRODUCTO SELECCIONADO PARA EDITAR:");
        mensajeEditar.setBounds(120, 450, 300, 60);
        mensajeEditar.setForeground(Color.white);
        ventana.add(mensajeEditar);
        
        
        resultadoB = new JTextField();
        resultadoB.setBounds(170, 550, 80, 40);
        ventana.add(resultadoB);
        
        resultadoC = new JTextField();
        resultadoC.setBounds(510, 500, 80, 40);
        ventana.add(resultadoC);
        
        editar = new JButton();
        editar.setText("EDITAR PRODUCTO");
        editar.setBounds(350, 500, 150, 40);
        editar.addActionListener(this);
        ventana.add(editar);
        
        eliminar = new JButton();
        eliminar.setText("ELIMINAR PRODUCTO");
        eliminar.setBounds(350, 550, 150, 40);
        eliminar.addActionListener(this);
        ventana.add(eliminar);
        
        agregar = new JButton();
        agregar.setText("AGREGAR");
        agregar.setBounds(120, 600, 150, 25);
        agregar.addActionListener(this);
        ventana.add(agregar);
		
	tabla.setCellSelectionEnabled(true);
	ListSelectionModel select = tabla.getSelectionModel();
        select.addListSelectionListener(new ListSelectionListener(){public void valueChanged(ListSelectionEvent e){}});
	eliminar.setEnabled(false);
	JScrollPane sp = new JScrollPane(tabla); 
        sp.setBounds(90, 20, 500, 400);
	ventana.add(sp);
        ventana.setSize(700,720);
	ventana.setLocationRelativeTo(null);
        ventana.setResizable(true);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(new java.awt.Color(64,64,64));
        ventana.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
	String Data = null;
	int valor = 0;
        int celda = 0;	 
	int []row = tabla.getSelectedRows();
	int[] columns = tabla.getSelectedColumns();
        for(int i = 0; i< row.length; i++) {
            for(int j = 0; j < columns.length;j++) {
                Data = (String) tabla.getValueAt(row[i], columns[j]);
                celda = columns[j];
            }
            valor = row[i];		
        }
        eliminar.setEnabled(true);
        switch(e.getActionCommand()) {
            case "ELIMINAR":
                if(model.getRowCount() > 0) {
                    model.removeRow(valor);
                }	  
                break;
            case "EDITAR":
                mensajeEditar.setText(Data);
                if(resultadoC.getText().equals(null)) {
                    resultadoC.setText(Data);
                }else {
                    tabla.setValueAt(resultadoC.getText(),valor, celda);
                }
                break;	   
            case "AGREGAR":
                eliminar.setEnabled(false);
                int id = model.getRowCount()+1;
                String valorId = String.valueOf(id);
                String resultado = resultadoA.getText();
 		String resultado2 = "$"+resultadoB.getText()+".00";
                addRow(valorId,resultado,resultado2);
                break;
        }
    };
    public void addRow(String str1, String str2, String str3) {
        model.addRow(new Object[] {str1,str2,str3});
	}
    public static void main(String[] args) {
        TablaPractica i = new TablaPractica();
        i.addRow("5", "Gordita", "$16.00");
    }
    
}
