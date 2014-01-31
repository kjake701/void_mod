package BlackDiamond.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RedStonePickPart3 extends Item
{
	private static final String RSPP3 = "rs:RedStonePickPart3";
	public static final String[][] field_82804_b = new String[][] {{"RedStonePickPart3"}};
    public RedStonePickPart3(int par1)
    {
        super(par1);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack par1ItemStack)
    {
        return par1ItemStack.stackSize == 1;
    }

    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon((this.RSPP3));
    }
    
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}

