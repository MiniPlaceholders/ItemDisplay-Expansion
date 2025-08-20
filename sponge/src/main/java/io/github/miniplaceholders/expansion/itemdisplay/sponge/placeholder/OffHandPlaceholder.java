package io.github.miniplaceholders.expansion.itemdisplay.sponge.placeholder;

import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

public final class OffHandPlaceholder implements AudienceTagResolver<ServerPlayer> {
    @Override
    public Tag tag(
            final ServerPlayer player,
            final ArgumentQueue queue,
            final Context ctx
    ) {
        final var item = player.itemInHand(HandTypes.OFF_HAND);
        final String name = queue.hasNext() ? queue.pop().value() : "item";
        return Tag.selfClosingInserting(Component.text().content(name).hoverEvent(item));
    }
}
