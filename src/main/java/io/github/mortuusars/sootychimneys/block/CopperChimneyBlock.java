package io.github.mortuusars.sootychimneys.block;

import io.github.mortuusars.sootychimneys.core.ChimneySmokeProperties;
import io.github.mortuusars.sootychimneys.core.ISootyChimney;
import io.github.mortuusars.sootychimneys.setup.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("NullableProblems")
public class CopperChimneyBlock extends ChimneyBlock implements ISootyChimney {

    private static final VoxelShape _shape = Shapes.or(
            Block.box(5,0,5, 11,4,11),
            Block.box(6,4,6, 10,16,10),
            Block.box(5,10,5, 11,14,11));

    public CopperChimneyBlock() {
        super(new ChimneySmokeProperties(0.5f, 1.25f, 0.5f, 0.025f, 0.05f, 0.025f)
                .setIntensity(0.5f)
                .setSpeed(1.2f),
            BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
                    .sound(SoundType.COPPER)
                    .strength(2f, 2f)
                    .destroyTime(2f)
                    .requiresCorrectToolForDrops());
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return _shape;
    }

    @Override
    public Block getCleanVariant() {
        return ModBlocks.COPPER_CHIMNEY.get();
    }

    @Override
    public Block getDirtyVariant() {
        return ModBlocks.DIRTY_COPPER_CHIMNEY.get();
    }
}
