package dardoMods.wallet.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GoldIngotMold extends Item {
	public GoldIngotMold(int par1) {
		super(par1);
		
		// Constructor Configuration
		setMaxStackSize(64);
		setIconIndex(1);
		setItemName("IngotMold");
	}
	 public String getTextureFile() {
         return CommonProxy.ITEMS_PNG;
 }
}
