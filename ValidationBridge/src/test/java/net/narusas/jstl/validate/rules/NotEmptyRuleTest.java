package net.narusas.jstl.validate.rules;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

public class NotEmptyRuleTest extends RuleTestBase {
	public static class RuleClass1 {
		@NotEmpty
		String stringValue;

		@NotEmpty
		List<String> collectionValue;
	}

	@Test
	public void stringType() {
		FieldAnnotaion<NotEmpty> entry = getFieldAnnotation(RuleClass1.class, "stringValue", NotEmpty.class);
		NotEmptyRule rule = new NotEmptyRule(entry.getAnnotation(), entry.getField());
		assertEquals("required: true", rule.toRuleString());
	}

	@Test
	public void collectionType() {
		FieldAnnotaion<NotEmpty> entry = getFieldAnnotation(RuleClass1.class, "collectionValue", NotEmpty.class);
		NotEmptyRule rule = new NotEmptyRule(entry.getAnnotation(), entry.getField());
		assertEquals("컬렉션을 자바스크립트에서 검증할 방법이 없음", "", rule.toRuleString());
	}

}
