package thevoid.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import thevoid.common.TheVoid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BlockRLog extends BlockRotatedPillar
{
    /** The type of tree this log came from. */
	public static final String[] woodType = new String[] {"DeadWood"};
	@SideOnly(Side.CLIENT)
    private Icon[] DeadLog;
    @SideOnly(Side.CLIENT)
    private Icon[] DeadLogTop;
    
    private final ResourceLocation RedLogSide3 = new ResourceLocation("rs:Blocks/DeadLog.png");
    private final String RedLogSide4 = "rs:DeadLog";
    private final String RedLogTop2 = "rs:DeadLogTop";

    public BlockRLog(int par1)
    {
        super(par1, Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return TheVoid.blockRLog.blockID;
    }

    
    @SideOnly(Side.CLIENT)
    /**
     * The icon for the side of the block.
     */
    protected Icon getSideIcon(int par1)
    {
        return this.DeadLog[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * The icon for the tops and bottoms of the block.
     */
    protected Icon getEndIcon(int par1)
    {
        return this.DeadLogTop[par1];
    }

    /**
     * returns a number between 0 and 3
     */
    public static int limitToValidMetadata(int par0)
    {
        return par0 & 3;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }

    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.DeadLog = new Icon[woodType.length];
        this.DeadLogTop = new Icon[woodType.length];

        for (int i = 0; i < this.DeadLog.length; ++i)
        {
            this.DeadLog[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + woodType[i]);
            this.DeadLogTop[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + woodType[i] + "_top");
        }
    }

    @Override
    public boolean isWood(World world, int x, int y, int z)
    {
        return true;
    }
}
