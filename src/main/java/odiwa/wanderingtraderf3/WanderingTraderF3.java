package odiwa.wanderingtraderf3;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.WanderingTraderManager;
import net.minecraft.world.World;
import net.minecraft.world.spawner.SpecialSpawner;
import odiwa.wanderingtraderf3.mixin.ServerWorldAccessor;
import odiwa.wanderingtraderf3.mixin.WanderingTraderManagerAccessor;
import odiwa.wanderingtraderf3.networking.JoinWithModIDPayload;
import odiwa.wanderingtraderf3.networking.LeaveWithModIDPayload;
import odiwa.wanderingtraderf3.networking.TraderIDPayload;
import java.util.ArrayList;
import java.util.List;

public class WanderingTraderF3 implements ModInitializer{
	public static final String MOD_ID = "wandering-trader-f3";
	public static List<ServerPlayerEntity> playersWithMod = new ArrayList<>();

	@Override
	public void onInitialize() {
		PayloadTypeRegistry.playS2C().register(TraderIDPayload.ID, TraderIDPayload.CODEC);
		PayloadTypeRegistry.playC2S().register(JoinWithModIDPayload.ID, JoinWithModIDPayload.CODEC);
		PayloadTypeRegistry.playC2S().register(LeaveWithModIDPayload.ID, LeaveWithModIDPayload.CODEC);
		ServerTickEvents.START_WORLD_TICK.register((server) -> {

			List<SpecialSpawner> spawners = ((ServerWorldAccessor) server.getServer().getWorld(World.OVERWORLD)).getSpawners();

			WanderingTraderManager wanderingTraderManager = (WanderingTraderManager) spawners.get(4);

			WanderingTraderManagerAccessor traderAccessor = ((WanderingTraderManagerAccessor) wanderingTraderManager);
			int timer = traderAccessor.getSpawnTimer();
			int delay = traderAccessor.getSpawnDelay();
			int chance = traderAccessor.getSpawnChance();

			if (!playersWithMod.isEmpty()){
                for (ServerPlayerEntity player : playersWithMod) {
                    ServerPlayNetworking.send(player, new TraderIDPayload(timer, delay, chance));
                }
			}
		});
		//SET UP LIST
		ServerPlayNetworking.registerGlobalReceiver(JoinWithModIDPayload.ID, (payload, context) -> {
			playersWithMod.add(context.player());
		});

		ServerPlayNetworking.registerGlobalReceiver(LeaveWithModIDPayload.ID, (payload, context) -> {
			playersWithMod.remove(context.player());
		});
	}
}