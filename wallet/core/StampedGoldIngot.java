package dardoMods.wallet.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class StampedGoldIngot extends Item {

	public StampedGoldIngot(int par1) {
		super(par1);
		
		// Constructor Configuration
		setMaxStackSize(1);
		setIconIndex(0);
		setItemName("StampedGoldIngot");
	}
	 public String getTextureFile() {
         return CommonProxy.ITEMS_PNG;
 }

}
