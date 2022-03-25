import java.io.FileWriter;
import java.io.IOException;

public class SingleLinkedList {
	private Node head;

	public SingleLinkedList() {
		this.head=null;
	}
	public void add(String nameToAdd,int scoreToAdd) {
		if(head==null) {//add to the top of the list.
			Node newNode= new Node(nameToAdd,scoreToAdd);
			head = newNode;
		}
		else {
			if(scoreToAdd >=(int)head.getScore()) {//add to the top of the list by comparison.
				Node newNode = new Node(nameToAdd,scoreToAdd);
				newNode.setLink(head);
				head=newNode;
			}
			else {
				Node temp = head;
				Node previous = null;
				while(temp!=null && scoreToAdd < (int)temp.getScore()) {
					previous = temp;
					temp = temp.getLink();
				}
				if(temp==null) { //add to the end of the list.
					Node newnode = new Node(nameToAdd,scoreToAdd);
					previous.setLink(newnode);
				}
				else {//add to the middle of the list.
					Node newnode = new Node(nameToAdd,scoreToAdd);
					newnode.setLink(temp);
					previous.setLink(newnode);
				}
			}
		}
	}
	public void PrintOf10() {
		int limit =0;
		if(head == null) System.out.println("linked is empty");
		else {
			Node temp = head;
			while(temp!=null && limit!=10) {
				System.out.println(temp.getName()+" "+temp.getScore());
				temp=temp.getLink();
				limit++;
			}
		}
	}
	public void Writeof10(int limit,String txt) {
		int count =0;
		try {
	        FileWriter writer = new FileWriter(txt, false);	//"false" for overwriting
	        Node temp = head;
	        while(temp!=null && count!=limit) {
	        	writer.write(temp.getName()+";"+temp.getScore()+"\n");
	        	temp=temp.getLink();
	        	count++;
	        }
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}
}
