package com.gctypo.mineralores.blocks;

import com.gctypo.mineralores.registry.MineralItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMineralOre extends BlockOre
{
	public static final float DEFAULT_HARDNESS = 3;
	public static final int DEFAULT_HARVEST = 1;
	
	public static final PropertyEnum<BackgroundType> BACKGROUND = PropertyEnum.create("background", BackgroundType.class);
	
	private ItemStack dust;
	private String name;
	
	public BlockMineralOre(String name_, float hardness, int harvestLevel, ItemStack dust_)
	{
		super();
		
		dust = dust_;
		name = name_;
		
		setRegistryName(name.toLowerCase() + "_ore");
		setUnlocalizedName(name.toLowerCase() + "_ore");
		
		setHardness(hardness);
		setHarvestLevel("pickaxe", harvestLevel);
		
		setDefaultState(blockState.getBaseState().withProperty(BACKGROUND, BackgroundType.STONE));
	}
	public BlockMineralOre(String name_, float hardness, int harvestlevel)
	{
		this(name_, hardness, harvestlevel,
			new ItemStack(MineralItems.dusts.get(name_), 2)); // the 2 here is standard doubling, will be configgable
	}
	public BlockMineralOre(String name_)
	{
		this(name_, DEFAULT_HARDNESS, DEFAULT_HARVEST);
	}
	
	public ItemStack getDust()
	{
		return dust;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return getItem(world, pos, state);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(state));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		Item res = Item.getItemFromBlock(this);
		return res;
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return state.getValue(BACKGROUND).getMeta();
	}
	
	@Override
	public void getSubBlocks(CreativeTabs tabs, NonNullList<ItemStack> stacks)
	{
		for (BackgroundType bg : BackgroundType.values())
		{
			stacks.add(new ItemStack(this, 1, bg.getMeta()));
		}
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
	                                        int meta, EntityLivingBase placer, EnumHand hand)
	{
		return getStateFromMeta(meta);
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BACKGROUND);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(BACKGROUND, BackgroundType.byMeta(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(BACKGROUND).getMeta();
	}
	
	public enum BackgroundType implements IStringSerializable
	{
		STONE(0, "stone"),
		NETHERRACK(1, "netherrack"),
		ENDSTONE(2, "endstone");
		
		private static final BackgroundType[] META_LOOKUP = new BackgroundType[values().length];
		
		private final int meta;
		private final String name;
		private final String unlocalizedName;
		
		BackgroundType(int meta_, String name_)
		{
			meta = meta_;
			name = name_;
			unlocalizedName = name_;
		}
		
		public int getMeta()
		{
			return meta;
		}
		
		@Override
		public String getName()
		{
			return name;
		}
		
		public String getUnlocalizedName()
		{
			return unlocalizedName;
		}
		
		@Override
		public String toString()
		{
			return name;
		}
		
		public static BackgroundType byMeta(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
			{
				meta = 0;
			}
			
			return META_LOOKUP[meta];
		}
		
		static
		{
			for (BackgroundType type : values())
			{
				META_LOOKUP[type.getMeta()] = type;
			}
		}
	}
}
