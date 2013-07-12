package net.narusas.jstl.validate.rules;

import javax.validation.constraints.Min;

import net.narusas.jstl.validate.ConvertRule;

public class MinRule extends ConvertRule {
	private long minLength;
	private String ruleName;

	public MinRule(Min min, Class<?> type) {
		super(min.message());
		minLength = min.value();
		if (type.isPrimitive()  || type.isAssignableFrom(Number.class)){
			ruleName = "min";
		}
		else {
			ruleName = "minlength";
		}
	}

	public String toRuleString() {
		return ruleName+": " + minLength;
	}

	public String toMessageString() {
		return ruleName+": '" + getMessageFromSource(message) + "'";
	}
}