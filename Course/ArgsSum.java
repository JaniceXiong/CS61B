public class ArgsSum {
	/** Prints out the sum of arguments, assuming they are
 	*  integers.
 	*/
    //access command line arguments
    //args: an array of Strings
	public static void main(String[] args) {
    	int index = 0;
    	int sum = 0;
    	while (index < args.length) {
        	sum = sum + Integer.parseInt(args[index]);
        	index = index + 1;
    	}
    	System.out.println(sum);
	}
}
