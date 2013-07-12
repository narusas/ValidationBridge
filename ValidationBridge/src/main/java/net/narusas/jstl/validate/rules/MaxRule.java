package net.narusas.jstl.validate.rules;

import javax.validation.constraints.Max;

import lombok.Getter;
import net.narusas.jstl.validate.ConvertRule;

@Getter
public class MaxRule extends ConvertRule {
	private long maxLength;
	private String ruleName;

	public MaxRule(Max max, Class<?> type) {
		super(max.message());
		maxLength = max.value();
		if (type.isPrimitive()  || Number.class.isAssignableFrom(type)){
			ruleName = "max";
		}
		else {
			ruleName = "maxlength";
		}
	}

	public String toRuleString() {
		return ruleName+": " + maxLength;
	}

	public String toMessageString() {
		return ruleName+": '" + getMessageFromSource(message) + "'";
	}
}