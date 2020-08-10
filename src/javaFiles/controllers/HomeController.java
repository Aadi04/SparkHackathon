package javaFiles.controllers;

import javaFiles.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable
{
    @FXML
    ImageView imageView;
    Scenes scenes = new Scenes();
    LogsController logsController = new LogsController();

    public void onClickedOnLogs(MouseEvent mouseEvent) throws IOException
    {
        logsController.showLogsScene();
    }

    public void onClickedOnActivities(MouseEvent mouseEvent) throws IOException
    {
        scenes.showActivityScene();
    }

    public void onClickedOnGraphs(MouseEvent mouseEvent) throws IOException
    {
        scenes.showProgress();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Image img = new Image("/resources/imgs/logo.png");
        imageView.setImage(img);
    }
}
