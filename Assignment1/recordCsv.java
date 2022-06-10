package recordMapper;

import java.util.Date;

public class recordCsv {
private String Datereceived;
private String  Product;

private  String Sub_product;

private  String Issue;
private  String Sub_issue;

private  String Company;
private  String State;
private String ZIP_code;

private  String Submitted_via;

private String Date_closed;

private  String Company_response;


private  String Timely_response;

private  String Consumer_disputed;

private String Complaint_ID;





@Override
public String toString() {
	return "recordCsv [Datereceived=" + Datereceived + ", Product=" + Product + ", Sub_product=" + Sub_product
			+ ", Issue=" + Issue + ", Sub_issue=" + Sub_issue + ", Company=" + Company + ", State=" + State
			+ ", ZIP_code=" + ZIP_code + ", Submitted_via=" + Submitted_via + ", Date_closed=" + Date_closed
			+ ", Company_response=" + Company_response + ", Timely_response=" + Timely_response + ", Consumer_disputed="
			+ Consumer_disputed + ", Complaint_ID=" + Complaint_ID + "]";
}

public String getZIP_code() {
	return ZIP_code;
}

public void setZIP_code(String zIP_code) {
	ZIP_code = zIP_code;
}

public String getComplaint_ID() {
	return Complaint_ID;
}

public void setComplaint_ID(String complaint_ID) {
	Complaint_ID = complaint_ID;
}



public recordCsv(String datereceived, String product, String sub_product, String issue, String sub_issue,
		String company, String state, String zIP_code, String submitted_via, String date_closed,
		String company_response, String timely_response, String consumer_disputed, String complaint_ID) {
	super();
	Datereceived = datereceived;
	Product = product;
	Sub_product = sub_product;
	Issue = issue;
	Sub_issue = sub_issue;
	Company = company;
	State = state;
	ZIP_code = zIP_code;
	Submitted_via = submitted_via;
	Date_closed = date_closed;
	Company_response = company_response;
	Timely_response = timely_response;
	Consumer_disputed = consumer_disputed;
	Complaint_ID = complaint_ID;
}

public String getDatereceived() {
	return Datereceived;
}

public void setDatereceived(String datereceived) {
	Datereceived = datereceived;
}

public String getDate_closed() {
	return Date_closed;
}

public void setDate_closed(String date_closed) {
	Date_closed = date_closed;
}

public String getProduct() {
	return Product;
}

public void setProduct(String product) {
	Product = product;
}

public String getSub_product() {
	return Sub_product;
}

public void setSub_product(String sub_product) {
	Sub_product = sub_product;
}

public String getIssue() {
	return Issue;
}

public void setIssue(String issue) {
	Issue = issue;
}

public String getSub_issue() {
	return Sub_issue;
}

public void setSub_issue(String sub_issue) {
	Sub_issue = sub_issue;
}

public String getCompany() {
	return Company;
}

public void setCompany(String company) {
	Company = company;
}

public String getState() {
	return State;
}

public void setState(String state) {
	State = state;
}



public String getSubmitted_via() {
	return Submitted_via;
}

public void setSubmitted_via(String submitted_via) {
	Submitted_via = submitted_via;
}



public String getCompany_response() {
	return Company_response;
}

public void setCompany_response(String company_response) {
	Company_response = company_response;
}

public String getTimely_response() {
	return Timely_response;
}

public void setTimely_response(String timely_response) {
	Timely_response = timely_response;
}

public String getConsumer_disputed() {
	return Consumer_disputed;
}

public void setConsumer_disputed(String consumer_disputed) {
	Consumer_disputed = consumer_disputed;
}




}
