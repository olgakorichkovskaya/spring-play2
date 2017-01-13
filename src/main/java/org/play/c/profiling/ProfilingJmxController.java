package org.play.c.profiling;

//using JMX console
public class ProfilingJmxController implements ProfilingControllerMBean  {
private boolean enabled =true;

@Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
