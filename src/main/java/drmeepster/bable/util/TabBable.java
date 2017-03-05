package drmeepster.bable.util;

import drmeepster.bable.ModBables;
import drmeepster.bable.item.BableItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBable extends CreativeTabs{

	public TabBable() {
		super(ModBables.MODID + ":TabBable");
	}

	@Override
	public Item getTabIconItem() {
		return BableItems.iconAmuletLegend;
	}
	
	public boolean hasSearchBar() {
		 return false;
	}

}
