package io.github.mortuusars.sootychimneys.setup;

import io.github.mortuusars.sootychimneys.blocks.BrickChimneyBlock;
import io.github.mortuusars.sootychimneys.blocks.ChimneyBlock;
import io.github.mortuusars.sootychimneys.blocks.StoneBrickChimneyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ModBlocks {
    public static final ArrayList<RegistryObject<? extends ChimneyBlock>> CHIMNEYS_LIST = new ArrayList<>();

    public static final RegistryObject<BrickChimneyBlock> BRICK_CHIMNEY =
            registerChimneyBlock("brick_chimney", () -> new BrickChimneyBlock(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<BrickChimneyBlock> DIRTY_BRICK_CHIMNEY =
            registerChimneyBlock("dirty_brick_chimney", () -> new BrickChimneyBlock(BlockBehaviour.Properties.of(Material.STONE)));

    public static final RegistryObject<StoneBrickChimneyBlock> STONE_BRICK_CHIMNEY =
            registerChimneyBlock("stone_brick_chimney", () -> new StoneBrickChimneyBlock(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<StoneBrickChimneyBlock> DIRTY_STONE_BRICK_CHIMNEY =
            registerChimneyBlock("dirty_stone_brick_chimney", () -> new StoneBrickChimneyBlock(BlockBehaviour.Properties.of(Material.STONE)));

    public static void init(){}

    private static <T extends ChimneyBlock> RegistryObject<T> registerChimneyBlock(String registryName, Supplier<T> blockSupplier){
        RegistryObject<T> block = Registry.BLOCKS.register(registryName, blockSupplier);
        CHIMNEYS_LIST.add(block);
        return block;
    }
}
