package com.t.alexcavescaver.mixin;

import com.github.alexmodguy.alexscaves.client.gui.SpelunkeryTableScreen;
import com.github.alexmodguy.alexscaves.client.gui.SpelunkeryTableWordButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SpelunkeryTableScreen.class)
public interface SpelunkeryTableScreenAccessor {
    
    @Accessor("targetWordButton")
    SpelunkeryTableWordButton getTargetWordButton();
    
    @Accessor("finishedLevel")
    boolean isFinishedLevel();
}
