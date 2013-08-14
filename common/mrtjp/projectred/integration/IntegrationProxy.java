package mrtjp.projectred.integration;

import static mrtjp.projectred.ProjectRed.itemPartGate;
import static mrtjp.projectred.ProjectRed.itemScrewdriver;
import mrtjp.projectred.core.Configurator;
import mrtjp.projectred.core.IProxy;
import codechicken.lib.packet.PacketCustom;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.MultiPartRegistry.IPartFactory;
import codechicken.multipart.MultipartGenerator;
import codechicken.multipart.TMultiPart;

public class IntegrationProxy implements IProxy, IPartFactory {

    @Override
    public void preinit() {
    }
    
    @Override
    public void init() {
        String[] gates = new String[EnumGate.VALID_GATES.length];
        for (EnumGate g : EnumGate.VALID_GATES) {
            gates[g.ordinal()] = g.name;
        }
        MultiPartRegistry.registerParts(this, gates);

        itemPartGate = new ItemPartGate(Configurator.part_gate.getInt());
        itemScrewdriver = new ItemScrewdriver(Configurator.item_screwdriverID.getInt());
        
        MultipartGenerator.registerPassThroughInterface("dan200.computer.api.IPeripheral");
        EnumGate.initOreDictDefinitions();
        
        PacketCustom.assignHandler(Configurator.integrationPacketChannel, 0, 32, new IntegrationSPH());
    }

    @Override
    public void postinit() {
        IntegrationRecipes.initIntegrationRecipes();
    }

    @Override
    public TMultiPart createPart(String name, boolean client) {
        EnumGate g = EnumGate.getByName(name);
        if (g != null) {
            return g.createPart();
        }
        return null;
    }
}
