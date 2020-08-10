package cn.itcast.repository;
import cn.itcast.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {
    List<Article> findByTitle(String condition);
    Page<Article> findByTitle(String condition, Pageable pageable);
    Page<Article> findByTitleOrContent(String title, String content,Pageable pageable);
}
