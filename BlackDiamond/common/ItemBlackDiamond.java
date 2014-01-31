
package BlackDiamond.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBlackDiamond extends Item
{
	private static final String BDI = "rs:BlackDiamond";
public ItemBlackDiamond(int id, int texture)
{
super(id);
this.setCreativeTab(CreativeTabs.tabMaterials);
}

public void registerIcons(IconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon((this.BDI));
}

public String getTextureFile()
    {
            return "/RedWood/MainTexture.png";
    }
}