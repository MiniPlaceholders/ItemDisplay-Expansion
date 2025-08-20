package io.github.miniplaceholders.expansion.itemdisplay.paper.placeholder;

import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class MainHandPlaceholder implements AudienceTagResolver<Player> {
    @Override
    public Tag tag(
            final @NotNull Player player,
            final @NotNull ArgumentQueue queue,
            final @NotNull Context ctx
    ) {
        final var item = player.getEquipment().getItemInMainHand();
        final String name = queue.hasNext() ? queue.pop().value() : "item";
        return Tag.selfClosingInserting(Component.text().content(name).hoverEvent(item));
    }
}
