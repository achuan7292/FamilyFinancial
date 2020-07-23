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
	        //����ʱ�Ĵ���  
	    }  
	    @Override  
	        //�ڷ�������ʱ��ִ�д˷�����  
	    public void contextInitialized(ServletContextEvent arg0) {  
	        new TimerManager();  
	    }  
	  //Ҫִ�е�����  
	    class NFDFlightDataTimerTask extends TimerTask{  
	        @Override  
	        //�˷���Ϊ����Ҫ��ʱ�����ķ���  
	        public void run() {  
	        	billService.updateDataBase();
	        }  
	    }  
	    class TimerManager{  
	        private static final long PERIOD_DAY=6 * 10000 * 60*24;  //ÿ��һ��ִ��һ��  
	        public TimerManager() {                     
	            Timer timer = new Timer();     //��ʱ��ʵ����   
	             NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();   //Ҫִ�е�����  
	             SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	             Date date = null;
				try {
					//��4��15��ʼÿ��ִ��һ��
					
					date = d.parse("2019-04-15 15:27:00");
				} catch (ParseException e) {
					e.printStackTrace();
				}
	             //����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�     
	                  timer.schedule(task,date,PERIOD_DAY);    
	           }      
	    }  
	
}
