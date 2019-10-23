package com.palex.pool.model;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.Date;

@Entity
@Table(name="pool")
public class PoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "pool_name")
    private String name;

    @Column(name = "begin_date")
    private Date begin;

    @Column(name = "end_date")
    private Date end;

    @Column(name = "is_Active")
    private Boolean isActive;


}
