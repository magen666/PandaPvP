package com.panda.pvpclient;
import com.panda.pvpclient.modules.*; import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents; import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper; import net.minecraft.client.option.KeyBinding; import net.minecraft.client.util.InputUtil; import net.minecraft.text.Text; import org.lwjgl.glfw.GLFW; import java.util.ArrayList; import java.util.List;
public class ModuleManager {
    public final List<Module> modules = new ArrayList<>();
    public void init() {
        modules.add(new KillAura()); modules.add(new AimAssist()); modules.add(new Hitboxes()); modules.add(new XRay());
        for (Module m : modules) m.register();
        KeyBinding guiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.pvpclient.gui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_L, "category.pvpclient"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (guiKey.wasPressed()) { if (client.currentScreen == null) client.setScreen(new com.panda.pvpclient.gui.ClickGUI()); }
            for (Module m : modules) { while (m.key.wasPressed()) { m.toggle(); } if (m.enabled) m.onTick(); }
        });
    }
    public <T extends Module> T get(Class<T> clazz) { for (Module m : modules) if (clazz.isInstance(m)) return clazz.cast(m); return null; }
}
