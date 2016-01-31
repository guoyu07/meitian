package com.app.everyday.utils.eventbus;

import de.greenrobot.event.EventBus;

public class EventBusUtils {

	private static EventBusUtils eventBusUtils = null;
	public synchronized static EventBusUtils getInstance(){
		if (eventBusUtils == null) {
			eventBusUtils = new EventBusUtils();
		}
		return eventBusUtils;
	}
	/**
	 * 统一注册eventbus，注册了一定要记得注销
	 */
	public void registerEventBus(Object ob){
		EventBus.getDefault().register(ob);
	}
	/**
	 * 统一注销eventbus
	 */
	public void unRegisterEventBus(Object ob){
		EventBus.getDefault().unregister(ob);
	}

	public void postEventBus(int type,Object ob,String message){
		EventBus.getDefault().post(new EventBusModel(type, ob, message));
	}
	public void postEventBus(int type,Object ob,String message,int anInt){
		EventBus.getDefault().post(new EventBusModel(type, ob ,message,anInt));
	}
	public void initAsyc(EventBusAsyc asyc){
		
	}
	public interface EventBusAsyc{
		public void onEventAsync(EventBusModel ebModel);
	}
	
	public interface EventMainThread{
		public void onEventMainThread(EventBusModel ebModel);
	}
	public interface EventBackgroundThread{
		public void onEventBackgroundThread(EventBusModel ebModel);
	}
}
