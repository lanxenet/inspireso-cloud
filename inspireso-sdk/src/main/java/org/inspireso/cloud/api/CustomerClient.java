/*
 * Copyright (c) 2016, Inspireso and/or its affiliates. All rights reserved.
 */

package org.inspireso.cloud.api;

import org.inspireso.cloud.api.domain.Customer;
import org.inspireso.remoting.client.RemotingClient;

import com.google.common.base.Optional;


/**
 * Created by lanxe on 2016/3/9.
 */
public class CustomerClient extends RemotingClient {


    public CustomerClient() {
        super("http://192.168.8.104:8761", "SIMPLE.SERVICE");
    }

    public Optional<Customer> get() {
        return this.execute(Customer.class, httpGet(), "customer");
    }

    public Optional<Customer> create(Customer customer) {
        return this.execute(Customer.class, httpPost(customer), "customer");
    }


    public Optional<Customer> update(Customer customer) {
        return this.execute(Customer.class, httpPut(customer), "customer");
    }

    public Optional<Customer> delete() {
        return this.execute(Customer.class, httpDelete(), "customer");
    }
}
