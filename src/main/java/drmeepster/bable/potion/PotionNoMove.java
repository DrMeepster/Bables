package drmeepster.bable.potion;

import drmeepster.bable.ModBables;
import drmeepster.drcorester.potion.BasicPotion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionNoMove extends BasicPotion {
	
	public static final String NAME = "no_move";
	public static final int COLOR = 0x897c75;

	public PotionNoMove() {
		super(true, COLOR, NAME, ModBables.MODID);
	}
	
	@Override
	public void performEffect(EntityLivingBase entity, int amplifier){
		entity.setVelocity(0, 0, 0);
		entity.jumpMovementFactor = 0;
	}
}
