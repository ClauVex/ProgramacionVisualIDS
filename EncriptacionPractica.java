import java.util.Base64;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class EncriptacionPractica extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(15,15,15,15));
        Scene scene = new Scene(grid,300,300);
        Label tag = new Label("PALABRA: ");
        grid.add(tag,0,1);
        final TextField palabra = new TextField("");
        grid.add(palabra, 1, 1);
        Button encriptar = new Button("ENCRIPTAR");
        Button desencriptar = new Button("DESENCRIPTAR");
        grid.add(encriptar,2,1);
        grid.add(desencriptar,2,2);
        Label answer = new Label("PALABRA ENCRIPTADA");
        grid.add(answer,1,2);
        encriptar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                byte[] palabraCaja = palabra.getText().getBytes();
                String encriptacion = Base64.getEncoder().encodeToString(palabraCaja);
                palabra.setText(encriptacion);
                
            }
        });
        desencriptar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                Base64.Decoder desencriptacion = Base64.getDecoder();
                byte[] array = desencriptacion.decode(palabra.getText());
                String palabraDesencriptada = new String(array);
                palabra.setText(palabraDesencriptada);
            }
        });
        
        
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
    
}