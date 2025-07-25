
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.timeinablock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.timeinablock.TimeInABlockMod;

public class TimeInABlockModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TimeInABlockMod.MODID);
	public static final RegistryObject<Item> TIME_ACCELERATOR_BLOCK = block(TimeInABlockModBlocks.TIME_ACCELERATOR_BLOCK);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
