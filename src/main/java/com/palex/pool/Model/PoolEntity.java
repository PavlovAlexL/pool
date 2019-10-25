package com.palex.pool.Model;

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

    @Column(name = "is_Active", nullable = false)
    public Boolean isActive;
    @Column(name = "pool_name", nullable = false)
    private String name;
    @Column(name = "begin_date", nullable = false)
    private Date begin;
    @Column(name = "end_date", nullable = false)
    private Date end;

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<QuestionEntity> questionEntityList;


}
