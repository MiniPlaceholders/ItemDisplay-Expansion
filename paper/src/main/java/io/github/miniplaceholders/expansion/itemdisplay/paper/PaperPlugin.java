package io.github.miniplaceholders.expansion.itemdisplay.paper;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.itemdisplay.paper.placeholder.MainHandPlaceholder;
import io.github.miniplaceholders.expansion.itemdisplay.paper.placeholder.OffHandPlaceholder;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperPlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        this.getSLF4JLogger().info("Starting ItemDisplay Expansion for Paper");

        Expansion.builder("item_display")
                .filter(Player.class)
                .audiencePlaceholder("main_hand", new MainHandPlaceholder())
                .audiencePlaceholder("off_hand", new OffHandPlaceholder())
                .build()
                .register();
    }
}
