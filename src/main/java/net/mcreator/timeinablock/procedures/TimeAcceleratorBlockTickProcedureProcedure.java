package net.mcreator.timeinablock.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

// Estes imports devem agora ser resolvidos se as dependencias do Gradle estiverem corretas
import com.magorage.tiab.api.ITimeInABottleAPI;
import com.haoict.tiab.common.core.api.APIRegistry; // Este e o que tem causado problemas!

import java.util.Optional; // Necessario para Optional

public class TimeAcceleratorBlockTickProcedureProcedure {

    // Declaracao da variavel estatica DENTRO da classe
    private static ITimeInABottleAPI TIAB_API_INSTANCE = null; // AQUI!

    public static void execute(LevelAccessor world, double x, double y, double z) {
        // Tenta obter a API apenas uma vez na primeira execucao ou se for null
        if (TIAB_API_INSTANCE == null) {
            try {
                Optional<ITimeInABottleAPI> apiOptional = APIRegistry.getAccess(ITimeInABottleAPI.class);
                if (apiOptional.isPresent()) {
                    TIAB_API_INSTANCE = apiOptional.get();
                    System.out.println("Time In A Bottle API obtida com sucesso via APIRegistry!");
                } else {
                    System.err.println("Time In A Bottle API nao presente apos getAccess via APIRegistry.");
                }
            } catch (Throwable e) {
                System.err.println("Erro ao tentar obter Time In A Bottle API via APIRegistry: " + e.getMessage());
                e.printStackTrace();
            }
        }


        if (world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z))) {
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
                            if (TIAB_API_INSTANCE != null) {
                                net.minecraft.core.BlockPos currentTargetPos = new net.minecraft.core.BlockPos((int) (x + xi), (int) (y + i), (int) (z + zi));
                                // Chamar accelerateBlock na instancia da API
                                // Assinatura: accelerateBlock(ItemStack stack, Player player, Level level, BlockPos pos)
                                TIAB_API_INSTANCE.accelerateBlock(null, null, (net.minecraft.world.level.Level) world, currentTargetPos);
                            } else {
                                System.err.println("Time In A Bottle API nao disponivel para aceleracao de bloco em: " + (x + xi) + ", " + (y + i) + ", " + (z + zi) + ".");
                            }
                        }
                    }
                }
            }
        } else {
            if (new Object() {
                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    if (blockEntity != null)
                        return blockEntity.getPersistentData().getDouble(tag);
                    return -1;
                }
            }.getValue(world, BlockPos.containing(x, y, z), "storedTime") < 999999) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("storedTime", (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "storedTime") + 20));
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("totalAccumulatedTime", (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                if (blockEntity != null)
                                    return blockEntity.getPersistentData().getDouble(tag);
                                return -1;
                            }
                        }.getValue(world, BlockPos.containing(x, y, z), "totalAccumulatedTime") + 20));
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
            }
        }
    }
}