public class DLLnode {
	private Object data;
	private DLLnode prev;
	private DLLnode next;
	public DLLnode(Object dataToAdd) {
		data = dataToAdd;
		prev = null;
		next = null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public DLLnode getPrev() {
		return prev;
	}
	public void setPrev(DLLnode prev) {
		this.prev = prev;
	}
	public DLLnode getNext() {
		return next;
	}
	public void setNext(DLLnode next) {
		this.next = next;
	}
}

