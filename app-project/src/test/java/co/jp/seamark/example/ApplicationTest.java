package co.jp.seamark.example;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.seamark.example.Application;

public class ApplicationTest {

	Application target = new Application();
	
	@Test
	public void test() throws Exception {
		target.run("a","b","c");
	}

}
