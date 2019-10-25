package com.palex.pool.DAO;

import com.palex.pool.Model.PoolEntity;
import com.palex.pool.View.pool.PoolGetFilterView;
import com.palex.pool.View.pool.PoolUpdateFilterView;

import java.util.List;

public interface PoolDao {

    List<PoolEntity> getPool(PoolGetFilterView view);

    void createPool(PoolEntity poolEntity);

    void updatePool(PoolUpdateFilterView view);

    void deletePool(Long id);

}
