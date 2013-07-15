package net.narusas.jstl.validate.rules;

import java.lang.reflect.Field;

import javax.validation.constraints.Size;

import lombok.Getter;
import net.narusas.jstl.validate.ConvertRule;

@Getter
public class SizeRule extends ConvertRule {
	private long min;
	private long max;
	private String ruleName;

	public SizeRule(Size annotation, Field field) {
		super(annotation.message());
		min = annotation.min();
		max = annotation.max();
		if (String.class.isAssignableFrom(field.getType())) {
			ruleName = "rangelength";
		} else {
			ruleName = null;
		}
	}

	public String toRuleString() {
		if (ruleName == null) {
			return "";
		}

		return ruleName + ": [" + min + "," + max + "]";
	}

	public String toMessageString() {
		if (ruleName == null) {
			return "";
		}
		return ruleName + ": '"
				+ getMessageFromSource(message, new Entry[] { new Entry("min", min), new Entry("max", max) }) + "'";
	}
}