package svenhjol.charm.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.mixin.accessor.BarrelBlockEntityAccessor;
import svenhjol.charm.module.VariantBarrels;

import javax.annotation.Nullable;

public class VariantBarrelBlock extends BarrelBlock implements ICharmBlock {
    protected CharmModule module;
    protected IVariantMaterial type;

    public VariantBarrelBlock(CharmModule module, IVariantMaterial type) {
        super(AbstractBlock.Settings.copy(Blocks.BARREL));

        this.module = module;
        this.type = type;

        this.register(module, type.asString() + "_barrel");
        this.setDefaultState(this.getStateManager()
            .getDefaultState()
            .with(FACING, Direction.NORTH)
            .with(OPEN, false)
        );
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.DECORATIONS;
    }

    @Override
    public void addStacksForDisplay(ItemGroup group, DefaultedList<ItemStack> list) {
        if (enabled())
            super.addStacksForDisplay(group, list);
    }

    @Override
    public boolean enabled() {
        return module.enabled;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return BarrelBlockEntityAccessor.invokeConstructor(VariantBarrels.BLOCK_ENTITY);
    }
}
