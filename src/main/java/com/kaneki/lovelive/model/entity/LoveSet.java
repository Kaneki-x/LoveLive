package com.kaneki.lovelive.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.util.List;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/4/29
 * @email yueqian@mogujie.com
 */
@Entity
@Table(name = "tb_love_set", catalog = "")
public class LoveSet {
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Index(name = "ls_id")
    private int ls_id;

    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    private long create_time;

    @Index(name = "status_id")
    private long status_id;

    @Transient
    private List<LovePic> lovePics;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLs_id() {
        return ls_id;
    }

    public void setLs_id(int ls_id) {
        this.ls_id = ls_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(long status_id) {
        this.status_id = status_id;
    }

    public List<LovePic> getLovePics() {
        return lovePics;
    }

    public void setLovePics(List<LovePic> lovePics) {
        this.lovePics = lovePics;
    }
}
