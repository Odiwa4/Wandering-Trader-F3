package odiwa.wanderingtraderf3.networking;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record JoinWithModIDPayload() implements CustomPayload {

    public static final CustomPayload.Id<JoinWithModIDPayload> ID = new CustomPayload.Id<>(ModMessages.JOIN_HAS_MOD_ID);
    public static final PacketCodec<RegistryByteBuf, JoinWithModIDPayload> CODEC = PacketCodec.unit(new JoinWithModIDPayload());
    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}

