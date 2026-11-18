package com.panda.pvpclient.util;
import java.util.Random;
public class Humanizer {
    private static final Random rng = new Random();
    public static float tremorAmp() { return 0.18f; }
    public static float applyGCD(float value, double sens) { float f = (float) (sens * 0.6 + 0.2); float gcd = f * f * f * 8.0f * 0.15f; return gcd < 0.0001f ? value : Math.round(value / gcd) * gcd; }
    public static boolean isPaused() { return rng.nextFloat() < 0.02f; }
    public static boolean shouldMiss(double dist) { return rng.nextFloat() < 0.05f; }
}
