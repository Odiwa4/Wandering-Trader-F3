package odiwa.wanderingtraderf3.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.DebugHud;
import odiwa.wanderingtraderf3.networking.ModMessages;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugHud.class)
public class F3ScreenMixin {
    @Shadow @Final private MinecraftClient client;

    @Inject(at = @At("RETURN"), method = "getLeftText")
    protected void getLeftText(CallbackInfoReturnable<List<String>> info) {
        int chance = ModMessages.chance;
        int delay = ModMessages.delay;
        int timer = ModMessages.timer;

        info.getReturnValue().add("Wandering Trader Spawn Chance: " + chance + "%");
        info.getReturnValue().add("Wandering Trader Spawn Ticks: " + (delay - (1200 - timer)));
    }
}
