package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();

    @Override
    public PageBean<Route> pageQeury(int cid, int pageSize, int currentPage, String rname) {

        PageBean<Route> routePageBean = new PageBean<>();
        routePageBean.setCurrentPage(currentPage);
        routePageBean.setPageSize(pageSize);

        //查找数量
        int count = routeDao.findCount(cid,rname);
        routePageBean.setTotalCount(count);

        //查找当前页数据
        int start = (currentPage - 1) * pageSize;
        List<Route> routeList = routeDao.findbyPage(cid, start, pageSize,rname);
        routePageBean.setList(routeList);

        //设置总页码
        int totalPage = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
        routePageBean.setTotalPage(totalPage);

        return routePageBean;
    }
}
