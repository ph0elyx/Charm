package svenhjol.charm.mixin.accessor;

import net.minecraft.block.Block;
import net.minecraft.item.HoeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(HoeItem.class)
public interface HoeItemAccessor {
    @Accessor("EFFECTIVE_BLOCKS")
    static Set<Block> getEffectiveBlocks() {
        throw new IllegalStateException();
    }
}
