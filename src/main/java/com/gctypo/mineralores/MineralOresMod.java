package com.gctypo.mineralores;

import com.gctypo.mineralores.items.ItemMineralDust;
import com.gctypo.mineralores.registry.MineralItems;
import com.gctypo.mineralores.registry.RegistryHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MineralOresMod.MODID, name = MineralOresMod.NAME, version = MineralOresMod.VERSION)
public class MineralOresMod
{
	public static final String MODID = "mineralores";
	public static final String NAME = "Mineral Ores";
	public static final String VERSION = "1.0.0";
	
	private static Logger logger;
	
	public static final CreativeTabs TAB_MINERALORES = new CreativeTabs("tabMineralOres")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(MineralItems.dusts.get("Magnetite"));
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		
		RegistryHelper.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//logger.info("HEY BUDDY");
	}
}