package com.kaneki.lovelive.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;

import javax.persistence.*;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/4/29
 * @email yueqian@mogujie.com
 */
@Entity
@Table(name = "tb_love_sister", catalog = "")
public class LoveSister {
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Index(name = "screen_name")
    private String screen_name;

    @Column(name = "profile_image_url")
    private String profile_image_url;

    @Column(name = "followers_count")
    private int followers_count;

    @Column(name = "uid")
    private long uid;

    @Index(name = "since_set_id")
    private long since_set_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getSince_set_id() {
        return since_set_id;
    }

    public void setSince_set_id(long since_set_id) {
        this.since_set_id = since_set_id;
    }
}
