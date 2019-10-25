package com.palex.pool.Service;

import com.palex.pool.DAO.PoolDao;
import com.palex.pool.Model.PoolEntity;
import com.palex.pool.Model.mapper.MapperFacade;
import com.palex.pool.View.pool.PoolCreateFilterView;
import com.palex.pool.View.pool.PoolGetFilterView;
import com.palex.pool.View.pool.PoolUpdateFilterView;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PoolServiceImpl implements PoolService {

    private final MapperFacade facade;
    private final PoolDao dao;


    public PoolServiceImpl(MapperFacade facade, PoolDao dao) {
        this.facade = facade;
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<PoolEntity> getPool(PoolGetFilterView view) {
        return dao.getPool(view);
    }

    @Override
    @Transactional
    public void createPool(PoolCreateFilterView view) {
        dao.createPool(facade.map(view, PoolEntity.class));
    }

    @Override
    @Transactional
    public void updatePool(PoolUpdateFilterView view) {
        dao.updatePool(view);
    }

    @Override
    @Transactional
    public void deletePool(Long id) {
        dao.deletePool(id);
    }
}
