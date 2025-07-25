
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.timeinablock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.timeinablock.world.inventory.DebuguiMenu;
import net.mcreator.timeinablock.TimeInABlockMod;

public class TimeInABlockModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TimeInABlockMod.MODID);
	public static final RegistryObject<MenuType<DebuguiMenu>> DEBUGUI = REGISTRY.register("debugui", () -> IForgeMenuType.create(DebuguiMenu::new));
}
