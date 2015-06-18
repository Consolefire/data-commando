/**
 * 
 */
package com.consolefire.data.commando.core.driver;

import java.util.Properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Getter
@Setter
public class ConnectionProperties {

	private String host;
	private String port;
	private String user;
	private String password;
	
	private Properties additionalInfo = new Properties();
	
	
}
