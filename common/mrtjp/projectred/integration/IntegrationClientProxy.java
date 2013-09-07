package mrtjp.projectred.integration;

import mrtjp.projectred.ProjectRedIntegration;
import net.minecraftforge.client.MinecraftForgeClient;
import codechicken.lib.packet.PacketCustom;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class IntegrationClientProxy extends IntegrationProxy {

    @Override
    public void preinit() {
        super.preinit();
        PacketCustom.assignHandler(IntegrationCPH.channel, new IntegrationCPH());
    }
    
    @Override
    public void init() {
        super.init();
        MinecraftForgeClient.registerItemRenderer(ProjectRedIntegration.itemPartGate.itemID, GateItemRenderer.instance);
    }
}
