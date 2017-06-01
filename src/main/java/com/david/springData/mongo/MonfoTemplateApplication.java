package com.david.springData.mongo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.david.springData.mongo.model.Book;
import com.david.springData.mongo.util.BookUtil;

public class MonfoTemplateApplication {
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");) {
			MongoOperations template = context.getBean(MongoTemplate.class);
			
			Book book = BookUtil.create();
			template.dropCollection("book");
			template.insert(book);
			
			System.out.println(book);
			
			
		}
	}
}
