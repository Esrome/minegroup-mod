package catwolf57.mgmod;

import catwolf57.mgmod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MinegroupTab extends CreativeTabs {
	public MinegroupTab(String label) { super("minegroupTab"); }
	public ItemStack getTabIconItem() { return new ItemStack(ModItems.MINEGROUP_CRYSTAL);}
}
