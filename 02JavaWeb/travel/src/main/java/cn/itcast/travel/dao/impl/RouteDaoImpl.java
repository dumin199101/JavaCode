package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findCount(int cid,String rname) {
        String sql = "select count(*) from tab_route where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if (cid != 0) {
            sb.append(" AND cid = ?");
            params.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" AND rname like ?");
            params.add("%" + rname + "%");
        }
        sql = sb.toString();
        Integer count = template.queryForObject(sql, Integer.class, params.toArray());
        return count;
    }

    @Override
    public List<Route> findbyPage(int cid, int start, int pageSize, String rname) {
        String sql = "select * from tab_route where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if (cid != 0) {
            sb.append(" AND cid = ?");
            params.add(cid);
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" AND rname like ?");
            params.add("%" + rname + "%");
        }
        sb.append(" limit ?,?");
        params.add(start);
        params.add(pageSize);
        sql = sb.toString();
        List<Route> lists = template.query(sql, new BeanPropertyRowMapper<>(Route.class), params.toArray());
        return lists;
    }
}
