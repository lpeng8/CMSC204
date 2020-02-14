
public class NoUpperAlphaException extends Exception{
      public NoUpperAlphaException() {
    	  super("The passwrod must contain at least one uppercase alphabetic character");
      }
}
