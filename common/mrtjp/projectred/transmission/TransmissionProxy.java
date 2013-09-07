package mrtjp.projectred.transmission;

import static mrtjp.projectred.ProjectRedTransmission.itemPartFramedWire;
import static mrtjp.projectred.ProjectRedTransmission.itemPartWire;
import mrtjp.projectred.core.Configurator;
import mrtjp.projectred.core.IProxy;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.MultiPartRegistry.IPartFactory;
import codechicken.multipart.TMultiPart;

public class TransmissionProxy implements IProxy, IPartFactory {

    @Override
    public void preinit() {

    }

    @Override
    public void init() {
        MultiPartRegistry.registerParts(this, new String[]{
                "pr_redwire", "pr_insulated", "pr_bundled",
                "pr_sredwire", "pr_sinsulated", "pr_sbundled"});

        itemPartWire = new ItemPartWire(Configurator.part_wire.getInt());
        itemPartFramedWire = new ItemPartFramedWire(Configurator.part_jwire.getInt());
        
        EnumWire.initOreDictDefinitions();
    }

    @Override
    public void postinit() {
        TransmissionRecipes.initTransmissionRecipes();
    }

    @Override
    public TMultiPart createPart(String id, boolean client) {
        if(id.equals("pr_redwire"))
            return new RedAlloyWirePart(0);
        else if(id.equals("pr_insulated"))
            return new InsulatedRedAlloyPart(0);
        else if(id.equals("pr_bundled"))
            return new BundledCablePart(0);
        else if(id.equals("pr_sredwire"))
            return new FramedRedAlloyWirePart();
        else if(id.equals("pr_sinsulated"))
            return new FramedInsulatedRedAlloyPart();
        else if(id.equals("pr_sbundled"))
            return new FramedBundledCablePart();
        return null;
    }

}
