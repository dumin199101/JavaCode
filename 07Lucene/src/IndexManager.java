import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class IndexManager {
    private IndexWriter indexWriter;
    @Before
    public void init() throws IOException {
        Directory directory = FSDirectory.open(new File("").toPath());
        indexWriter = new IndexWriter(directory,new IndexWriterConfig(new IKAnalyzer()));
    }
    @Test
    public void addDocument() throws IOException {
        Document document = new Document();
        document.add(new TextField("name","中华人民共和国", Field.Store.YES));
        document.add(new LongPoint("size",100000L));
        document.add(new StoredField("size",100000L));
        document.add(new TextField("content","中华人民共和国中央人民政府成立了", Field.Store.YES));
        document.add(new StoredField("path","c://index"));
        indexWriter.addDocument(document);
        System.out.println("创建索引成功");
    }

    @Test
    public void delAllDocument() throws IOException {
        indexWriter.deleteAll();
    }

    @Test
    public void delDocument() throws IOException {
        indexWriter.deleteDocuments(new Term("name", "spring"));
    }

    @Test
    public void updateDocument() throws IOException {
        Document document = new Document();
        document.add(new TextField("name","mybatis is the best ORM framework", Field.Store.YES));
        document.add(new TextField("content","mybatis is the best ORM framework", Field.Store.YES));
        indexWriter.updateDocument(new Term("name","apache"),document);
    }

    @After
    public void destroy() throws IOException{
        indexWriter.close();
    }
}
