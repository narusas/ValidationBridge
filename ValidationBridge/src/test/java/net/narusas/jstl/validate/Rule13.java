package net.narusas.jstl.validate;

import javax.validation.constraints.Digits;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Rule13 {
	@Digits(integer = 3, fraction = 0)
	Integer age;

	@Digits(integer = 3, fraction = 1)
	Float height;
}
