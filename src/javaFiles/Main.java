package javaFiles;

import javaFiles.util.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage = getStage();

        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/home.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static Stage getStage()
    {
        return stage;
    }

    public static Scene getScene( Parent root)
    {
       Scene scene = new Scene(root);

       return scene;
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
