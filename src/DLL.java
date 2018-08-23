/**
	 * the DLL class is a subclass of the DLLInterface interface.
	 * All methods contained in the superclass must be included in the DLL class.
	 * This class creates a DLL object; this object is to store DLLNode objects which 
	 * contain information as well as pointers to the next and previous DLLNodes in the DLL.
	 */

public class DLL implements DLLInterface{
	private DLLNode list;
	private DLLNode last;
	
	/**
	 * DLL constructor initializes the list DLLNode to null and 
	 * the last DLLNode to null.
	 */
	
	public DLL() {
		list = null;
		last = null;
	}
	
	/**
	 * @return DLLNode list - the first DLLNode in the DLL.
	 */
	
	public DLLNode getFirstNode() {
		return list; 
	}
	
	/**
	 * @return DLLNode last - the last DLLNode in the DLL.
	 */
	
	public DLLNode getLastNode() {
		return last; 
	}
	
	/**
	 * returns the information stored in the first DLLNode in the DLL unless the list is composed only of a null.
	 * @return Object list.getInfo() - the Object stored in the first DLLNode in the list.
	 */
	
	public Object getFirst() {
		if(list == null) {
			System.out.println("Runtime Error: getFirst()");
			System.exit(1);
		}
		return list.getInfo();
	}
	
	/**
	 * returns the information stored in the last DLLNode in the DLL unless the list is composed only of a null.
	 * @return Object last.getInfo() - the Object stored in the last DLLNode in the list.
	 */
	
	public Object getLast() {
		if(list == null) {
			System.out.println("Runtime Error: getLast()");
			System.exit(1);
		}
		return last.getInfo();
	}
	
	/**
	 * stores an object into the newly created first DLLNode of the DLL.
	 * If list is initially composed of only a null, then this newly created first DLLNode is also the last node in the list.
	 * @param Object o - the Object which is to be stored in the first DLLNode of the list.
	 */
	
	public void addFirst(Object o) {
		DLLNode p = new DLLNode(o, list, null);
		if(list == null) last = p;
		list = p;
	}
	
	/**
	 * adds the first DLLNode into the DLL.
	 * If list is initially composed of only a null, then this newly created first DLLNode is also the last node in the list.
	 * @param DLLNode p - the node which is to be the first DLLNode in the list.
	 */
	
	public void addFirst(DLLNode p) {
		if(p == null) {
			System.out.println("Runtime Error: addFirst()");
			System.exit(1);
		}
		p.setNext(list);
		if(list == null) last = p;
		else {
			list.setBack(p);
		}
		list = p;
	}
	
	/**
	 * stores an object into the newly created last DLLNode of the DLL.
	 * If list is initially composed of only a null, then this newly created last DLLNode is also the first node of the list.
	 * @param Object o - the Object which is to be stored in the last (or first) DLLNode of the list.
	 */
	
	public void addLast(Object o) {
		DLLNode p = new DLLNode(o, null, last);
		if(list == null) list = p;
		else last.setNext(p);
		last = p;
	}
	
	/**
	 * removes the DLLNode from the DLL which contains Object o.
	 * If the list does not contain o, then null is returned.
	 * @param Object o - the Object which is to be deleted form the list along with the DLLNode which it is contained in.
	 * @return the node which is deleted from the list, or null if the list is empty or doensn't contain o.
	 */
	
	public Object remove(DLLNode p) {
		if(p == null || list == null) {
			System.out.println("Runtime Error: reove();");
			System.exit(1);
		}
		DLLNode q = p.getBack();
		DLLNode r = p.getNext();
		if(q == null) {
			list = r;
		}
		else {
			q.setNext(r);
		}
		if(r != null) {
			r.setBack(q);
		}
		else {
			last = q;
		}
		return p.getInfo();
	}
	
	/**
	 * Inserts a newly created DLLNode r containing Object o to the left of the DLLNode p contained in the DLL.
	 * @param DLLNode p - the reference node to which the DLLNode containing Object o is to be inserted left of in the DLL.
	 * @param Object o - the Object which is to be placed in a new DLLNode and inserted in the DLL left of p.
	 */
	
	public void insertLeft(DLLNode p, Object o) {
		DLLNode r;
		
		if(list == null || p == null) {
			System.out.println("Runtime Erro: insertLeft()");
		}
		DLLNode q = new DLLNode(o);
		r = p.getBack();
		if(r != null) r.setNext(q);
		q.setBack(r);
		q.setNext(p);
		p.setBack(q);
		if(list == p) list = q;
	}
	
	/**
	 * Inserts a newly created DLLNode r containing Object o to the right of the DLLNode p contained in the DLL.
	 * @param DLLNode p - the reference node to which the DLLNode containing Object o is to be inserted right of in the DLL.
	 * @param Object o - the Object which is to be placed in a new DLLNode and inserted in the DLL right of p.
	 */
	
	public void insertRight(DLLNode p, Object o) {
		DLLNode r;
		
		if(list == null || p == null) {
			System.out.println("Runtime Error: insertRight()");
			System.exit(1);
		}
		DLLNode q = new DLLNode(o);
		r = p.getNext();
		if(r != null) r.setBack(q);
		q.setNext(r);
		q.setBack(p);
		p.setNext(q);
		if(r == null) last = q;
	}
	
	/**
	 * determines if the DLL is empty depending on whether or not list = null.
	 * @return boolean - true or false depending on whether or not the DLL is empty.
	 */
	
	public boolean isEmpty() {
		return list == null;
	}
	
	/**
	 * sets list and last to null, thus clearing the DLL of all information.
	 */
	
	public void clear() {
		list = null; 
		last = null;
	}
	
	/**
	 * determines the number of nodes contained in the DLL.
	 * @return int count - the number of nodes in the DLL, which represents the size of the DLL. 
	 */
	
	public int size() {
		int count = 0; 
		DLLNode p = list; 
		while(p != null) {
			++count; 
			p = p.getNext();
		}
		return count;
	}
	
	/**
	 * creates a new DLL object, newList, and copies the contents of the current DLL onto that DLL. 
	 * @return DLL newList - the new DLL which is a copy of the current DLL. 
	 */
	
	public DLL copyList() {
		DLLNode p = null; 
		DLLNode q = null; 
		DLLNode r = list;
		
		if(isEmpty()) return null;
		DLL newList = new DLL();
		while(r != null) {
			p = new DLLNode(r.getInfo());
			if(newList.isEmpty()) newList.addFirst(p);
			else {
				q.setNext(p);
				p.setBack(q);
			}
			q = p; 
			r = r.getNext();
		}
		newList.last = p;
		return newList;
	}
}
