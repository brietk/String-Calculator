package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) throws Exception{
		
		String delimiter = ",|n";
		
		if (text.equals(""))
			return 0;
		else if (text.startsWith("//")) 
		{
        	int delimiterIndex = text.indexOf("//") + 2;
        	delimiter += "|" + text.substring(delimiterIndex, 1);
        	String numbersWithoutDelimiter = text.substring(text.indexOf("n") + 1);
			return sum(splitNumbers(numbersWithoutDelimiter, delimiter));
    	}
		else if(text.contains(",") || (text.contains("\n"))){
			return sum(splitNumbers(text, delimiter));
		}
		else
			return toInt(text);
	}
    
	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiter){
	    return numbers.split(delimiter);
	}

	private static int sum(String[] numbers) throws Exception{
 	    int total = 0;
 	    String negs = "";
        for(String number : numbers)
        {
        	if((toInt (number) < 0) || (toInt(number) > 1000)) {
        		if(negs != "")
        			negs += ",";
        		negs += number;
        	}
		    total += toInt(number);
		}

		if(negs != "")
			throw new Exception("Negatives not allowed: "+negs);

		return total;
	}

}