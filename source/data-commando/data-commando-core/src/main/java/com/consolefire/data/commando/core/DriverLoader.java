package com.consolefire.data.commando.core;

import java.io.File;

import com.consolefire.data.commando.core.driver.DriverInfo;
import com.consolefire.data.commando.core.exception.UnsupportedDriverException;

/**
 * @author sabuj.das
 *
 */
public interface DriverLoader {

	DriverType getDriverType();
	
	DriverInfo load(String name, String fileName) throws UnsupportedDriverException;
	DriverInfo load(String name, File file) throws UnsupportedDriverException;
	
}
