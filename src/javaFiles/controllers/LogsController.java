package javaFiles.controllers;

import javaFiles.Main;
import javaFiles.Scenes;
import javaFiles.UserData;
import javaFiles.util.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogsController implements Initializable
{
    Scenes scenes = new Scenes();
    //Table View Items
    @FXML
    private TableView<UserData> tableView;
    @FXML
    private TableColumn<UserData,String> dayCol;
    @FXML
    private TableColumn<UserData,String> bedTimeCol;
    @FXML
    private TableColumn<UserData,String> wokeUpTimeCol;
    @FXML
    private TableColumn<UserData,String> totalHoursCol;

    private static ObservableList<UserData> data = FXCollections.observableArrayList();


    private static Stage stage = new Stage();

    public void showLogsScene() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/logs.fxml"));
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/logs.fxml"));

        Stage stage = Main.getStage();
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setTitle("Logs");
        stage.setScene(scene);
        stage.show();
    }

    public void showPlusScene() throws IOException
    {
        //Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/enteringNewInfo.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/enteringNewInfo.fxml"));
        Parent root = loader.load();

        Stage stage = getPopUpStage();
        Scene scene = new Scene(root);

        AddingMoreInfoController addingMoreInfoController = loader.getController();
        addingMoreInfoController.setLogsController(this);

        stage.setResizable(false);
        stage.setTitle("Add Info");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            loadData();


        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void backButtonClicked(MouseEvent mouseEvent) throws IOException
    {
        scenes.showHomeScene();
    }

    public void plusButtonClicked(MouseEvent mouseEvent) throws IOException
    {
        showPlusScene();
    }

    public void loadData() throws SQLException
    {
        Connection connection = DbConnection.connection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM userdata");
        ResultSet rs = ps.executeQuery();

        while(rs.next())
        {
            data.add(new UserData(rs.getString("Day"),rs.getString("BedTime"), rs.getString("TimeWokeUp"),rs.getString("TotalHoursOfSleep")));
        }

        this.dayCol.setCellValueFactory(new PropertyValueFactory<>("Day"));
        this.bedTimeCol.setCellValueFactory(new PropertyValueFactory<>("BedTime"));
        this.wokeUpTimeCol.setCellValueFactory(new PropertyValueFactory<>("TimeWokeUp"));
        this.totalHoursCol.setCellValueFactory(new PropertyValueFactory<>("TotalHoursOfSleep"));

        tableView.setItems(data);

        connection.close();
        ps.close();
        rs.close();
    }

    public void clearTableView()
    {
        tableView.getItems().clear();
    }


    public static Stage getPopUpStage()
    {
        return stage;
    }


}
