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

}
