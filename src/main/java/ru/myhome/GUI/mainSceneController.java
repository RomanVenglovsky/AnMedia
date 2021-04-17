package ru.myhome.GUI;

import ru.myhome.Main;
import ru.myhome.bridge.BridgeInterface;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mainSceneController implements Controller, InitializingBean{
	
	@Qualifier("testDao")
	@Autowired
	private BridgeInterface amDao;
	
	@FXML
    private Button btnLogin;
	
	@FXML
    private PasswordField psfPassword;
	@FXML
    private Label labelHello;

	@FXML
	private TextField txfLogin;
	
	@FXML
    void onBtnLoginClick(ActionEvent event) {
		
		String login = txfLogin.getText();
		String password = psfPassword.getText();
		//System.out.println("Login: " + login + "\nPassword: " + password);
		System.out.println(amDao);
		//if(amDao.validateUser(login, password)) labelHello.setText("Hello " + login);
		if(amDao.validateUser(login, password)) {
			Stage stage = (Stage) btnLogin.getScene().getWindow();
			stage.close();
			Main.changeRoot("addTimeScene");
		}
		else labelHello.setText("validate failed");
    }

	@Override
	public void setScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet from main scene");
		txfLogin.setText("admin");
		psfPassword.setText("root");
	}
}
