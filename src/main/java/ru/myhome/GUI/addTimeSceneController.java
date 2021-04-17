package ru.myhome.GUI;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import ru.myhome.bridge.BridgeInterface;

public class addTimeSceneController implements Controller, Initializable{
	
	@Qualifier("testDao")
	@Autowired
	private BridgeInterface amDao;
	
    @FXML
    private Button btnAdd;

	@FXML
    private DatePicker dtpDate;

	@FXML
    void onBtnAddClick(ActionEvent event) {
		System.out.println("DAO: " + amDao);
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("DAO: " + amDao);
		//DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		LocalDate date = LocalDate.now();
		dtpDate.setValue(date);
	}

    @Override
	public void setScene() {
		// TODO Auto-generated method stub
		
	}
}
