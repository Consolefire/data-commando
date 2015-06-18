/**
 * 
 */
package com.consolefire.data.commando.core.driver;

import java.io.File;

import com.consolefire.data.commando.core.DriverLoader;
import com.consolefire.data.commando.core.DriverType;
import com.consolefire.data.commando.core.exception.UnsupportedDriverException;

/**
 * @author sabuj.das
 *
 */
public class MysqlDriverLoader implements DriverLoader {

	private static final DriverContainer DRIVER_CONTAINER 
		= DriverContainer.getContainer();
	@Override
	public DriverType getDriverType() {
		return DriverType.MYSQL;
	}

	@Override
	public DriverInfo load(String name, String fileName)
			throws UnsupportedDriverException {
		return load(fileName, new File(fileName));
	}

	@Override
	public DriverInfo load(String name, File file)
			throws UnsupportedDriverException {
		// TODO Auto-generated method stub
		return null;
	}

}
