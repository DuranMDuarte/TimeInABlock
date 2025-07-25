
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.timeinablock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.timeinablock.block.entity.TimeAcceleratorBlockBlockEntity;
import net.mcreator.timeinablock.TimeInABlockMod;

public class TimeInABlockModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TimeInABlockMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> TIME_ACCELERATOR_BLOCK = register("time_accelerator_block", TimeInABlockModBlocks.TIME_ACCELERATOR_BLOCK, TimeAcceleratorBlockBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
