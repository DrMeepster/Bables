package drmeepster.bable.item.test;

import static drmeepster.drcorester.util.Util.register;

import java.util.ArrayList;

import drmeepster.bable.ModBables;
import drmeepster.bable.item.test.TrinketCosmeticTest;
import drmeepster.bable.item.test.TrinketWrathTest;
import drmeepster.drcorester.item.BasicItem;
import net.minecraft.item.Item;

public class BableTestItems {
	
	public static TrinketCosmeticTest trinketCosmeticTest;
	public static TrinketWrathTest trinketWrathTest;
	public static TrinketNbtTest trinketNbtTest;
	
	public static void init(){
		trinketCosmeticTest = register(new TrinketCosmeticTest());
		trinketWrathTest = register(new TrinketWrathTest());
		trinketNbtTest = register(new TrinketNbtTest());
	}
}
