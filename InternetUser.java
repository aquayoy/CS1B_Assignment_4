
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
		 
		setUserData(userName, userIp);
	 }
	 //Mutator for each member.
	 public void setUserData (String userName, String userIp) {
		 if (isValidName(userName) == true) {
			 this.name = userName;
		 }
		else {
			this.name =  DEFAULT_NAME;
		 }
		 if (isValidIp(userIp) == true) {
			 this.ip = userIp;
		 }
		 else {
			 this.ip = DEFAULT_IP;
		 }
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
	 public String getUserName(){
		 return name;
	 }
	 public String getUserIp(){
		 return ip;
	 }
	 
	 //a toString() method that provides a nicely formatted return string for potential screen I/O
	public String toString() {
		String result = "NAME:" + getUserName() +"\nIP address: ";
		for(int k = 0; k < ip.length(); k++)
	         if (Character.isDigit(ip.charAt(k))||ip.charAt(k)=='.') {
	            result = result +ip.charAt(k);
	         }
	      return result;
		
		
//	      result = "(" + areaCode + ")"
//	         + number.substring(0,3) + "-"
//	         + number.substring(3,7);
//	      return result;
	}
	
	
}
