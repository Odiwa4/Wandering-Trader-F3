package odiwa.wanderingtraderf3.networking;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record LeaveWithModIDPayload() implements CustomPayload {

    public static final Id<LeaveWithModIDPayload> ID = new Id<>(ModMessages.LEAVE_HAS_MOD_ID);
    public static final PacketCodec<RegistryByteBuf, LeaveWithModIDPayload> CODEC = PacketCodec.unit(new LeaveWithModIDPayload());
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}

