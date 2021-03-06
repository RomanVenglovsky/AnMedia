package ru.myhome;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.myhome.GUI.FormView;
import ru.myhome.GUI.InterfaceBuilder;

public class Main extends Application{
	
	@Qualifier("mainView")
    @Autowired
	private FormView view;
	private static Scene scene;
	
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {

		try(AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(InterfaceBuilder.class)){
			context.getAutowireCapableBeanFactory().autowireBean(this);
			scene = new Scene(view.getView("mainScene"));
			stage.setScene(scene);
			stage.initStyle(StageStyle.UTILITY);
			//stage.setResizable(false);
			stage.setAlwaysOnTop(true);
			stage.show();
		}
	}
	public static void changeRoot(String name) {
		try(AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(InterfaceBuilder.class)){
			
			scene.setRoot(context.getBean(FormView.class).getView(name));
			Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(scene);
            stage.show();
            // Hide this current window (if this is what you want)
		}
	}

	/*private static Parent getParent(String name) {
		return view.getView(name);
	}*/
}
