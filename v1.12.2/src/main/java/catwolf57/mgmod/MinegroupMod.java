package catwolf57.mgmod;

import catwolf57.mgmod.proxy.ServerProxy;
import catwolf57.mgmod.util.Reference;
import catwolf57.mgmod.util.handlers.RegistryHandler;
import catwolf57.mgmod.util.handlers.SmeltingRecipeHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class MinegroupMod {
	
	public static final CreativeTabs MINEGROUP = new MinegroupTab("tutorialtab");
	
	@Instance
	public static MinegroupMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static ServerProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		RegistryHandler.otherRegistries();
		System.out.println("Pre-Initializing Minegroup Mod");
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event){
		SmeltingRecipeHandler.addRecipes();
		System.out.println("Initializing Minegroup Mod");
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		System.out.println("Post-Initializing Minegroup Mod");
	}

}
