
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.timeinablock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.timeinablock.block.TimeAcceleratorBlockBlock;
import net.mcreator.timeinablock.TimeInABlockMod;

public class TimeInABlockModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TimeInABlockMod.MODID);
	public static final RegistryObject<Block> TIME_ACCELERATOR_BLOCK = REGISTRY.register("time_accelerator_block", () -> new TimeAcceleratorBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
