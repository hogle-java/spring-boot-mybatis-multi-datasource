package net.yuanmomo.springboot.generator;


import com.github.yuanmomo.mybatis.mbg.MyBatisGeneratorTool;

public class GeneratorMain {
	public static void main(String args[]) {
		MyBatisGeneratorTool.generate("src/test/resources/generatorConfig.xml");
	}
}
