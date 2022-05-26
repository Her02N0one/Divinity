package com.froggydev.divinity.registries;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.froggydev.divinity.DivinityMod.MODID;

public class DivinityBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> BONFIRE = registerBlock("bonfire",
            () -> new Block(BlockBehaviour.Properties.of(Material.FIRE)
                    .strength(9f).requiresCorrectToolForDrops()), new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        return registerBlock(name, block, new Item.Properties().tab(tab));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemProperties);
        return toReturn;
    }

    public static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties itemProperties){
        return DivinityItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                itemProperties));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
