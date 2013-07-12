package net.narusas.jstl.validate;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class Rule08 implements Serializable {
	private static final long serialVersionUID = 1822712139230881537L;

	@Range(min = 1, max = 99)
	int age;

}
