package drmeepster.bable.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import drmeepster.bable.ModBables;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrownFallOutOfWorld extends BasicBable{
	
	public static final String NAME = "crown_fall_out_of_world";
	
	public CrownFallOutOfWorld() {
		super(NAME, ModBables.TAB_BABLE);
		this.setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.HEAD;
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player){

	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player){

	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player){
		player.noClip = true;
		if(player.posY <= 0){
			if(player instanceof EntityPlayer){
				System.out.println("booooooooooooooooooooop");
				BlockPos pos = player.getPosition();
				player.setPosition(pos.getX(), player.getEntityWorld().getActualHeight() - 1, pos.getZ());
			}
			player.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
		}
	}
}
