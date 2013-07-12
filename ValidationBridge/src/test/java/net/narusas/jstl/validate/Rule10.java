package net.narusas.jstl.validate;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rule10 implements Serializable {
	private static final long serialVersionUID = 1822712139230881537L;

	@NotNull
	String name;
	
	@Min(1)
	int age;
	
	@Valid
	Rule11 license;

	
	String dummy;
}
