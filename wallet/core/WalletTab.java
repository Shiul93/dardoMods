package dardoMods.wallet.core;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WalletTab extends CreativeTabs {

	public WalletTab(String label) {
		super(label);

	}

	public WalletTab(int position, String tabID) {
		super(position, tabID);

	}
	
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(Wallet.stampedGoldIngot); //Temp
	    
	}

}
