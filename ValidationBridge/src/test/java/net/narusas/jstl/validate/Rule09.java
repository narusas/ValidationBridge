package net.narusas.jstl.validate;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class Rule09 implements Serializable {
	private static final long serialVersionUID = 1822712139230881537L;
	@Length(min = 2, max = 20)
	@NotNull
	String name;

}
