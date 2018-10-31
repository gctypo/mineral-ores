package com.gctypo.mineralores.registry;

import com.gctypo.mineralores.MineralOresMod;
import com.gctypo.mineralores.blocks.BlockMineralOre;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.*;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MineralOresMod.MODID)
public class RegistryHelper
{
	public static void preInit()
	{
		MineralBlocks.preInit();
		MineralItems.preInit();
	}
	
	@SubscribeEvent
	public static void registerAllBlocks(RegistryEvent.Register<Block> event)
	{
		for (Block block : MineralBlocks.blocks.values())
		{
			event.getRegistry().register(block);
		}
	}
	
	@SubscribeEvent
	public static void registerAllItems(RegistryEvent.Register<Item> event)
	{
		for (BlockMineralOre block : MineralBlocks.blocks.values())
		{
			ItemMultiTexture imt = new ItemMultiTexture(block, block,
				stack -> BlockMineralOre.BackgroundType.byMeta(stack.getMetadata()).getUnlocalizedName());
			imt.setRegistryName(block.getRegistryName());
			imt.setHasSubtypes(true);
			imt.setUnlocalizedName(block.getUnlocalizedName());
			
			event.getRegistry().register(imt);
		}
		
		for (Item dust : MineralItems.dusts.values())
		{
			//event.getRegistry().register(dust);
		}
	}
	
	@SubscribeEvent
	public static void registerRenderers(ModelRegistryEvent event)
	{
		for (BlockMineralOre block : MineralBlocks.blocks.values())
		{
			Item itemBlock = Item.getItemFromBlock(block);
			for (BlockMineralOre.BackgroundType bg : BlockMineralOre.BackgroundType.values())
			{
				ModelLoader.setCustomModelResourceLocation(itemBlock, bg.getMeta(),
					new ModelResourceLocation(itemBlock.getRegistryName(), BlockMineralOre.BACKGROUND.getName() +
						"=" + bg.getName()));
			}
		}
	}
	
	public static void registerRender(Item item, int meta)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta,
			new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
