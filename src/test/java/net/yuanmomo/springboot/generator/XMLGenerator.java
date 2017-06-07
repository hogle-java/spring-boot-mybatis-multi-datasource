package net.yuanmomo.springboot.generator;


import net.yuanmomo.springboot.mbg.plugin.TableXMLGenerator;

import java.util.List;

public class XMLGenerator {
	public static void main(String[] args) throws Exception {
		List<String> output = new TableXMLGenerator().generator("src/main/resources/application.properties");
		for(String str : output){
			System.out.println(str);
		}
	}
}
