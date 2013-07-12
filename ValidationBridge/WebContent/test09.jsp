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
<title>09. Combo Parameterized message Message Convert</title>
</head>
<body>
	<h2>09. Combo Parameterized message Message Convert</h2>
	<%
		Rule09 r = new Rule09();
		request.setAttribute("rule", r);
	%>
<br/>
validationMessage.xml:
<pre> 
...
&lt;entry key=&quot;org.hibernate.validator.constraints.Length.message&quot;&gt;length must be between {min} and {max}&lt;/entry&gt;
&lt;entry key=&quot;javax.validation.constraints.NotNull.message&quot;&gt; VALUE IS NEEDED!!! &lt;/entry&gt;
...

</pre>

<br/>

<br/>

Rule Code:
<pre> 
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class Rule09 implements Serializable {
	private static final long serialVersionUID = 1822712139230881537L;
	@Length(min = 2, max = 20)
	@NotNull
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
		name:{rangelength: [2,20],required: true}
	}
	,messages: {
		name:{rangelength: 'length must be between 2 and 20',required: ' VALUE IS NEEDED!!! '}
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