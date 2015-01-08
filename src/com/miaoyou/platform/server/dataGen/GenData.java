/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miaoyou.platform.server.dataGen;

import java.io.File;
import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 *
 * @author 305027939
 */
public class GenData extends PluginAdapter {

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {

        addStringSetterGetting(topLevelClass, introspectedTable, "groupby");
        // add field, getter, setter for limit clause
        addIntegerSetterGetting(topLevelClass, introspectedTable, "limitStart");
        addIntegerSetterGetting(topLevelClass, introspectedTable, "limitEnd");

        addConditionSql(topLevelClass);

        return super.modelExampleClassGenerated(topLevelClass,
                introspectedTable);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement root = document.getRootElement();

        XmlElement groupByElement = new XmlElement("cache");
        root.addElement(0,groupByElement);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        topLevelClass.addImportedType("com.fasterxml.jackson.annotation.JsonIgnoreProperties");
        topLevelClass.addAnnotation("@JsonIgnoreProperties(ignoreUnknown = true)");
        topLevelClass.addImportedType("java.io.Serializable");
        topLevelClass.addSuperInterface(new FullyQualifiedJavaType("java.io.Serializable"));

        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
        // XmlElement isParameterPresenteElemen = (XmlElement) element
        // .getElements().get(element.getElements().size() - 1);

        List<Element> allElements = element.getElements();
        int index = -1;
        for (int i = 0; i < allElements.size(); i++) {

            Element elementch = allElements.get(i);
            if (elementch instanceof XmlElement) {
                XmlElement child = (XmlElement) elementch;
                List<Attribute> attrs = child.getAttributes();
                for (Attribute att : attrs) {
                    if (att.getName().equals("test") && att.getValue().trim().equals("orderByClause != null")) {
                        index = i;
                    }
                }
            }
        }

        /*add group*/
        XmlElement groupByElement = new XmlElement("if"); //$NON-NLS-1$  
        groupByElement.addAttribute(new Attribute(
                "test", "groupby != null")); //$NON-NLS-1$ //$NON-NLS-2$  
        //	      isNotNullElement.addAttribute(new Attribute("compareValue", "0")); //$NON-NLS-1$ //$NON-NLS-2$  
        groupByElement.addElement(new TextElement(
                "group by ${groupby}"));
        // isParameterPresenteElemen.addElement(isNotNullElement);
        if (index != -1) {
            element.addElement(index, groupByElement);
        }

        /*add pagination for mysql*/
        XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$  
        isNotNullElement.addAttribute(new Attribute(
                "test", "limitStart != null and limitStart>=0")); //$NON-NLS-1$ //$NON-NLS-2$  
        //	      isNotNullElement.addAttribute(new Attribute("compareValue", "0")); //$NON-NLS-1$ //$NON-NLS-2$  
        isNotNullElement.addElement(new TextElement(
                "limit #{limitStart} , #{limitEnd}"));
        // isParameterPresenteElemen.addElement(isNotNullElement);
        element.addElement(isNotNullElement);

        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,
                introspectedTable);
    }

    private void addConditionSql(TopLevelClass topLevelClass) {
        InnerClass criteria = null;
        // first, find the Criteria inner class
        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
            if ("Criteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$
                criteria = innerClass;
                break;
            }
        }

        if (criteria != null) {
            String value = "addConditionSql";
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setName("addConditionSql");
            method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
            method.addParameter(new Parameter(PrimitiveTypeWrapper.getStringInstance(), value)); //$NON-NLS-1$
            method.addBodyLine("addCriterion(" + value + ");");
            method.addBodyLine("return this;"); //$NON-NLS-1$
            criteria.addMethod(method);
        }

    }

    private void addIntegerSetterGetting(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable, String name) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        // field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setType(PrimitiveTypeWrapper.getIntegerInstance());
        field.setName(name);
        // field.setInitializationString("-1");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(PrimitiveTypeWrapper
                .getIntegerInstance(), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(PrimitiveTypeWrapper.getIntegerInstance());
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    private void addStringSetterGetting(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable, String name) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        // field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setType(PrimitiveTypeWrapper.getStringInstance());
        field.setName(name);
        // field.setInitializationString("-1");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(PrimitiveTypeWrapper
                .getStringInstance(), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(PrimitiveTypeWrapper.getStringInstance());
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    /**
     * This plugin is always valid - no properties are required
     */
    public boolean validate(List<String> warnings) {
        return true;
    }

    public static void main(String[] args) {
    	String path = System.getProperty("user.dir")+"/src/com/miaoyou/platform/server/mapper";
    	File files = new File(path);
    	System.out.println("::::::::::mapper path:"+path);
//    	if(files.exists()){
//    		File[] fileChilds = files.listFiles();
//    		for(File f:fileChilds){
//    			System.out.println("::::::::::try to delete file:"+f.getName());
//        		f.delete();
//    		}
//    		
//    	}
//    	
    	
        String config = GenData.class.getResource("databaseGen.xml").getFile();
        String[] arg = {"-configfile", config, "-overwrite"};

        ShellRunner.main(arg);
    }
}
