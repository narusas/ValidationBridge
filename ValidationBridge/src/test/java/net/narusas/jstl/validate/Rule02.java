package net.narusas.jstl.validate;

import java.io.Serializable;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rule02 implements Serializable {
	private static final long serialVersionUID = 1822712139230881537L;

	@Min(2)
	String name;
}
