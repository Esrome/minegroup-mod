package catwolf57.mgmod.items.froyo;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemFroyo extends Item implements IHasModel {

	public static final int[] DYE_COLORS = new int[] {1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};

    public ItemFroyo(String name)
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinegroupMod.MINEGROUP);
		
		ModItems.ITEMS.add(this);
    }

    @Override
	public void registerModels() {
    	for(int i = 0; i < EnumDyeColor.values().length; i++)
		{
			MinegroupMod.proxy.registerVariantRenderer(this, i, "froyo_" + EnumDyeColor.values()[i].getName(), "inventory");
		}
	}
    
    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int i = stack.getMetadata();
        return super.getUnlocalizedName() + "_" + EnumDyeColor.values()[i].getUnlocalizedName();
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            for (int i = 0; i < 16; ++i)
            {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }
	
}
