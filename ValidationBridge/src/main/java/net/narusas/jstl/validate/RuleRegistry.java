package net.narusas.jstl.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.narusas.jstl.validate.rules.DateFormatRule;
import net.narusas.jstl.validate.rules.DigitsRule;
import net.narusas.jstl.validate.rules.EmailRule;
import net.narusas.jstl.validate.rules.LengthRule;
import net.narusas.jstl.validate.rules.MinRule;
import net.narusas.jstl.validate.rules.NotBlankRule;
import net.narusas.jstl.validate.rules.NotEmptyRule;
import net.narusas.jstl.validate.rules.NotNullRule;
import net.narusas.jstl.validate.rules.PatternRule;
import net.narusas.jstl.validate.rules.RangeRule;
import net.narusas.jstl.validate.rules.SizeRule;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class RuleRegistry {
	static Map<Class<? extends Annotation>, Class<? extends ConvertRule>> registry = new HashMap<Class<? extends Annotation>, Class<? extends ConvertRule>>();

	static {
		register(DateTimeFormat.class, DateFormatRule.class);
		register(Digits.class, DigitsRule.class);
		register(Email.class, EmailRule.class);
		register(Length.class, LengthRule.class);
		register(Max.class, EmailRule.class);
		register(Min.class, MinRule.class);
		register(NotBlank.class, NotBlankRule.class);
		register(NotEmpty.class, NotEmptyRule.class);
		register(NotNull.class, NotNullRule.class);
		register(Pattern.class, PatternRule.class);
		register(Range.class, RangeRule.class);
		register(Size.class, SizeRule.class);
	}

	public static void register(Class<? extends Annotation> constraint, Class<? extends ConvertRule> rule) {
		registry.put(constraint, rule);
	}

	public static ConvertRule findMatchRule(Class<?> fieldClass, Annotation annotation) {
		Class<? extends ConvertRule> ruleClass = registry.get(annotation.annotationType());
		if (ruleClass == null) {
			throw new IllegalArgumentException("No match rule " + annotation.annotationType());
		}

		try {
			Constructor<? extends ConvertRule> c = ruleClass.getConstructor(new Class[] { annotation.annotationType(),
					Class.class });

			return c.newInstance(new Object[] { annotation, fieldClass });
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
