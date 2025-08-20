package io.github.miniplaceholders.expansion.itemdisplay;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.api.MiniPlaceholders;
import io.github.miniplaceholders.api.provider.ExpansionProvider;
import io.github.miniplaceholders.api.provider.LoadRequirement;
import io.github.miniplaceholders.api.types.Platform;
import io.github.miniplaceholders.expansion.itemdisplay.common.PlatformExpansionProvider;
import io.github.miniplaceholders.expansion.itemdisplay.paper.PaperExpansionProvider;
import io.github.miniplaceholders.expansion.itemdisplay.sponge.SpongeExpansionProvider;

public final class ItemDisplayExpansionProvider implements ExpansionProvider {
    @Override
    public Expansion provideExpansion() {
        final PlatformExpansionProvider provider = switch (MiniPlaceholders.platform()) {
            case SPONGE -> new SpongeExpansionProvider();
            case PAPER -> new PaperExpansionProvider();
            default -> throw new UnsupportedOperationException("Unsupported Platform");
        };
        return provider.provideBuilder()
                .author("MiniPlaceholders Contributors")
                .version("2.0.0")
                .build();
    }

    @Override
    public LoadRequirement loadRequirement() {
        return LoadRequirement.platform(Platform.PAPER, Platform.SPONGE);
    }
}
