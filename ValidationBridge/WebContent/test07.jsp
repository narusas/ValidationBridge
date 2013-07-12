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
<title>07. Specified Spring Message Convert</title>
</head>
<body>
	<h2>07. Specified  Spring Message Convert</h2>
	<%
		Rule07 r = new Rule07();
		request.setAttribute("rule", r);
	%>
<br/>
<br/>
validationMessage.xml:
<pre> 
...
&lt;entry key=&quot;ANOTHER_SPRING_MESSAGE&quot;&gt;You can use message source.&lt;/entry&gt;
...

</pre>

<br/>


Rule Code:
<pre> 
@Getter
@Setter
public class Rule07 implements Serializable {
	@NotNull(message="{ANOTHER_SPRING_MESSAGE}")
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
		name:{required: 'You can use message source.'}
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