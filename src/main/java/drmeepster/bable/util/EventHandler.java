package drmeepster.bable.util;

import baubles.api.BaublesApi;
import drmeepster.bable.item.AmuletSmith;
import drmeepster.bable.item.BableItems;
import drmeepster.bable.item.BasicBable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.BlockWorkbench.InterfaceCraftingTable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class EventHandler {
	
	@Mod.EventBusSubscriber
	public static class witchKill{
		@SubscribeEvent
		public static void event(LivingDeathEvent event){
			EntityLivingBase entity = event.getEntityLiving();
			EntityLivingBase attacker = entity.getAttackingEntity();
			if(
			(entity instanceof EntityWitch) && 
			(attacker instanceof EntityPlayer)){
				if((BaublesApi.getBaublesHandler((EntityPlayer)attacker).getStackInSlot(3) != null) &&
				(BaublesApi.getBaublesHandler((EntityPlayer)attacker).getStackInSlot(3).getItem() == BableItems.beltKinesis)){
					((EntityPlayer)attacker).addStat(BablesAchieve.achieveSpinKill);
				}
				for(int i = 0; i < BaublesApi.getBaublesHandler((EntityPlayer)attacker).getSlots(); i++){
					if((BaublesApi.getBaublesHandler((EntityPlayer)attacker).getStackInSlot(i) != null) &&
					(BaublesApi.getBaublesHandler((EntityPlayer)attacker).getStackInSlot(i).getItem() == BableItems.trinketStupid)){
						((EntityPlayer)attacker).addStat(BablesAchieve.achieveDerpWitch);
					}
				}
			}
		}
	}
	
	@Mod.EventBusSubscriber
	public static class amuletRelog{
		@SubscribeEvent
		public static void event(PlayerLoggedInEvent event){
			EntityPlayer player = event.player;
			System.out.println("meep");
			ItemStack stack = BaublesApi.getBaublesHandler(player).getStackInSlot(0);
			if((stack != null) && (stack.getItem() == BableItems.amuletSmith)){
				((AmuletSmith)stack.getItem()).onEquipped(stack, player);
			}else if(stack != null){
				System.out.println(stack.getItem().getUnlocalizedName());
			}
		}
	}
	
	@Mod.EventBusSubscriber
	public static class craft{
		@SubscribeEvent
		public static void event(ItemCraftedEvent event){
			System.out.println("BOOm!");
			
			if(event.crafting.getItem() == BableItems.trinketBable){
				event.player.addStat(BablesAchieve.achieveBableCraft);
			}else if(event.crafting.getItem() == BableItems.trinketStupid){
				event.player.addStat(BablesAchieve.achieveStupidCraft);
			}
		}
	}
	
	@Mod.EventBusSubscriber
	public static class death{
		@SubscribeEvent
		public static void event(PlayerRespawnEvent event){
			ItemStack s = BaublesApi.getBaublesHandler(event.player).getStackInSlot(4);
			if(s != null && s.getItem() == BableItems.crownFallOutOfWorld){
				event.player.noClip = true;
			}
		}
	}
}
