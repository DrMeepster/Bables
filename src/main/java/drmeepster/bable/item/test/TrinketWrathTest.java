package drmeepster.bable.item.test;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import drmeepster.bable.ModBables;
import drmeepster.bable.item.BasicBable;
import drmeepster.bable.util.BablesAchieve;
import drmeepster.drcorester.util.Util;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TrinketWrathTest extends BasicBable{
	
	public static final String NAME = "trinket_wrath_test";
	
	public TrinketWrathTest() {
		super(NAME, ModBables.TAB_BABLE);
		this.setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.TRINKET;
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player){
		if(!this.isDamped(itemstack)){
			Util.wrath(player, BablesAchieve.achieveMeepWrath);
		}
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player){
		
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player){
		
	}
}
