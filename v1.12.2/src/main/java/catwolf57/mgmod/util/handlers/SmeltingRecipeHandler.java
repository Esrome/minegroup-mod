package catwolf57.mgmod.util.handlers;

import java.util.Random;

import catwolf57.mgmod.init.ModBlocks;
import catwolf57.mgmod.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipeHandler {

	public static void addRecipes(){
		GameRegistry.addSmelting(ModBlocks.MINEGROUP_LOGS, new ItemStack(Items.COAL), 0.1f);
		GameRegistry.addSmelting(ModItems.CATWOLFIAN_SCROLL, new ItemStack(ModItems.CATWOLFIAN_ASHES), 0.1f);
		Random rand = new Random();
		GameRegistry.addSmelting(new ItemStack(ModBlocks.ORE_OVERWORLD, 1, 0), new ItemStack(ModItems.MINEGROUP_SHARD, 1 + rand.nextInt(3)), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.ORE_OVERWORLD, 1, 1), new ItemStack(ModItems.CATWOLFIAN_ESSENCE), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.ORE_OVERWORLD, 1, 2), new ItemStack(ModItems.DESTINY_INGOT), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.ORE_OVERWORLD, 1, 3), new ItemStack(ModItems.WYRM_TOOTH), 1.0f);
	}
	
}
