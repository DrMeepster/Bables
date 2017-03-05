package drmeepster.bable.block;

import java.util.Random;

import drmeepster.bable.ModBables;
import drmeepster.drcorester.util.Util;
import drmeepster.drcorester.block.BasicBlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AnvilSmith extends BasicBlockFalling{
	
	public static final String NAME = "anvil_smith";
	
	public AnvilSmith(){
		super(Material.IRON, NAME, null, ModBables.MODID);
		this.setSoundType(SoundType.ANVIL);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		super.updateTick(worldIn, pos, state, rand);
        if(!this.canFallThrough(worldIn.getBlockState(pos.down()))){
        	
        	for(EntityPlayer player : Util.getPlayersAtPos(worldIn, pos, 0)){
        		player.attackEntityFrom(ModBables.DAMAGE_SMITH, Float.MAX_VALUE);
        	}
        	if(!worldIn.isRemote){
        		worldIn.setBlockToAir(pos);
        	}
        	worldIn.playSound(null, pos, SoundEvent.REGISTRY.getObject(new ResourceLocation("block.anvil.land")), SoundCategory.BLOCKS, 2, 1);
        }
    }
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face){
		return false;
	}
}
