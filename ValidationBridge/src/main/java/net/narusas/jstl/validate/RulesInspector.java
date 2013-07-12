package net.narusas.jstl.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.MessageSource;

@Slf4j
public class RulesInspector {

	public RulesInspector() {
	}

	public List<FieldNode> collectRules(List<FieldNode> fieldNodes) {
		List<FieldNode> candidates = new ArrayList<FieldNode>();
		for (FieldNode fieldNode : fieldNodes) {
			log.debug("Check field Node:{}", fieldNode.getName());
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

	public ConvertRule findMatchRule(Field field, Annotation annotation) {
		return RuleRegistry.findMatchRule(field.getType(), annotation);
	}

	public List<FieldNode> collectMessage(List<FieldNode> fieldNodes, MessageSource messageSource) {
		List<FieldNode> list = collectRules(fieldNodes);
		for (FieldNode node : list) {
			node.setMessageFormatter(true, messageSource);
		}
		return list;
	}
}
