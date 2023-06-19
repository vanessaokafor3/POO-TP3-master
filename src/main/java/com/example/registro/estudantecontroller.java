package com.example.registro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class estudantecontroller {
    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField nomeTextField;
    @FXML
    public TextField emailTextField;
    @FXML
    public TextField apelidoTextField;
    @FXML
    public TextField passwordField;

    @FXML
    private Button cancelButton;

    public void cancelButton(ActionEvent event){
        Stage stage= (Stage)  cancelButton.getScene().getWindow();
        stage.close();
    }


    public void registroaluno() {





        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String nome = nomeTextField.getText();
        String apelido = apelidoTextField.getText();
        String password = passwordField.getText();


        String insertFiels = "INSERT INTO aluno (username,email,nome,apelido,password) VALUES ('";
        String insertValues = username + "','" + email + "','" + nome + "','" + apelido + "','" + password + ",')";

        String insertToRegister = insertFiels + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}
