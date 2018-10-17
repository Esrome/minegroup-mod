package catwolf57.mgmod.items;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemShovelBase extends ItemSpade implements IHasModel {

	public ItemShovelBase(ToolMaterial material, String name){
		super(material);
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
