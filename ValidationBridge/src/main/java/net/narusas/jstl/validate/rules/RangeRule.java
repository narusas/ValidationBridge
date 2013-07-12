package net.narusas.jstl.validate.rules;

import net.narusas.jstl.validate.*;

import org.hibernate.validator.constraints.Range;

public class RangeRule extends ConvertRule {
	private long min;
	private long max;

	public RangeRule(Range range, Class<?> type) {
		super(range.message());
		min = range.min();
		max = range.max();
	}

	public String toRuleString() {
		return "range: [" + min + "," + max + "]";
	}

	public String toMessageString() {
		return "range: '" + getMessageFromSource(message, new Entry[] { new Entry("min", min), new Entry("max", max) })
				+ "'";
	}
}