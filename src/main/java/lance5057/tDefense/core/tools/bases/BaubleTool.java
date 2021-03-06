package lance5057.tDefense.core.tools.bases;

import java.util.List;

import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;

//@Optional.InterfaceList({@Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.ISheathed"), @Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.shield.IArrowCatcher"), @Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.shield.IArrowDisplay"), @Optional.Interface(modid = "battlegear2", iface = "mods.battlegear2.api.shield.IShield")})
public abstract class BaubleTool extends ToolCore implements IBauble, IRenderBauble
{
	//protected static PartMaterialType ShieldMat = new PartMaterialType(TinkerTools.largePlate, ShieldMaterialStats.TYPE);
	
	public BaubleTool(PartMaterialType... requiredComponents)
	{
		super(requiredComponents);
		
//		this.addPropertyOverride(new ResourceLocation("block"), new IItemPropertyGetter()
//        {
//            @SideOnly(Side.CLIENT)
//            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
//            {
//            	float i = entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
//                return i;
//            }
//        });
	}

	protected float baseSpeed()
	{
		return 1.5f;
	}

	protected float effectiveSpeed()
	{
		return 15f;
	}

	public float breakSpeedModifier()
	{
		return 1.0f;
	}

//	@Override
//	public float getDigSpeed(ItemStack stack, Block block, int meta)
//	{
//		return 0.0f;
//	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
//	@Override
//	public EnumAction getItemUseAction(ItemStack par1ItemStack)
//	{
//		return EnumAction.BLOCK;
//	}
	
//	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
//    {
//        playerIn.setActiveHand(hand);
//        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
//    }
//	
//	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
//    {
//        return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
//    }

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
//		super.onUpdate(stack, world, entity, par4, par5);
//		if(entity instanceof EntityPlayerSP)
//		{
//			final EntityPlayerSP player = (EntityPlayerSP) entity;
//			final ItemStack usingItem = player.getActiveItemStack();
//			if(usingItem != null && usingItem.getItem() == this)
//			{
//				player.movementInput.moveForward *= 2.5F;
//				player.movementInput.moveStrafe *= 2.5F;
//			}
//		}
	}

	protected String getHarvestType()
	{
		return null;
	}

	@Override
	public float damagePotential() {
		// TODO Auto-generated method stub
		return 0.1f;
	}

	@Override
	public double attackSpeed() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public NBTTagCompound buildTag(
			List<slimeknights.tconstruct.library.materials.Material> materials) {
		ToolNBT data = buildDefaultTag(materials);
		return data.get();
	}
}
