package odiwa.wanderingtraderf3.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.spawner.SpecialSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ServerWorld.class)
public interface ServerWorldAccessor {
    @Accessor
    List<SpecialSpawner> getSpawners();
}
