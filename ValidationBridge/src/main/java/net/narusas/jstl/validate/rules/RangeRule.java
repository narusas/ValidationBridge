package net.narusas.jstl.validate.rules;

import lombok.Getter;
import net.narusas.jstl.validate.ConvertRule;

import org.hibernate.validator.constraints.Range;

@Getter
public class RangeRule extends ConvertRule {
	private long min;
	private long max;
	private String ruleName;

	public RangeRule(Range range, Class<?> type) {
		super(range.message());
		min = range.min();
		max = range.max();
		ruleName = "range";
	}

	public String toRuleString() {
		return ruleName+": [" + min + "," + max + "]";
	}

	public String toMessageString() {
		return ruleName+": '" + getMessageFromSource(message, new Entry[] { new Entry("min", min), new Entry("max", max) })
				+ "'";
	}
}