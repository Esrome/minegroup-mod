package catwolf57.mgmod.items;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinegroupMod.MINEGROUP);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		MinegroupMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
