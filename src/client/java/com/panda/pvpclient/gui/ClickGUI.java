package com.panda.pvpclient.gui;
import net.minecraft.client.gui.DrawContext; import net.minecraft.client.gui.screen.Screen; import net.minecraft.text.Text;
public class ClickGUI extends Screen {
    public ClickGUI() { super(Text.literal("PandaPvP")); }
    @Override public void render(DrawContext ctx, int mx, int my, float delta) { ctx.drawTextWithShadow(this.textRenderer, "PandaPvP GUI", 20, 20, 0xFFFFFF); super.render(ctx, mx, my, delta); }
}
