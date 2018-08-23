/**
	 * the DLLInterface interface is the superclass of the DLL class.
	 * The DLL class must include all of the following methods.
	 */

public interface DLLInterface {
	
	/**
	 * DLL class must contain a getFirstNode method.
	 * @return DLLNode object.
	 */
	
	public DLLNode getFirstNode();
	
	/**
	 * DLL class must contain a getLastNode method.
	 * @return DLLNode object.
	 */
	
	public DLLNode getLastNode();
	
	/**
	 * DLL class must contain a getFirst method.
	 * @return Object.
	 */

	public Object getFirst();
	
	/**
	 * DLL class must contain a getLast method.
	 * @return Object.
	 */
	
	public Object getLast();
	
	/**
	 * DLL class must contain an addFirst method.
	 * @param Object o..
	 */
	
	public void addFirst(Object o);
	
	/**
	 * DLL class must contain an addFirst method.
	 * @param DLLNode p.
	 */
	
	public void addFirst(DLLNode p);
	
	/**
	 * DLL class must contain an addLast method.
	 * @param Object o.
	 */
	
	public void addLast(Object o);
	
	/**
	 * DLL class must contain a remove method.
	 * @param DLLNode p.
	 * @return Object.
	 */
	
	public Object remove(DLLNode p);
	
	/**
	 * DLL class must contain an insertLeft method.
	 * @param DLLNode p
	 * @param Object o
	 */
	
	public void insertLeft(DLLNode p, Object o);
	
	/**
	 * DLL class must contain an insertRight method.
	 * @param DLLNode p
	 * @param Object o
	 */
	
	public void insertRight(DLLNode p, Object o);
	
	/**
	 * DLL class must contain an isEmpty method.
	 */
	
	public boolean isEmpty();
	
	/**
	 * DLL class must contain a clear method.
	 */
	
	public void clear();
	
	/**
	 * DLL class must contain a size method. 
	 * @return integer value.
	 */
	
	public int size();
	
	/**
	 * DLL class must contain a copyList method. 
	 * @return DLL.
	 */
	
	public DLL copyList();
}
