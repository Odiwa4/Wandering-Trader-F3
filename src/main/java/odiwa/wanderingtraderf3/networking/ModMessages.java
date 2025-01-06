package odiwa.wanderingtraderf3.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import odiwa.wanderingtraderf3.WanderingTraderF3;


public class ModMessages {
    public static final Identifier TRADER_ID = Identifier.of(WanderingTraderF3.MOD_ID, "trader");
    public static final Identifier JOIN_HAS_MOD_ID = Identifier.of(WanderingTraderF3.MOD_ID, "join_has_mod");
    public static final Identifier LEAVE_HAS_MOD_ID = Identifier.of(WanderingTraderF3.MOD_ID, "leave_has_mod");
    public static int timer = 0;
    public static int delay = 0;
    public static int chance = 0;
    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(TraderIDPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                timer = payload.timer();
                delay = payload.delay();
                chance = payload.chance();
            });
        });
    }
}
