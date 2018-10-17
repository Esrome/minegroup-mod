package catwolf57.mgmod.init;

import java.util.ArrayList;
import java.util.List;

import catwolf57.mgmod.items.ItemArmorBase;
import catwolf57.mgmod.items.ItemAxeBase;
import catwolf57.mgmod.items.ItemBase;
import catwolf57.mgmod.items.ItemFoodBase;
import catwolf57.mgmod.items.ItemHoeBase;
import catwolf57.mgmod.items.ItemPickaxeBase;
import catwolf57.mgmod.items.ItemShovelBase;
import catwolf57.mgmod.items.ItemSwordBase;
import catwolf57.mgmod.items.froyo.ItemFroyo;
import catwolf57.mgmod.items.froyo.ItemFroyoSword;
import catwolf57.mgmod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	private static final ArmorMaterial CATESSENCE = EnumHelper.addArmorMaterial("catwolf", Reference.MODID + ":catwolfessence",  15, new int[]{2, 5, 6, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	private static final ArmorMaterial DESTINYCRYSTAL = EnumHelper.addArmorMaterial("destiny", Reference.MODID + ":destiny",  33, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	private static final ArmorMaterial WYRMTOOTH = EnumHelper.addArmorMaterial("wyrmtooth", Reference.MODID + ":wyrmtooth", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	private static final ArmorMaterial FROYOARMOR = EnumHelper.addArmorMaterial("froyo", Reference.MODID + ":froyo", 18, new int[]{2, 6, 7, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.0F);
	
	private static final ArmorMaterial CATCLOTH = EnumHelper.addArmorMaterial("catcloth", Reference.MODID + ":catwolfian", 33, new int[]{3, 6, 8, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
	private static final ArmorMaterial DESTINYCLOTH = EnumHelper.addArmorMaterial("destinycloth", Reference.MODID + ":destined", 66, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
	private static final ArmorMaterial WYRMSCALE = EnumHelper.addArmorMaterial("wyrmscale", Reference.MODID + ":wyrmscale", 33, new int[]{3,  6,  8,  3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 4.0F);
	
	private static final ToolMaterial CAT = EnumHelper.addToolMaterial("Catwolfian", 2, 250, 6.0F, 2.0F, 22);
	private static final ToolMaterial DESTINY = EnumHelper.addToolMaterial("Fated", 2, 1561, 6.0F, 2.0F, 14);
	private static final ToolMaterial WYRM = EnumHelper.addToolMaterial("Wyrm", 2, 250, 6.0F, 3.0F, 14);
	private static final ToolMaterial FROYOTOOLS = EnumHelper.addToolMaterial("Froyo", 2, 560, 6.1F, 2.5F, 16);
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item CATWOLFIAN_ASHES = new ItemBase("catwolfian_ashes");
	public static final Item CATWOLFIAN_SCROLL = new ItemBase("catwolfian_scroll");
	public static final Item CATWOLFIAN_CLOTH = new ItemBase("catwolfian_cloth");
	public static final Item CATWOLFIAN_ESSENCE = new ItemBase("catwolfian_essence");
	public static final Item CATWOLFIAN_ESSENCE_HELMET = new ItemArmorBase("catwolfessence_helmet", CATESSENCE, 1, EntityEquipmentSlot.HEAD);
	public static final Item CATWOLFIAN_ESSENCE_CHESTPLATE = new ItemArmorBase("catwolfessence_chestplate", CATESSENCE, 1, EntityEquipmentSlot.CHEST);
	public static final Item CATWOLFIAN_ESSENCE_LEGGINGS = new ItemArmorBase("catwolfessence_leggings", CATESSENCE, 2, EntityEquipmentSlot.LEGS);
	public static final Item CATWOLFIAN_ESSENCE_BOOTS = new ItemArmorBase("catwolfessence_boots", CATESSENCE, 1, EntityEquipmentSlot.FEET);
	public static final Item CATWOLFIAN_HELMET = new ItemArmorBase("catwolfian_helmet", CATCLOTH, 1, EntityEquipmentSlot.HEAD);
	public static final Item CATWOLFIAN_CHESTPLATE = new ItemArmorBase("catwolfian_chestplate", CATCLOTH, 1, EntityEquipmentSlot.CHEST);
	public static final Item CATWOLFIAN_LEGGINGS = new ItemArmorBase("catwolfian_leggings", CATCLOTH, 2, EntityEquipmentSlot.LEGS);
	public static final Item CATWOLFIAN_BOOTS = new ItemArmorBase("catwolfian_boots", CATCLOTH, 1, EntityEquipmentSlot.FEET);
	public static final Item CATWOLFIAN_AXE = new ItemAxeBase("catwolfian_axe", CAT);
	public static final Item CATWOLFIAN_HOE = new ItemHoeBase(CAT, "catwolfian_hoe");
	public static final Item CATWOLFIAN_PICKAXE = new ItemPickaxeBase(CAT, "catwolfian_pickaxe");
	public static final Item CATWOLFIAN_SHOVEL = new ItemShovelBase(CAT, "catwolfian_shovel");
	public static final Item CATWOLFIAN_SWORD = new ItemSwordBase(CAT, "catwolfian_sword");
	
	public static final Item DESTINY_INGOT = new ItemBase("destiny_ingot");
	public static final Item DESTINY_CLOTH = new ItemBase("destiny_cloth");
	public static final Item DESTINY_CRYSTAL_HELMET = new ItemArmorBase("destiny_helmet", DESTINYCRYSTAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item DESTINY_CRYSTAL_CHESTPLATE = new ItemArmorBase("destiny_chestplate", DESTINYCRYSTAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item DESTINY_CRYSTAL_LEGGINGS = new ItemArmorBase("destiny_leggings", DESTINYCRYSTAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item DESTINY_CRYSTAL_BOOTS = new ItemArmorBase("destiny_boots", DESTINYCRYSTAL, 1, EntityEquipmentSlot.FEET);
	public static final Item DESTINY_HELMET = new ItemArmorBase("destined_helmet", DESTINYCLOTH, 1, EntityEquipmentSlot.HEAD);
	public static final Item DESTINY_CHESTPLATE = new ItemArmorBase("destined_chestplate", DESTINYCLOTH, 1, EntityEquipmentSlot.CHEST);
	public static final Item DESTINY_LEGGINGS = new ItemArmorBase("destined_leggings", DESTINYCLOTH, 2, EntityEquipmentSlot.LEGS);
	public static final Item DESTINY_BOOTS = new ItemArmorBase("destined_boots", DESTINYCLOTH, 1, EntityEquipmentSlot.FEET);
	public static final Item DESTINY_AXE = new ItemAxeBase("destiny_axe", DESTINY);
	public static final Item DESTINY_HOE = new ItemHoeBase(DESTINY, "destiny_hoe");
	public static final Item DESTINY_PICKAXE = new ItemPickaxeBase(DESTINY, "destiny_pickaxe");
	public static final Item DESTINY_SHOVEL = new ItemShovelBase(DESTINY, "destiny_shovel");
	public static final Item DESTINY_SWORD = new ItemSwordBase(DESTINY, "destiny_sword");
	
	public static final Item MINEGROUP_CRYSTAL = new ItemBase("minegroup_crystal");
	public static final Item MINEGROUP_SHARD = new ItemBase("minegroup_shard");
	
	public static final Item WYRM_FRUIT = new ItemFoodBase(3, 0.3F, false, "wyrm_fruit");
	public static final Item WYRM_SCALE = new ItemBase("wyrm_scale");
	public static final Item WYRM_TOOTH = new ItemBase("wyrm_tooth");
	public static final Item WYRM_TOOTH_HELMET = new ItemArmorBase("wyrmtooth_helmet", WYRMTOOTH, 1, EntityEquipmentSlot.HEAD);
	public static final Item WYRM_TOOTH_CHESTPLATE = new ItemArmorBase("wyrmtooth_chestplate", WYRMTOOTH, 1, EntityEquipmentSlot.CHEST);
	public static final Item WYRM_TOOTH_LEGGINGS = new ItemArmorBase("wyrmtooth_leggings", WYRMTOOTH, 2, EntityEquipmentSlot.LEGS);
	public static final Item WYRM_TOOTH_BOOTS = new ItemArmorBase("wyrmtooth_boots", WYRMTOOTH, 1, EntityEquipmentSlot.FEET);
	public static final Item WYRM_SCALE_HELMET = new ItemArmorBase("wyrmscale_helmet", WYRMSCALE, 1, EntityEquipmentSlot.HEAD);
	public static final Item WYRM_SCALE_CHESTPLATE = new ItemArmorBase("wyrmscale_chestplate", WYRMSCALE, 1, EntityEquipmentSlot.CHEST);
	public static final Item WYRM_SCALE_LEGGINGS = new ItemArmorBase("wyrmscale_leggings", WYRMSCALE, 2, EntityEquipmentSlot.LEGS);
	public static final Item WYRM_SCALE_BOOTS = new ItemArmorBase("wyrmscale_boots", WYRMSCALE, 1, EntityEquipmentSlot.FEET);
	public static final Item WYRM_AXE = new ItemAxeBase("wyrm_axe", WYRM);
	public static final Item WYRM_HOE = new ItemHoeBase(WYRM, "wyrm_hoe");
	public static final Item WYRM_PICKAXE = new ItemPickaxeBase(WYRM, "wyrm_pickaxe");
	public static final Item WYRM_SHOVEL = new ItemShovelBase(WYRM, "wyrm_shovel");
	public static final Item WYRM_SWORD = new ItemSwordBase(WYRM, "wyrm_sword");
	
	public static final Item FROYO = new ItemFroyo("froyo");
	public static final Item FROYO_SWORD = new ItemFroyoSword(FROYOTOOLS, "froyo_sword");
	//public static final Item FROYO_HELMET = new ItemFroyoHelmet("froyo", FROYOARMOR, 1, EntityEquipmentSlot.HEAD);
}
