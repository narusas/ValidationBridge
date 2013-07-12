package net.narusas.jstl.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;

import net.narusas.jstl.validate.rules.DigitsRule;
import net.narusas.jstl.validate.rules.LengthRule;
import net.narusas.jstl.validate.rules.MaxRule;
import net.narusas.jstl.validate.rules.MinRule;
import net.narusas.jstl.validate.rules.NotNullRule;
import net.narusas.jstl.validate.rules.RangeRule;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.MessageSource;

@Slf4j
public class RulesInspector {

	public RulesInspector() {
	}

	public List<FieldNode> collectRules(List<FieldNode> fieldNodes) {
		List<FieldNode> candidates = new ArrayList<FieldNode>();
		for (FieldNode fieldNode : fieldNodes) {
			log.debug("Check field Node:{}", fieldNode);
			for (Annotation annotation : fieldNode.getAnnotations()) {
				ConvertRule rule = findMatchRule(fieldNode.getField(), annotation);
				if (rule != null) {
					fieldNode.addRule(rule);
				}
			}
			if (fieldNode.hasRules()) {
				candidates.add(fieldNode);
			}
		}
		return candidates;
	}

	ConvertRule findMatchRule(Field field, Annotation annotation) {
		if (annotation instanceof NotNull) {
			log.debug("Field({}) have NotNull rule", field);
			return new NotNullRule((NotNull) annotation,field.getType());
		} else if (annotation instanceof Min) {
			log.debug("Field({}) have Min rule", field);
			return new MinRule((Min) annotation, field.getType());
		} else if (annotation instanceof Max) {
			log.debug("Field({}) have Max rule", field);
			return new MaxRule((Max) annotation, field.getType());
		} else if (annotation instanceof Range) {
			log.debug("Field({}) have Range rule", field);
			return new RangeRule((Range) annotation, field.getType());
		} else if (annotation instanceof Length) {
			log.debug("Field({}) have Length rule", field);
			return new LengthRule((Length) annotation, field.getType());
		}
		else if (annotation instanceof Digits) {
			log.debug("Field({}) have Digits rule", field);
			return new DigitsRule((Digits) annotation, field.getType());
		}
		return null;
	}

	public List<FieldNode> collectMessage(List<FieldNode> fieldNodes, MessageSource messageSource) {
		List<FieldNode> list = collectRules(fieldNodes);
		for (FieldNode node : list) {
			node.setMessageFormatter(true, messageSource);
		}
		return list;
	}
}
