package com.froggydev.divinity.block.entity;

import com.froggydev.divinity.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

public class BonfireBlockEntity extends SyncedBlockEntity {
    private static final int NUM_SLOTS = 1;
    private final ItemStackHandler inventory;

    public BonfireBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.BONFIRE.get(), blockPos, blockState);
        inventory = createHandler();
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(NUM_SLOTS)
        {
            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }
        };
    }
}
