package dynamicIPService.service;

import dynamicIPService.exception.IPException;
import dynamicIPService.interfaces.AllocationService;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by kislay on 3/31/18.
 */
public class AllocationServiceImpl implements AllocationService {

    private static Map<String, IPStatus> ipMap;
    private static Properties properties;
    private static AllocationServiceImpl instance;

    private AllocationServiceImpl()
    {
    }

    public static AllocationServiceImpl getInstance() throws Exception
    {
	if (instance == null) {
	    synchronized (AllocationServiceImpl.class) {
		if (instance == null) {
		    instance = new AllocationServiceImpl();
		    ipMap = new TreeMap<>();
		    properties = new Properties();
		    InputStream input = new FileInputStream("ipallocation.properties");
		    properties.load(input);
		}
	    }
	}
	return instance;
    }

    @Override
    public String allocate(String macAddress)
    {
	if (ipMap.containsKey(macAddress))
	    return ipMap.get(macAddress).getAllocatedIPAddr();

	int ipStart = Integer.parseInt(properties.getProperty(Constants.IPADDRESS_START_RANGE));
	int ipEnd = Integer.parseInt(properties.getProperty(Constants.IPADDRESS_END_RANGE));
	int ipExpiryTimeInHr =
			Integer.parseInt(properties.getProperty(Constants.IPADDRESS_END_RANGE));

	Date currentDate = new Date();
	Date expiryDate = new Date(currentDate.getTime() + ipExpiryTimeInHr * Constants.HOUR);
	String ipAddress = String.valueOf(ThreadLocalRandom.current().nextInt(ipStart, ipEnd));
	IPStatus ipStatus = new IPStatus(ipAddress, expiryDate);
	ipMap.put(macAddress, ipStatus);

	return ipAddress;
    }

    @Override
    public boolean refresh(String macAddress, String allocatedIPAddress) throws IPException
    {
	if (!ipMap.containsKey(macAddress))
	    throw new IPException(String.format("MacAddress -%s not assigned any IP", macAddress));

	IPStatus ipStatus = ipMap.get(macAddress);
	Date expiryDate = ipStatus.getExpiryTime();
	int ipExpiryTimeInHr = Integer.parseInt(
			properties.getProperty(Constants.IPADDRESS_EXPIRE_DURATION));
	Date newExpiryDate = new Date(expiryDate.getTime() + ipExpiryTimeInHr * Constants.HOUR);
	ipStatus.setExpiryTime(newExpiryDate);

	return true;
    }
}
