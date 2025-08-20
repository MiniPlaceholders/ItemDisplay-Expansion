package io.github.miniplaceholders.expansion.itemdisplay.paper.placeholder;

import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class GenericHandPlaceholder implements AudienceTagResolver<Player> {
    @Override
    public @Nullable Tag tag(Player player, ArgumentQueue queue, Context ctx) {
        final String hand = queue.popOr("You need to provide a hand argument").lowerValue();
        final var item = switch (hand) {
            case "main", "main_hand" -> player.getEquipment().getItemInMainHand();
            case "off", "off_hand" -> player.getEquipment().getItemInOffHand();
            default -> throw ctx.newException("You need to provide a valid hand");
        };
        final String name = queue.hasNext() ? queue.pop().value() : "item";
        return Tag.selfClosingInserting(Component.text().content(name).hoverEvent(item));
    }
}
