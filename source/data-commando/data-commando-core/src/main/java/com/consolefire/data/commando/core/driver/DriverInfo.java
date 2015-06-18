/**
 * 
 */
package com.consolefire.data.commando.core.driver;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sabuj.das
 *
 */
@Getter
@Setter
public class DriverInfo {

	private String name;
	private String defaultDriverName;
	private String[] otherDriverNames;
	private String fileName;
	private boolean loaded;
	
	public DriverInfo(String name) {
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof DriverInfo)) {
			return false;
		}
		DriverInfo other = (DriverInfo) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	
}
