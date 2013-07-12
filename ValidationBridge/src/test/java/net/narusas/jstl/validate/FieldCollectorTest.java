package net.narusas.jstl.validate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class FieldCollectorTest {

	@Test
	public void test() {
		FieldCollector c = new FieldCollector();
		List<FieldNode> nodes = c.collect(Rule01.class);
		assertNotNull(nodes);
		assertEquals(1, nodes.size());
	}

	@Test
	public void hasFieldContstraint() throws SecurityException, NoSuchFieldException {
		FieldNode fieldNode = new FieldNode(Rule01.class.getDeclaredField("name"));
		
		assertTrue(fieldNode.isConstraintedField());
	}

	@Test
	public void  hasChild() throws SecurityException, NoSuchFieldException {
		FieldNode fieldNode = new FieldNode(Rule11.class.getDeclaredField("authority"));
		assertTrue(fieldNode.hasChild());
	}
	
	@Test
	public void test2() {
		FieldCollector c = new FieldCollector();
		List<FieldNode> nodes = c.collect(Rule11.class);
		assertNotNull(nodes);
		assertEquals(4, nodes.size());
		assertEquals("[authority.created, authority.name, licensedTime, no]", nodes.toString());
	}
	
	@Test
	public void test3() {
		FieldCollector c = new FieldCollector();
		List<FieldNode> nodes = c.collect(Rule10.class);
		assertNotNull(nodes);
		assertEquals(6, nodes.size());
		assertEquals("[age, license.authority.created, license.authority.name, license.licensedTime, license.no, name]", nodes.toString());
	}

}
