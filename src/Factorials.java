import java.io.PrintWriter;

/**
 * The Factorials class creates a Factorials object that contains a PrintWriter Object that writes data to the csis_factorials.txt file.
 * The point of the class is to calculate the factorials of numbers provided by the user and store their values in double linked lists.
 */

public class Factorials
{
	private PrintWriter pw;
	
	/**
	 * Factorials constructor initializes the PrintWriter object pw to the value provided in the parameter.
	 * @param PrintWriter pw - the Object initialized in the main method which writes to the csis_factorials.txt file. 
	 */
	
	public Factorials(PrintWriter pw) {
		this.pw = pw;
	}
	
	/**
	 * getList calculates the factorial of the number provided to the method by the user from the main method.
	 * If the number provided is 1, then the factorial of 1 is immediately returned.
	 * If the number is more than 1, then the calculation of the factorial takes place in one long while loop, until
	 * the count of the while loop is equivalent to the number provided by the user.
	 * The first nested while loop takes into account the number of times that the current count can be divided by 10 in order
	 * to figure out how many times the current factorial should be multiplied by the next number (ex: 9! X 10, 9 factorial should
	 * first be multiplied by the 0 in 10, and then the 1 in 10, and then multiplied by 10 to add a zero).
	 * The products of factorial multiplication are stored in 3 DLLs, with DLL 1 containing the current factorial, DLL 2 containing 
	 * the current factorial multiplied by the appropriate digit in the next factorial, and DLL 3 containing the addition of the 
	 * previous products stored in DLL 2, true to elementary school multiplication tables. Once a given facotrial is calculated, then
	 * its value is stored in DLL 1 and the next factorial is produced in the same way.
	 * Each node in the DLL is to only contain 3 digits max; whenever the multiplication of a given node exceeds 1000, then its remainder
	 * when divided by 1000 is stored in the node and the number of times the number was divided by 1000 is added to the product of the next 
	 * node. The number of microseconds it takes from beginning to end to calculate a factorial is determined by placed two System.currentTimeMillis()
	 * methods at the beginning and end of the method.
	 * @param int fact - the number provided by the user in the main method, whose factorial is to be calculated.
	 * @return DLL f - the DLL containing the factorial of the integer fact.
	 */
	
	public DLL getList(int fact) {
		long start = System.currentTimeMillis();
		DLL f = new DLL();
		DLL g = new DLL();
		DLL h = new DLL();
		f.addFirst(1);
		h.addFirst(0);
		DLLNode here;
		DLLNode there;
		int remaining = 0;
		int count = 2; 
		int divisor = 1;
		if(fact == 1) return f;
		while(count <= fact) {
				while(count / divisor != 0) {
					g = f.copyList();
					here = g.getFirstNode();
					there = h.getFirstNode();
					
					
					remaining = 0;
					while(here != null) 
					{
						here.setInfo((Integer)here.getInfo() * ((count%(divisor*10))/(divisor)) + remaining); // how to get from 0-9 to 10 - 100
					
						remaining = 0;
						if(((Integer)here.getInfo()) > 999) {
							remaining = ((Integer)here.getInfo() / 1000);
							here.setInfo(((Integer)here.getInfo()) % 1000);
						}
						here = here.getNext();
					}
					if(here == null) 
					{
						if(remaining != 0){
							g.addLast(remaining); 
					
						}
						here = g.getFirstNode();
						remaining = 0;
						int divisor2 = divisor;
						while(divisor2 / 10 != 0) {
							while(here != null) {
								here.setInfo(((Integer)here.getInfo()) * 10 + remaining); // how to get from 0-9 to 10 - 100
								remaining = 0;
								if(((Integer)here.getInfo()) > 999) {
									remaining = ((Integer)here.getInfo() / 1000);
									here.setInfo(((Integer)here.getInfo()) % 1000);
								}
								here = here.getNext();
							}
							if(remaining != 0){
								g.addLast(remaining); 
							}
							remaining = 0;
							divisor2 /= 10;
							here = g.getFirstNode();
						}
					}					
					here = g.getFirstNode();
					there = h.getFirstNode();
					remaining = 0;
					while(here != null) {
						there.setInfo((Integer)there.getInfo() + (Integer)here.getInfo() + remaining);
						remaining = 0;
						if((Integer)there.getInfo() > 999) {
							remaining = ((Integer)there.getInfo() / 1000);
							there.setInfo((Integer)there.getInfo()%1000);
						}
						here = here.getNext();
						if(there.getNext() == null && here != null) h.addLast(0);
						there = there.getNext();
					}
					if(remaining != 0){
						h.addLast(remaining); 
					}
					divisor *= 10;
				}
				divisor = 1;
				count++;
				f = h.copyList();
				h.clear();
				h.addFirst(0);
		}
		long end = System.currentTimeMillis();
		System.out.print("took " + (end - start) + " milliseconds to compute and contains ");
		pw.println("took " + (end - start) + " milliseconds to compute and contains ");
		return f;
	}
	
	/**
	 * Prints the values contained in the DLL from end to beginning in an appropriate manner.
	 * The contents of the first node are printed first, followed by every other node in a while loop.
	 * A comma is to be placed after every third digit, and only 45 digits are to be printed per line.
	 * Final three digits will contain no comma afterwards.
	 * @param DLL list - the DLL object that contains the factorial of a given number. 
	 */
	
	public void printFactorial(DLL list) {
		DLLNode p = list.getLastNode();
		int count = 0;
		if(list.size() == 1) {
			System.out.println(p.getInfo());
			pw.println(p.getInfo());
			return;
		}
		else {
			System.out.print(p.getInfo() + ",");
			pw.print(p.getInfo() + ",");
		}
		if((Integer)p.getInfo() < 10) count += 1;
		else if((Integer)p.getInfo() < 100) count += 2;
		else count += 3;
		p = p.getBack();
		while(p.getBack() != null) {
			if(count > 42 && count <= 45) {
				System.out.println();
				pw.println();
				count = 0;
			}
			if((Integer)p.getInfo() < 10) {
				System.out.print("00" + p.getInfo() + ",");
				pw.print("00" + p.getInfo() + ",");
			}
			else if((Integer)p.getInfo() < 100) {
				System.out.print("0" + p.getInfo() + ",");
				pw.print("0" + p.getInfo() + ",");
			}
			else {
				System.out.print(p.getInfo() + ",");
				pw.print(p.getInfo() + ",");
			}
			count += 3;
			p = p.getBack();
		}
		if(count > 42 && count <= 45) {
			System.out.println();
			pw.println();
			count = 0;
		}
		if((Integer)p.getInfo() < 10) {
			System.out.print("00" + p.getInfo());
			pw.print("00" + p.getInfo());
		}
		else if((Integer)p.getInfo() < 100) {
			System.out.print("0" + p.getInfo());
			pw.print("0" + p.getInfo());
		}
		else {
			System.out.print(p.getInfo());
			pw.print(p.getInfo());
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		pw.println();
		pw.println("-------------------------------------------------------------");
		pw.println();
	}
	
	/**
	 * The number of digits in the factorial are determined and printed.
	 * First, the number of digits, depending on the value of the number, contained within the 
	 * final node is determined, followed by the number of nodes in the DLL multiplied by three.
	 * The addition of the number of digits in the first node and the product of the number of 
	 * nodes in the DLL by 3 shall yield the total number of digits in the factorial.
	 * @param DLL list - the DLL object that contains the factorial of a given number. 
	 */
	
	public void printDigits(DLL list) {
		int count = 0;
		DLLNode d = list.getLastNode();
		if((Integer)d.getInfo() < 10) {
			count += 1;
		}
		else if((Integer)d.getInfo() < 100 && (Integer)d.getInfo() >= 10) {
			count += 2;
		}
		else count += 3;
		count += (list.size()-1)*3;
		System.out.println(count + " digits.");
		System.out.println();
		pw.println(count + " digits.");
		pw.println();
	}
}
