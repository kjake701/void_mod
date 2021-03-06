package thevoid.common.dimension.biome;

import java.util.Random;

import thevoid.common.TheVoid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;


public class BiomeGraveyard extends BiomeGenBase
{
	private WorldGenerator WorldGenRedWood;
	public final Material blockMaterial;
	public BiomeGraveyard(int par1)
	{
		super(par1);
		this.theBiomeDecorator.treesPerChunk = 15;
		this.blockMaterial = Material.water;
		this.minHeight = 0.09F;
		this.maxHeight = 0.1F;
		this.topBlock = (byte) (TheVoid.blockGraveYardGrass.blockID);
		this.fillerBlock = (byte) (TheVoid.blockGraveYardDirt.blockID);
		this.setBiomeName("Grave Yard");
		/** this changes the water colour, its set to red now but ggole the java colours **/
		this.waterColorMultiplier = 0xE42D17;
	}

}