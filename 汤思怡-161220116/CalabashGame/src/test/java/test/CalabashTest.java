package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import creatures.Calabash;

/**
 * 
 * ��«��ö�ٲ�����
 * 
 * @author TangSiyi
 *
 */
public class CalabashTest {

	@Test
	public void calabashTest() {
		Calabash dawa = new Calabash(0, true);
		assertEquals("����", dawa.getRankName());
		
		Calabash erwa = new Calabash(1, true);
		assertEquals("����", erwa.getRankName());
		
		Calabash qiwa = new Calabash(6, true);
		assertEquals("����", qiwa.getRankName());
	}
}
