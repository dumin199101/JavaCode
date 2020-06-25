package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        //redis缓存优化
        Jedis jedis = JedisUtil.getJedis();
        Set<Tuple> category = jedis.zrangeWithScores("category", 0, -1);
        List<Category> lists = null;
        if(category==null||category.size()==0){
            //从数据库读取
            lists = categoryDao.findAll();
            //添加数据到Redis
            for (Category list : lists) {
                jedis.zadd("category",list.getCid(),list.getCname());
            }
        }else{
            //从Redis读取
            //此处list初始化，不然会报空指针异常
            lists = new ArrayList<Category>();
            for (Tuple tuple : category) {
                Category cg = new Category();
                cg.setCid((int) tuple.getScore());
                cg.setCname(tuple.getElement());
                lists.add(cg);
            }
        }
        return lists;
    }
}
