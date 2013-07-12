package net.narusas.jstl.validate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author narusas
 * 
 */
public class FieldCollector {

	public List<FieldNode> collect(Class<?> ruleClass) {
		return sort(collect(ruleClass, null));
	}

	List<FieldNode> sort(List<FieldNode> list) {
		Collections.sort(list, new Comparator<FieldNode>() {
			@Override
			public int compare(FieldNode v1, FieldNode v2) {
				return v1.toString().compareTo(v2.toString());
			}
		});
		return list;
	}

	List<FieldNode> collect(Class<?> ruleClass, FieldNode parent) {
		List<FieldNode> collection = new ArrayList<FieldNode>();
		collect(collection, ruleClass, parent);
		return collection;
	}

	void collect(List<FieldNode> collection, Class<?> ruleClass, FieldNode parent) {
		Field[] fields = ruleClass.getDeclaredFields();
		for (Field field : fields) {
			new FieldNode(parent, field).collect(collection, this);
		}
	}
}
