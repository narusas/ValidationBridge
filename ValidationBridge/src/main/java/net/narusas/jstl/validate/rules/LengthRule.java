package net.narusas.jstl.validate.rules;

import net.narusas.jstl.validate.*;

import org.hibernate.validator.constraints.Length;

public class LengthRule extends ConvertRule {
	private long min;
	private long max;

	public LengthRule(Length length, Class<?> type) {
		super(length.message());
		min = length.min();
		max = length.max();
	}

	public String toRuleString() {
		return "rangelength: [" + min + "," + max + "]";
	}

	public String toMessageString() {
		return "rangelength: '"
				+ getMessageFromSource(message, new Entry[] { new Entry("min", min), new Entry("max", max) }) + "'";
	}
}