public class CountryNode {
	private String CountryData;
	private CountryNode next;
	
	public CountryNode(String dataToAdd) {
		CountryData = dataToAdd;
		next=null;
	}

	public String getCountryData() {
		return CountryData;
	}

	public void setCountryData(String countryData) {
		CountryData = countryData;
	}

	public CountryNode getNext() {
		return next;
	}

	public void setNext(CountryNode next) {
		this.next = next;
	}
}
