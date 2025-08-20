package io.github.miniplaceholders.expansion.itemdisplay.paper;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.itemdisplay.common.PlatformExpansionProvider;
import io.github.miniplaceholders.expansion.itemdisplay.paper.placeholder.GenericHandPlaceholder;
import io.github.miniplaceholders.expansion.itemdisplay.paper.placeholder.MainHandPlaceholder;
import io.github.miniplaceholders.expansion.itemdisplay.paper.placeholder.OffHandPlaceholder;
import org.bukkit.entity.Player;

public final class PaperExpansionProvider implements PlatformExpansionProvider {

    @Override
    public Expansion.Builder provideBuilder() {
        return Expansion.builder("item_display")
                .audiencePlaceholder(Player.class, "hand", new GenericHandPlaceholder())
                .audiencePlaceholder(Player.class, "main_hand", new MainHandPlaceholder())
                .audiencePlaceholder(Player.class, "off_hand", new OffHandPlaceholder());
    }
}
