package io.github.miniplaceholders.expansion.itemdisplay.sponge.placeholder;

import io.github.miniplaceholders.api.placeholder.AudiencePlaceholder;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

public final class MainHandPlaceholder implements AudiencePlaceholder {
    @Override
    public Tag tag(
            final @NotNull Audience audience,
            final @NotNull ArgumentQueue queue,
            final @NotNull Context ctx
    ) {
        final ServerPlayer player = (ServerPlayer) audience;
        final var item = player.itemInHand(HandTypes.MAIN_HAND);
        final String name = queue.hasNext() ? queue.pop().value() : "item";
        return Tag.selfClosingInserting(Component.text().content(name).hoverEvent(item));
    }
}
