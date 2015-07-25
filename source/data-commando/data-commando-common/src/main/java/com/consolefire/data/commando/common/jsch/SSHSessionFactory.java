/**
 * 
 */
package com.consolefire.data.commando.common.jsch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * @author sabuj.das
 *
 */
public final class SSHSessionFactory {
	
	private static SSHSessionFactory instance;
	private final JSch jsch;
	private Map<String, Session> sessionCache;
	
	private SSHSessionFactory(){
		jsch = new JSch();
		java.util.Properties config = new java.util.Properties(); 
        config.put("StrictHostKeyChecking", "no");
        config.put("Compression", "yes");
        config.put("ConnectionAttempts","2");
		sessionCache = new HashMap<>();
	}
	
	public synchronized Session getSession(String hotName){
		if(!StringUtils.hasText(hotName)){
			
		}
		return null;
	}
	
	public synchronized Session getSession(String hotName, boolean createNew){
		if(!StringUtils.hasText(hotName)){
			
		}
		return null;
	}
	
}
