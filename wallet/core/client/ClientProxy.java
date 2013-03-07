package dardoMods.wallet.core.client;

import net.minecraftforge.client.MinecraftForgeClient;
import dardoMods.wallet.core.CommonProxy;

public class ClientProxy extends CommonProxy {
       
        @Override
        public void registerRenderers() {
                MinecraftForgeClient.preloadTexture(ITEMS_PNG); //temp textures
                MinecraftForgeClient.preloadTexture(BLOCK_PNG); //temp textures
        }
       
}
