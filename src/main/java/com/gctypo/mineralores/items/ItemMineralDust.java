package com.gctypo.mineralores.items;

import com.gctypo.mineralores.MineralOresMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMineralDust extends Item
{
	private String name;
	
	public ItemMineralDust(String name_)
	{
		super();
		
		name = name_;
		setRegistryName(name.toLowerCase() + "_dust");
		setUnlocalizedName(name.toLowerCase() + "_dust");
		
		setCreativeTab(MineralOresMod.TAB_MINERALORES);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getOreDictionaryName()
	{
		return "dust" + getName();
	}
}
