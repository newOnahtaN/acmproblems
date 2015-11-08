import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Third {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int end, start;
		String gender;
		
		do {
			end = scan.nextInt();
			start = scan.nextInt();
			gender = scan.next();
						
			ArrayDeque<Node> q = new ArrayDeque<Node>();
			q.push(new Node(0, 0, start));
			Node found = new Node(0, 0, -1);
			ArrayList<Integer> visited = new ArrayList<Integer>();
			
			while(!q.isEmpty()) {
				Node temp = q.pop();
				if (temp.n == end) {
					found = temp;
					break;
				}
				
				// add children
				if(!visited.contains(temp.getLeftChild().n) && temp.child != 7) q.add(temp.getLeftChild());
				if(!visited.contains(temp.getRightChild().n) && temp.child != 7) q.add(temp.getRightChild());
				if(!visited.contains(temp.getParent().n) && temp.parent != 4 && temp.child != 7 && temp.n != 0) q.add(temp.getParent());
				
				visited.add(temp.n);
			}
			
			String relate = "kin";
			if(found.n != -1) {
				// we found a relationship!
				if(found.child == 1 && found.parent == 1) {
					System.out.println("sibling");
				} else if(found.child == 1) {
					switch(found.parent){
					case 2:
						if(gender.equals("M")){
							relate = "nephew";
						} else {
							relate = "niece";
						}
						break;
					case 3:
						if(gender.equals("M")){
							relate = "grandnephew";
						} else {
							relate = "grandniece";
						}
						break;
					case 4:
						if(gender.equals("M")){
							relate = "great-grandnephew";
						} else {
							relate = "great-grandniece";
						}
						break;
					case 5:
						if(gender.equals("M")){
							relate = "great-great-grandnephew";
						} else {
							relate = "great-great-grandniece";
						}
						break;
					default:
						relate = "kin";
					}
				} if(found.parent == 1) {
					switch(found.child){
					case 2:
						if(gender.equals("M")){
							relate = "uncle";
						} else {
							relate = "aunt";
						}
						break;
					case 3:
						if(gender.equals("M")){
							relate = "granduncle";
						} else {
							relate = "grandaunt";
						}
						break;
					case 4:
						if(gender.equals("M")){
							relate = "great-granduncle";
						} else {
							relate = "great-grandaunt";
						}
						break;
					case 5:
						if(gender.equals("M")){
							relate = "great-great-granduncle";
						} else {
							relate = "great-great-grandaunt";
						}
						break;
					default:
						relate = "kin";
					}
				} else if(found.child == 0) {
					switch(found.parent) {
					case 1:
						relate = "child";
						break;
					case 2:
						relate = "grandchild";
						break;
					case 3:
						relate = "great-grandchild";
						break;
					case 4:
						relate = "great-great-grandchild";
						break;
					default:
						relate = "kin";
						break;
					}
				} else if(found.parent == 0) {
					switch(found.child) {
					case 1:
						relate = "parent";
						break;
					case 2:
						relate = "grandparent";
						break;
					case 3:
						relate = "great-grandparent";
						break;
					case 4:
						relate = "great-great-grandparent";
						break;
					default:
						relate = "kin";
						break;
					}
				} else if(Math.min(found.child, found.parent) >= 2 && Math.min(found.child,  found.parent) <= 4) {
					int removed = Math.abs(found.child-found.parent);
					int number = Math.min(found.child, found.parent) - 1;
				
					String numberString;
					String removedString;
					
					switch(number) {
					case 1:
						numberString = "1st ";
						break;
					case 2:
						numberString = "2nd ";
						break;
					case 3:
						numberString = "3rd ";
						break;
					default:
						numberString = "SOMethING IS WRONG";
					}
					
					switch(removed) {
					case 0:
						removedString = "";
						break;
					case 1:
						removedString = " once removed";
						break;
					case 2:
						removedString = " twice removed";
						break;
					case 3:
						removedString = " thrice removed";
						break;
					default:
						removedString = "ASDASLDAS";
						break;
					}
					
					relate = numberString + "cousin" + removedString;
				} else {
					relate = "kin";
				}
			}
			
			if(end != -1) System.out.println(relate);
		} while(end != -1);
		
	}
	
}
