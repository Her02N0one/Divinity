package com.froggydev.divinity.registry;

import com.froggydev.divinity.DivinityMod;
import com.froggydev.divinity.block.BonfireBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DivinityMod.MODID);

    public static final RegistryObject<Block> BONFIRE = registerBlock("bonfire",
            () -> new BonfireBlock(BlockBehaviour.Properties.copy(Blocks.CAMPFIRE)), new Item.Properties().stacksTo(1).tab(DivinityMod.DIVINITY_TAB));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        return registerBlock(name, block, new Item.Properties().tab(tab));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemProperties);
        return toReturn;
    }

    public static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties itemProperties){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                itemProperties));
    }
}
