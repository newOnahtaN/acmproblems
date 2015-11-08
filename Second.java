import java.util.Scanner;
import java.util.ArrayList;

public class Second {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()){
			ArrayList<Integer> seq = new ArrayList<Integer>();
			double geometricFactor = 0;
			double arithmeticDifference = 0;
			
//			int read;
//			boolean invalid = false;
			for (int i = 0; i < 4; i++){
				seq.add(scan.nextInt());
//				if (read >= 1 && read <= 10000 || read == -1) {
//					seq.add(scan.nextInt());
//				}
//				else {
//					invalid = true;
//					break;
//				}
			}
			if (seq.get(0) == -1 && seq.get(1) == -1 && seq.get(2) == -1 && seq.get(3) == -1){
				break;
			}
//			if (invalid){
//				scan.nextLine();
//				continue;
//			}
			
			for (int i = 0; i < 3; i++){
				if (seq.get(i) != -1 && seq.get(i+1) != -1){
//					System.out.printf("%d %d\n", seq.get(i), seq.get(i+1));
					geometricFactor = ((double)seq.get(i+1) / seq.get(i));
					arithmeticDifference = seq.get(i+1) - seq.get(i);
//					System.out.printf("%d %d ", seq.get(i), seq.get(i+1));
					break;
				}
			}
			
			//arithmetic
			boolean solved = false;
			double temp;
			if (seq.get(0) != -1){
				temp = seq.get(0);
			} else{
				temp = seq.get(1) - arithmeticDifference;
			}
			double missingValue = -1;
			for (int i = 0; i < 4; i++){
				
				if (seq.get(i) != -1){
					if (seq.get(i) == temp){
						temp = seq.get(i) + arithmeticDifference;
					}
					else {break;}
				}
				else {
					missingValue = temp;
					temp = temp + arithmeticDifference;
				}
				if (i == 3 && (int)missingValue >= 1 && (int)missingValue <= 1000000){
					System.out.println((int)missingValue);
					solved = true;
				}
			}
			
			
			//geometric
			if (seq.get(0) != -1){
				temp = seq.get(0);
			} else{
				temp = (double)seq.get(1) / geometricFactor;
			}
			missingValue = -1;
			for (int j = 0; j < 4; j++){
				
				if (seq.get(j) != -1){
					if (seq.get(j) == temp){
						temp = seq.get(j) * geometricFactor;
					}
					else {break;}
				}
				else {
					missingValue = temp;
					temp = temp * geometricFactor;
				}
				if (j == 3 && (int)missingValue >= 1 && (int)missingValue <= 1000000 && !solved){
					System.out.println((int)missingValue);
					solved = true;
				}
			}
			
			if (!solved){
				System.out.println("-1");
			}
			
//			System.out.printf("%f %f\n", arithmeticDifference, geometricFactor);
//			
			scan.nextLine();
		}
	}
}
  