package kikugie.cls;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class CustomLoadingScreen implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("custom-loading-screen");
    public static final File CONFIG_PATH = new File(FabricLoader.getInstance().getConfigDir() + "/custom-loading-screen");

    @Override
    public void onInitialize() {
        if (CONFIG_PATH.mkdir()) {
            LOGGER.info("Initialising Custom Loading Screen config directory.");
        }
    }
}
