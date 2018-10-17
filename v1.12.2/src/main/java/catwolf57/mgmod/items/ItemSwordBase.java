package catwolf57.mgmod.items;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword implements IHasModel {

	public ItemSwordBase(ToolMaterial material, String name){
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
