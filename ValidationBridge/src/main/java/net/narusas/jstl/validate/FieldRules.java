package net.narusas.jstl.validate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

@Getter
@Setter
class FieldRules {
	Field field;
	List<ConvertRule> rules = new ArrayList<ConvertRule>();
	private Field parent;

	public FieldRules(Field field2) {
		this.field = field2;
	}

	public void addRule(ConvertRule rule) {
		rules.add(rule);
	}

	public void setMessageFormatter(boolean b, MessageSource messageSource) {
		for (ConvertRule rule : rules) {
			rule.setMessageFormatter(b);
			rule.setMessageSource(messageSource);
		}
	}

	public boolean hasRules() {
		return rules.size() > 0;
	}

	@Override
	public String toString() {
		return (parent != null ? parent.getName() + "." : "") + field.getName()
				+ ":{" + StringUtils.join(rules, ',') + "}";
	}

	public void setParent(Field parent) {
		this.parent = parent;
	}
}