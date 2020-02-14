import java.util.ArrayList;

public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {
		
	}

	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException {
		int count1=0, count2=0, count3=0;
		
		
			if (passwordString.length()< 6)
				throw new LengthException();
			for(int i = 0;i<passwordString.length(); i++) {
				if(Character.isUpperCase(passwordString.charAt(i))) 
					count1++;
				if(Character.isLowerCase(passwordString.charAt(i)))
					count2++;
				if(Character.isDigit(passwordString.charAt(i)))
					count3++;
			}
			if(count1==0) 
			    throw new NoUpperAlphaException();
			if(count2==0)
		        throw new NoLowerAlphaException();
			if(count3==0)
				throw new NoDigitException();
			for(int i=0; i<passwordString.length()-2;i++) {
				if(passwordString.charAt(i)==passwordString.charAt(i+1) && passwordString.charAt(i)==passwordString.charAt(i+2))
					throw new InvalidSequenceException();
			}
				
			
		

		
		
		return true;
	}
	public static boolean isWeakPassword(String passwordString) {
		if(passwordString.length()>= 6 && passwordString.length()<=9)
		return true;
		else return false;
	}
	public static ArrayList<String> invalidPasswords( ArrayList<String> passwords) {
		ArrayList<String> invalidPwd = new ArrayList<String>();
		for(int i = 0; i< passwords.size(); i++) {
			try {
				if(!isValidPassword(passwords.get(i))) {
					int count1=0, count2=0, count3=0;
					
					
						if (passwords.get(i).length()< 6)
							throw new LengthException();
						for(int j = 0;j<passwords.get(i).length(); j++) {
							if(Character.isUpperCase(passwords.get(i).charAt(j))) 
								count1++;
							if(Character.isLowerCase(passwords.get(i).charAt(j)))
								count2++;
							if(Character.isDigit(passwords.get(i).charAt(j)))
								count3++;
						}
						if(count1==0) 
						    throw new NoUpperAlphaException();
						if(count2==0)
					        throw new NoLowerAlphaException();
						if(count3==0)
							throw new NoDigitException();
						
						for(int k=0; k<passwords.get(i).length()-2;k++) {
							if(passwords.get(i).charAt(k)==passwords.get(i).charAt(k+1) && passwords.get(i).charAt(k)==passwords.get(i).charAt(k+2))
								throw new InvalidSequenceException();
						}
				
				}
					 
			}
			catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
					| InvalidSequenceException e) {
				
				invalidPwd.add(passwords.get(i)+" "+e.getMessage() );
			}	
			
		}
		return invalidPwd;
	}
}
