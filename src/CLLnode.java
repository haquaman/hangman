
public class CLLnode {
	private String data;
	private CLLnode link;
	
	public CLLnode(String dataToAdd) {
		data = dataToAdd;
		link = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public CLLnode getLink() {
		return link;
	}

	public void setLink(CLLnode link) {
		this.link = link;
	}
}
