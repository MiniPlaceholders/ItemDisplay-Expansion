package io.github.miniplaceholders.expansion.itemdisplay.sponge;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.itemdisplay.common.PlatformExpansionProvider;
import io.github.miniplaceholders.expansion.itemdisplay.sponge.placeholder.GenericHandPlaceholder;
import io.github.miniplaceholders.expansion.itemdisplay.sponge.placeholder.MainHandPlaceholder;
import io.github.miniplaceholders.expansion.itemdisplay.sponge.placeholder.OffHandPlaceholder;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

public final class SpongeExpansionProvider implements PlatformExpansionProvider {

    @Override
    public Expansion.Builder provideBuilder() {
        return Expansion.builder("item_display")
                .audiencePlaceholder(ServerPlayer.class, "hand", new GenericHandPlaceholder())
                .audiencePlaceholder(ServerPlayer.class, "main_hand", new MainHandPlaceholder())
                .audiencePlaceholder(ServerPlayer.class, "off_hand", new OffHandPlaceholder());
    }
}
