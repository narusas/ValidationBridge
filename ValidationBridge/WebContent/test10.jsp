<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="net.narusas.jstl.validate.*"%>
<%@ taglib prefix="v" uri="http://www.narusas.net/tags/valid"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/jquery.js"></script>
<script type="text/javascript" src="/jquery.validate.js"></script>
<title>10. Child validation</title>
</head>
<body>
	<h2>10. Child validation</h2>
	<%
		
		Rule10 parent = new Rule10();
		request.setAttribute("rule", parent);
	%>
<br/>
<br/>

<br/>

Rule Code:
<pre> 
@Getter
@Setter
public class Rule10 implements Serializable {

	@Valid
	Rule09 child;
}
</pre>

<br/>
<br/>
<br/>
Generated Code:
<pre> 

$( "#f" ).validate({
	rules: {
		age:{minlength: 1},license.authority.created:{required: true},license.authority.name:{required: true},license.licensedTime:{required: true},license.no:{minlength: 1000},name:{required: true}
	}
	,messages: {
		age:{minlength: 'must be greater than or equal to {value}'},license.authority.created:{required: ' VALUE IS NEEDED!!! '},license.authority.name:{required: ' VALUE IS NEEDED!!! '},license.licensedTime:{required: ' VALUE IS NEEDED!!! '},license.no:{minlength: 'must be greater than or equal to {value}'},name:{required: ' VALUE IS NEEDED!!! '}
	}
});
</pre>
	<form name="f" id="f">
		
		Name: <input type="text" name="name" /><br/> 
		Age: <input type="text" name="age" /><br/>
		License No: <input type="text" name="license.no" /><br/>
		License Time: <input type="text" name="license.licensedTime" /><br/>
		License Authority Name: <input type="text" name="license.authority.name" /><br/>
		License Authority Created: <input type="text" name="license.authority.created" /><br/>
		
		<input type="submit"value="Validate!">
	</form>

	<script>
//just for the demos, avoids form submit
jQuery.validator.setDefaults({
  debug: true,
  success: "valid"
});

$( "#f" ).validate({
	rules: {
		<v:validationRules ruleBean="${rule}"/>
	}
	,messages: {
		<v:validationMessages ruleBean="${rule}"/>
	}
});
</script>
</body>
</html>