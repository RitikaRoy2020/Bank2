package com.Areteans.Bank2;

import com.Areteans.Bank2.models.Customer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping(path = "test")
public class TestController {
    CustomerService customerService=new CustomerService();
    @GetMapping(path = "/data")
    public String getDummyData(@RequestParam(value = "name", required = false)String name,
                               @RequestParam(value = "age", required = false)Integer age){
        //return "Hello World";
        return name!= null && age!= null? name.toUpperCase()+": "+ age : "Empty Input";
    }
    @GetMapping(path = "data/{age}")
    public String getfromPV(@PathVariable("age") Integer age){
        return String.valueOf(age);
    }
    @PostMapping(path = "data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDummyData(@RequestBody Map<String,String> input) {
        String name = input.get("name");
        Integer age=Integer.parseInt(input.get("age"));
        return name!= null && age!=null ? name.toUpperCase() + " : " + age : "Empty Input";
    }
    @PutMapping(path = "data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDummyData1(@RequestBody Map<String,String> input) {
        String name = input.get("name");
        Integer age=Integer.parseInt(input.get("age"));
        return name!= null && age!=null ? name.toUpperCase() + " : " + age : "Empty Input";
    }

    @PostMapping(path = "interest", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bank calcInterest(@RequestBody Bank bank) {
        int pAmt= bank.getPrincipalAmt();
        bank.calcInterest(pAmt);
        return bank;
    }

@PostMapping(path = "insertCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
public Customer insertCustomer(@RequestBody Customer customer){
    System.out.println("in postendpoint reading requestBody");
    Customer op=customerService.xyz(customer);
    return op;
}
}