package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {
    public PageBean<Route> pageQeury(int cid, int pageSize, int currentPage, String rname);
}
