package drmeepster.bable.item;

import java.util.Random;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import drmeepster.bable.ModBables;
import drmeepster.bable.potion.BablePotions;
import drmeepster.bable.util.Util;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TrinketStupid extends BasicBable{
	
	public static final String NAME = "trinket_stupid";
	private AttributeModifier modifier;
	
	public TrinketStupid() {
		super(NAME, ModBables.TAB_BABLE);
		this.setMaxStackSize(1);
		modifier = new AttributeModifier(getName(), 0, 2);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.TRINKET;
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player){
		player.getAttributeMap().getAttributeInstanceByName("generic.attackDamage").applyModifier(modifier);
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player){
		player.getAttributeMap().getAttributeInstanceByName("generic.attackDamage").removeModifier(modifier);
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player){
		if(new Random().nextInt(11) == 5){
			player.moveRelative(1, 0, 0.25F);
		}
		if(new Random().nextInt(11) == 5){
			player.moveRelative(0, 1, 0.25F);
		}
		if(new Random().nextInt(11) == 5){
			player.moveRelative(-1, 0, 0.25F);
		}
		if(new Random().nextInt(11) == 5){
			player.moveRelative(0, -1, 0.25F);
		}
	}
	
	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
}
