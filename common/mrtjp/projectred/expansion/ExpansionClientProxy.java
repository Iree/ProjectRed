package mrtjp.projectred.expansion;


public class ExpansionClientProxy extends ExpansionProxy {
    
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postinit() {
        super.postinit();
        ExpansionRecipes.initRecipes();
    }
}
