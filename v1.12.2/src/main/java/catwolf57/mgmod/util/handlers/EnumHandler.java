package catwolf57.mgmod.util.handlers;

import catwolf57.mgmod.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
		public static enum EnumOreType implements IStringSerializable{
		
			MINEGROUP(0, "minegroup"),
			CATWOLFIAN(1, "catwolfian"),
			DESTINY(2, "destiny"),
			WYRM(3, "wyrm");
			
			private static final EnumOreType[] META_LOOKUP = new EnumOreType[values().length];
			private final int meta;
			private final String name, unlocalizedName;
		
			private EnumOreType(int meta, String name){
				this(meta, name, name);
			}
			
			private EnumOreType(int meta, String name, String unlocalizedName){
				this.meta = meta;
				this.name = name;
				this.unlocalizedName = name;
			}
			
			@Override
			public String getName(){
				return this.name;
			}
		
			@Override
			public String toString(){
				return this.name;
			}
		
			public String getUnlocalizedName(){
				return this.unlocalizedName;
			}
			
			public int getMeta(){
				return this.meta;
			}
			
			public static EnumOreType byMetadata(int meta){
				return META_LOOKUP[meta];
			}
			
			static{
				for(EnumOreType enumtype : values()){
					META_LOOKUP[enumtype.getMeta()] = enumtype;
				}
			}
		}
		
		public static enum EnumColorType implements IStringSerializable{
			
			WHITE(0, "white"),
			ORANGE(1, "orange"),
			MAGENTA(2, "magenta"),
			LIGHTBLUE(3, "light_blue"),
			YELLOW(4, "yellow"),
			LIME(5, "lime"),
			PINK(6, "pink"),
			GRAY(7, "gray"),
			LIGHTGRAY(8, "light_gray"),
			CYAN(9, "cyan"),
			PURPLE(10, "purple"),
			BLUE(11, "blue"),
			BROWN(12, "brown"),
			GREEN(13, "green"),
			RED(14, "red"),
			BLACK(15, "black");
			
			private static final EnumColorType[] META_LOOKUP = new EnumColorType[values().length];
			private final int meta;
			private final String name, unlocalizedName;
		
			private EnumColorType(int meta, String name){
				this(meta, name, name);
			}
			
			private EnumColorType(int meta, String name, String unlocalizedName){
				this.meta = meta;
				this.name = name;
				this.unlocalizedName = name;
			}
			
			@Override
			public String getName(){
				return this.name;
			}
		
			@Override
			public String toString(){
				return this.name;
			}
		
			public String getUnlocalizedName(){
				return this.unlocalizedName;
			}
			
			public int getMeta(){
				return this.meta;
			}
			
			public static EnumColorType byMetadata(int meta){
				return META_LOOKUP[meta];
			}
			
			static{
				for(EnumColorType enumtype : values()){
					META_LOOKUP[enumtype.getMeta()] = enumtype;
				}
			}
		}
		
		public static enum EnumWoodType implements IStringSerializable{
			
			WYRM(0, "wyrm"),
			CATWOLFIAN(1, "catwolfian"),
			DESTINED(2, "destined"),
			FROYO(3, "froyo");
			
			private static final EnumWoodType[] META_LOOKUP = new EnumWoodType[values().length];
			private final int meta;
			private final String name, unlocalizedName;
		
			private EnumWoodType(int meta, String name){
				this(meta, name, name);
			}
		
			private EnumWoodType(int meta, String name, String unlocalizedName){
				this.meta = meta;
				this.name = name;
				this.unlocalizedName = name;
			}
			
			@Override
			public String getName(){
				return this.name;
			}
		
			@Override
			public String toString(){
				return this.name;
			}
		
			public String getUnlocalizedName(){
				return this.unlocalizedName;
			}
		
			public int getMeta(){
				return this.meta;
			}
			
			public static EnumWoodType byMetadata(int meta){
				return META_LOOKUP[meta];
			}
			
			static{
				for(EnumWoodType enumtype : values()){
					META_LOOKUP[enumtype.getMeta()] = enumtype;
				}
			}
		}
	
}
