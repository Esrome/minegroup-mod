package catwolf57.mgmod.util.handlers;

import catwolf57.mgmod.blocks.container.ContainerFroyoFreezer;
import catwolf57.mgmod.blocks.froyo.TileEntityFroyoFreezer;
import catwolf57.mgmod.blocks.gui.FreezerGUI;
import catwolf57.mgmod.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUIFREEZER) return new ContainerFroyoFreezer(player.inventory, (TileEntityFroyoFreezer)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
		
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUIFREEZER) return new FreezerGUI(player.inventory, (TileEntityFroyoFreezer)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
}
