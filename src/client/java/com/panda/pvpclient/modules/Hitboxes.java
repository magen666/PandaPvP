package com.panda.pvpclient.modules;
import com.panda.pvpclient.Module; import org.lwjgl.glfw.GLFW;
public class Hitboxes extends Module {
    public float expandXZ = 0.5f, expandY = 0.0f;
    public Hitboxes() { super("Hitboxes", GLFW.GLFW_KEY_B); }
}
