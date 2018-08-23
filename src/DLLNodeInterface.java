/**
	 * the DLLNodeInterface interface is the superclass of the DLLNode class.
	 * The DLLNode class must include all of the following methods.
	 */

public interface DLLNodeInterface 
{
	/**
	 * DLLNode class must contain a setInfo method.
	 * @param accepts an object o.
	 */
	
	public void setInfo(Object o);
	
	/**
	 * DLLNode class must contain a getInfo method.
	 * @return an Object contained within the DLLNode.
	 */
	
	public Object getInfo();
	
	/**
	 * DLLNode class must contain a setNext method.
	 * @param accepts a DLLNode p.
	 */
	
	public void setNext(DLLNode p);
	
	/**
	 * DLLNode class must contain a getNext method.
	 * @return a DLLNode Object contained within the DLLNode.
	 */
	
	public DLLNode getNext();
	
	/**
	 * DLLNode class must contain a setBack method.
	 * @param accepts a DLLNode q.
	 */
	
	public void setBack(DLLNode q);
	
	/**
	 * DLLNode class must contain a getBack method.
	 * @return a DLLNode Object contained within the DLLNode.
	 */
	
	public DLLNode getBack();
}

