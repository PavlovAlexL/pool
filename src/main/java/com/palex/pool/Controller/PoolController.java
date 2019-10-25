package com.palex.pool.Controller;

import com.palex.pool.Service.PoolServiceImpl;
import com.palex.pool.View.ResponseView;
import com.palex.pool.View.SuccessView;
import com.palex.pool.View.pool.PoolCreateFilterView;
import com.palex.pool.View.pool.PoolGetFilterView;
import com.palex.pool.View.pool.PoolUpdateFilterView;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/pool")
public class PoolController {

    private PoolServiceImpl service;

    public PoolController(PoolServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseView getPool(@RequestBody PoolGetFilterView view) {
        return new ResponseView(service.getPool(view));
    }

    @PostMapping("/create")
    public ResponseView createPool(@RequestBody PoolCreateFilterView view) {
        service.createPool(view);
        return new ResponseView(new SuccessView());
    }

    @PostMapping("/update")
    public ResponseView updatePool(@RequestBody PoolUpdateFilterView view) {
        service.updatePool(view);
        return new ResponseView(new SuccessView());
    }

    @DeleteMapping("/delete/{id:\\d+}")
    public ResponseView deletePool(@PathVariable Long id) {
        service.deletePool(id);
        return new ResponseView(new SuccessView());
    }

}
