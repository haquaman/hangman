
public class CircularLinkedList {
	private CLLnode head = null;
	
	public void add(String dataToAdd) {
		CLLnode temp;
		if(head==null) {
			CLLnode newnode = new CLLnode(dataToAdd);
			head = newnode;
			head.setLink(head);
		}
		else {
			temp = head;
			while(temp.getLink()!=head) temp=temp.getLink();
			CLLnode newnode = new CLLnode(dataToAdd);
			newnode.setLink(temp.getLink());
			temp.setLink(newnode);
		}
	}
	public void addFromCSLL1(CircularLinkedList CSLL2,String data) {
		CLLnode temp = head;
		int count1 =0, count2=0;
		do {
			if(temp.getData().equalsIgnoreCase(data)) {
				count2=count1;
				CLLnode temp2 = CSLL2.head;
				do {
					if(count2!=0)temp2=temp2.getLink();
					count2--;
				}while(temp2!=null && count2>0);
				temp2.setData(temp.getData());
			}
			temp = temp.getLink();
			count1++;
		}while(temp != head);
	}
	public void display() {
		if(head == null)
			System.out.println("List is empty");
		else {
		CLLnode temp = head;
			do {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			}while(temp != head);
		}
	}
	public int Score(String data) {
		int score = 0;
		int count=0;
		int multiplier=10;
		if(data.equalsIgnoreCase("A") || data.equalsIgnoreCase("I") || data.equalsIgnoreCase("Ý") || 
				data.equalsIgnoreCase("O") || data.equalsIgnoreCase("U") || data.equalsIgnoreCase("E")) multiplier = 5;
		if(head == null)
			System.out.println("List is empty");
		else {
		CLLnode temp = head;
			do {
				if(temp.getData().equalsIgnoreCase(data)) {
					count++;
				}
				temp = temp.getLink();
			}while(temp != head);
		}
		score = count * multiplier;
		return score;
	}
	public boolean isFinished() {
		//Checking that the user knows the entire word
		boolean flag = true;
		if(head == null)
			System.out.println("List is empty");
		else {
		CLLnode temp = head;
			do {
				if(temp.getData().equals("-")) {
					flag=false;
				}
				temp = temp.getLink();
			}while(temp != head);
		}
		return flag;
	}
}
