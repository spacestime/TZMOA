package cn.tzm.oa.cfg;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testGetPageSize() {
		int pageSize= Configuration.getPageSize();
		System.out.println(pageSize);
	}

}
