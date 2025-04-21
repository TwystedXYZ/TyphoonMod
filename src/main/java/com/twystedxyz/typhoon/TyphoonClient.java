package com.twystedxyz.typhoon;

import net.fabricmc.api.ClientModInitializer;

public class TyphoonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Typhoon.LOGGER.info("Activating TyphoonMod");
    }}