package net.narusas.jstl.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldNode {

	FieldNode parent;
	Field field;
	Annotation[] annotations;
	List<ConvertRule> rules = new ArrayList<ConvertRule>();

	public FieldNode(Field declaredField) {
		this(null, declaredField);
	}

	public FieldNode(FieldNode parent, Field field) {
		this.parent = parent;
		this.field = field;
		this.annotations = field.getDeclaredAnnotations();
	}

	boolean hasConstraint(Annotation[] annotations) {
		for (Annotation annotation : annotations) {
			Class<? extends Annotation> types = annotation.annotationType();
			if (types.getAnnotation(Constraint.class) != null) {
				return true;
			}
		}
		return false;
	}

	public boolean isConstraintedField() {
		return hasConstraint(annotations);
	}

	public boolean hasChild() {
		return field.getAnnotation(Valid.class) != null;
	}

	public void collect(List<FieldNode> collection, FieldCollector fieldCollector) {
		if (isConstraintedField()) {
			collection.add(this);
		}
		if (hasChild()) {
			fieldCollector.collect(collection, field.getType(), this);
		}
	}

	@Override
	public String toString() {
		return "'"+parentName() + field.getName() +"':{"+StringUtils.join(rules,',')+"}";
	}

	String parentName() {
		if (parent == null) {
			return "";
		}
		return parent.parentName() + parent.field.getName() + ".";
	}

	public void addRule(ConvertRule rule) {
		rules.add(rule);
	}

	public boolean hasRules() {
		return rules.isEmpty() == false;
	}

	public void setMessageFormatter(boolean b, MessageSource messageSource) {
		for (ConvertRule rule : rules) {
			rule.setMessageFormatter(b);
			rule.setMessageSource(messageSource);
		}
	}
}
