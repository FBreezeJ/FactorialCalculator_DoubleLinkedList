/**
	 * the DLLNode class is a subclass of the DLLNodeInterface interface.
	 * All methods contained in the superclass must be included in the DLLNode class.
	 * This class creates a DLLNode object; these objects are to store DLLNodes indicating 
	 * the previous and next nodes attached to the DLLNode, as well as an Object indicating
	 * the information stored in the DLLNode.
	 * These ObjectListNode objects are to be stored in the DLL.
	 */

public class DLLNode implements DLLNodeInterface
{
	private Object info;
	private DLLNode next; 
	private DLLNode back;
	
	/**
	 * DLLNode constructor initializes the info, next, and back variables to null.
	 */
	
	public DLLNode() {
		info = null; 
		next = null;
		back = null;
	}
	
	/**
	 * ObjectListNode constructor initializes the info field to an Object o, and the next and back DLLNodes to null.
	 */
	
	public DLLNode(Object o) {
		info = o; 
		next = null;
		back = null; 
	}
	
	/**
	 * ObjectListNode constructor initializes every Object to their counterpart in the parameters.
	 * @param Object o - the Object information that is to be stored in the DLLNode.
	 * @param DLLNode p - the DLLNode which indicates the node after the current DLLNode.
	 * @param DLLNode q - the DLLNode which indicates the node previous to the current DLLNode.
	 */
	
	public DLLNode(Object o, DLLNode p, DLLNode q) {
		info = o; 
		next = p;
		back = q;
	}
	
	/**
	 * setInfo() method sets the info objects information to the Object o.
	 * @param Object o - the info Object will contain the information in the o Object.
	 */
	
	public void setInfo(Object o) {
		info = o;
	}
	
	/**
	 * getInfo() method returns the information contained in the info Object.
	 * @return Object info - information contained within the DLLNode.
	 */
	
	public Object getInfo() {
		return info;
	}
	
	/**
	 * setNext() method sets the next DLLNode's information to the DLLNode p.
	 * @param DLLNode p - a DLLNode object that will come after the current DLLNode.
	 */
	
	public void setNext(DLLNode p) {
		next = p;
	}
	
	/**
	 * getNext() method returns the DLLnode object that is contained within next.
	 * @return DLLNode next - the DLLNode object that comes after the current DLLNode.
	 */
	
	public DLLNode getNext() {
		return next;
	}
	
	/**
	 * setBack() method sets the previous DLLNode's information to the DLLNode p.
	 * @param DLLNode p - a DLLNode object that will come before the current DLLNode.
	 */
	
	public void setBack(DLLNode q) {
		back = q;
	}
	
	/**
	 * getBack() method returns the DLLnode object that is contained within back.
	 * @return DLLNode back - the DLLNode object that comes before the current DLLNode.
	 */
	
	public DLLNode getBack() {
		return back;
	}
}