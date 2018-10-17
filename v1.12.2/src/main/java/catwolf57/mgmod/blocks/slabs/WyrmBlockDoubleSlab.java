package catwolf57.mgmod.blocks.slabs;

import net.minecraft.block.material.Material;

public class WyrmBlockDoubleSlab extends WyrmBlockSlab{

	public WyrmBlockDoubleSlab(String name, Material material, float hardness) {
		super(name, material, hardness);
	}
	
	public WyrmBlockDoubleSlab(String name, Material material, float hardness, int harvestLevel, String harvestTool) {
		super(name, material, hardness, harvestLevel, harvestTool);
	}

	@Override
	public boolean isDouble() {
		return true;
	}
	
}
