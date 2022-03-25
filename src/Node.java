public class Node {
	private String name;
	private int score;
	private Node link;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public Node (String nameToAdd,int scoreToAdd) {
		name = nameToAdd;
		score = scoreToAdd;
		link=null;
	}
}
