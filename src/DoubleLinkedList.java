public class DoubleLinkedList {
	private DLLnode head;
	private DLLnode tail;
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	public void add(String letter) {
		DLLnode newNode;
		if(head == null) {
			newNode = new DLLnode(letter);
			head = newNode;
			tail = newNode;
		}
		else {
			newNode = new DLLnode(letter);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}		
	}
	
	public void removeFromHead(String letter) {
		if(head == null) {
			System.out.println("LinkedList is empty");
		}
		else {
			while(((String)head.getData()).equalsIgnoreCase(letter)) {
				head = head.getNext();
				head.setPrev(null);
			}
			DLLnode temp = head;
			while(temp != null) {
				if(((String)temp.getData()).equalsIgnoreCase(letter)) {
					if(temp.getNext() == null) {
						tail = tail.getPrev();
						tail.setNext(null);
					}
					else {
						temp.getPrev().setNext(temp.getNext());
						temp.getNext().setPrev(temp.getPrev());
					}
				}
				temp = temp.getNext();
			}			
		}
	}
	public void removeFromTail(String letter) {
		if(head == null) {
			System.out.println("LinkedList is empty");
		}
		else {
			while(((String)tail.getData()).equalsIgnoreCase(letter)) {
				tail=tail.getPrev();
				tail.setNext(null);
			}
			DLLnode temp = tail;
			while(temp != null) {
				if(((String)temp.getData()).equalsIgnoreCase(letter)) {
					if(temp.getPrev() == null) {
						head = head.getNext();
						head.setPrev(null);
					}
					else {
						temp.getNext().setPrev(temp.getPrev());
						temp.getPrev().setNext(temp.getNext());
					}
				}
				temp = temp.getPrev();
			}			
		}
	}
	public boolean ControlofRepeat(String letter) {
		boolean flag =false;
		if(head == null) {
			System.out.println("LinkedList is empty");
		}
		else {
			DLLnode temp = head;
			while(temp != null) {
				if(((String)temp.getData()).equalsIgnoreCase(letter)) flag=true;
				temp = temp.getNext();
			}
		}
		return flag;
	}
	public int size() {
		int count = 0;
		if(head == null) {
			System.out.println("LinkedList is empty");
		}
		else {
			DLLnode temp = head;
			while(temp != null) {
				count++;
				temp = temp.getNext();
			}
		}
		return count;
	}
	public void display() {
		if(head == null) {
			System.out.println("LinkedList is empty");
		}
		else {
			DLLnode temp = head;
			while(temp != null) {
				System.out.print(temp.getData());
				temp = temp.getNext();
			}
		}
	}

}

