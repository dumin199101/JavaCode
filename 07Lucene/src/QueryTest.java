import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.Query ;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class QueryTest {

    private static DirectoryReader directoryReader;

    @Test
    public void  testTermQuery() throws Exception{
        IndexSearcher indexSearcher = getIndexSearcher();
        TermQuery termQuery = new TermQuery(new Term("name", "apache"));
        searchResult(termQuery,indexSearcher);
        directoryReader.close();

    }

    public static IndexSearcher getIndexSearcher() throws Exception{
        Directory directory = FSDirectory.open(new File("D:\\lucene\\index").toPath());
        directoryReader = DirectoryReader.open(directory);
        //创建IndexSearcher对象
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
        return indexSearcher;
    }

    public static void searchResult(Query query,IndexSearcher indexSearcher) throws IOException {
        TopDocs topDocs = indexSearcher.search(query, 10);

        System.out.println("查询结果匹配数为："+topDocs.totalHits);
        //遍历结果集
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            //获取ID
            int docid = scoreDoc.doc;
            //根据id查询文档
            Document document = indexSearcher.doc(docid);
            String name = document.get("name");
            System.out.println(name);
        }

    }


    @Test
    public void testRangeQuery() throws Exception{
        IndexSearcher indexSearcher = getIndexSearcher();
        Query rangeQuery = LongPoint.newRangeQuery("size", 1, 1000);
        searchResult(rangeQuery,indexSearcher);
        directoryReader.close();
    }

    @Test
    public void testParseQuery() throws Exception{
        IndexSearcher indexSearcher = getIndexSearcher();
        QueryParser queryParser = new QueryParser("name", new IKAnalyzer());
        Query query = queryParser.parse("lucene是一个Java开发的全文检索工具包");
        searchResult(query,indexSearcher);
        directoryReader.close();
    }
}
