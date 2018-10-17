package catwolf57.mgmod.blocks.slabs;

import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfStoneSlabNew;
import net.minecraft.block.material.Material;

public class WyrmBlockHalfSlab extends WyrmBlockSlab {

	public WyrmBlockHalfSlab(String name, Material material, float Hardness) {
		super(name, material, Hardness);
	}
	
	public WyrmBlockHalfSlab(String name, Material material, float Hardness, int HarvestLevel, String HarvestTool) {
		super(name, material, Hardness, HarvestLevel, HarvestTool);
	}

	@Override
	public boolean isDouble() {
		return false;
	}
	
}
