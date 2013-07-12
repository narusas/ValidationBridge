package net.narusas.jstl.validate;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rule04 implements Serializable {
	private static final long serialVersionUID = 1822712139230881537L;

	@NotNull
	@Min(2)
	String name;
	
	@NotNull
	@Max(6)
	String nick;
}
