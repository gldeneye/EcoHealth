package com.example.EcoHealth.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class CustomerRepository {

    @Autowired
    private DataSource dataSource;

}
