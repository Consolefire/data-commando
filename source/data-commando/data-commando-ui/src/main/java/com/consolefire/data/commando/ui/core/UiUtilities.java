package com.consolefire.data.commando.ui.core;

import java.awt.Window;
import java.lang.reflect.Method;

public abstract class UiUtilities {

	
	public static boolean isMacOs(){
		String lcOSName = System.getProperty("os.name").toLowerCase();
		return lcOSName.startsWith("mac os x");
	}
        
        
        /**
     * @param window
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void enableOSXFullscreen(Window window) {
        if(null == window)
            return;
        try {
            Class util = Class.forName("com.apple.eawt.FullScreenUtilities");
            Class params[] = new Class[]{Window.class, Boolean.TYPE};
            Method method = util.getMethod("setWindowCanFullScreen", params);
            method.invoke(util, window, true);
        } catch (ClassNotFoundException e1) {
        } catch (Exception e) {

        }
    }
	
}
