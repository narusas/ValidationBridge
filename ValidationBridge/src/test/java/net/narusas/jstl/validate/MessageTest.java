package net.narusas.jstl.validate;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ApplicationConfig.class })
public class MessageTest {
	@Autowired
	MessageSource messageSource;
	private FieldCollector fieldCollector;
	private RulesInspector inspector;

	@Before
	public void setUp() {
		fieldCollector = new FieldCollector();
		inspector = new RulesInspector();
	}

	@Test
	public void minInt() {
		class Rule {
			@Min(2)
			int age;
		}

		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{min: 'must be greater than or equal to 2'}", ageField.toString());
	}
	
		
	@Test
	public void max() {
		class Rule {
			@Max(3)
			int age;
		}
		
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{max: 'must be less than or equal to 3'}", ageField.toString());
	}
	
	@Test
	public void length() {
		class Rule{
			@Length(min=3, max=5)
			int age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{rangelength: 'length must be between 3 and 5'}", ageField.toString());
	}
	
	@Test
	public void notEmpty() {
		class Rule{
			@NotEmpty
			String age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{required: 'may not be empty'}", ageField.toString());
	}
	
	@Test
	public void notBlank() {
		class Rule{
			@NotBlank
			String age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{required: 'may not be empty'}", ageField.toString());
	}
	
	@Test
	public void notNull() {
		class Rule{
			@NotNull
			String age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{required: ' VALUE IS NEEDED!!! '}", ageField.toString());
	}
	
	@Test
	public void email() {
		class Rule{
			@Email
			String age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{email: 'not a well-formed email address'}", ageField.toString());
	}
	
	@Test
	public void digits() {
		class Rule{
			@Digits(integer=3, fraction=0)
			int age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{digits: 'numeric value out of bounds (<3 digits>.<0 digits> expected)'}", ageField.toString());
	}
	
	@Test
	public void numbers() {
		class Rule{
			@Digits(integer=3, fraction=2)
			int age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{number: 'numeric value out of bounds (<3 digits>.<2 digits> expected)'}", ageField.toString());
	}
	
	@Test
	public void customeMessage() {
		class Rule{
			@Digits(integer=3, fraction=2, message="This is custome message")
			int age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{number: 'This is custome message'}", ageField.toString());
	}
	
	@Test
	public void customeMessageParameter() {
		class Rule{
			@Digits(integer=3, fraction=2, message="This is custome message {integer}")
			int age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{number: 'This is custome message 3'}", ageField.toString());
	}
	
	@Test
	public void customeMessageFromMessageSource() {
		class Rule{
			@Digits(integer=3, fraction=2, message="{ANOTHER_SPRING_MESSAGE}")
			int age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{number: 'You can use message source.'}", ageField.toString());
	}
	
	@Test
	public void multiMessage(){
		class Rule{
			@Min(value=2, message="min message")
			@Max(value=10, message="max message")
			int age;
		}
		FieldNode ageField = setup(Rule.class);
		assertEquals("'age':{min: 'min message', max: 'max message'}", ageField.toString());
	}
	
	
	@Test
	public void dateFormat() {
		class Rule{
			@ValidDateTimeFormat
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
			Date date;
		}
		FieldNode field = setup(Rule.class);
		assertEquals("'date':{regex: 'Date format is invalid.'}", field.toString());
	}
	

	FieldNode setup(Class<?> clazz) {
		List<FieldNode> fieldNodes = fieldCollector.collect(clazz);
		inspector.collectMessage(fieldNodes, messageSource);
		FieldNode fieldNode = fieldNodes.get(0);
		fieldNode.setMessageFormatter(true, messageSource);
		return fieldNode;
	}

}
