package odiwa.wanderingtraderf3.mixin;
import net.minecraft.world.WanderingTraderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WanderingTraderManager.class)
public interface WanderingTraderManagerAccessor {
    //GETS
    @Accessor
    int getSpawnTimer();
    @Accessor
    int getSpawnDelay();
    @Accessor
    int getSpawnChance();
    //SETS
    @Accessor("spawnTimer")
    public void setSpawnTimer(int spawnTimer);
    @Accessor("spawnDelay")
    public void setSpawnDelay(int spawnDelay);
    @Accessor("spawnChance")
    public void setSpawnChance(int spawnChance);
}

