import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * Lucene:全文检索
 *
 */
public class LuceneDemo {
    @Test
    public void createIndextest() throws Exception{
        //1.指定索引存储位置
        Directory directory = FSDirectory.open(new File("D:\\lucene\\index").toPath());
        //2.创建IndexWriter对象
        IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(new IKAnalyzer()));
        //3.遍历文件
        File file = new File("F:\\迅雷下载\\87.lucene\\lucene\\02.参考资料\\searchsource");
        File[] files = file.listFiles();
        for (File f : files) {
            String name = f.getName();
            String path = f.getPath();
            String content = FileUtils.readFileToString(f,"utf-8");
            long fsize = FileUtils.sizeOf(f);
            //4.创建Field对象
            Field filename = new TextField("name", name, Field.Store.YES);
            Field filepath = new TextField("path", path, Field.Store.YES);
            Field filecontent = new TextField("content", content, Field.Store.YES);
            Field filesize = new TextField("size", fsize+"", Field.Store.YES);
            //5.创建Document对象
            Document document = new Document();
            document.add(filename);
            document.add(filepath);
            document.add(filecontent);
            document.add(filesize);
            //6.创建索引,写入索引库
            indexWriter.addDocument(document);
        }

        //7.关闭IndexWriter
        indexWriter.close();

        System.out.println("索引创建成功");


    }

    @Test
    public void QueryIndextest() throws Exception{
        //1.指定索引位置
        Directory directory = FSDirectory.open(new File("D:\\lucene\\index").toPath());
//        第二步：创建一个indexReader对象，需要指定Directory对象。
        IndexReader indexReader = DirectoryReader.open(directory);
//        第三步：创建一个indexsearcher对象，需要指定IndexReader对象
        IndexSearcher searcher = new IndexSearcher(indexReader);
//        第四步：创建一个TermQuery对象，指定查询的域和查询的关键词。
        TermQuery query = new TermQuery(new Term("name", "spring"));
//        第五步：执行查询。
        TopDocs docs = searcher.search(query, 10);
//        第六步：返回查询结果。遍历查询结果并输出。
        System.out.println("总记录数："+docs.totalHits);
        for (ScoreDoc scoreDoc : docs.scoreDocs) {
            //根据docid进行查询
            int id = scoreDoc.doc;
            Document doc = searcher.doc(id);
            System.out.println(id+":"+doc.get("name")+","+doc.get("size"));
        }
//        第七步：关闭IndexReader对象
        indexReader.close();

    }

    @Test
    public void TokenAnalyzertest() throws IOException {
        //1.创建一个标准分析器
        StandardAnalyzer analyzer = new StandardAnalyzer();
        //2.获得tokenStream对象
        TokenStream stream = analyzer.tokenStream("name", "Welcome to the Apache Solr project");
//        TokenStream stream = analyzer.tokenStream("name", "我是中国人");
        //3.获取关键词
        CharTermAttribute charTermAttribute = stream.addAttribute(CharTermAttribute.class);
        //4.调整指针位置
        stream.reset();
        //5.遍历输出关键词
        while (stream.incrementToken()) {
            System.out.println(charTermAttribute);
        }
        //6.关闭stream
        stream.close();
    }

    @Test
    public void TokenIKAnalyzertest() throws IOException {
        //1.创建一个标准分析器
        IKAnalyzer analyzer = new IKAnalyzer();
        //2.获得tokenStream对象
        TokenStream stream = analyzer.tokenStream("name", "我是中国人");
        //3.获取关键词
        CharTermAttribute charTermAttribute = stream.addAttribute(CharTermAttribute.class);
        //4.调整指针位置
        stream.reset();
        //5.遍历输出关键词
        while (stream.incrementToken()) {
            System.out.println(charTermAttribute);
        }
        //6.关闭stream
        stream.close();
    }
}
