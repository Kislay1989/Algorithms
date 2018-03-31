package dynamicIPService.interfaces;

import dynamicIPService.exception.IPException;

/**
 * Created by kislay on 3/31/18.
 */
public interface AllocationService {
    String allocate(String macAddress);
    boolean refresh(String macAddress, String allocatedIPAddress) throws IPException;
}
