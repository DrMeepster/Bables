package drmeepster.bable.util;

import drmeepster.bable.ModBables;
import drmeepster.bable.item.BableItems;
import drmeepster.drcorester.property.PropertyHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBable extends CreativeTabs{
	
	public static final String NAME = "tabBable";
	
	public TabBable() {
		super(PropertyHandler.getName(ModBables.MODID, NAME));
	}

	@Override
	public Item getTabIconItem() {
		return BableItems.iconAmuletLegend;
	}
	
	public boolean hasSearchBar() {
		 return false;
	}

}
