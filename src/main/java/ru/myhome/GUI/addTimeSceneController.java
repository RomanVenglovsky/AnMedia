package ru.myhome.GUI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.myhome.bridge.BridgeInterface;
import ru.myhome.model.intefaces.Worktime;
import ru.myhome.test.WorktimeTest;

public class addTimeSceneController implements Controller, InitializingBean{
	
	@Qualifier("testDao")
	@Autowired
	private BridgeInterface amDao;
	private ObservableList<Worktime> items;
	
	@FXML private TableView<Worktime> tblDateTime;
	@FXML private TableColumn<Worktime, LocalDate> dateColumn;
	@FXML private TableColumn<Worktime, LocalTime> timeAColumn;
	@FXML private TableColumn<Worktime, LocalTime> timeBColumn;
	@FXML private Button btnAdd;
	@FXML private DatePicker dtpDate;
	@FXML private TextField txfStartTime;
	@FXML private TextField txfEndTime;
	
	
	@FXML
    void onBtnAddClick(ActionEvent event) {
		LocalDate d = dtpDate.getValue();
		LocalTime a = LocalTime.parse(txfStartTime.getText());
		LocalTime b = LocalTime.parse(txfEndTime.getText());
		Worktime wt = new WorktimeTest(d,a,b);
		amDao.addWorktime(wt);
		items.add(wt);
    }
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		dateColumn.setCellValueFactory(new PropertyValueFactory<Worktime, LocalDate>("date"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		dateColumn.setCellFactory(tc -> new TableCell<Worktime, LocalDate>() {
		    @Override
		    protected void updateItem(LocalDate date, boolean empty) {
		        super.updateItem(date, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            setText(formatter.format(date));
		        }
		    }
		});
		timeAColumn.setCellValueFactory(new PropertyValueFactory<Worktime, LocalTime>("startTime"));
		timeBColumn.setCellValueFactory(new PropertyValueFactory<Worktime, LocalTime>("endTime"));
		
		items = FXCollections.observableArrayList(amDao.getWorktimeList().values());
		tblDateTime.setItems(items);
		LocalDate date = LocalDate.now();
		dtpDate.setValue(date);
	}

    @Override
	public void setScene() {
		// TODO Auto-generated method stub
		
	}
}
