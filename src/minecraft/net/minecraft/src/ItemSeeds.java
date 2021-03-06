package net.minecraft.src;

public class ItemSeeds extends Item
{
    /**
     * The type of block this seed turns into (wheat or pumpkin stems for instance)
     */
    private int blockType;

    /** BlockID of the block the seeds can be planted on. */
    private int soilBlockID;
    private int soilBlockID2 = -1;

    public ItemSeeds(int par1, int par2, int par3)
    {
        super(par1);
        this.blockType = par2;
        this.soilBlockID = par3;
        this.setTabToDisplayOn(CreativeTabs.tabMaterials);
    }

	public ItemSeeds(int par1, int par2, int par3, int par4)
    {
        super(par1);
        this.blockType = par2;
        this.soilBlockID = par3;
        this.soilBlockID2 = par4;
        this.setTabToDisplayOn(CreativeTabs.tabMaterials);
    }

    public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6))
        {
            int var11 = par3World.getBlockId(par4, par5, par6);

            if ((var11 == this.soilBlockID || var11 == this.soilBlockID2) && par3World.isAirBlock(par4, par5 + 1, par6))
            {
                par3World.setBlockWithNotify(par4, par5 + 1, par6, this.blockType);
                --par1ItemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
