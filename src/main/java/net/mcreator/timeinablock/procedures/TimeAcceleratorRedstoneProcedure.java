package net.mcreator.timeinablock.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class TimeAcceleratorRedstoneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "storedTime") >= 100) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("storedTime", ((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "storedTime")) - 100));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			int horizontalRadiusSquare = (int) 2 - 1;
			int verticalRadiusSquare = (int) 2 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						com.magorage.tiab.api.ITimeInABottleAPI tiabApiInstance = net.mcreator.timeinablock.TiabApiHolder.getApi();
						if (tiabApiInstance != null) {
							net.minecraft.core.BlockPos targetPos = new net.minecraft.core.BlockPos((int) x, (int) y, (int) z);
							tiabApiInstance.accelerateBlock(tiabApiInstance, null, null, (net.minecraft.world.level.Level) world, targetPos);
						}
						assert Boolean.TRUE; //#dbg:TimeAcceleratorRedstone:marker1
					}
				}
			}
		}
	}
}
