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
<title>11. Digits validation</title>
</head>
<body>
	<h2>11. Digits validation</h2>
	<%
		
		Rule13 parent = new Rule13();
		request.setAttribute("rule", parent);
	%>
<br/>
<br/>

<br/>

Rule Code:
<pre> 
@Getter @Setter
public class Rule13 {
	@Digits(integer = 3, fraction = 0)
	int age;

	@Digits(integer = 3, fraction = 1)
	float height;
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
		
		Age: <input type="text" name="age" /><br/>
		Height: <input type="text" name="height" /><br/> 
		
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