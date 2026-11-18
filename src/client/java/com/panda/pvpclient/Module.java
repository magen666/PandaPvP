package com.panda.pvpclient;
import com.panda.pvpclient.gui.Value; import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper; import net.minecraft.client.option.KeyBinding; import net.minecraft.client.util.InputUtil; import java.util.ArrayList; import java.util.List;
public abstract class Module {
    public final String name; private final int defaultKey; public boolean enabled, expanded; public KeyBinding key; public List<Value> values = new ArrayList<>();
    protected Module(String name, int key) { this.name = name; this.defaultKey = key; }
    public void register() { key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.pvpclient." + name.toLowerCase(), InputUtil.Type.KEYSYM, defaultKey, "category.pvpclient")); }
    public void toggle() { enabled = !enabled; }
    public void onTick() {}
}
