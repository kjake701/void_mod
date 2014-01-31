
package BlackDiamond.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRedStoneCrystal extends Item
{
	private static final String RSC = "rs:RedStoneCrystal";
public ItemRedStoneCrystal(int id, int texture)
{
super(id);
this.setCreativeTab(CreativeTabs.tabMaterials);
}

public void registerIcons(IconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon((this.RSC));
}

public String getTextureFile()
    {
            return "/RedWood/MainTexture.png";
    }
}