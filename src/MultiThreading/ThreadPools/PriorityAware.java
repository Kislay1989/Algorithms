package MultiThreading.ThreadPools;

/**
 * Implemented by any Runnable that carries a scheduling priority.
 * Higher values are scheduled before lower values.
 * Tasks that do not implement this interface are treated as priority 0.
 *
 * getBasePriority()     – the static priority assigned at construction time.
 * getEffectivePriority() – the runtime priority used for scheduling decisions;
 *                          defaults to getBasePriority() but may incorporate
 *                          aging, load, or any other dynamic signal.
 */
public interface PriorityAware {

    int getBasePriority();

    default int getEffectivePriority() {
        return getBasePriority();
    }
}
