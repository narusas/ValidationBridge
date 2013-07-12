package net.narusas.jstl.validate.rules;

import javax.validation.constraints.Max;

import net.narusas.jstl.validate.ConvertRule;

public class MaxRule extends ConvertRule {
	private long maxLength;
	private String ruleName;

	public MaxRule(Max max, Class<?> type) {
		super(max.message());
		maxLength = max.value();
		if (type.isPrimitive()  || type.isAssignableFrom(Number.class)){
			ruleName = "min";
		}
		else {
			ruleName = "minlength";
		}
	}

	public String toRuleString() {
		return ruleName+": " + maxLength;
	}

	public String toMessageString() {
		return ruleName+": '" + getMessageFromSource(message) + "'";
	}
}