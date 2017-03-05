package drmeepster.bable.item.test;

import baubles.api.BaubleType;
import drmeepster.bable.ModBables;
import drmeepster.bable.item.BasicBable;
import net.minecraft.item.ItemStack;

public class TrinketCosmeticTest extends BasicBable {

	public static final String NAME = "trinket_cosmetic_test";
	
	public TrinketCosmeticTest(){
		super(NAME, ModBables.TAB_BABLE, true);
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.TRINKET;
	}

}
