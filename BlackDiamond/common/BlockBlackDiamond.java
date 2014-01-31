package BlackDiamond.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBlackDiamond extends Block 
{
public BlockBlackDiamond(int id, int texture)
 {
 super(id, Material.wood);
 this.setCreativeTab(CreativeTabs.tabBlock);
 }

public String getTextureFile()
 {
	return "/RedWood/green.png";
 }
}