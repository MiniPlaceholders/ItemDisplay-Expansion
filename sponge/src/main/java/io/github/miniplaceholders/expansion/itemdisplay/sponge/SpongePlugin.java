package io.github.miniplaceholders.expansion.itemdisplay.sponge;

import com.google.inject.Inject;
import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.itemdisplay.sponge.placeholder.MainHandPlaceholder;
import io.github.miniplaceholders.expansion.itemdisplay.sponge.placeholder.OffHandPlaceholder;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.StartingEngineEvent;
import org.spongepowered.plugin.builtin.jvm.Plugin;

@Plugin("itemdisplay-expansion")
public class SpongePlugin {
    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(final StartingEngineEvent<Server> event) {
        logger.info("Starting ItemDisplay Expansion for Sponge");

        Expansion.builder("item_display")
                .audiencePlaceholder("main_hand", new MainHandPlaceholder())
                .audiencePlaceholder("off_hand", new OffHandPlaceholder())
                .build()
                .register();
    }
}
