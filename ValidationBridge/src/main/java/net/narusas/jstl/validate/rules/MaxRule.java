package net.narusas.jstl.validate.rules;

import java.lang.reflect.Field;

import javax.validation.constraints.Max;

import lombok.Getter;
import net.narusas.jstl.validate.ConvertRule;

@Getter
public class MaxRule extends ConvertRule {
	private long maxLength;
	private String ruleName;

	public MaxRule(Max max, Field field) {
		super(max.message());
		maxLength = max.value();
		ruleName = "max";
	}

	public String toRuleString() {
		return ruleName+": " + maxLength;
	}

	public String toMessageString() {
		return ruleName+": '" + getMessageFromSource(message,new Entry[]{new Entry("value", maxLength)}) + "'";
	}
}