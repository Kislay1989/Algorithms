package testcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by kislay on 5/11/17 at 5:57 PM .
 */
public class MapTest {

    public static class Employee {
	private final String name;
	private final Random random;

	Employee(String name)
	{
	    this.name = name;
	    this.random = new Random();
	}

	@Override
	public int hashCode()
	{
	    return random.nextInt();
	}
    }

    public static void main(String[] args)
    {
	Employee employee = new Employee("ram");
	Map<Employee, String> map = new HashMap<>();
	map.put(employee, "Ram");
	map.put(new Employee("Name"), "Name");
	map.put(employee, "Ram");

	System.out.println(map.size());
	System.out.println(map.get(employee));
    }
}
