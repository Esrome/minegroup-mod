package catwolf57.mgmod.items;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemArmorBase extends ItemArmor implements IHasModel {

	public ItemArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) 
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinegroupMod.MINEGROUP);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		MinegroupMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
