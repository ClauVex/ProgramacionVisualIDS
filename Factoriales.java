/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoriales;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author ClaudioCésar
 */
public class Factoriales extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Calcular factorial");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Scene scene = new Scene(grid, 300, 250);
        
        Label etiqueta = new Label();
        grid.add(etiqueta,5,5);
        
        final TextField numero = new TextField();
        grid.add(numero, 1, 1);
        
        Button factorial = new Button("Factorial");
        grid.add(factorial, 1, 2);
        
        final Label resultado = new Label();
        grid.add(resultado, 2, 1);
        
        factorial.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                int num = Integer.parseInt(numero.getText());
                int suma=1;
                String resultadoFact;
                for(int i = num; i>=1; i--){
                    suma*=i;
                }
                resultadoFact = Integer.toString(suma);
                resultado.setText(resultadoFact);
                
            }
            
        });
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
