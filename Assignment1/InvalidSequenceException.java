
public class InvalidSequenceException extends Exception {
 public InvalidSequenceException() {
	 super("The password cannont contain more than two of the same character in sequence");
 }
}
