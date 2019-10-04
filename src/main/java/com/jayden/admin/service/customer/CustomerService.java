package com.jayden.admin.service.customer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayden.admin.model.Customer;
import com.jayden.admin.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerService {

    private List<Customer> data = new ArrayList<>();

    public CustomerService() {
        loadData();
    }

    private void loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.readValue(FileUtil.getFileFromResources("data/customer.json"), new TypeReference<List<Customer>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> fetch() {
        return data;
    }
}
