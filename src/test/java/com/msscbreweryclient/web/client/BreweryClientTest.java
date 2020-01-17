package com.msscbreweryclient.web.client;

import com.msscbreweryclient.web.model.BeerDto;
import com.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;


    @Test
    void getBeerByIdTest() {
        BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void savedNewBeerTest() {
        BeerDto beerDto = BeerDto.builder().beerName("New Ale").build();
        URI uri = breweryClient.savedNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());

    }

    @Test
    void updateBeerTest() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeerTest() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerByIdTest() {
        CustomerDto dto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void savedNewCustomerTest() {
        CustomerDto customerDto = CustomerDto.builder()
                .customerName("New Customer").build();
        URI uri = breweryClient.savedNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomerTest() {
        CustomerDto customerDto = CustomerDto.builder().customerName("New Customer").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomerTest() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}