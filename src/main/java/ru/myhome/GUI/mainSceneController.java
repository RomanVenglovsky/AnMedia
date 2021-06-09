package ru.myhome.GUI;

import ru.myhome.CurentUser;
import ru.myhome.Main;
import ru.myhome.bridge.BridgeInterface;
import ru.myhome.model.Person;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mainSceneController implements Controller, InitializingBean, Initializable{
	
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
		System.out.println("amDAO: " + amDao);
		Optional<Person> currentUser = amDao.validateUser(login, password);
		if(currentUser.isPresent()) {
			CurentUser.set(currentUser.get());
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
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BuilderDao.class);
		PersonDao personDao = context.getBean("jpaPesronService", PersonDao.class);
		WorkdayDao workdayDao = context.getBean("jpaWorkdayService", WorkdayDao.class);
		WorktimeDao worktimeDao = context.getBean("jpaWorktimeService", WorktimeDao.class);
		System.out.println("Context created!!!");*/
		txfLogin.setText("+79771106575");
		psfPassword.setText("root");
	}
	
}
