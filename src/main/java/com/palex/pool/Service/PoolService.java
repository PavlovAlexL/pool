package com.palex.pool.Service;

import com.palex.pool.Model.PoolEntity;
import com.palex.pool.View.pool.PoolCreateFilterView;
import com.palex.pool.View.pool.PoolGetFilterView;
import com.palex.pool.View.pool.PoolUpdateFilterView;

import java.util.List;

public interface PoolService {

    List<PoolEntity> getPool(PoolGetFilterView view);

    void createPool(PoolCreateFilterView view);

    void updatePool(PoolUpdateFilterView view);

    void deletePool(Long id);
}
