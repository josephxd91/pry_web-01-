package com.bolsadeideas.springboot.app;

import java.io.File;

import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringBootDataJpaApplicationTests {

	// @Test
	public void contextLoads() {

	}
	
	//\\LIM-62BWDC2\blublu 

	public static void main(String[] args) {
		System.out.println("init...");
		File file = new File("\\\\LIM-1VR5QN2\\Revisiones");

		
		if(file!=null) {
				System.out.println("file => " + file.getAbsolutePath() + " - " + file.listFiles().length);
//			for (File fi : file.listFiles()) {
//				System.out.println(fi.getAbsolutePath());
//			}
		}
		
		
		
	}

}
