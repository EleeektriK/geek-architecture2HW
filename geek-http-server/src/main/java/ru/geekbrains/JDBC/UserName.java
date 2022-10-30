package ru.geekbrains.JDBC;

public class UserName {
    private int id;
    private String name;
    private String post;

    public UserName(int id, String name, String post) {
        this.id = id;
        this.name = name;
        this.post = post;

    }

    public UserName(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString(){
        return  id + " " + name + " " + post;
    }

}
