package com.app.everyday.utils.eventbus;

import de.greenrobot.event.EventBusException;

public class EventBusModel {

	
	public EventBusModel( int type,Object model,String message){
		this.type = type;
		this.model = model;
		this.message = message;
	}
	private int type;
	private Object model;
	private String message;
	private int anInt;
	public int getType() {
		return type;
	}
	public Object getModel() throws EventBusException{
		return model;
	}
	public String getMessage(){
		return message;
	}
	public EventBusModel( int type,Object model,String message,int anInt){
		this.type = type;
		this.model = model;
		this.message = message;
		this.anInt = anInt;
	}

	public int getAnInt(){
		return anInt;
	}
}
