package com.gctypo.mineralores.registry;

import com.gctypo.mineralores.items.ItemMineralDust;
import net.minecraft.item.Item;

import java.util.*;

public class MineralItems
{
	public static Map<String, ItemMineralDust> dusts = new HashMap<>();
	
	public static void addDust(ItemMineralDust item)
	{
		dusts.put(item.getUnlocalizedName(), item);
	}
	
	public static void preInit()
	{
		addDust(new ItemMineralDust("Magnetite"));
	}
}
