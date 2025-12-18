package com.t.alexcavescaver.mixin;

import com.github.alexmodguy.alexscaves.client.gui.SpelunkeryTableScreen;
import com.github.alexmodguy.alexscaves.client.gui.SpelunkeryTableWordButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpelunkeryTableScreen.class)
public abstract class SpelunkeryTableScreenMixin {

    @Shadow
    private SpelunkeryTableWordButton targetWordButton;

    @Shadow
    private boolean finishedLevel;

    @Shadow
    private float passLevelProgress;

    @Shadow
    public abstract boolean hasTablet();

    @Shadow
    public abstract boolean hasPaper();

    @Shadow
    public abstract void onClickWord(SpelunkeryTableWordButton tableWordButton);

    @Inject(method = "containerTick", at = @At("TAIL"))
    private void alexcavescaver$autoSolve(CallbackInfo ci) {
        if (hasTablet() && hasPaper()) {
            // Skip animation by forcing progress to complete
            if (finishedLevel && passLevelProgress < 10.0F) {
                passLevelProgress = 10.0F;
            }

            // Auto-solve
            if (!finishedLevel && targetWordButton != null) {
                onClickWord(targetWordButton);
            }
        }
    }
}