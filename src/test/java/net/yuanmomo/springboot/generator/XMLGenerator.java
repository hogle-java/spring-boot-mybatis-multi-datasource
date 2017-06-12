package net.yuanmomo.springboot.generator;



import com.github.yuanmomo.mybatis.mbg.table.MySqlTableXmlPrinter;

import java.util.List;

public class XMLGenerator {
	public static void main(String[] args) throws Exception {
		MySqlTableXmlPrinter printer = new MySqlTableXmlPrinter("root","root");
		List<String> outputList = printer.print("demo","todo");
		for(String str : outputList){
			System.out.println(str);
		}
	}
}
