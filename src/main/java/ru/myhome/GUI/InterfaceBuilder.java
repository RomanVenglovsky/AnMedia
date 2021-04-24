package ru.myhome.GUI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import ru.myhome.bridge.BridgeInterface;
import ru.myhome.bridge.GuiBridgeDao;

@Configuration
public class InterfaceBuilder {
	
	
	@Bean(name = "testDao")
	@Lazy
	public BridgeInterface getDao(){
		BridgeInterface testDao = new GuiBridgeDao();
        return testDao;
    }

	@Bean(name = "mainView")
	@Scope("singleton")
	public FormView getMainView() throws IOException {
		//System.out.println(getClass().getResource("mainScene.fxml") + "!");
        return loadView(new String[]{"mainScene", "addTimeScene"});
    }
	/**
     * Именно благодаря этому методу мы добавили контроллер в контекст спринга,
     * и заставили его произвести все необходимые инъекции.
     */
    /*@Bean
    public Map<String,Object> getMainController() throws IOException {
        
    	Map<String,Object> controllers = new HashMap<String, Object>();
    	Map<String,Parent> parentList = getMainView().getViewList();
    	for(Map.Entry<String, Parent> item : parentList.entrySet()){
    		String contName = item + "Controller";
            controllers.put(contName, item.getValue());
        }
    	return controllers;
    }*/
	@Bean
    public mainSceneController getMainController() throws IOException {
        return (mainSceneController) getMainView().getController("mainSceneController");
    }
	@Bean
    public addTimeSceneController getAddTimeController() throws IOException {
        return (addTimeSceneController) getMainView().getController("addTimeSceneController");
    }
	
	
    /**
     * Самый обыкновенный способ использовать FXML загрузчик.
     * Как раз-таки на этом этапе будет создан объект-контроллер,
     * произведены все FXML инъекции и вызван метод инициализации контроллера.
     */
    protected FormView loadView(String[] url) throws IOException {
        try {
        	Map<String,Parent> parentList = new HashMap<String,Parent>();
        	Map<String,Object> controllerList = new HashMap<String,Object>();
            for(String item: url) {
            	System.out.println(getClass().getResource(item + ".fxml"));
            	FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(item + ".fxml"));
                loader.load();
               //if(!parentList.containsKey(item))
                String contName = item + "Controller";
                controllerList.put(contName, loader.getController());
                parentList.put(item, loader.getRoot());
            }
            return new FormView(parentList, controllerList);
        } finally {
            
        }
    }
}
