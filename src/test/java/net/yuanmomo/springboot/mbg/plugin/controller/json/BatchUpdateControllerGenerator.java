package net.yuanmomo.springboot.mbg.plugin.controller.json;

import net.yuanmomo.springboot.util.AjaxResponseBean;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;

import java.util.ArrayList;
import java.util.List;

public class BatchUpdateControllerGenerator {
	public static List<Method> generator(FullyQualifiedJavaType innerClassType, String beanName,
                                         String businessFieldName){
		List<Method> methodList = new ArrayList<Method>();
		
		String innerClassFieldName = StringUtils.uncapitalize(innerClassType.getShortName());
		
		Method method = new Method();
        method.addAnnotation("@RequestMapping(value = \"batchUpdateSave" + beanName + ".do\")");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType(AjaxResponseBean.class.getName()));
        method.setName("batchUpdateSave" + beanName);
        Parameter param1 = new Parameter(innerClassType, innerClassFieldName);
        param1.addAnnotation("@ModelAttribute ");
        method.addParameter(param1); 
        // 方法body
        method.addBodyLine("try {");
        method.addBodyLine("if(" + innerClassFieldName + " != null && CollectionUtils.isNotEmpty(" + innerClassFieldName + ".get"+ beanName + "List())){");
        method.addBodyLine("int updateCount = this." + businessFieldName + ".update(" + innerClassFieldName + ".get"+ beanName + "List());");
        method.addBodyLine("if(updateCount >0 ){");
        method.addBodyLine("return AjaxResponseBean.Const.SUCCESS_RESPONSE_BEAN;");
        method.addBodyLine("}");
        method.addBodyLine("}");
        method.addBodyLine("return AjaxResponseBean.Const.ERROR_RESPONSE_BEAN;");
        method.addBodyLine("} catch (Exception e) {");
        method.addBodyLine("logger.error(\"批量更新异常\" + e.getMessage());");
        method.addBodyLine("return AjaxResponseBean.getErrorResponseBean(\"批量更新异常\" + e.getMessage());");
        method.addBodyLine("}");
		methodList.add(method);
		
	    return methodList;
	}	
}