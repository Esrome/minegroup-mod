package catwolf57.mgmod.items;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import net.minecraft.item.ItemFood;

public class ItemFoodBase extends ItemFood implements IHasModel {

	public ItemFoodBase(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
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
