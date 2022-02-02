package dynamicIPService.service;

import java.util.Date;

/**
 * Created by kislay on 3/31/18.
 */
public class IPStatus {
    private final String allocatedIPAddr;
    private Date expiryTime;

    public IPStatus(String allocatedIPAddr, Date expiryTime)
    {
	this.allocatedIPAddr = allocatedIPAddr;
	this.expiryTime = expiryTime;
    }

    public Date getExpiryTime()
    {
	return expiryTime;
    }

    public void setExpiryTime(Date expiryTime)
    {
	this.expiryTime = expiryTime;
    }

    public String getAllocatedIPAddr()
    {
	return allocatedIPAddr;
    }
}
