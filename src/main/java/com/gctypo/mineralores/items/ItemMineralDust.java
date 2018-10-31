package com.gctypo.mineralores.items;

import net.minecraft.item.Item;

public class ItemMineralDust extends Item
{
	public ItemMineralDust(String name)
	{
		super();
		
		setRegistryName(name.toLowerCase() + "_dust");
		setUnlocalizedName(name.toLowerCase() + "_dust");
	}
	
	public String getOreDictionaryName()
	{
		return "dust" + getUnlocalizedName();
	}
}
