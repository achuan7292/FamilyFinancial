package com.family.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.family.service.BillService;

public class NFDFlightDataTaskListener implements ServletContextListener {
	
	BillService billService = (BillService) ApplicationContextUtil.getBean("billService");
	 @Override  
	    public void contextDestroyed(ServletContextEvent arg0) {  
	        //销毁时的代码  
	    }  
	    @Override  
	        //在服务启动时，执行此方法。  
	    public void contextInitialized(ServletContextEvent arg0) {  
	        new TimerManager();  
	    }  
	  //要执行的任务  
	    class NFDFlightDataTimerTask extends TimerTask{  
	        @Override  
	        //此方法为具体要定时操作的方法  
	        public void run() {  
	        	billService.updateDataBase();
	        }  
	    }  
	    class TimerManager{  
	        private static final long PERIOD_DAY=6 * 10000 * 60*24;  //每隔一天执行一次  
	        public TimerManager() {                     
	            Timer timer = new Timer();     //定时器实例化   
	             NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();   //要执行的任务  
	             SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	             Date date = null;
				try {
					//从4月15开始每天执行一次
					
					date = d.parse("2019-04-15 15:27:00");
				} catch (ParseException e) {
					e.printStackTrace();
				}
	             //安排指定的任务在指定的时间开始进行重复的固定延迟执行。     
	                  timer.schedule(task,date,PERIOD_DAY);    
	           }      
	    }  
	
}
