package drmeepster.bable.item;

import java.util.List;
import java.util.function.Predicate;

import baubles.api.IBauble;
import drmeepster.bable.ModBables;
import drmeepster.drcorester.util.Util;
import drmeepster.drcorester.item.BasicItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BasicBable extends BasicItem implements IBauble{
	
	private boolean cosmetic;
	
	public BasicBable(String name, CreativeTabs tab, boolean cosmetic) {
		super(name, tab, ModBables.MODID);
		this.cosmetic = cosmetic;
	}
	
	public BasicBable(String name, boolean cosmetic) {
		this(name, null, cosmetic);
	}
	
	public BasicBable(String name, CreativeTabs tab){
		this(name, tab, false);
	}
	
	public BasicBable(String name){
		this(name, null, false);
	}

	public boolean isDamped(ItemStack stack){
		NBTTagCompound tag = stack.getTagCompound();
		if(tag != null){
			return tag.getBoolean("Damped");
		}else{
			return false;
		}
	}
	
	public boolean isCosmetic(){
		return cosmetic;
	}
	
	public boolean canDamp(ItemStack stack, boolean damp){
		return !cosmetic && Util.XOR.test(damp, isDamped(stack));
	}
	
	public boolean canDamp(ItemStack stack){
		return this.canDamp(stack, true);
	}
	
	public static final Predicate<ItemStack> CAN_DAMP = a -> a.getItem() instanceof BasicBable && ((BasicBable)a.getItem()).canDamp(a, true);
	public static final Predicate<ItemStack> CAN_UNDAMP = a -> a.getItem() instanceof BasicBable && ((BasicBable)a.getItem()).canDamp(a, false);
		
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		if(isDamped(stack)){
			tooltip.add("\u00A74" + I18n.translateToLocal("tooltip.damped"));
		}
		if(cosmetic){
			tooltip.add("\u00A74" + I18n.translateToLocal("tooltip.cosmetic"));
		}
	}
	
	public ItemStack damp(ItemStack stack, boolean damp, boolean absoulute){
		if(!absoulute && !this.canDamp(stack, damp)){
			return stack;
		}
		NBTTagCompound tag = stack.getTagCompound();
		if(tag == null){
			tag = new NBTTagCompound();
		}
		tag.setBoolean("Damped", damp);
		stack.setTagCompound(tag);
		return stack;
	}
}
