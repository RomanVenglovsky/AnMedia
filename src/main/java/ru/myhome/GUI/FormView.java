package ru.myhome.GUI;

import java.util.Map;

import javafx.scene.Parent;

public class FormView {
	
	private Map<String,Parent> view;
    private Map<String,Object> controller;
    
    public FormView(Map<String,Parent> view, Map<String,Object> controller) {
        this.view = view;
        this.controller = controller;
    }
    public Parent getView(String key) {
        return view.get(key);
    }
    public Map<String,Parent> getViewList() {
        return view;
    }
    public void setView(Map<String,Parent> view) {
        this.view = view;
    }
    public Object getController(String key) {
        return controller.get(key);
    }
    public Map<String,Object> getControllerList() {
        return controller;
    }
    public void setController(Map<String,Object> controller) {
        this.controller = controller;
    }

}
