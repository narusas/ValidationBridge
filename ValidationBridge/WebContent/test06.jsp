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
<title>06. Specified Message Convert</title>
</head>
<body>
	<h2>06. Specified  Message Convert</h2>
	<%
		Rule06 r = new Rule06();
		request.setAttribute("rule", r);
	%>
Rule Code:
<pre> 
@Getter
@Setter
public class Rule06 implements Serializable {
	@NotNull(message="Please give me your name")
	String name;
}

</pre>

<br/>
<br/>
<br/>
Generated Code:
<pre> 
$( "#f" ).validate({
	rules: {
		name:{required: true}
	}
	,messages: {
		name:{required: 'Please give me your name'}
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