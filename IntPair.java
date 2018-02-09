
 class IntPair {

	// IntPair allows public, no filtering; classes that use it will protect it
	
	    public long firstInt;
	    public long secondInt;

	    // constructors
	    IntPair() { firstInt = secondInt = 0; }
	    IntPair(long frst, long scnd) { firstInt = frst;  secondInt = scnd; }
	    
	    public String toString()
	    {  
	       return "(" + firstInt + ", " + secondInt + ")";
	    }
	 
}
