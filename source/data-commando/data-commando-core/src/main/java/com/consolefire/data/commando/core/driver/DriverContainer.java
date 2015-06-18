/**
 * 
 */
package com.consolefire.data.commando.core.driver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consolefire.data.commando.core.DriverLoader;

/**
 * @author sabuj.das
 *
 */
public class DriverContainer {

	private final Map<String, DriverInfo> driverInfoCache;
	
	private static DriverContainer container;
	
	private DriverContainer(){
		driverInfoCache = new HashMap<>();
	}
	
	public static DriverContainer getContainer(){
		if(null == container){
			synchronized (DriverContainer.class) {
				if(null == container){
					container = new DriverContainer();
				}
			}
		}
		return container;
	}
	
	public void addDriver(DriverInfo driverInfo){
		if(null != driverInfo){
			driverInfoCache.put(driverInfo.getFileName(), driverInfo);
		}
	}
}
