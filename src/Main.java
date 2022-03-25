import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Main {
	
	public static void FileReading(String txt,MultiLinkedList MLL,SingleLinkedList SLL) {
		String str="";
		try {
			FileInputStream fStream = new FileInputStream(txt);
			DataInputStream dStream = new DataInputStream(fStream);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream,"UTF8"));
			//In order not to repeat similar processes, I made the file reading operation in a single function using if-else.
			if(txt.equalsIgnoreCase("D:\\input.txt")) {
				while ((str = bReader.readLine()) != null) {
					//Checking whether there is the same lengthNode in MLL while adding lengthNode to MLL.
					int tempLength = str.length();
					boolean flag = MLL.lengthControl(tempLength);
					//New lengthNode generation of lengthNode is not in MLL
					if(flag==false) {
						MLL.addLengthnode(tempLength);
					}
					MLL.addCountry(str, tempLength);
					//Adding countryNode and adding lengthNode operations was done in alphabetical and length order.
				}
				dStream.close();
			}
			else {
				//Reading HighScoreTable.txt.
				while ((str = bReader.readLine()) != null) {
					String [] tempStr = str.split(";");
					String tempName = tempStr[0];
					int tempScore = Integer.parseInt(tempStr[1]);
					//Adding players to SLL has been added according to the players' scores. Thus, the Highscoretable in SLL has been created.
					SLL.add(tempName,tempScore);
				}
				dStream.close();
			}
			
		}catch(Exception e)
		{
			System.out.println("Error: "+ e.getMessage());
		}
	}
	public static boolean letterControl(String letter) {
		//Checking the letter received from the user.
		boolean flag = true;
		boolean flag2=false;;
		//Checking whether the input entered is a letter.
		if(letter.length()!=1) {
			flag=false;
		}
		else {
			//Checking if the entry entered is a letter in the alphabet.
			char c=letter.charAt(0);
			int intLetter =(int)c;
			if(intLetter<=90 && intLetter>=65) flag2=true;
			if(intLetter<=122 && intLetter>=97) flag2=true;
			if(flag2==false) flag =false;
		}
		return flag;
		
	}
	public static void Game(MultiLinkedList MLL,SingleLinkedList SLL,DoubleLinkedList DLL,CircularLinkedList CSLL1,CircularLinkedList CSLL2) {
		Random rnd = new Random();
		Scanner scn = new Scanner(System.in);
		int lives =6,score=0;
		//Random country selection operation.
		int numberOfCountry = MLL.numberOfCountry();
		int randomNumber = rnd.nextInt(numberOfCountry)+1;
		String SelectedCountry = MLL.TakingTheCountry(randomNumber);
		//Creating CSLL1 and CSLL2.
		for (int i = 0; i < SelectedCountry.length(); i++) {
			CSLL1.add(SelectedCountry.substring(i, i+1));
			CSLL2.add("-");
		}
		//Creating alfabet in DLL.
		for (int i = 65; i <=90; i++) {
			char c=(char)i;
			String s = String.valueOf(c);  
			DLL.add(s);
		}
		System.out.print("Please enter your name: ");
		String name = scn.next();
		System.out.println("Randomly generated number: "+randomNumber);
		System.out.println();
		boolean gameFlag = true;
		while(gameFlag==true) {
			System.out.println();
			System.out.print("Word: ");
			CSLL2.display();
			System.out.print("\t\tLives: "+lives+"\tScore: "+score+"\t");
			DLL.display();
			System.out.print("\nGuess: ");
			String letter = scn.next();
			//Checking the letter received from the user.
			boolean letterControl = letterControl(letter);
			while(letterControl==false) {
				System.out.println("Your guess is invalid. Please enter a letter (A-Z or a-z) ");
				System.out.print("Guess: ");
				letter = scn.next();
				letterControl = letterControl(letter);
			}
			//Letter repeat control
			boolean ControlofRepeat = DLL.ControlofRepeat(letter);
			if(ControlofRepeat==true) {
				//Adding the letter received from the user to CSSL2 compared to CSLL1
				CSLL1.addFromCSLL1(CSLL2, letter);
				//Calculation of score.
				score = score + CSLL1.Score(letter);
				if(CSLL1.Score(letter)==0) lives--;
				//Removing of letters from the DLL according to their positions according to the letter M.
				if(letter.toUpperCase().compareTo("M")>0) DLL.removeFromTail(letter);
				if(letter.toUpperCase().compareTo("M")<=0) DLL.removeFromHead(letter);
				//The game ends when the player has any life. 
				if(lives==0) {
					gameFlag=false;
					System.out.println("You lost !!");
				}
				//User win this game when the user knows all the letters in the word
				if(CSLL2.isFinished()==true) {
					gameFlag=false;
					System.out.print("Word: ");
					CSLL2.display();
					System.out.print("\t\tLives: "+lives+"\tScore: "+score+"\t");
					DLL.display();
					System.out.println();
					System.out.println("\nYou win !!!!");
				}
			}
			else {
				System.out.println("You entered the same letter before.");
			}
		}
		System.out.println();
		//Adding the user in SLL.
		SLL.add(name, score);
		System.out.println("High Score Table");
		//Printing HighScoreTable and Writing HighScoreTable in HighScoreTable.txt.
		SLL.PrintOf10();
		SLL.Writeof10(10, "D:\\HighScoreTable.txt");
		
	}

	public static void main(String[] args) {
		//Creating MLL, SLL, DLL and CSLL.
		//I used Node for SLL.
		//I used CLLnode for CSLL.
		//I used DLLnode for DLL.
		//I used CountryNode and LengthNode for MLL.
		MultiLinkedList MLL = new MultiLinkedList();
		SingleLinkedList SLL = new SingleLinkedList();
		DoubleLinkedList DLL = new DoubleLinkedList();
		CircularLinkedList CSLL1 = new CircularLinkedList();
		CircularLinkedList CSLL2 = new CircularLinkedList();
		//Reading input.txt and HighScoreTable.txt.
		FileReading("D:\\input.txt",MLL,SLL);
		FileReading("D:\\HighScoreTable.txt",MLL,SLL);
		Game(MLL,SLL,DLL,CSLL1,CSLL2);

	}

}
