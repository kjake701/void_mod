package thevoid.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import thevoid.common.TheVoid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockDeadStoneBrick extends Block
{
    public static final String[] STONE_BRICK_TYPES = new String[] {"default"};
    public static final String[] field_94407_b = new String[] {null,};
	
    @SideOnly(Side.CLIENT)
    private Icon[] field_94408_c;

    private static final String DSB = "rs:DeadStoneBrick";
    
    public BlockDeadStoneBrick(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
              if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;
                    int l1 = par1World.getBlockId(i1, j1 + 1, k1);

                    if (par1World.getBlockId(i1, j1, k1) == Block.stoneBrick.blockID  && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, TheVoid.blockDeadStoneBrick.blockID);
                    }
                    
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 >= field_94407_b.length)
        {
            par2 = 0;
        }

        return this.field_94408_c[par2];
    }
    

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94408_c = new Icon[field_94407_b.length];

        for (int i = 0; i < this.field_94408_c.length; ++i)
        {
            String s = this.DSB;

            if (field_94407_b[i] != null)
            {
                s = s + "_" + field_94407_b[i];
            }

            this.field_94408_c[i] = par1IconRegister.registerIcon(s);
        }
    }


    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }
}
