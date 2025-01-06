package odiwa.wanderingtraderf3.networking;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public record TraderIDPayload(int timer, int delay, int chance) implements CustomPayload {

    public static final Id<TraderIDPayload> ID = new Id<>(ModMessages.TRADER_ID);
    public static final PacketCodec<RegistryByteBuf, TraderIDPayload> CODEC = PacketCodec.tuple(PacketCodecs.INTEGER,  TraderIDPayload::timer, PacketCodecs.INTEGER,  TraderIDPayload::delay, PacketCodecs.INTEGER,  TraderIDPayload::chance, TraderIDPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
