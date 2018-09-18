package cn.boz.nettystd.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDbJdbc {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		var mc=new MongoClient("localhost", 27017);
		ListDatabasesIterable<Document> dbs = mc.listDatabases();
		MongoCursor<Document> mc2 = dbs.iterator();
		while(mc2.hasNext()) {
			Document doc = mc2.next();
			doc.forEach((k,v)->{
				System.out.print(k+":"+v+"\t");
			});
			System.out.println();
		}
		
		System.out.println();
		MongoDatabase db = mc.getDatabase("blueboz");
		var cols= db.listCollections();
		MongoCursor<Document> docs = cols.iterator();
		//blue这个库
		while(docs.hasNext()) {
			Document doc = docs.next();
			//得到的这个文档是这个collection的描述信息
			doc.forEach((k,v)->{
				System.out.print(k+":"+v+"\t");
			});
			System.out.println();
			System.out.println();
		}
		
		FindIterable<Document> fis  = db.getCollection("blueboz").find();
	}

}
