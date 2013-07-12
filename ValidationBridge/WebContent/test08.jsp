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
<title>08. Parameterized message Message Convert</title>
</head>
<body>
	<h2>08. Parameterized message Message Convert</h2>
	<%
		Rule08 r = new Rule08();
		request.setAttribute("rule", r);
	%>
<br/>
validationMessage.xml:
<pre> 
...
&lt;entry key=&quot;org.hibernate.validator.constraints.Range.message&quot;&gt;must be between {min} and {max}&lt;/entry&gt;
...

</pre>

<br/>

<br/>

Rule Code:
<pre> 
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class Rule08 implements Serializable {
	@Range(min = 1, max = 99)
	int age;
}

</pre>

<br/>
<br/>
<br/>
Generated Code:
<pre> 
$( "#f" ).validate({
	rules: {
		age:{range: [1,99]}
	}
	,messages: {
		age:{range: 'must be between 1 and 99'}
	}
});
</pre>
	<form name="f" id="f">
		Name: <input type="text" name="age" /><br/> 
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