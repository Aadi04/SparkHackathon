package javaFiles.controllers;

import javaFiles.Scenes;
import javaFiles.util.DbConnection;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddingMoreInfoController
{

    LogsController logsController;
    public TextField wakingUpField;
    public TextField sleepingTimeField;
    public TextField dayField;
    public RadioButton radio1, radio2;

    public void addButtonClicked(MouseEvent mouseEvent) throws SQLException
    {
        addData();
        LogsController.getPopUpStage().close();
        logsController.clearTableView();
        logsController.loadData();
    }

    private void addData() throws SQLException
    {
        Connection connection = DbConnection.connection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO userdata (Day, BedTime, TimeWokeUp, TotalHoursOfSleep) VALUES (?,?,?,?)");

        ps.setString(1, dayField.getText());
        ps.setString(2, sleepingTimeField.getText());
        ps.setString(3, wakingUpField.getText());
        ps.setString(4, "8");

        ps.execute();

        connection.close();
        ps.close();
    }

    public void setLogsController(LogsController logsController)
    {
        this.logsController = logsController;
    }

}
