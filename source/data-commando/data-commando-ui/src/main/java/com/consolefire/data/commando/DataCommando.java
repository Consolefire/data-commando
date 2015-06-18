package com.consolefire.data.commando;

import com.consolefire.data.commando.ui.DataCommandoBaseFrame;
import com.consolefire.data.commando.ui.core.UiUtilities;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.apache.log4j.Logger;

/**
 * @author Sabuj Das | sabuj.das@gmail.com
 *
 */
public class DataCommando {

    public static void main(String[] args) {
        if (UiUtilities.isMacOs()) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Data Commando");
        }

        DataCommandoUiContext.getContext().initContext();
        Logger logger = Logger.getLogger(DataCommando.class);

        try {
            logger.info("Set LaF to " + DataCommandoUiContext.getContext().getAppSettings().getLafClassName());
            UIManager.setLookAndFeel(DataCommandoUiContext.getContext().getAppSettings().getLafClassName());
        } catch (Exception e) {
            logger.error(e);
            try {
                logger.info("Set LaF to " + UIManager.getCrossPlatformLookAndFeelClassName());
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ignore) {

            }
        }
        logger.info("Start App");
        //new GSplitFrame().setVisible(true);
        JFrame f = new DataCommandoBaseFrame();
        if (UiUtilities.isMacOs()) {
            UiUtilities.enableOSXFullscreen(f);
        }
        f.setVisible(true);

    }

}
