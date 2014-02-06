package thevoid.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockGraveYardDirt extends BlockDirt {

	private static final String GYD = "rs:GraveYardDirt";
	
	public BlockGraveYardDirt(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.blockIcon = par1IconRegister.registerIcon((this.GYD));
	}

}
