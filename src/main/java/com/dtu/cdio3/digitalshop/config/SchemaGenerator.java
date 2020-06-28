//package com.dtu.cdio3.digitalshop.config;
//
//import java.io.File;
//import java.util.EnumSet;
//
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.tool.hbm2ddl.SchemaExport;
//import org.hibernate.tool.schema.TargetType;
//
//public class SchemaGenerator {
//	public static final String SCRIPT_FILE = "exportScript.sql";
//
//	private static SchemaExport getSchemaExport() {
//
//		SchemaExport export = new SchemaExport();
//		// Script file.
//		File outputFile = new File(SCRIPT_FILE);
//		String outputFilePath = outputFile.getAbsolutePath();
//
//		System.out.println("Export file: " + outputFilePath);
//
//		export.setDelimiter(";");
//		export.setOutputFile(outputFilePath);
//
//		// Không ngừng nếu có lỗi
//		export.setHaltOnError(false);
//		//
//		return export;
//	}
//
//	public static void dropDataBase(SchemaExport export, Metadata metadata) {
//
//		// TargetType.DATABASE - Thực thi lệnh vào Databse
//		// TargetType.SCRIPT - Ghi ra file Script.
//		// TargetType.STDOUT - Ghi thông tin Log ra màn hình Console.
//		EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);
//
//		export.drop(targetTypes, metadata);
//	}
//
//	public static void createDataBase(SchemaExport export, Metadata metadata) {
//	  
//	       // TargetType.DATABASE - Thực thi lệnh vào Databse
//	       // TargetType.SCRIPT - Ghi ra file Script.
//	       // TargetType.STDOUT - Ghi thông tin Log ra màn hình Console.
//	       EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT);
//	       
//	       SchemaExport.Action action = SchemaExport.Action.CREATE;
//	       //
//	       export.execute(targetTypes, action, metadata);
//	 
//	       System.out.println("Export OK");
//	}
//	
//
//	   public static void main(String[] args) {
//	       // Sử dụng Oracle.
//	       String configFileName = "hibernate-mysql.cfg.xml";
//	  
//	       // Tạo đối tượng ServiceRegistry từ hibernate-xxx.cfg.xml
//	       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
//	               .configure(configFileName).build();
//	  
//	       // Tạo nguồn siêu dữ liệu (metadata) từ ServiceRegistry
//	       Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//	 
//	       SchemaExport export = getSchemaExport();
//	 
//	       System.out.println("Drop Database...");
//	       // Drop Database
//	       dropDataBase(export, metadata);
//	 
//	       System.out.println("Create Database...");
//	  
//	       // Tạo lại hệ thống bảng
//	       createDataBase(export, metadata);
//	   }
//}
//
