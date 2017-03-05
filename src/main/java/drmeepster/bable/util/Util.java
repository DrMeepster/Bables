package drmeepster.bable.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import drmeepster.bable.ModBables;
import drmeepster.bable.item.BableItems;
import drmeepster.drcorester.ModDrCorester;
import drmeepster.drcorester.block.IBasicBlock;
import drmeepster.drcorester.proxy.ClientProxy;
import drmeepster.drcorester.util.IBasicObject;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Util{
		
	public static boolean unEquipBauble(EntityPlayer player, int slot){
		IBaublesItemHandler handler = BaublesApi.getBaublesHandler(player);
		ItemStack bauble = handler.extractItem(slot, Integer.MAX_VALUE, false);
		if(bauble == null){
			return false;
		}
		if(!player.inventory.addItemStackToInventory(bauble)){
			World world = player.getEntityWorld();
			BlockPos playerPos = player.getPosition();
			
			EntityItem entItem = new EntityItem(world, (double)playerPos.getX(), (double)playerPos.getY(), (double)playerPos.getZ(), bauble);
			entItem.setDefaultPickupDelay();
			world.spawnEntityInWorld(entItem);
		}
		return true;
	}
	
	//TODO Add code below this line to DrCorester
}