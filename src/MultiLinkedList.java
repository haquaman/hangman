
public class MultiLinkedList {
	LengthNode head;
	public void addLengthnode(int dataToAdd) {
		if(head==null) {//add to the top of the list.
			LengthNode newNode= new LengthNode(dataToAdd);
			head =newNode;
		}
		else {
			if((int)dataToAdd< (int)head.getLength()) {//add to the top of the list by comparison.
				LengthNode newNode= new LengthNode(dataToAdd);
				newNode.setDown(head);
				head=newNode;
			}
			else {
				LengthNode temp = head;
				LengthNode previous = null;
				while(temp!=null &&(int)dataToAdd>(int)temp.getLength()) {
					previous =temp;
					temp = temp.getDown();
				}
				if(temp==null) { //add to the end of the list.
					LengthNode newNode= new LengthNode(dataToAdd);
					previous.setDown(newNode);
				}
				else {//add to the middle of the list.
					LengthNode newNode= new LengthNode(dataToAdd);
					newNode.setDown(temp);
					previous.setDown(newNode);
				}
			}
		}
	}
	public void addCountry(String dataToAdd,int lengthID) {
		if(head == null) {
			System.out.println("Add a row before cell data");
		}
		else {
			LengthNode temp = head;
			while(temp!=null) {
				if(temp.getLength() == lengthID) {
					CountryNode temp2 = temp.getRight();
					CountryNode previous = null;
					if(temp2==null) {
						CountryNode newNode= new CountryNode(dataToAdd);
						temp2 =newNode;
						temp.setRight(temp2);
					}
					else {
						if(dataToAdd.compareTo(temp2.getCountryData())<0) {
							CountryNode newNode= new CountryNode(dataToAdd);
							CountryNode tempNode = temp.getRight();
							temp2=newNode;
							temp.setRight(temp2);
							temp2.setNext(tempNode);
						}
						else {
							while(temp2!=null && dataToAdd.compareTo(temp2.getCountryData())>0) {
								previous = temp2;
								temp2 = temp2.getNext();
							}
							if(temp2==null) {
								CountryNode newNode = new CountryNode(dataToAdd);
								previous.setNext(newNode);
							}
							else {
								CountryNode newNode = new CountryNode(dataToAdd);
								newNode.setNext(temp2);
								previous.setNext(newNode);
							}
						}
					}
					
				}
				temp = temp.getDown();
			}
		}
	}
	public boolean lengthControl(int value) {
		boolean flag = false;
		LengthNode temp = head;
		while(temp!=null) {
			if(value==temp.getLength()) flag = true;
			temp = temp.getDown();
		}
		return flag;
	}
	public void Print() {
		System.out.println();
		if(head == null) {
			System.out.println("Linked list is empty");
		}
		else {
			LengthNode temp = head;
			while(temp!=null) {
				System.out.print(temp.getLength() + "-->");
				CountryNode temp2= temp.getRight();
				while(temp2!=null) {
					System.out.print(temp2.getCountryData()+" ");
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
				System.out.println();

			}
		}
		
	}
	public int numberOfCountry() {
		int count =0;
		LengthNode temp = head;
		while(temp!=null) {
			CountryNode temp2= temp.getRight();
			while(temp2!=null) {
				count++;
				temp2 = temp2.getNext();
			}
			temp = temp.getDown();
		}
		return count;
	}
	public String TakingTheCountry(int countryNumber){
		String str="";
		int count =0;
		LengthNode temp = head;
		while(temp!=null) {
			CountryNode temp2= temp.getRight();
			while(temp2!=null) {
				count++;
				if(countryNumber == count) str = temp2.getCountryData();
				temp2 = temp2.getNext();
			}
			temp = temp.getDown();
		}
		return str;
	}
}
