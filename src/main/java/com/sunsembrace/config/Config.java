package com.sunsembrace.config;

import com.sunsembrace.SunsEmbraceMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = SunsEmbraceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
  private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

  private static final ForgeConfigSpec.IntValue SOLAR_FURNACE_MIN_SKYLIGHT =
      BUILDER
          .comment("Minimum skylight value for the solar furnaces to work")
          .defineInRange("solar_furnace_min_skylight", 7, 0, 15);

  private static final ForgeConfigSpec.IntValue SOLAR_FURNACE_RECHARGE_RATE =
      BUILDER
          .comment("Recharge rate in ticks for the solar furnaces when getting enough skylight")
          .defineInRange("solar_furnace_recharge_rate", 2, 0, Integer.MAX_VALUE);

  private static final ForgeConfigSpec.IntValue SOLAR_FURNACE_MAX_CHARGE =
      BUILDER
          .comment("Max charge stored in the solar furnace")
          .defineInRange("solar_furnace_max_charge", 1000, 0, Integer.MAX_VALUE);

  public static final ForgeConfigSpec SPEC = BUILDER.build();

  public static int solarFurnaceMinSkylight;
  public static int solarFurnaceRechargeRate;
  public static int solarFurnaceMaxCharge;

  @SubscribeEvent
  static void onLoad(final ModConfigEvent event) {
    solarFurnaceMinSkylight = SOLAR_FURNACE_MIN_SKYLIGHT.get();
    solarFurnaceRechargeRate = SOLAR_FURNACE_RECHARGE_RATE.get();
    solarFurnaceMaxCharge = SOLAR_FURNACE_MAX_CHARGE.get();
  }
}
