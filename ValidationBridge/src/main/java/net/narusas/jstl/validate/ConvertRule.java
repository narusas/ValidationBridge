package net.narusas.jstl.validate;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
@Setter
public abstract class ConvertRule {
	protected MessageSource messageSource;
	protected String message;
	boolean messageFormatter = false;

	public ConvertRule(String message) {
		this.message = message;
	}

	public abstract String toRuleString();

	public abstract String toMessageString();

	@Override
	public String toString() {
		return messageFormatter ? toMessageString() : toRuleString();
	}

	protected String getMessageFromSource(String message) {
		if (message != null && message.startsWith("{")) {
			return messageSource.getMessage(message.substring(1, message.length() - 1), null,
					LocaleContextHolder.getLocale());
		}
		return message;
	}

	protected String getMessageFromSource(String message, Entry[] entries) {
		String templateMessage = getMessageFromSource(message);

		for (Entry entry : entries) {
			Object value = entry.getValue();
			if (value == null) {
				continue;
			}
			templateMessage = StringUtils.replace(templateMessage, "{" + entry.getKey() + "}", entry.getValue()
					.toString());
		}
		return templateMessage;
	}

	@Getter
	@Setter
	public static class Entry {
		String key;
		Object value;

		public Entry(String key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}
	}
}