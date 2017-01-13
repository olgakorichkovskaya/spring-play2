package org.play.c;

import org.springframework.stereotype.Component;


public class ProfilingController implements ProfilingControllerMBean  {
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
