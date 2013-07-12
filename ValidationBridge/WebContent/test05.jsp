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
<title>05. Message Convert</title>
</head>
<body>
	<h2>05. Message Convert</h2>
	<%
		Rule05 r = new Rule05();
		request.setAttribute("rule", r);
	%>
	
Message is from Spring MessageSource.<br/> 
See src/test/java/ApplicationConfig.java<br/>
<br/>	
<br/>
Rule Code:
<pre>
@Getter
@Setter
public class Rule05 implements Serializable {
	@NotNull
	String name;
}
</pre>
<br/>
Generated Code:
<pre>
$( "#f" ).validate({
	rules: {
		name:{required: true}
	}
	,messages: {
		name:{required: ' VALUE IS NEEDED!!! '}
	}
});
</pre>

	<form name="f" id="f">
		Name: <input type="text" name="name" /><br/> 
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