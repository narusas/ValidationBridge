package net.narusas.jstl.validate.rules;

import javax.validation.constraints.Digits;

import net.narusas.jstl.validate.ConvertRule;

public class DigitsRule extends ConvertRule {

	private int integerPart;
	private int fractionPart;
	private String ruleName;

	public DigitsRule(Digits annotation, Class<?> type) {
		super(annotation.message());
		integerPart = annotation.integer();
		fractionPart = annotation.fraction();
		if (fractionPart == 0) {
			ruleName = "digits";
		} else {
			ruleName = "number";
		}
	}

	@Override
	public String toRuleString() {
		if (fractionPart == 0) {
			return ruleName + ": true, regex: /^[-]?\\d{0,"+integerPart+"}$/";
		}
		else {
			return ruleName + ": true, regex: /^[-]?\\d{0,"+integerPart+"}(\\.\\d{0,"+fractionPart+"})?$/";
		}
	}

	@Override
	public String toMessageString() {
		return ruleName + ": '" + getMessageFromSource(message, new Entry[]{new Entry("integer", integerPart), new Entry("fraction", fractionPart)}) + "'";
	}

}
