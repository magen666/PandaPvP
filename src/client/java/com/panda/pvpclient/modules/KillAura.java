package com.panda.pvpclient.modules;
import com.panda.pvpclient.Module; import com.panda.pvpclient.util.Humanizer; import net.minecraft.client.MinecraftClient; import net.minecraft.entity.LivingEntity; import net.minecraft.util.Hand; import net.minecraft.util.math.Box; import org.lwjgl.glfw.GLFW; import java.util.Comparator; import java.util.List;
public class KillAura extends Module {
    public KillAura() { super("KillAura", GLFW.GLFW_KEY_I); }
    @Override public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null || mc.world == null || mc.interactionManager == null) return;
        if (Humanizer.isPaused()) return;
        Box box = mc.player.getBoundingBox().expand(3.5);
        List<LivingEntity> list = mc.world.getEntitiesByClass(LivingEntity.class, box, e -> e != mc.player && e.isAlive());
        LivingEntity target = list.stream().min(Comparator.comparingDouble(e -> e.squaredDistanceTo(mc.player))).orElse(null);
        if (target == null || mc.player.distanceTo(target) > 3.5) return;
        double dx = target.getX() - mc.player.getX(), dz = target.getZ() - mc.player.getZ();
        mc.player.setYaw((float)(Math.toDegrees(Math.atan2(dz, dx)) - 90.0));
        if (mc.player.getAttackCooldownProgress(0.5f) >= 0.9f && !Humanizer.shouldMiss(3.0)) {
            mc.interactionManager.attackEntity(mc.player, target); mc.player.swingHand(Hand.MAIN_HAND);
        }
    }
}
