package ru.myhome.GUI;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import ru.myhome.CurentUser;
import ru.myhome.bridge.BridgeInterface;
import ru.myhome.dao.BuilderDao;
import ru.myhome.dao.interfaces.WorkdayDao;
import ru.myhome.dao.interfaces.WorktimeDao;
import ru.myhome.model.Workday;
import ru.myhome.model.WorkdayPK;
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
		
		Worktime wt = new Worktime();
		wt.setStarttime(Time.valueOf(a));
		wt.setEndtime(Time.valueOf(b));
		
		WorkdayPK wdId = new WorkdayPK();
		wdId.setDate(Date.valueOf(d));
		wdId.setPersonId(CurentUser.getId());
		Workday wd;
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BuilderDao.class)){
			
			WorkdayDao wdDao = context.getBean("jpaWorkdayService", WorkdayDao.class);
			Optional<Workday> tempWd = wdDao.getWorkday(wdId);
			if(tempWd.isPresent()) {
				System.out.println("isPresent");
				wd = tempWd.get();
			}
			else{
				System.out.println("is not Present");
				wd = new Workday();
				wd.setId(wdId);
				wd.setWorktimes(new ArrayList<Worktime>());
			}
		/*try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BuilderDao.class)){
			WorktimeDao wtDao = context.getBean("jpaWorktimeService", WorktimeDao.class);*/
			wd.addWorktime(wt);
			//wt.setWorkday(wd);
			wdDao.addWorkday(wd);
			items.add(wt);
		}
    }
	@FXML
	public void initialize() {
		System.out.println("addTimeSceneController: initialize()");
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
		System.out.println("addTimeSceneController:\n\tCurrentUser: " + CurentUser.get());
		items = FXCollections.observableArrayList();
		if(CurentUser.get().getWorkdays() != null) {
			System.out.println("addTimeSceneController: Load workdays list");
			int i = 1;
			for(Workday temp: CurentUser.getWorkdays()) {
				System.out.println("\t" + i++ + " " + temp);
				items.addAll(temp.getWorktimes());
			}
			System.out.println(items);
			System.out.println("addTimeSceneController: Load workdays is finish");
						
			SortedList<Worktime> sortedData = new SortedList<>(items);
			sortedData.comparatorProperty().bind(tblDateTime.comparatorProperty());
			
			tblDateTime.setItems(sortedData);
			tblDateTime.getSortOrder().add(dateColumn);
			tblDateTime.getSortOrder().add(timeAColumn);
			LocalDate date = LocalDate.now();
			dtpDate.setValue(date);
		}else System.out.println("addTimeSceneController: Workdays list is null");
		
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
