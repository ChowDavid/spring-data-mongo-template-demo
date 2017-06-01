package com.david.springData.mongo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;

import com.david.springData.mongo.model.Book;
import com.david.springData.mongo.util.BookUtil;

public class MongoTemplateApplication {
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");) {
			MongoOperations template = context.getBean(MongoTemplate.class);
			
			Book book = BookUtil.create();
			book.setTitle("Learn MongoDB");
			template.dropCollection("book");
			//simple insert, default in book collection
			template.insert(book);
			//simple insert in different collection
			template.insert(book,"library");
			//find all from mongodb
			template.findAll(Book.class).forEach(b->System.out.println(b));
			//insert many books in book collection
			template.insert(BookUtil.create(20),Book.class);
			
			template.findAll(Book.class).forEach(b->System.out.println(b));
			
			//query the book and modify the content
			Book book1=template.find(new BasicQuery("{title:'Learn MongoDB'}"), Book.class).get(0);
			book1.setPageCount(1000);
			//save update or insert depend on ID
			template.save(book1);
			

			
			
			
		}
	}
}
