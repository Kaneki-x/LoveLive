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
@Table(name = "tb_love_pic", catalog = "")
public class LovePic {
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Index(name = "ls_set_id")
    private int ls_set_id;

    @Column(name = "pic_thumbnail")
    private String pic_thumbnail;

    @Column(name = "pic_middle")
    private String pic_middle;

    @Column(name = "pic_origin")
    private String pic_origin;

    @Column(name = "pic_local_path")
    private String pic_local_path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLs_set_id() {
        return ls_set_id;
    }

    public void setLs_set_id(int ls_set_id) {
        this.ls_set_id = ls_set_id;
    }

    public String getPic_thumbnail() {
        return pic_thumbnail;
    }

    public void setPic_thumbnail(String pic_thumbnail) {
        this.pic_thumbnail = pic_thumbnail;
    }

    public String getPic_middle() {
        return pic_middle;
    }

    public void setPic_middle(String pic_middle) {
        this.pic_middle = pic_middle;
    }

    public String getPic_origin() {
        return pic_origin;
    }

    public void setPic_origin(String pic_origin) {
        this.pic_origin = pic_origin;
    }

    public String getPic_local_path() {
        return pic_local_path;
    }

    public void setPic_local_path(String pic_local_path) {
        this.pic_local_path = pic_local_path;
    }
}
