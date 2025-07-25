package net.mcreator.timeinablock.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class TimeAcceleratorRedstoneProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z
) {
if (world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x,y,z))) {if (new Object(){
public double getValue(LevelAccessor world, BlockPos pos, String tag) {
BlockEntity blockEntity=world.getBlockEntity(pos);
if(blockEntity != null) return blockEntity.getPersistentData().getDouble(tag);
return -1;
}
}.getValue(world, BlockPos.containing(x,y,z), "storedTime")>=100) {if(!world.isClientSide()) {
BlockPos _bp = BlockPos.containing(x,y,z);
BlockEntity _blockEntity = world.getBlockEntity(_bp);
BlockState _bs = world.getBlockState(_bp);
if(_blockEntity != null)
_blockEntity.getPersistentData().putDouble("storedTime", ((new Object(){
public double getValue(LevelAccessor world, BlockPos pos, String tag) {
BlockEntity blockEntity=world.getBlockEntity(pos);
if(blockEntity != null) return blockEntity.getPersistentData().getDouble(tag);
return -1;
}
}.getValue(world, BlockPos.containing(x,y,z), "storedTime"))
-100));
if(world instanceof Level _level)
_level.sendBlockUpdated(_bp, _bs, _bs, 3);
}int horizontalRadiusSquare = (int) 5 - 1;
int verticalRadiusSquare = (int) 5 - 1;
int yIterationsSquare = verticalRadiusSquare;
for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
// Execute the desired statements within the square/cube
// Importações necessárias (o MCreator deve gerenciar a maioria, mas estas são cruciais)
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import com.magorage.tiab.api.ITimeInABottleAPI;

import com.haoict.tiab.common.core.api.APIRegistry;
// As coordenadas do bloco que o loop está AGORA iterando são dadas pelas variáveis "x", "y", "z"
// no contexto do MCreator dentro de um loop.
// O "world" é a variável que representa o Level (o mundo do Minecraft).
// Tenta obter a instância da API do Time In A Bottle
ITimeInABottleAPI tiabApiInstance = APIRegistry.getAccess(ITimeInABottleAPI.class);
// Verifica se a API foi encontrada
if (tiabApiInstance != null) {
// Cria um objeto BlockPos com as coordenadas do bloco atual no loop
BlockPos targetPos = new BlockPos(x, y, z); // Use as variáveis do loop do MCreator
// Chama o método accelerateBlock da API.
// O primeiro argumento é a própria instância da API.
// Os argumentos 'ItemStack' e 'Player' são passados como 'null'
// porque a aceleração está vindo do seu bloco, não de um item ou jogador específico.
tiabApiInstance.accelerateBlock(tiabApiInstance, null, null, world, targetPos);
} else {
// Isso é para depuração: Se a API não for carregada, você verá esta mensagem no console do MCreator.
System.err.println("Time In A Bottle API not found! Acceleration failed for block at " + x + ", " + y + ", " + z);
}
}
}
}
}}
}
}
