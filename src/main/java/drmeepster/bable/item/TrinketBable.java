package drmeepster.bable.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import drmeepster.bable.ModBables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
//Optional
public class TrinketBable extends BasicBable{
	
	public static final String NAME = "trinket_bable";
	
	public TrinketBable() {
		super(NAME, ModBables.TAB_BABLE, true);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.TRINKET;
	}
}
