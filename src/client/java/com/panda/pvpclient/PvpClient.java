package com.panda.pvpclient;
import net.fabricmc.api.ClientModInitializer;
public class PvpClient implements ClientModInitializer {
    public static final String NAME = "PandaPvP";
    public static ModuleManager modules;
    @Override public void onInitializeClient() { modules = new ModuleManager(); modules.init(); }
}
