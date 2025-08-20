package io.github.miniplaceholders.expansion.itemdisplay.sponge.placeholder;

import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

public final class GenericHandPlaceholder implements AudienceTagResolver<ServerPlayer> {
    @Override
    public Tag tag(ServerPlayer player, ArgumentQueue queue, Context ctx) {
        final String hand = queue.popOr("You need to provide a hand argument").lowerValue();
        final var item = player.itemInHand(switch (hand) {
            case "main", "main_hand" -> HandTypes.MAIN_HAND;
            case "off", "off_hand" -> HandTypes.OFF_HAND;
            default -> throw ctx.newException("You need to provide a valid hand");
        });
        final String name = queue.hasNext() ? queue.pop().value() : "item";
        return Tag.selfClosingInserting(Component.text().content(name).hoverEvent(item));
    }
}
