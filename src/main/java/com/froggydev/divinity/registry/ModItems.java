package com.froggydev.divinity.registry;


import com.froggydev.divinity.DivinityMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DivinityMod.MODID);
    public static final RegistryObject<Item> HOLY_TORCH = ITEMS.register("holy_torch", () -> new Item(new Item.Properties().tab(DivinityMod.DIVINITY_TAB)));
}
