import java.util.regex.Pattern;
import java.io.IOException;

public class Util {
    public static boolean validateWeapon(String weapon){
	if(weapon.equals("laser") || weapon.equals("mortar") || weapon.equals("droid")){
	    return true;
	}
	return false;
    }
    public static void validateUsername(String username) throws ProtocolException {
	if(username.length() < 3){
	    throw new ProtocolException("Username too short: needs to be 3 characters or longer.");
	}
	if(username.length() > 16){
	    throw new ProtocolException("Username too long: needs to be 16 characters or less.");
	}
	if(!Pattern.matches("[a-zA-Z0-9-_+]+", username)){
	    throw new ProtocolException("Username contains invalid characters. May only contain "
					+ "a-z, A-Z, 0-9, -, _, +.");
	}
    }
    public static void pressEnterToContinue(String reason){
	System.out.print(reason + ": ");
	System.out.flush();
	try {
	    System.in.read();
	}
	catch (IOException e){}
    }
    public static ProtocolException throwInaccessibleTileException(String direction, Tile theTile){
	if(theTile == null){
	    return new ProtocolException("Invalid move: tile " + direction + " is not accessible (outside of map)");
	}
	else {
	    return new ProtocolException("Invalid move: " + theTile.tileType + " tile is not accessible");
	}
    }
}
