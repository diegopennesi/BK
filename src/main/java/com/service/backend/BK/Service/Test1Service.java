package com.service.backend.BK.Service;

import com.service.backend.BK.Pojo.Test;
import com.service.backend.BK.Repository.Test1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test1Service {
    @Autowired
    Test1Repository repo;
    public List<Test> getAll() {
        return repo.findAll();
    }

    public void insert(Test test) {repo.insert(test);

    }
}
