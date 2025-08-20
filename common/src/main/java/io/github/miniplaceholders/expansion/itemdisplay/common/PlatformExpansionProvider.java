package io.github.miniplaceholders.expansion.itemdisplay.common;

import io.github.miniplaceholders.api.Expansion;

public interface PlatformExpansionProvider {
    Expansion.Builder provideBuilder();
}
