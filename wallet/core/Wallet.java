package dardoMods.wallet.core;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

@Mod(modid="Wallet", name="Wallet", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Wallet {

        @Instance("Wallet")
        public static Wallet instance;
        
        public static CreativeTabs walletTab = new WalletTab(CreativeTabs.getNextID(),"walletTab");
        
        //declaring Items
        public static Item stampedGoldIngot, GoldIngotMold;
        //declaring ItemsID
        public static int stampedGoldIngotID, GoldIngotMoldID;
      
        
        // Says where the client and server proxy code is loaded.
        @SidedProxy(clientSide="dardoMods.wallet.core.client.ClientProxy", serverSide="dardoMods.wallet.core.CommonProxy")
        public static CommonProxy proxy;
       
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
        	
        	
        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        	config.load();
        	
        	//Getting and initializing configuration variables
        	//Item ID from configuration file
        	stampedGoldIngotID = config.getItem("StampedGoldIngot", 1552).getInt();
        	GoldIngotMoldID = config.getItem("GoldIngotMold", 1553).getInt();
        		
        	config.save();
        }
       
        @Init
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();

              
                
                //Tab Name
                //TODO Local Lang File
                LanguageRegistry.instance().addStringLocalization("itemGroup.walletTab", "en_US", "Wallet");
                
                //Items
                stampedGoldIngot = (new StampedGoldIngot(stampedGoldIngotID).setIconIndex(0).setItemName("StampedGoldIngot"));
                LanguageRegistry.addName(stampedGoldIngot, "Stamped Gold Ingot");
                
                GoldIngotMold = (new GoldIngotMold(GoldIngotMoldID).setIconIndex(1).setItemName("GoldIngotMold"));
                LanguageRegistry.addName(GoldIngotMold, "Gold Ingot Mold");
                
                //Recipes
                GameRegistry.addRecipe(new ItemStack(GoldIngotMold,16), "x x", "x x", " x ",
                        'x', Item.brick);
                GameRegistry.addShapelessRecipe(new ItemStack(stampedGoldIngot),
                        GoldIngotMold, Item.ingotGold);
                
                //Inseting items in own creative Tab
                stampedGoldIngot.setCreativeTab(this.walletTab);
                GoldIngotMold.setCreativeTab(this.walletTab);
                
                
        }
       
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}