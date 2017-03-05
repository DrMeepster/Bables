package drmeepster.bable.item;

import static drmeepster.drcorester.util.Util.register;

import java.util.ArrayList;

import drmeepster.bable.ModBables;
import drmeepster.bable.item.test.BableTestItems;
import drmeepster.bable.item.test.TrinketCosmeticTest;
import drmeepster.bable.item.test.TrinketWrathTest;
import drmeepster.drcorester.item.BasicItem;
import net.minecraft.item.Item;

public class BableItems {
	
	public static RingLegend ringLegend;
	public static BeltKinesis beltKinesis;
	public static AmuletSmith amuletSmith;
	public static TrinketBable trinketBable;
	public static TrinketStupid trinketStupid;
	public static CrownFallOutOfWorld crownFallOutOfWorld;
	
	public static BasicItem iconMagicSpin;
	public static BasicItem iconPureRage;
	public static BasicItem iconAmuletLegend;
	public static BasicItem powderDamp;
	public static BasicItem gooUndamp;
	public static BasicItem iconDerpWitch;
	
	public static BasicItem placeholder;
	
	public static ArrayList<Item> list = new ArrayList();
	
	public static void init(){
		ringLegend = register(new RingLegend(), list);
		beltKinesis = register(new BeltKinesis(), list);
		amuletSmith = register(new AmuletSmith(), list);
		trinketBable = register(new TrinketBable(), list);
		trinketStupid = register(new TrinketStupid(), list);
		crownFallOutOfWorld = register(new CrownFallOutOfWorld(), list);
		
		iconMagicSpin = register(new BasicItem("icon_magic_spin", ModBables.MODID), list);
		iconPureRage = register(new BasicItem("icon_pure_rage", ModBables.MODID), list);
		iconAmuletLegend = register(new BasicItem("icon_amulet_legend", ModBables.MODID), list);
		powderDamp = register(new BasicItem("powder_damp", ModBables.TAB_BABLE, ModBables.MODID), list);
		gooUndamp = register(new BasicItem("goo_undamp", ModBables.TAB_BABLE, ModBables.MODID), list);
		iconDerpWitch = register(new BasicItem("icon_derp_witch", ModBables.MODID), list);
		
		if(ModBables.devItems){
			BableTestItems.init();
		}
	}
}
