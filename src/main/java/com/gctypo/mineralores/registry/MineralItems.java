package com.gctypo.mineralores.registry;

import com.gctypo.mineralores.items.ItemMineralDust;
import net.minecraft.item.Item;

import java.util.*;

public class MineralItems
{
	public static Map<String, ItemMineralDust> dusts = new HashMap<>();
	
	public static void addDust(ItemMineralDust item)
	{
		dusts.put(item.getName(), item);
	}
	
	public static void preInit()
	{
		addDust(new ItemMineralDust("Bauxite"));
		addDust(new ItemMineralDust("Cassiterite"));
		addDust(new ItemMineralDust("Chalcopyrite"));
		addDust(new ItemMineralDust("Chromite"));
		addDust(new ItemMineralDust("Cinnabar"));
		addDust(new ItemMineralDust("Cobaltite"));
		addDust(new ItemMineralDust("Galena"));
		addDust(new ItemMineralDust("Garnierite"));
		addDust(new ItemMineralDust("Grossular"));
		addDust(new ItemMineralDust("Ilmenite"));
		addDust(new ItemMineralDust("Magnesite"));
		addDust(new ItemMineralDust("Magnetite"));
		addDust(new ItemMineralDust("Malachite"));
		addDust(new ItemMineralDust("Olivine"));
		addDust(new ItemMineralDust("Pentlandite"));
		addDust(new ItemMineralDust("Pitchblende"));
		addDust(new ItemMineralDust("Pyrite"));
		addDust(new ItemMineralDust("Pyrolusite"));
		addDust(new ItemMineralDust("Quartzite"));
		addDust(new ItemMineralDust("Rocksalt"));
		addDust(new ItemMineralDust("Scheelite"));
		addDust(new ItemMineralDust("Sodalite"));
		addDust(new ItemMineralDust("Sperrylite"));
		addDust(new ItemMineralDust("Sphalerite"));
		addDust(new ItemMineralDust("Spodumene"));
		addDust(new ItemMineralDust("Stibnite"));
		addDust(new ItemMineralDust("Talc"));
		addDust(new ItemMineralDust("Tantalite"));
		addDust(new ItemMineralDust("Tetrahedrite"));
		addDust(new ItemMineralDust("Tungstate"));
		addDust(new ItemMineralDust("VanadiumMagnetite"));
	}
}
