package net.narusas.jstl.validate.rules;

import javax.validation.constraints.Min;

import lombok.Getter;
import net.narusas.jstl.validate.ConvertRule;
@Getter
public class MinRule extends ConvertRule { 
	private long minLength;
	private String ruleName;

	public MinRule(Min min, Class<?> type) {
		super(min.message());
		minLength = min.value();
		if (type.isPrimitive()  || Number.class.isAssignableFrom(type)){
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