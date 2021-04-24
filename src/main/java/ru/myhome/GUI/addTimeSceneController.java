package ru.myhome.GUI;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import ru.myhome.Main;
import ru.myhome.bridge.BridgeInterface;
import ru.myhome.model.Workday;
import ru.myhome.model.Worktime;

public class addTimeSceneController implements Controller, InitializingBean{
	
	@Qualifier("testDao")
	@Autowired
	private BridgeInterface amDao;
	private ObservableList<Worktime> items;
	
	public ObservableList<Worktime> getItems() {
		return items;
	}
	public void setItems(ObservableList<Worktime> items) {
		this.items = items;
	}

	@FXML private AnchorPane anchorPane;
	@FXML private TableView<Worktime> tblDateTime;
	@FXML private TableColumn<Worktime, Date> dateColumn;
	@FXML private TableColumn<Worktime, Time> timeAColumn;
	@FXML private TableColumn<Worktime, Time> timeBColumn;
	@FXML private Button btnAdd;
	@FXML private DatePicker dtpDate;
	@FXML private TextField txfStartTime;
	@FXML private TextField txfEndTime;
	
	
	@FXML
    void onBtnAddClick(ActionEvent event) {
		LocalDate d = dtpDate.getValue();
		LocalTime a = LocalTime.parse(txfStartTime.getText());
		LocalTime b = LocalTime.parse(txfEndTime.getText());
		/*Worktime wt = new WorktimeTest(d,a,b);
		amDao.addWorktime(wt);
		items.add(wt);*/
    }
	
	
	
	@FXML
	public void initialize() {
		dateColumn.setCellValueFactory(new PropertyValueFactory<Worktime,Date>("date"));
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		dateColumn.setCellFactory(tc -> new TableCell<Worktime, Date>() {
		    @Override
		    protected void updateItem(Date date, boolean empty) {
		        super.updateItem(date, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            setText(new SimpleDateFormat("dd.MM.YYYY").format(date));
		        }
		    }
		});
		timeAColumn.setCellValueFactory(new PropertyValueFactory<Worktime, Time>("starttime"));
		timeBColumn.setCellValueFactory(new PropertyValueFactory<Worktime, Time>("endtime"));
		//anchorPane.addEventHandler(, eventHandler);
		anchorPane.addEventHandler(eventType., eventHandler);
		for(Workday temp: Main.getCurrentUser().getWorkdays()) {
			items.addAll(temp.getWorktimes());
		}
		tblDateTime.setItems(items);
		LocalDate date = LocalDate.now();
		dtpDate.setValue(date);
	}

    @Override
	public void setScene() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
