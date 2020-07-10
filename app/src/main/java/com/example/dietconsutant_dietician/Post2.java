package com.example.dietconsutant_dietician;

public class Post2 {
    String User_name;
    String Msg;
    public Post2()
    { }

    @Override
    public String toString() {
        return "Post2{" +
                "User_name='" + User_name + '\'' +
                ", Msg='" + Msg + '\'' +
                '}';
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
