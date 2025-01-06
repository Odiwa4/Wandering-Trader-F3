package odiwa.wanderingtraderf3;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import odiwa.wanderingtraderf3.networking.JoinWithModIDPayload;
import odiwa.wanderingtraderf3.networking.LeaveWithModIDPayload;
import odiwa.wanderingtraderf3.networking.ModMessages;

public class WanderingTraderF3Client implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();
        //PayloadTypeRegistry.playC2S().register(JoinWithModIDPayload.ID, JoinWithModIDPayload.CODEC);
        //PayloadTypeRegistry.playC2S().register(LeaveWithModIDPayload.ID, LeaveWithModIDPayload.CODEC);

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            ClientPlayNetworking.send(new JoinWithModIDPayload());
        });

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            ClientPlayNetworking.send(new LeaveWithModIDPayload());
        });
    }
}
