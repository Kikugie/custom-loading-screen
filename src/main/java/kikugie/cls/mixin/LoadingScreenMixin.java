package kikugie.cls.mixin;

import kikugie.cls.utils.ConfigTextureLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashOverlay.class)
public class LoadingScreenMixin {
    private static final Identifier CUSTOM_LOGO = new Identifier("mojangstudios.png");

    @Final
    @Shadow
    static Identifier LOGO;

    @Inject(method = "init(Lnet/minecraft/client/MinecraftClient;)V", at = @At("HEAD"), cancellable = true)
    private static void initCustom(CallbackInfo ci) {
        MinecraftClient.getInstance().getTextureManager().registerTexture(LOGO, new ConfigTextureLoader(CUSTOM_LOGO, LOGO));
        ci.cancel();
    }
}