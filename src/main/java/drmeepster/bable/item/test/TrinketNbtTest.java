package drmeepster.bable.item.test;

import java.util.List;

import baubles.api.BaubleType;
import drmeepster.bable.ModBables;
import drmeepster.bable.item.BasicBable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrinketNbtTest extends BasicBable {
	
	public static final String NAME = "trinket_nbt_test";
	
	public TrinketNbtTest(){
		super(NAME, ModBables.TAB_BABLE);
		this.setMaxStackSize(1);
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.TRINKET;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
    	super.addInformation(stack, playerIn, tooltip, advanced);
    	NBTTagCompound tag = stack.getTagCompound();
    	if(tag != null && tag.hasKey("beep", 3)){
			tooltip.add("\u00A7a" + String.valueOf(tag.getInteger("beep")) + "-" + ModBables.nbtTestString);
		}

    }
}
