package net.narusas.jstl.validate.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldAnnotaion<T extends Annotation > {
	Field field;
	T annotation;

	public FieldAnnotaion(Field f, T a) {
		this.field = f;
		this.annotation = a;
	}
}