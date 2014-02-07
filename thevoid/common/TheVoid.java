package thevoid.common;

import java.util.Random;




















































import thevoid.common.blocks.BlockBlackDiamondOre;
import thevoid.common.blocks.BlockColorG;
import thevoid.common.blocks.BlockDeadStone;
import thevoid.common.blocks.BlockDeadStoneBrick;
import thevoid.common.blocks.BlockGraveYardDirt;
import thevoid.common.blocks.BlockGraveYardGrass;
import thevoid.common.blocks.BlockRLog;
import thevoid.common.blocks.BlockRedStoneCrystal;
import thevoid.common.blocks.BlockRedStoneCrystalGlowing;
import thevoid.common.blocks.BlockRedWoodSapling;
import thevoid.common.blocks.BlockSpoooooky;
import thevoid.common.blocks.BlockVoidPortal;
import thevoid.common.blocks.Blood;
import thevoid.common.blocks.Blood_Flowing;
import thevoid.common.blocks.RedWoodLeaves;
import thevoid.common.blocks.RedWoodPlanks;
import thevoid.common.blocks.VoidMineralBlock;
import thevoid.common.blocks.VoidMineralGlowingBlock;
import thevoid.common.blocks.blockVoidFire;
import thevoid.common.dimension.WorldProviderVoid;
import thevoid.common.dimension.biome.BiomeGraveyard;
import thevoid.common.gen.BDWorldGen;
import thevoid.common.gen.DeadBrickGraveGen;
import thevoid.common.gen.DeadTreeGen;
import thevoid.common.gen.OreGeneration;
import thevoid.common.gen.RedStoneCrystalGen;
import thevoid.common.gen.VoidMineralGen;
import thevoid.common.gen.WorldGenRedWood;
import thevoid.common.items.ItemBlackDiamond;
import thevoid.common.items.ItemRedStoneCrystal;
import thevoid.common.items.ItemRedStonePick;
import thevoid.common.items.ItemRedStoneStick;
import thevoid.common.items.ItemRedStoneSword;
import thevoid.common.items.RedStonePickPart1;
import thevoid.common.items.RedStonePickPart2;
import thevoid.common.items.RedStonePickPart3;
import thevoid.common.items.RedWoodBoneMeal;
import thevoid.common.items.SuspiciousMinerals;
import thevoid.common.items.VoidPortalStaff;
import thevoid.common.mob.EntityKitty;
import thevoid.common.util.BID;
import thevoid.common.util.CommonProxyBlackDiamond;
import thevoid.common.util.ToolMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.BlockWood;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.src.BaseMod;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "kjake701_TheVoid", name = "The Void", version = "0.1.5")

@NetworkMod(clientSideRequired = true, serverSideRequired = true)


public class TheVoid
{
	public Icon iconGrassSideOverlay;
	
	//Biomes
	
	
	//More Blocks
	
	public static blockVoidFire voidFire = (blockVoidFire)new blockVoidFire(2008).setLightValue(0.8F);
	
	public static BlockVoidPortal voidPortal = (BlockVoidPortal)new BlockVoidPortal(2009);

	public static final Block blockDeadCobbleStone = (new Block(2055, Material.rock)).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Dead Stone Brick").setCreativeTab(CreativeTabs.tabBlock).setTextureName("rs:deadcobblestone2");
	
	public final static Block blood_Flowing = 
			new Blood_Flowing(166).setUnlocalizedName("BloodFlowing");
	
	public final static Block blood_Still = 
			new Blood(2013).setUnlocalizedName("BloodStill");
	
	public final static Block blockGraveYardGrass = 
			new BlockGraveYardGrass(160).setStepSound(Block.soundGrassFootstep).setHardness(0.6F).setUnlocalizedName("Grave Yard Grass");
	
	public final static Block blockDeadStone = 
			new BlockDeadStone(161).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setUnlocalizedName("Dead Stone");
	
	public final static Block blockDeadStoneBrick = 
			new BlockDeadStoneBrick(165).setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setUnlocalizedName("Dead Stone Brick");
	
	public final static Block blockSpoooooky = 
			new BlockSpoooooky(2078, false).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Spooky").setTextureName("rs:spooky");
	
	public final static Block blockSpoooookyLantern = 
			new BlockSpoooooky(2080, true).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setLightValue(1.0F).setUnlocalizedName("Spooky lit").setTextureName("rs:spooky");
	
	public final static Block blockGraveYardDirt = new BlockGraveYardDirt(162).setHardness(0.6f).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Grave Yard Dirt");
	
	public final static Block blockRLog = new BlockRLog(1001).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("rs:RedLogSide");
	
	public final static Block redWoodLeaves = new RedWoodLeaves(1000).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("RS:BoneLeaves");
	
	public final static Block voidMineralBlock = 
			new VoidMineralBlock(2081, 12, false).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Void Mineral Block");
	
	public final static Block voidMineralGlowingBlock = 
			new VoidMineralGlowingBlock(2082, 12, true).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setLightValue(1.0F).setUnlocalizedName("Void Mineral Block Glowing");
	//Other
	static int startEntityId = 300;
	
	public static int RLog;
	
	public static int RedStoneSword;
	
	public static int BlackDiamondOre;
	
	public static int RedColorGlass;
	
	public static int BlackDiamond;
	
	public static int RedStoneCrystal;
	
	public static int RedStoneCrystalGlowing;
	
	//Dimension
	
    public static int dimensionId = 5;
	
	//Items
	public static Item ItemTiller;
	
	public static Item ItemRedWoodFertilizer;
	
	public static Item ItemRedStoneCrystal;
	
	public static Item ItemRedStoneSword;
	
	public static Item ItemBlackDiamond;
	
	public static Item RedStonePickPart1;
	
	public static Item RedStonePickPart2;
	
	public static Item RedStonePickPart3;
	
	public static Item ItemRedStoneStick;
	
	public static Item ItemRedStonePick;
	
	public static Item SuspiciousMinerals;
	
	public static Item voidPortalStaff;
	
	//Blocks
	
	public static Block BlockColorG;
	
	public static Block BlockRedStoneCrystalGlowing;
	
	public static Block BlockRedStoneCrystal;
	
	public static Block BlockBlackDiamondOre;
	
	public static Block RedWoodLeaves;
	
	public static Block RedWoodPlanks;
	
	public static Block BlockRLog;
	
	public static Block Blood;
	
	public static Block Blood_Flowing;
	
	public static Block RedWoodSapling;
	
	@SidedProxy(clientSide = "thevoid.common.util.ClientProxyBlackDiamond", serverSide = "thevoid.common.util.CommonProxyBlackDiamond")
	public static CommonProxyBlackDiamond proxy;
	
	public static final StepSound soundStoneFootstep = new StepSound("stone", 1.0F, 1.0F);
	
	public static final StepSound soundGrassFootstep = new StepSound("grass", 1.0F, 1.0F);
	
	public static final StepSound soundDirtFootstep = new StepSound("ground", 1.0F, 1.0F);

	public static final StepSound soundWoodFootstep = new StepSound("wood", 1.0F, 1.0F);
	
	public static final BiomeGenBase biomeGraveYard = new BiomeGraveyard(BID.BiomeID_1);
	
	@PreInit
	public void preinit(FMLPreInitializationEvent event){
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	config.load();

	BlackDiamondOre = config.get("Blocks", "Black Diamond Ore", 544).getInt();
	BlackDiamond = config.get("Items", "Black Diamond", 565).getInt();

	config.save();
	}


	
	@Init
	public void load(FMLInitializationEvent event)
	{	
		//Print
		System.out.println("[The Void] Activating The Void Version 0.1.5");
		
		//Blocks
		
		BlockColorG = (new BlockColorG(432)).setHardness(2.0f).setResistance(5.0f).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("RS:RedColorGlass");
		
		BlockRedStoneCrystal = (new BlockRedStoneCrystal(573, 11, false)).setHardness(12.0F).setResistance(10.0F).setStepSound(soundStoneFootstep).setUnlocalizedName("RS:RedStoneCrystalOre");
		
		BlockRedStoneCrystalGlowing = (new BlockRedStoneCrystalGlowing(575, 11, true)).setLightValue(0.625F).setHardness(12.0F).setResistance(10.0F).setStepSound(soundStoneFootstep).setUnlocalizedName("RS:RedStoneCrystalOre");
		
		BlockBlackDiamondOre = (new BlockBlackDiamondOre(544, 9)).setHardness(15.0F).setResistance(12.5F).setStepSound(soundStoneFootstep).setUnlocalizedName("RS:BlackDiamondOre");
				 
		RedWoodPlanks = (new RedWoodPlanks(250, 2)).setHardness(2.0F).setResistance(5.0F).setStepSound(soundWoodFootstep).setUnlocalizedName("RS:RedWoodPlanks");
				
		RedWoodSapling = (new BlockRedWoodSapling(467)).setUnlocalizedName("RS:RedWood Sapling");
				

        MinecraftForge.setBlockHarvestLevel(BlockBlackDiamondOre, "pickaxe", 3);
        
        MinecraftForge.setBlockHarvestLevel(BlockRedStoneCrystal, "pickaxe", 3);

		
		//Items
         ItemRedStoneStick = (new ItemRedStoneStick(634)).setUnlocalizedName("RedStoneStick");
         ItemRedStonePick = (new ItemRedStonePick(625, 12, 1, ToolMaterials.BlackDiamond, null)).setUnlocalizedName("RedStonePick");
         RedStonePickPart3 = (new RedStonePickPart3(636)).setUnlocalizedName("RedStonePickPart3");
         RedStonePickPart2 = (new RedStonePickPart2(638)).setUnlocalizedName("RedStonePickPart2");
         RedStonePickPart1 = (new RedStonePickPart1(635)).setUnlocalizedName("RedStonePickPart1");
		 ItemRedStoneSword = (new ItemRedStoneSword(543, 7, ToolMaterials.BlackDiamond)).setUnlocalizedName("RS:RedStoneSword");
		 ItemBlackDiamond = (new ItemBlackDiamond(565, 8).setUnlocalizedName("RS:BlackDiamond"));
		 ItemRedStoneCrystal = (new ItemRedStoneCrystal(568, 10).setUnlocalizedName("RS:RedStoneCrystal"));
		 SuspiciousMinerals = (new SuspiciousMinerals(789));
		 voidPortalStaff = (new VoidPortalStaff(780));
		
		MinecraftForge.EVENT_BUS.register(new RedWoodBoneMeal());
		
		//ores gen
		
		GameRegistry.registerWorldGenerator(new DeadBrickGraveGen());
		GameRegistry.registerWorldGenerator(new VoidMineralGen());
		GameRegistry.registerWorldGenerator(new BDWorldGen());
		GameRegistry.registerWorldGenerator(new OreGeneration());
		GameRegistry.registerWorldGenerator(new RedStoneCrystalGen());
		
		proxy.registerRenderThings();
				
		//Registry
		
		GameRegistry.registerBlock(voidPortal);
		
		DimensionManager.registerProviderType(TheVoid.dimensionId, WorldProviderVoid.class, false);
		DimensionManager.registerDimension(TheVoid.dimensionId, TheVoid.dimensionId);
		
		GameRegistry.registerBlock(blood_Flowing, "Blood_Flowing");
		GameRegistry.registerBlock(blood_Still, "Blood_Still");
		GameRegistry.registerBlock(voidFire);
		
		GameRegistry.registerBlock(voidMineralBlock, "Void Mineral Block");
		GameRegistry.registerBlock(voidMineralGlowingBlock, "Void Mineral Block Glowing");
		GameRegistry.registerBlock(blockSpoooookyLantern);
		GameRegistry.registerBlock(blockSpoooooky);
		GameRegistry.registerBlock(blockDeadCobbleStone);
		GameRegistry.registerBlock(blockDeadStoneBrick);
		GameRegistry.registerBlock(blockDeadStone);
		GameRegistry.registerBlock(blockGraveYardGrass);
		GameRegistry.registerBlock(blockGraveYardDirt);
		GameRegistry.registerBlock(BlockColorG);
		GameRegistry.registerBlock(BlockRedStoneCrystal);
	    GameRegistry.registerBlock(blockRLog);
		GameRegistry.registerBlock(redWoodLeaves);
		GameRegistry.registerBlock(RedWoodSapling);
		GameRegistry.registerBlock(RedWoodPlanks);
		GameRegistry.registerBlock(BlockBlackDiamondOre);
		
		LanguageRegistry.addName(voidMineralGlowingBlock, "Suspicious Glowing Block");
		LanguageRegistry.addName(voidMineralBlock, "Suspicious Block");
		LanguageRegistry.addName(voidFire, "Block Void Fire");
		LanguageRegistry.addName(blockSpoooookyLantern, "Spoooookier");
		LanguageRegistry.addName(blockSpoooooky, "Spoooooky");
		LanguageRegistry.addName(voidPortal, "Void Portal");
		LanguageRegistry.addName(blockDeadCobbleStone, "Dead Cobblestone");
		LanguageRegistry.addName(blockDeadStoneBrick, "Dead Stone Brick");
		LanguageRegistry.addName(blockDeadStone, "Dead Stone");
		LanguageRegistry.addName(blockGraveYardGrass, "Graveyard Grass");
		LanguageRegistry.addName(blockGraveYardDirt, "Graveyard Dirt");
		LanguageRegistry.addName(blood_Flowing, "Blood");
		LanguageRegistry.addName(RedStonePickPart3, "Red Stone Pickaxe Part Three");
		LanguageRegistry.addName(RedStonePickPart2, "Red Stone Pickaxe Part Two");
		LanguageRegistry.addName(RedStonePickPart1, "Red Stone Pickaxe Part One");
		LanguageRegistry.addName(ItemRedStoneStick, "Red Stone Stick");
		LanguageRegistry.addName(ItemRedStonePick, "Red Stone Pickaxe");
		LanguageRegistry.addName(BlockColorG, "Color Glass");
		LanguageRegistry.addName(BlockRedStoneCrystal, "Red Stone Crystal");
	    LanguageRegistry.addName(BlockBlackDiamondOre, "Black Diamond Ore");
	    LanguageRegistry.addName(blockRLog, "Redwood Log");
		LanguageRegistry.addName(redWoodLeaves, "Redwood Leaves");
		LanguageRegistry.addName(RedWoodSapling, "Redwood Sapling");
		LanguageRegistry.addName(RedWoodPlanks, "Redwood Planks");
		LanguageRegistry.addName(ItemRedStoneSword, "Red Stone Sword");
		LanguageRegistry.addName(ItemBlackDiamond, "Black Diamond");
		LanguageRegistry.addName(ItemRedStoneCrystal, "Red Stone Crystal");
		LanguageRegistry.addName(SuspiciousMinerals, " Suspicious Minerals");
		LanguageRegistry.addName(voidPortalStaff, "Void Portal Staff");
		
		//Recipes
		
		GameRegistry.addShapelessRecipe(new ItemStack(TheVoid.blockDeadStoneBrick, 4), new Object[] { TheVoid.blockDeadStone, TheVoid.blockDeadStone, TheVoid.blockDeadStone, TheVoid.blockDeadStone });
		
		GameRegistry.addRecipe(new ItemStack(TheVoid.blockDeadStoneBrick, 4), new Object[]{
            "ABC",
			" D ",
            " D ",
            'A', TheVoid.RedStonePickPart1,  'B', TheVoid.RedStonePickPart2, 'C', TheVoid.RedStonePickPart3, 'D', TheVoid.ItemRedStoneStick
     });
		
		GameRegistry.addRecipe(new ItemStack(TheVoid.blockSpoooookyLantern, 1), new Object[]{
            " B ",
			" A ",
            "   ",
            'A', Item.bone,  'B', TheVoid.blockSpoooooky
     });
		
		GameRegistry.addRecipe(new ItemStack(TheVoid.ItemRedStonePick, 1), new Object[]{
            "ABC",
			" D ",
            " D ",
            'A', TheVoid.RedStonePickPart1,  'B', TheVoid.RedStonePickPart2, 'C', TheVoid.RedStonePickPart3, 'D', TheVoid.ItemRedStoneStick
     });
		
		GameRegistry.addRecipe(new ItemStack(TheVoid.voidPortalStaff, 1), new Object[]{
            "ABA",
			" D ",
            " D ",
            'A', TheVoid.ItemBlackDiamond,  'B', TheVoid.SuspiciousMinerals, 'D', TheVoid.ItemRedStoneStick
     });
		
		GameRegistry.addShapedRecipe(new ItemStack(TheVoid.RedStonePickPart3, 1), new Object[]{
            " YY",
            " XX",
            'X', TheVoid.ItemBlackDiamond,  'Y', TheVoid.ItemRedStoneCrystal
     });
		
		GameRegistry.addRecipe(new ItemStack(TheVoid.RedStonePickPart2, 1), new Object[]{
            " Y ",
            " X ",
            'X', TheVoid.ItemBlackDiamond,  'Y', TheVoid.ItemRedStoneCrystal
     });
		
		GameRegistry.addShapedRecipe(new ItemStack(TheVoid.RedStonePickPart1, 1), new Object[]{
            "XX ",
            "YY ",
            'X', TheVoid.ItemBlackDiamond,  'Y', TheVoid.ItemRedStoneCrystal
     });
		
		GameRegistry.addRecipe(new ItemStack(TheVoid.ItemRedStoneStick, 2), new Object[]{
            "XZY",
            "XZY",
            "XZY",
            'X', TheVoid.ItemBlackDiamond,  'Y', TheVoid.ItemRedStoneCrystal, 'Z', Item.stick
     });
		
		GameRegistry.addRecipe(new ItemStack(TheVoid.RedWoodPlanks, 4), new Object[]{
            "X",
            'X', TheVoid.blockRLog,  'X', TheVoid.blockRLog, 'Z', new ItemStack(TheVoid.blockRLog, 251, 1)
     });
		
		GameRegistry.addRecipe(new ItemStack(Item.stick, 4), new Object[]{
            "X",
            "X",
            'X', TheVoid.RedWoodPlanks, 'Z', new ItemStack(TheVoid.RedWoodPlanks, 250, 2)
     });
		
		GameRegistry.addRecipe(new ItemStack(Block.workbench, 1), new Object[]{
            "XX",
            "XX",
            'X', TheVoid.RedWoodPlanks,  'X', TheVoid.RedWoodPlanks, 'Z', new ItemStack(TheVoid.RedWoodPlanks, 250, 2)
     });
		
		GameRegistry.addRecipe(new ItemStack(TheVoid.ItemRedStoneSword, 1), new Object[]{"SGS", "SGS", " O ", 'G', TheVoid.ItemBlackDiamond, 'S', TheVoid.ItemRedStoneCrystal, 'O', Item.stick});
		//Entities
		
		 EntityRegistry.registerModEntity(EntityKitty.class, "Kitty", 1, this, 80, 3, true);
		 
		 
		 EntityRegistry.addSpawn(EntityKitty.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.beach,
					BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills,
					BiomeGenBase.jungle,              BiomeGenBase.jungleHills,               BiomeGenBase.mushroomIsland,
					BiomeGenBase.mushroomIslandShore,    BiomeGenBase.ocean,     BiomeGenBase.plains, BiomeGenBase.river,
					BiomeGenBase.swampland);
		 
		 LanguageRegistry.instance().addStringLocalization("entity.kjake701_RandomStuff.Kitty.name", "Kitty");
		 
		 registerEntityEgg(EntityKitty.class, 0xffffff, 0x000000);
		
	}
	
	public static int getUniqueEntityId()
    {
     do
     {
      startEntityId++;
     }
     while (EntityList.getStringFromID(startEntityId) != null);
 
     return startEntityId;
    }

    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
    {
     int id = getUniqueEntityId();
     EntityList.IDtoClassMapping.put(id, entity);
     EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }


	
}
