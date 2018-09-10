package pl.aogiri.results;

public class Result {
	
	private String status;
	
	private String response;
	
	public Result() {		
	}

	public Result(String status, String response) {
		super();
		this.status = status;
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
	
	

}
