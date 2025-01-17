package io.github.mortuusars.sootychimneys;

import io.github.mortuusars.sootychimneys.integration.create.CreateIntegration;
import io.github.mortuusars.sootychimneys.config.CommonConfig;
import io.github.mortuusars.sootychimneys.core.WindGetter;
import io.github.mortuusars.sootychimneys.setup.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SootyChimneys.MOD_ID)
public class SootyChimneys
{
    public static final String MOD_ID = "sootychimneys";

    public static boolean debug = false;

    public SootyChimneys()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);

        Registry.init();
        MinecraftForge.EVENT_BUS.addListener(WindGetter::onPlayerTick);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);

        if (debug)
            MinecraftForge.EVENT_BUS.addListener(WindGetter::onRightClick);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        if (ModList.get().isLoaded("create")) {
            CreateIntegration.registerMovingBehaviors();
        }
    }

    public static ResourceLocation resource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
