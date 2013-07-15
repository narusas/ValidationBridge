package net.narusas.jstl.validate;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Rule12 implements Serializable{
	private static final long serialVersionUID = 6054311979032278711L;

	@NotNull
	String name;

	@NotNull
	Date created;
}
