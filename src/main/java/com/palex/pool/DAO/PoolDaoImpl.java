package com.palex.pool.DAO;

import com.palex.pool.Model.PoolEntity;
import com.palex.pool.View.pool.PoolGetFilterView;
import com.palex.pool.View.pool.PoolUpdateFilterView;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
public class PoolDaoImpl implements PoolDao {

    EntityManager em;

    public PoolDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<PoolEntity> getPool(PoolGetFilterView view) {
        String name = view.name;
        Date begin = view.begin;
        Date end = view.end;
        String isActive = view.isActive;

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PoolEntity> query = cb.createQuery(PoolEntity.class);
        Root<PoolEntity> poolEntityRoot = query.from(PoolEntity.class);
        Predicate predicate = cb.conjunction();
        if (name != null) predicate = cb.and(predicate, cb.equal(poolEntityRoot.get("pool_name"), name));
        if (begin != null) predicate = cb.and(predicate, cb.equal(poolEntityRoot.get("begin_date"), begin));
        if (end != null) predicate = cb.and(predicate, cb.equal(poolEntityRoot.get("end_date"), end));
        if (isActive != null) predicate = cb.and(predicate, cb.equal(poolEntityRoot.get("is_active"), isActive));
        query.where(predicate);
        return em.createQuery(query).getResultList();
    }

    @Override
    public void createPool(PoolEntity poolEntity) {
        System.out.println(poolEntity);
        em.persist(poolEntity);
    }

    @Override
    public void updatePool(PoolUpdateFilterView view) {
        PoolEntity poolEntity = em.find(PoolEntity.class, view.id);
        if (view.name != null) poolEntity.setName(view.name);
        if (view.begin != null) poolEntity.setBegin(view.begin);
        if (view.end != null) poolEntity.setEnd(view.end);
        if (view.isActive != null) poolEntity.setActive(Boolean.parseBoolean(view.isActive));
        em.merge(poolEntity);
    }

    @Override
    public void deletePool(Long id) {
        PoolEntity poolEntity = em.find(PoolEntity.class, id);
        em.remove(poolEntity);
    }
}
