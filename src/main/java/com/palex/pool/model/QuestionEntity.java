package com.palex.pool.model;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "pool_id")
    private Long poolId;

    @Column(name = "text")
    private String text;

    @Column(name = "order_id")
    private Integer order_id;

}
