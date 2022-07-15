<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="ShowDetails">View Employees</a>
<form action="SaveDetailsServ" method="post">
<table>
<tr><td>Business Code:</td><td><input type="text" name="business_code"/></td></tr>
<tr><td>Customer number:</td><td><input type="number" name="cust_number"/></td></tr>
<tr><td>Clear Date:</td><td><input type="date" name="clear_date"/></td></tr>
<tr><td>buisness_year:</td><td><input type="text" name="buisness_year"/></td></tr>
<tr><td>doc_id:</td><td><input type="number" name="doc_id"/></td></tr>
<tr><td>posting_date:</td><td><input type="date" name="posting_date"/></td></tr>
<tr><td>document_create_date:</td><td><input type="date" name="document_create_date"/></td></tr>
<tr><td>document_create_date1:</td><td><input type="date" name="document_create_date1"/></td></tr>
<tr><td>due_in_date:</td><td><input type="date" name="due_in_date"/></td></tr>
<tr><td>invoice_currency:</td><td><input type="text" name="invoice_currency"/></td></tr>
<tr><td>document_type:</td><td><input type="text" name="document_type"/></td></tr>
<tr><td>posting_id:</td><td><input type="number" name="posting_id"/></td></tr>
<tr><td>area_business:</td><td><input type="text" name="area_business"/></td></tr>
<tr><td>total_open_amount:</td><td><input type="number" name="total_open_amount"/></td></tr>
<tr><td>baseline_create_date:</td><td><input type="date" name="baseline_create_date"/></td></tr>
<tr><td>cust_payment_terms:</td><td><input type="text" name="cust_payment_terms"/></td></tr>
<tr><td>invoice_id:</td><td><input type="number" name="invoice_id"/></td></tr>
<tr><td>isOpen:</td><td><input type="number" name="isOpen"/></td></tr>
<tr><td>aging_bucket:</td><td><input type="text" name="aging_bucket"/></td></tr>
<tr><td>is_deleted:</td><td><input type="number" name="is_deleted"/></td></tr>
<tr><td></td><td><input type="submit" value="register"/></td></tr>
</table>
</form>
</body>
</html>