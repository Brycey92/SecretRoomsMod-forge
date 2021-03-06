package com.wynprice.secretroomsmod.blocks;

import java.util.Collection;

import com.wynprice.secretroomsmod.base.interfaces.ISecretBlock;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SecretStairs extends BlockStairs implements ISecretBlock
{
	public SecretStairs() {
		super(Blocks.STONE.getDefaultState());
		setRegistryName("secret_stairs");
		setUnlocalizedName("secret_stairs");
		this.setHardness(0.5f);
		this.translucent = true;
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return ISecretBlock.super.getBoundingBox(state, source, pos);
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		return true;
	}
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
		return false;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return ISecretBlock.super.getBlockFaceShape(worldIn, state, pos, face);
	}
	
	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos)  {
		return ISecretBlock.super.getBlockHardness(blockState, worldIn, pos);
	}
	
	@Override
	public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return ISecretBlock.super.isSideSolid(base_state, world, pos, side);
	}
	
	@Override
	public SoundType getSoundType(IBlockState state, World world, BlockPos pos, Entity entity) 
	{
		return ISecretBlock.super.getSoundType(state, world, pos, entity);
	}
	
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean addHitEffects(IBlockState state, World worldObj, RayTraceResult target, ParticleManager manager) 
	{
		return ISecretBlock.super.addHitEffects(state, worldObj, target, manager);
	}
		
	@SideOnly(Side.CLIENT)
	@Override
	public boolean addDestroyEffects(World world, BlockPos pos, ParticleManager manager) 
	{
		return ISecretBlock.super.addDestroyEffects(world, pos, manager);
	}
	
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    
	@SideOnly(Side.CLIENT)
    @Override
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) 
    {
		return ISecretBlock.super.canRenderInLayer(state, layer);
    }
    
	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) 
	{
		return super.getExtendedState(ISecretBlock.super.getExtendedState(state, world, pos), world, pos);
	}
    
    @Override
    protected BlockStateContainer createBlockState() {
    	Collection < IProperty<? >> properties = super.createBlockState().getProperties();
    	return new ExtendedBlockState(this, properties.toArray(new IProperty[properties.size()]), new IUnlistedProperty[] {RENDER_PROPERTY});
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
    	return ISecretBlock.super.isOpaqueCube(state);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public float getAmbientOcclusionLightValue(IBlockState state) {
    	return ISecretBlock.super.getAmbientOcclusionLightValue(state);
    }
    
    @Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
		return ISecretBlock.super.canCreatureSpawn(state, world, pos, type);
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ISecretBlock.super.getActualState(state, worldIn, pos, super.getActualState(state, worldIn, pos));
	}
	
	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
		return ISecretBlock.super.canHarvestBlock(world, pos, player);
	}
	
	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return ISecretBlock.super.canBeConnectedTo(world, pos, facing);
	}
	
	@Override
	public int getLightOpacity(IBlockState state, IBlockAccess world, BlockPos pos) {
		return ISecretBlock.super.getLightOpacity(state, world, pos);
	}
	
	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
		return ISecretBlock.super.getLightValue(state, world, pos);
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return ISecretBlock.super.getHarvestTool(state);
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return ISecretBlock.super.getHarvestLevel(state);
	}
	
	@Override
	public boolean addRunningEffects(IBlockState state, World world, BlockPos pos, Entity entity) {
		return ISecretBlock.super.addRunningEffects(state, world, pos, entity);
	}
	
	@Override
	public boolean addLandingEffects(IBlockState state, WorldServer worldObj, BlockPos blockPosition,
			IBlockState iblockstate, EntityLivingBase entity, int numberOfParticles) {
		return ISecretBlock.super.addLandingEffects(state, worldObj, blockPosition, iblockstate, entity, numberOfParticles);
	}
	
	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return ISecretBlock.super.canConnectRedstone(state, world, pos, side);
	}
	
	@Override
	public float getSlipperiness(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
		return ISecretBlock.super.getSlipperiness(state, world, pos, entity);
	}
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return ISecretBlock.super.canPlaceTorchOnTop(state, world, pos);
	}
	
	@Override
	public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start,
			Vec3d end) {
		return ISecretBlock.super.collisionRayTrace(blockState, worldIn, pos, start, end);
	}
	
	@Override
    public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos) {
    	return ISecretBlock.super.getPackedLightmapCoords(state, source, pos);
    }
}
