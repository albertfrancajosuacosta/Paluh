import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        //System.out.println("oI");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        primaryStage.setTitle("Paluh");
        Button botao = new Button("Clique aqui");
        botao.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Clicou no botão");
            }
            
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(botao);
        primaryStage.setScene(new Scene(root,300,250));
        primaryStage.show();
    }
}
