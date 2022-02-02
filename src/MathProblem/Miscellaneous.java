package MathProblem;

/**
 * Created by kislay on 4/7/17 at 1:38 PM .
 */
public class Miscellaneous {

    public void printPrimeFactors(int data)
    {
	while (data % 2 == 0) {
	    System.out.println(2 + " ");
	    data /= 2;
	}

	double sqrtData = Math.sqrt(data);
	for (int i = 3; i <= sqrtData; i += 2) {
	    while (data % i == 0) {
		System.out.println(i + " ");
		data /= i;
	    }
	}

	if (data > 2)
	    System.out.println(data);
    }

    public static void main(String[] args)
    {
	Miscellaneous misc = new Miscellaneous();
	misc.printPrimeFactors(45);
    }
}
