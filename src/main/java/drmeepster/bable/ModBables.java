package drmeepster.bable;

import baubles.api.BaublesApi;
import baubles.api.cap.BaublesCapabilities;
import baubles.api.cap.IBaublesItemHandler;
import drmeepster.bable.block.BableBlocks;
import drmeepster.bable.item.BableItems;
import drmeepster.bable.potion.BablePotions;
import drmeepster.bable.proxy.ClientProxy;
import drmeepster.bable.proxy.IProxy;
import drmeepster.bable.recipe.BableRecipies;
import drmeepster.bable.util.BablesAchieve;
import drmeepster.bable.util.TabBable;
import drmeepster.bable.util.Util;
import drmeepster.drcorester.ModDrCorester;
import drmeepster.drcorester.property.PropertyHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;

@Mod(modid = ModBables.MODID, useMetadata = true)
public class ModBables {
	
	public static final String MODID = "bables";
	@SidedProxy(clientSide = "drmeepster.bable.proxy.ClientProxy", serverSide = "drmeepster.bable.proxy.ServerProxy")
	public static IProxy proxy;
	
	public static final DamageSource DAMAGE_THAR = new DamageSource("thar").setDamageAllowedInCreativeMode().setDamageIsAbsolute();
	public static final DamageSource DAMAGE_SMITH = new DamageSource("smith").setDamageAllowedInCreativeMode().setDamageIsAbsolute();
	public static final TabBable TAB_BABLE = new TabBable();
	
	public static boolean devItems;
	public static String nbtTestString;
	public static int nbtTestInt;
	public static boolean badJava = false;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws Throwable{
		if(!Loader.instance().java8){
			FMLRelaunchLog.severe("WARNING! Bables requires Java 8! Things will propably not work!");
			badJava = true;
		}
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		ConfigCategory dev = config.getCategory("dev");
		config.addCustomCategoryComment(dev.getName(), "A few developer configs for Bable.");
		
		devItems = config.getBoolean("allowDevItems", dev.getName(), false, "Adds in items used to test Bables.");
		nbtTestString = config.getString("nbtTestString", dev.getName(), "beepboopimarobot", "The string that is used for the item \"item.bables_trinket_nbt_test.name\".");
		nbtTestInt = config.getInt("nbtTestInt", dev.getName(), 101010, Integer.MIN_VALUE, Integer.MAX_VALUE, "The int that is used for the item \"item.bables_trinket_nbt_test.name\".");
		
		config.save();
		
		if(badJava && ModDrCorester.careAboutJava){
			throw new UnknownError("Bables requires Java 8 to function normally! If you want to run the game still, disable \"careAboutJVMVersion\" in the config");
		}
		
		if(devItems){
			FMLRelaunchLog.info("Bables Dev items enabled with test string, \"%s\"", nbtTestString);
		}
		BablePotions.init();
		BableItems.init();
		BableBlocks.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		BableRecipies.init();
		BablesAchieve.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
	
	}
}
