package com.t.alexcavescaver;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AlexCavesCaver.MODID)
public class AlexCavesCaver {
    public static final String MODID = "alexcavescaver";
    public static final Logger LOGGER = LogManager.getLogger();

    public AlexCavesCaver() {
        LOGGER.info("Alex Caves Caver loaded - tablet puzzles will auto-solve");
    }
}
