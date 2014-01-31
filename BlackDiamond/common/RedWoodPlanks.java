
package BlackDiamond.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class RedWoodPlanks extends Block 
{
private static final String RedWoodPlanks = "rs:RedWoodPlanks";
public RedWoodPlanks(int id, int texture)
 {
 super(id, Material.wood);
 this.setCreativeTab(CreativeTabs.tabBlock);
 }

public void registerIcons(IconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon((this.RedWoodPlanks));
}

public String getTextureFile()
 {
	return "/RedWood/green.png";
 }
}