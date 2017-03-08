package drmeepster.bable.recipe;

import java.util.ArrayList;
import java.util.List;

import drmeepster.bable.ModBables;
import drmeepster.bable.item.BableItems;
import drmeepster.bable.item.BasicBable;
import drmeepster.bable.item.test.BableTestItems;
import drmeepster.drcorester.recipes.NBTShapelessRecipe;
import drmeepster.drcorester.util.Util;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BableRecipies {
	
	public static final NBTTagCompound DAMPED  = new NBTTagCompound();
	public static final NBTTagCompound UNDAMPED  = new NBTTagCompound();
	
	public static void init(){
		DAMPED.setBoolean("Damped", true);
		UNDAMPED.setBoolean("Damped", false);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.ringLegend)
				, "GS "
				, "SDS"
				, "TS "
				, 'G', Items.GOLD_INGOT
				, 'S', "stick"
				, 'D', Items.DIAMOND
				, 'T', BableItems.trinketBable
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.ringLegend)
				, " SG"
				, "SDS"
				, " ST"
				, 'G', Items.GOLD_INGOT
				, 'S', "stick"
				, 'D', Items.DIAMOND
				, 'T', BableItems.trinketBable
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.ringLegend)
				, " ST"
				, "SDS"
				, " SG"
				, 'G', Items.GOLD_INGOT
				, 'S', "stick"
				, 'D', Items.DIAMOND
				, 'T', BableItems.trinketBable
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.ringLegend)
				, "TS "
				, "SDS"
				, "GS "
				, 'G', Items.GOLD_INGOT
				, 'S', "stick"
				, 'D', Items.DIAMOND
				, 'T', BableItems.trinketBable
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.beltKinesis)
				, " P "
				, "LLL"
				, "TS "
				, 'L', Items.LEATHER
				, 'P', Blocks.PISTON
				, 'S', "stone"
				, 'T', BableItems.trinketBable
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.beltKinesis)
				, "TS "
				, "LLL"
				, " P "
				, 'L', Items.LEATHER
				, 'P', Blocks.PISTON
				, 'S', "stone"
				, 'T', BableItems.trinketBable
		));
		
		GameRegistry.addRecipe(new ItemStack(BableItems.amuletSmith)
				, "STS"
				, " S "
				, "ICI"
				, 'S', Items.STRING
				, 'C', Items.COAL
				, 'I', Items.IRON_INGOT
				, 'T', BableItems.trinketBable
		);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.trinketBable)
				, " W "
				, "WDW"
				, " W "
				, 'W', "plankWood"
				, 'D', "dyeOrange"
		));
		
		GameRegistry.addRecipe(new ItemStack(BableItems.trinketStupid)
				, " TP"
				, "DBD"
				, "ST "
				, 'B', BableItems.trinketBable
				, 'D', Blocks.DIRT
				, 'T', Blocks.TNT
				, 'S', Items.NETHER_STAR
				, 'P', Items.PRISMARINE_CRYSTALS
		);
		
		GameRegistry.addRecipe(new ItemStack(BableItems.trinketStupid)
				, "PT "
				, "DBD"
				, " TS"
				, 'B', BableItems.trinketBable
				, 'D', Blocks.DIRT
				, 'T', Blocks.TNT
				, 'S', Items.NETHER_STAR
				, 'P', Items.PRISMARINE_CRYSTALS
		);
		
		GameRegistry.addRecipe(new ItemStack(BableItems.trinketStupid)
				, " TS"
				, "DBD"
				, "PT "
				, 'B', BableItems.trinketBable
				, 'D', Blocks.DIRT
				, 'T', Blocks.TNT
				, 'S', Items.NETHER_STAR
				, 'P', Items.PRISMARINE_CRYSTALS
		);
		
		GameRegistry.addRecipe(new ItemStack(BableItems.trinketStupid)
				, "ST "
				, "DBD"
				, " TP"
				, 'B', BableItems.trinketBable
				, 'D', Blocks.DIRT
				, 'T', Blocks.TNT
				, 'S', Items.NETHER_STAR
				, 'P', Items.PRISMARINE_CRYSTALS
		);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.gooUndamp)
				, "DMD"
				, "DSD"
				, "DMD"
				, 'D', "dye"
				, 'M', Items.MAGMA_CREAM
				, 'S', "slimeball"
		));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BableItems.crownFallOutOfWorld)
				, " IT"
				, "IDI"
				, "III"
				, 'I', "ingotIron"
				, 'D', Items.DIAMOND
				, 'T', BableItems.trinketBable
		));
		
		ArrayList<ItemStack> list = new ArrayList<>();
		list.add(new ItemStack(BableTestItems.trinketNbtTest));
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("beep", ModBables.nbtTestInt);
		
		GameRegistry.addRecipe(new NBTShapelessRecipe(list.toArray(new ItemStack[0]), Util.setNbtData(new ItemStack(BableTestItems.trinketNbtTest), tag), null));
		
		for(Item item : BableItems.list){
			if(!(item instanceof BasicBable) || ((BasicBable)item).isCosmetic()){
				continue;
			}
			ArrayList<ItemStack> listA = new ArrayList<>();
			ArrayList<ItemStack> listB = new ArrayList<>();
			
			listA.add(new ItemStack(item));
			listA.add(new ItemStack(BableItems.powderDamp));
			listB.add(Util.setNbtData(new ItemStack(item), DAMPED));
			listB.add(new ItemStack(BableItems.gooUndamp));
			
			GameRegistry.addRecipe(new NBTShapelessRecipe(listA.toArray(new ItemStack[0]), Util.setNbtData(new ItemStack(item), DAMPED), BasicBable.CAN_DAMP));
			GameRegistry.addRecipe(new NBTShapelessRecipe(listB.toArray(new ItemStack[0]), Util.setNbtData(new ItemStack(item), UNDAMPED), BasicBable.CAN_UNDAMP));
		}
	}
}
