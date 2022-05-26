package com.froggydev.divinity;

import com.froggydev.divinity.registries.Blocks;
import com.froggydev.divinity.registries.Items;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DivinityMod.MODID)
public class DivinityMod
{
    public static final String MODID = "divinity";
    public static final net.minecraft.world.item.CreativeModeTab DIVINITY_TAB = new net.minecraft.world.item.CreativeModeTab("divinitytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.HOLY_TORCH.get());
        }
    };
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public DivinityMod()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Items.register(eventBus);
        Blocks.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }


}
