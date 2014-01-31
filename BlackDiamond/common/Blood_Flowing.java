package BlackDiamond.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class Blood_Flowing extends BlockFlowing {

	protected Blood_Flowing(int par1) {
		super(par1, Material.water);
        this.blockHardness = 100.0F;
        this.setLightOpacity(3);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.theIcon = new Icon[] {
                iconRegister.registerIcon("rs:BloodStill2"),
                iconRegister.registerIcon("rs:BloodFlow2") };
    }

}
