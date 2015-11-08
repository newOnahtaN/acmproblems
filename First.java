import java.util.Scanner;

public class First {
	static String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", 
		"eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
		"seventeen", "eighteen", "nineteen", "twenty"};
	static String[] tenStrings = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	/**
	 * Converts up to three-digit numbers to text
	 */
	static String convertDigitsToText(int n) {
		String nStr = String.valueOf(n);
		StringBuilder builder = new StringBuilder();
		String tensPlace, onesPlace, hundredsPlace;
		int ones, tens, hundreds;
		
		if (n <= 20) return digits[n];
		
		ones = nStr.charAt(nStr.length() - 1) - '0';
		onesPlace = (ones > 0) ? digits[ones] : "";
		tens = nStr.charAt(nStr.length() - 2) - '0';
		tensPlace = (tens > 0) ? tenStrings[tens] : "";
		
		if (n >= 100) {
			hundreds = nStr.charAt(nStr.length() - 3) - '0';
			hundredsPlace = digits[hundreds];
			
			builder.append(hundredsPlace).append(" hundred");
			if(!tensPlace.equals("") || !onesPlace.equals("")) builder.append (" and ");
		}
		
		// teens
		if(tens == 1) {
			builder.append(digits[Integer.parseInt(String.valueOf(tens) + String.valueOf(ones))]);
		} else {
			if(!tensPlace.equals("")) builder.append(tensPlace);
			if(!tensPlace.equals("") && !onesPlace.equals("")) builder.append("-");
			if(!onesPlace.equals("")) builder.append(onesPlace);
		}
				
		return builder.toString();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String nStr;
		int l, originalL;
		
		int thousands, millions, hundreds;
		String thousandsString, millionsString, hundredsString;
		
		while(n >= 0) {
			nStr = String.valueOf(n);
			originalL = nStr.length();
			nStr = new StringBuilder(nStr).insert(0, "000000000").toString();
			l = nStr.length();
			
			StringBuilder builder = new StringBuilder();
			
			if(originalL <= 3) System.out.println(convertDigitsToText(n));
			else if(originalL <= 6) {
				thousands = Integer.parseInt((nStr.substring(l-6, l-3)));
				thousandsString = convertDigitsToText(thousands) + " thousand";
				builder.append(thousandsString);
				
				hundreds = Integer.parseInt((nStr.substring(l-3)));
				hundredsString = (hundreds > 0) ? convertDigitsToText(hundreds) : "";
				if(!hundredsString.equals("")){
					if(hundreds < 100) builder.append(" and ");
					else builder.append(", ");
					
					builder.append(hundredsString);
				}
				
				System.out.println(builder.toString());
			} else {
				millions = Integer.parseInt((nStr.substring(l-9, l-6)));
				millionsString = convertDigitsToText(millions) + " million";
				builder.append(millionsString);
				
				thousands = Integer.parseInt((nStr.substring(l-6, l-3)));
				thousandsString = (thousands > 0) ? convertDigitsToText(thousands) + " thousand" : "";
				if(!thousandsString.equals("")) {
					builder.append(", ").append(thousandsString);
				}
				
				hundreds = Integer.parseInt((nStr.substring(l-3)));
				hundredsString = (hundreds > 0) ? convertDigitsToText(hundreds) : "";
				if(!hundredsString.equals("")){
					if(hundreds < 100) builder.append(" and ");
					else builder.append(", ");
					
					builder.append(hundredsString);
				}
				
				
				System.out.println(builder.toString());
			}
			
			n = scan.nextInt();
		}
	}
}