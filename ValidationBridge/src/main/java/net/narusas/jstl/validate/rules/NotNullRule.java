package net.narusas.jstl.validate.rules;

import javax.validation.constraints.NotNull;

import net.narusas.jstl.validate.ConvertRule;

public class NotNullRule extends ConvertRule {
	public NotNullRule(NotNull notnull, Class<?> type) {
		super(notnull.message());
	}

	public String toRuleString() {
		return "required: true";
	}

	public String toMessageString() {
		return "required: '" + getMessageFromSource(message) + "'";
	}

}