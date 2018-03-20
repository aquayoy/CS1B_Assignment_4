
class InternetUser {

	//Public Static Class Constants
	//Define a full set of limits and defaults, like MAX_NAME_LENGTH, MIN_IP_LENGTH , and DEFAULT_IP for both min, max lengths and default data of each member.
	
	public final static int  MAX_NAME_LENGTH = 50, MIN_NAME_LENGTH = 2, MAX_IP_LENGTH = 15, MIN_IP_LENGTH = 7;
	public final static String DEFAULT_NAME = "(undefined)", DEFAULT_IP = "0.0.0.0"; 
	
	//Private Member Data
	 private String name;
	 private String ip;
	 
	 //Public Methods
	 //Default and 2-parameter constructors.
	 InternetUser(){
		 this.name =  DEFAULT_NAME;
		 this.ip = DEFAULT_IP;
	 }
	 
	 InternetUser(String userName, String userIp){
		 
		setIp(userIp);
		setName(userName);
	 }
	 //Mutator for each member.
	 public boolean setIp (String userIp) {
		 boolean isSetIp = false;
		 if (isValidIp(userIp)) {
			 this.ip = userIp;
			 isSetIp = true;
		 }
		 else {
			 this.ip = DEFAULT_IP;
		 }
		 return isSetIp;
	 }
	 
	 public boolean setName (String userName) {
		 boolean isSetName = false;
		 if (isValidName(userName)) {
			 this.name = userName;
			 isSetName = true;
		 }
		else {
			this.name =  DEFAULT_NAME;
		 }
		 return isSetName;
	 }
	 /* private static validation helpers to filter client parameters.  
	  * These will support our public methods and we should only test lengths here*/
	 private static boolean isValidName(String userName) {
		 if (userName.length()<MIN_NAME_LENGTH || userName.length()>MAX_NAME_LENGTH) {
			 return false;
		 }
		 return true;
	 }

	 private static boolean isValidIp(String userIp) {
		 if (userIp.length()<MIN_IP_LENGTH || userIp.length()>MAX_IP_LENGTH) {
			 return false;
		 }
		 return true;
		 
	 }
	 
	 //Accessor for each member.
	 public String getName(){
		 return name;
	 }
	 public String getIp(){
		 return ip;
	 }
	 
	 //a toString() method that provides a nicely formatted return string for potential screen I/O
	public String toString() {
		String result = "NAME:" + getName() +"\nIP address: ";
		for(int k = 0; k < ip.length(); k++)
	         if (Character.isDigit(ip.charAt(k))||ip.charAt(k)=='.') {
	            result = result +ip.charAt(k);
	         }
	      return result;
		
		
	}
	
	
}
