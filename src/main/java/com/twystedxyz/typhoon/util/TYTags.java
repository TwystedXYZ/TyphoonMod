package com.twystedxyz.typhoon.util;

import com.twystedxyz.typhoon.Typhoon;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TYTags {

    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_BLAZE_TOOL = TagKey.create(
                Registries.BLOCK, Typhoon.rl(""));
    }
}