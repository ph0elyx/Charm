package svenhjol.charm.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import svenhjol.charm.base.CharmClientModule;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.module.EntitySpawners;

public class EntitySpawnersClient extends CharmClientModule {
    public EntitySpawnersClient(CharmModule module) {
        super(module);
    }

    @Override
    public void register() {
        BlockRenderLayerMap.INSTANCE.putBlock(EntitySpawners.ENTITY_SPAWNER, RenderLayer.getCutout());
    }
}
