package BlackDiamond.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class Blood extends BlockStationary {
	
	protected Blood(int par1) {
		super(par1, Material.water);
        this.blockHardness = 100.0F;
        this.setLightOpacity(3);
		this.disableStats();
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.theIcon = new Icon[] {
                iconRegister.registerIcon("rs:BloodStill2"),
                iconRegister.registerIcon("rs:BloodFlow2") };
    }

}
