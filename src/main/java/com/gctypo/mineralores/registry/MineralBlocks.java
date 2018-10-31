package com.gctypo.mineralores.registry;

import com.gctypo.mineralores.blocks.BlockMineralOre;

import java.util.*;

public class MineralBlocks
{
	public static Map<String, BlockMineralOre> blocks = new HashMap<>();
	
	public static void addOre(BlockMineralOre ore)
	{
		blocks.put(ore.getName(), ore);
	}
	
	public static void preInit()
	{
		addOre(new BlockMineralOre("Magnetite"));
	}
}
