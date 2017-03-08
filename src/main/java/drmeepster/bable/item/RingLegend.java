package drmeepster.bable.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import drmeepster.bable.ModBables;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RingLegend extends BasicBable{
	
	public static final String NAME = "ring_legend";
	private int tick = 5;
	private World world;
	private BlockPos playerPos;
	private EntityLightningBolt lightning;
	
	public RingLegend() {
		super(NAME, ModBables.TAB_BABLE);
		this.setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}
	
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player){
		if(!this.isDamped(itemstack)){
			player.attackEntityFrom(ModBables.DAMAGE_THAR, Float.MAX_VALUE);
		}
		world = player.getEntityWorld();
		playerPos = player.getPosition();
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player){
		tick = 5;
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player){
		if(tick >= ModBables.tharTickDelay && ModBables.tharTickDelay != -1){
			lightning = new EntityLightningBolt(world, (double)playerPos.getX(), (double)playerPos.getY(), (double)playerPos.getZ(), true);
			world.spawnEntityInWorld(lightning);
			tick = 5;
		}
	}
}
