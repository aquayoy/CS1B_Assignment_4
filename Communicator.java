import java.util.*;
public class Communicator extends InternetUser {

	
	/*The private key is a pair of integers (each private key is an IntPair member object). 
	Public keys are the product of a pair of integers
	For example: privateKey: (214, 703) publicKey: 16169 (the result of 23 *703)*/
	IntPair publicKey;
	IntPair privateKey;
	
	/* Static Class Constants (Both final)
	 * To the existing base class statics, add two more in this derived class:*/
	 
	// public. Make this equal 0.
	public static final int ERROR_FLAG_NUM = 0;
	
	/* private. It means the maximum of p as well as the maximum of q (our two members firstPrime and secondPrime).  
	 * The value to be assigned by our class is the (positive) square root of the largest long in our compiler.
	 * That can be found by taking the Java constant symbol, Long.MAX_VALUE defined inside java.util, then taking its square root.*/
	private static final long MAX_PQ = (long) Math.sqrt( Long.MAX_VALUE );
	
	
	//Additional Private Member Data. They are helpful intermediate variables during the computation of the keys.
	private long firstPrime;
	private long secondPrime;
	private long n, phi, e, d;
	
	//Public Methods
	/*Our constructors and mutators have to check that the client-supplied p and q arguments are prime and distinct 
	 *and if so, the constructors must generate the two encryption keys for us using those primes as a foundation.  
	 *Neither prime is actually part of either encryption key. */
	
	/*Four constructors. Use constructor chaining.
	 * Constructors that receive illegal numerical values as reported by the mutator return value tested in the constructor (see requirements of p, q, above) 
	 * will assign ERROR_FLAG_NUM to all numeric members.  
	 * Meanwhile, String errors are handled already by chaining to your previously designed and tested base class constructor. */
	Communicator(){
		super();
		firstPrime = secondPrime = n = phi = e = d = ERROR_FLAG_NUM; 
		publicKey = new  IntPair (e,n);
    	privateKey = new IntPair (d,n);
	}
    Communicator( long p, long q ){
    	super();
    	setPrimes(p, q);
    	if (!setPrimes(p, q)) {
    		 firstPrime = secondPrime = n = phi = e = d = ERROR_FLAG_NUM;
    		 publicKey = new  IntPair (e,n);
    		 privateKey = new IntPair (d,n);
    	}
    }
    Communicator( String name, String ip ){
    	super(name, ip);
    	firstPrime = secondPrime = n = phi = e = d = ERROR_FLAG_NUM;
    	 publicKey = new  IntPair (e,n);
		 privateKey = new IntPair (d,n);
    }
    Communicator( String name, String ip, long p, long q ){
    	super(name, ip);
    	setPrimes(p, q);
    	if (!setPrimes(p, q)) {
    		 firstPrime = secondPrime = n = phi = e = d = ERROR_FLAG_NUM;
    		 publicKey = new  IntPair (e,n);
    		 privateKey = new IntPair (d,n);
    	}
    }
    
    //One Mutator for both primes. It takes both primes, p and q, because they must be compared to each other.  If good values are detected it sets firstPrime and secondPrime and goes on to call computeBothEncrKeys() to set  the keys so they are compatible with these two new valid primes just set. Details, below.
    public boolean setPrimes(long p, long q) {
    	
    	if (isValidPrimeSet(p, q)) {
    		this.firstPrime = p;
    		this.secondPrime = q;
    		/* If good values are detected, it sets firstPrime and secondPrime and goes on to call computeBothEncrKeys() 
        	 * to set  the keys so they are compatible with these two new valid primes just set*/
    		computeBothEncrKeys(firstPrime, secondPrime );
    		return true;
    	}
  
    	return false;
    }
	
	
    //Accessors - one for each key. Only the encryption keys have accessors. Remember, an accessor return type always agrees with that of the member.
    public IntPair getPublicKey() {
    	return publicKey;
    }
    
    public IntPair getPrivateKey() {
    	return privateKey;
    }
    
    /*toString() - a method that returns a String of the entire object's private data((p, q)  n, phi, e, d, public key,private key.)
     * Make proper use of method chaining.*/
    public String toString() {
    	String result ="\n" + super.toString() + "\n(p, q)  n, phi, e, d: "+ "("+ firstPrime +", "+secondPrime+")  "+ n +" "+ phi +"  "+ e +" "+ d 
    			+"\npublic key " + getPublicKey() +"\nprivate key " + getPrivateKey();
    	return result;
    }
    //Private Methods
    /*computeBothEncrKeys(), a method that uses the primes to build encryption keys.  
     *It checks to see whether the member primes are valid, and returns false if they are not, leaving data unaffected.  
     *If they are valid, it takes the following action (this is how RSA encryption key generation is accomplished)*/
    private boolean computeBothEncrKeys(long p, long q) {
    	
    	if (!isValidPrimeSet(p, q)) {
    		
    		return false ;
    	}
    	
    	// If the member primes are valid,  it takes the following action which is RSA encryption key generation:
    	//1. Generate n = p * q;
    	n = p * q;
    	
    	/*2. Generate phi = £p(n) which is the number of primes smaller than n.  
    	 * £p(n)  is called "Euler's totient function," and in the special case where n is the product of two primes (but not generally), 
    	 *  £p(n) is simply (p - 1) * (q - 1). */ 
    	phi = (p -1) * (q -1);
    	
    	/*Compute e.  Select a random prime number that is relatively small:  between 19 and 541 that has the property that it is LESS THAN phi and it DOES NOT DIVIDE EVENLY into phi.
    	 * If you succeed, the result is the value you assign to member e, and you will return true at the end of the method.  */
    	int count =0;
    	for (e=phi; e >= phi || phi % e == 0 || count <10000;count++) {
    		
    		e = EncryptionSupport.getSmallRandomPrime();
    	}
    	
    	/*Compute d as the mod n multiplicative inverse of the e just computed.  
    	 * This is done for you by the method inverseModN(e, n) in your EncryptionSupport class.*/
    	d = EncryptionSupport.inverseModN(e, n);
    	
    	//Set the public key IntPair to (e, n) and the private key IntPair to (d, n).
    	publicKey = new IntPair(e,n);
    	privateKey = new IntPair(d,n);
    	
    	return true;
	}
    //helper 
    private boolean isValidPrimeSet(long p, long q) {
    
    	boolean isValid = true;
    	boolean isFirstPrime = EncryptionSupport.isPrime(p);
    	boolean isSecondPrime = EncryptionSupport.isPrime(q);
    	if (p>MAX_PQ || q>MAX_PQ || !isFirstPrime || !isSecondPrime || p==q) {
    		isValid = false;
    		return isValid ;
    	}
    	
    	return isValid;
    
    }
    
    
    
    //  private key     		public key(can't be a long )
	// intpair  d  n(p.q)      intpair   e    n
	
}
