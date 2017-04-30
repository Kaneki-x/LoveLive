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

}
