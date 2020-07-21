package cn.itcast.domain;

import java.util.List;
import java.util.Map;

public class Account {
    private Integer id;
    private String name;
    private Double money;
    private User user;

    private List<User> lists;
    private Map<String,User> map;

    public List<User> getLists() {
        return lists;
    }

    public void setLists(List<User> lists) {
        this.lists = lists;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", user=" + user +
                ", lists=" + lists +
                ", map=" + map +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

}
