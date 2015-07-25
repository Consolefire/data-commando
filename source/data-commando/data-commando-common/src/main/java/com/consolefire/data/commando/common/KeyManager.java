/**
 * 
 */
package com.consolefire.data.commando.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import lombok.Getter;

/**
 * @author sabuj.das
 *
 */
public final class KeyManager {
	private static final Logger logger = LoggerFactory.getLogger(KeyManager.class);
	private static KeyManager manager;
	private final Map<String, KeyPair> KEY_PAIR_MAP;
	
	private KeyManager(){
		KEY_PAIR_MAP = new HashMap<>();
	}
	
	
	public static KeyManager getManager() {
		if(null == manager){
			synchronized (KeyManager.class) {
				if(null == manager){
					manager = new KeyManager();
				}
			}
		}
		return manager;
	}

	public KeyPair getKey(String alias){
		return KEY_PAIR_MAP.get(alias);
	}
	
	public synchronized void addKey(String alias, String key, String value){
		if(!StringUtils.hasText(alias)){
			alias = key;
		}
		if(!StringUtils.hasText(key)){
			throw new RuntimeException("Invalid Key");
		}
		KeyPair keyPair = new KeyPair(alias, key, value);
		if(KEY_PAIR_MAP.containsKey(alias)){
			throw new RuntimeException("Key already added");
		}
		KEY_PAIR_MAP.put(alias, keyPair);
	}
	
	public synchronized void updateKey(String alias, String key, String value){
		if(!StringUtils.hasText(alias)){
			alias = key;
		}
		if(!StringUtils.hasText(key)){
			throw new RuntimeException("Invalid Key");
		}
		KeyPair keyPair = new KeyPair(alias, key, value);
		if(KEY_PAIR_MAP.containsKey(alias)){
			KEY_PAIR_MAP.put(alias, keyPair);
		}
		
	}
	
	@Getter
	private static final class KeyPair{
		private final String alias;
		private final String key;
		private final String value;
		
		public KeyPair(String alias, String key, String value) {
			this.alias = alias;
			this.key = key;
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((alias == null) ? 0 : alias.hashCode());
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof com.consolefire.data.commando.common.KeyManager.KeyPair)) {
				return false;
			}
			KeyPair other = (KeyPair) obj;
			if (alias == null) {
				if (other.alias != null) {
					return false;
				}
			} else if (!alias.equals(other.alias)) {
				return false;
			}
			if (key == null) {
				if (other.key != null) {
					return false;
				}
			} else if (!key.equals(other.key)) {
				return false;
			}
			return true;
		}
		
		
		
	}
	
	
	
}
