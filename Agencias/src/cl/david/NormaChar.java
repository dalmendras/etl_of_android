package cl.david;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class NormaChar {
	

	public static String remover1(String input) {

	    // Cadena de caracteres original a sustituir.

	    String original = "áàäéèëíìïóòöúùüñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";

	    // Cadena de caracteres ASCII que reemplazarán los originales.

	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    
	    for (int i=0; i<original.length(); i++) {
	        // Reemplazamos los caracteres especiales.
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}
 
    public static  String getStringOfLettersSpacesOnly(String s) {
        //using a StringBuilder instead of concatenate Strings
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
        	 if (Character.isLetter(s.charAt(i)) || Character.isSpaceChar(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                //adding data into the StringBuilder
                sb.append(s.charAt(i));
            }
        }
        //return the String contained in the StringBuilder
        return sb.toString();
    }

    public static  String getStringNormalize(String stringcell) {
        //using a StringBuilder instead of concatenate Strings
    	
    	stringcell = getStringOfLettersSpacesOnly(stringcell);
    	stringcell = stringcell.trim();
    	stringcell = remover1(stringcell).toUpperCase();
  	  	Pattern pattern = Pattern.compile("\\s+");
  	  	Matcher matcher = pattern.matcher(stringcell);
  	  	stringcell = matcher.replaceAll(" ");
        //return the String normalized
        return stringcell;
    }
    
    
}
