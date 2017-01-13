package org.play.profilingandother.profiling;

public interface ProfilingControllerMBean {
    boolean isEnabled();

    void setEnabled(boolean enabled);
}
