package com.murari.listener;

import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class IOCContainerMonitoringListener implements ApplicationListener {
	
	private long start,end;
	
	public  IOCContainerMonitoringListener() {
		System.out.println("IOCContainerMonitoringListener.IOCContainerMonitoringListener()");
	}
	
	@Override
	public void onApplicationEvent(ApplicationEvent e) {
		if(e.toString().indexOf("ContextRefreshed")!=-1) {
			start=System.currentTimeMillis();
			System.out.println("IOC container is started at"+new Date());
		}
		else if(e.toString().indexOf("ContextClosed")!=-1) {
			end=System.currentTimeMillis();
			System.out.println("IOC container is stopped at"+new Date());
			System.out.println("IOC container active duration is"+(end-start));
		}
		
	}

}
