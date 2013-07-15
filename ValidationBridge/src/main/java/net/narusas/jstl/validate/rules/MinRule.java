package net.narusas.jstl.validate.rules;

import java.lang.reflect.Field;

import javax.validation.constraints.Min;

import lombok.Getter;
import net.narusas.jstl.validate.ConvertRule;
@Getter
public class MinRule extends ConvertRule { 
	private long minLength;
	private String ruleName;

	public MinRule(Min min, Field field) {
		super(min.message());
		minLength = min.value();
		ruleName = "min";
	}

	public String toRuleString() {
		return ruleName+": " + minLength;
	}

	public String toMessageString() {
		return ruleName+": '" + getMessageFromSource(message, new Entry[]{new Entry("value", minLength)}) + "'";
	}
}