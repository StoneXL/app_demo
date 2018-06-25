package com.example.ai.myapplication2.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import javax.annotation.Priority;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Yuan.Y.Q
 * @Date 2017/10/13.
 */
@Entity
public class UserInfo {
    @Id
    private long id;
    @Property(nameInDb = "USER_NAME")
    private String username;
    @Property(nameInDb = "NICK_NAME")
    private String nickname;
    @Generated(hash = 1580153212)
    public UserInfo(long id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

