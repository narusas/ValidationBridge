package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.validation.constraints.Size;

import org.junit.Test;

public class SizeRuleTest extends RuleTestBase {
	public static class Rule {
		@Size(min = 2, max = 5)
		String stringValue;
		
		@Size(min = 2, max = 5)
		List<String> collectionValue;
		
		@Size(max=5)
		String stringValue2;
		
		@Size(min=5)
		String stringValue3;
	}

	@Test
	public void stringSize() {
		FieldAnnotaion<Size> entry = getFieldAnnotation(Rule.class, "stringValue", Size.class);
		SizeRule rule = new SizeRule(entry.getAnnotation(), entry.getField());
		assertEquals(2, rule.getMin());
		assertEquals(5, rule.getMax());
		assertEquals("rangelength: [2,5]", rule.toRuleString());
	}
	
	@Test
	public void collectionSize() {
		FieldAnnotaion<Size> entry = getFieldAnnotation(Rule.class, "collectionValue", Size.class);
		SizeRule rule = new SizeRule(entry.getAnnotation(), entry.getField());
		assertEquals(2, rule.getMin());
		assertEquals(5, rule.getMax());
		assertEquals("컬렉션이나 배열의 크기를 제한 하는 자바스크립트 소스는  단순하게 만들수 없다.","", rule.toRuleString());
	}

	@Test
	public void  maxSize() {
		FieldAnnotaion<Size> entry = getFieldAnnotation(Rule.class, "stringValue2", Size.class);
		SizeRule rule = new SizeRule(entry.getAnnotation(), entry.getField());
		assertEquals(0, rule.getMin());
		assertEquals(5, rule.getMax());
		assertEquals("rangelength: [0,5]", rule.toRuleString());
	}
	
	@Test
	public void  minSize() {
		FieldAnnotaion<Size> entry = getFieldAnnotation(Rule.class, "stringValue3", Size.class);
		SizeRule rule = new SizeRule(entry.getAnnotation(), entry.getField());
		assertEquals(5, rule.getMin());
		assertEquals(Integer.MAX_VALUE, rule.getMax());
		assertEquals("rangelength: [5,"+Integer.MAX_VALUE+"]", rule.toRuleString());
	}
	

}
