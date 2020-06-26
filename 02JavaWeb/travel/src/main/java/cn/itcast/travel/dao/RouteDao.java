package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    int findCount(int cid,String rname);
    List<Route> findbyPage(int cid, int start, int pageSize, String rname);
}
