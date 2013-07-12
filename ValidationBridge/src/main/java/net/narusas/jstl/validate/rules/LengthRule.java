package net.narusas.jstl.validate.rules;

import lombok.Getter;
import net.narusas.jstl.validate.ConvertRule;

import org.hibernate.validator.constraints.Length;

@Getter
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