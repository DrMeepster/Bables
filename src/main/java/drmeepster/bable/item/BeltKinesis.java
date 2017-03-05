package drmeepster.bable.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import drmeepster.bable.ModBables;
import drmeepster.bable.util.BablesAchieve;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class BeltKinesis extends BasicBable{
	
	public static final String NAME = "belt_kinesis";
	private int tick = 0;
	private float yaw = 0;
	private World world;
	
	public BeltKinesis() {
		super(NAME, ModBables.TAB_BABLE);
		this.setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player){
		yaw = player.rotationYaw;
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player){
		
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player){
		if(this.isDamped(itemstack)){
			return;
		}
		player.rotationYaw += 0.5;
	}
	
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		if(this.isDamped(itemstack)){
			return true;
		}
		world = player.getEntityWorld();
		if(player instanceof EntityPlayer){
			if(((EntityPlayer)player).hasAchievement(BablesAchieve.achieveSpinKill)){
				return true;
			}
		}
		for(ItemStack s : OreDictionary.getOres("stone")){
			Block b = Block.getBlockFromItem(s.getItem());
			if(b == null){
				continue;
			}else if(world.getBlockState(player.getPosition().down()).getBlock() == b){
				return true;
			}
		}
		return false;
	}
}
