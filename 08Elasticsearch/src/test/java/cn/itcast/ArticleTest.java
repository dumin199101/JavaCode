package cn.itcast;



import cn.itcast.domain.Article;
import cn.itcast.repository.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ArticleTest {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchTemplate template;

    /**
     * 创建索引跟映射
     * @throws Exception
     */
    @Test
    public void createIndex() throws Exception {
        template.createIndex(Article.class);
    }

    /**
     * 添加文档
     * @throws Exception
     */
    @Test
    public void addDocument() throws Exception {
        Article article = new Article();
        article.setId(4);
        article.setTitle("美媒称TikTok计划起诉美政府，将指控特”");
        article.setContent("被曝想把自己头像加到总统山上 特朗普");
        articleRepository.save(article);
    }

    /**
     * 修改文档：实质先删除再添加
     * @throws Exception
     */
    @Test
    public void updateDocument() throws Exception{
        Article article = new Article();
        article.setId(4);
        article.setTitle("美国希望中国打第一枪？专家：千万不能中了它的计”");
        article.setContent("被曝想把自己头像加到总统山上 特朗普");
        articleRepository.save(article);
    }

    /**
     * 删除文档
     */
    @Test
    public void deleteDocument(){
        Article article = new Article();
        article.setId(2);
        articleRepository.delete(article);
    }

    /**
     * 批量添加
     * @throws Exception
     */
    @Test
    public void batchAddDocument() throws Exception {
        for (int i = 1; i <=20 ; i++) {
            Article article = new Article();
            article.setId(i);
            article.setTitle(i+"人民至上生命至上 共建共享健康中国 理上网来”");
            article.setContent(i+"香港各界强烈谴责美国所谓制裁 支持立法会推迟选举");
            articleRepository.save(article);
        }
    }

    /**
     * 按照ID删除
     * @throws Exception
     */
    @Test
    public void deleteDocumentById() throws Exception {
        articleRepository.deleteById(1);
    }

    /**
     * 查询所有
     * @throws Exception
     */
    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = PageRequest.of(1, 5);
        Page<Article> articles = articleRepository.findAll(pageRequest);
        for (Article article : articles.getContent()) {
            System.out.println(article);
            System.out.println("***************");
        }

    }

    /**
     * 查询单条
     * @throws Exception
     */
    @Test
    public void testFindById() throws Exception {
        Optional<Article> article = articleRepository.findById(10);
        System.out.println(article.get());
    }

    @Test
    public void testFindByTitle() throws Exception {
       /* List<Article> articles = articleRepository.findByTitle("人民");
        for (Article article : articles) {
            System.out.println(article);
        }*/

        Pageable pageable = PageRequest.of(1, 4);
        Page<Article> articles = articleRepository.findByTitle("人民", pageable);
        for (Article article : articles.getContent()) {
            System.out.println(article);
        }

    }

    @Test
    public void testFindByTitleOrContent() throws Exception {
        Pageable pageable = PageRequest.of(1, 4);
        Page<Article> articles = articleRepository.findByTitleOrContent("人民","香港", pageable);
        for (Article article : articles.getContent()) {
            System.out.println(article);
        }
    }

    /**
     * 原生查询
     * @throws Exception
     */
    @Test
    public void testNativeSearchQuery() throws Exception {
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("生命").defaultField("title"))
                .withPageable(PageRequest.of(1, 5))
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
                .withHighlightFields(new HighlightBuilder.Field("title").preTags("<h3>").postTags("</h3>"))
                .build();
//        template.queryForList(query, Article.class).forEach((article)-> System.out.println(article));
        List<Article> articles = template.queryForList(query, Article.class);
        for (Article article : articles) {
            System.out.println(article);
        }


    }
}
