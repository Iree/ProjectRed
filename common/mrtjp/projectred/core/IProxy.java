package mrtjp.projectred.core;

public abstract interface IProxy {
    
    public abstract void preinit();
    public abstract void init();
    public abstract void postinit();
}