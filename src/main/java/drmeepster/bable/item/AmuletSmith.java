package drmeepster.bable.item;

import baubles.api.BaubleType;
import drmeepster.bable.ModBables;
import drmeepster.bable.block.BableBlocks;
import drmeepster.bable.potion.BablePotions;
import drmeepster.bable.util.BablesAchieve;
import drmeepster.drcorester.util.Util;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AmuletSmith extends BasicBable{
	
	public static final String NAME = "amulet_smith";
	private static PotionEffect noDie;
	private static PotionEffect noMove;
	private int timer;
	private int count;
	
	private World world;
	
	public AmuletSmith() {
		super(NAME, ModBables.TAB_BABLE);
		this.setMaxStackSize(1);
		noMove = new PotionEffect(BablePotions.noMove, Integer.MAX_VALUE, 200, true, true);
		noDie  = new PotionEffect(MobEffects.RESISTANCE, Integer.MAX_VALUE, 200, true, true);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.AMULET;
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player){
		if(this.isDamped(itemstack)){
			return;
		}
		player.addPotionEffect(noDie);
		player.addPotionEffect(noMove);
		
		player.resetPositionToBB();
		world = player.getEntityWorld();
		BlockPos playerPos = player.getPosition();
		
		world.setBlockState(Util.clearAir(world, playerPos, 50, false).down(), BableBlocks.anvilSmith.getDefaultState());
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player){

	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player){
		if(this.isDamped(itemstack)){
			return;
		}
		if(
		(player.getActivePotionEffect(Potion.getPotionById(11)) == null) || 
		(player.getActivePotionEffect(Potion.getPotionById(11)).getAmplifier() < 200)){
			player.addPotionEffect(noDie);
		}
		if(player.getActivePotionEffect(BablePotions.noMove) == null){
			player.addPotionEffect(noMove);
		}
		timer++;
		if(timer == 150){
			this.onEquipped(itemstack, player);
			timer = 0;
			count++;
		}
		if(count == 5){
			Util.wrath(player, BablesAchieve.achieveMeepWrath);
		}
	}
	
	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return this.isDamped(itemstack);
	}
}
