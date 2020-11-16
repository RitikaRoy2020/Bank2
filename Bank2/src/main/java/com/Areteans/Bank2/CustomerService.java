package com.Areteans.Bank2;

import com.Areteans.Bank2.config.PostgresManager;
import com.Areteans.Bank2.models.Customer;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class CustomerService {

public Customer xyz(Customer customer) {
    Connection connection = PostgresManager.getConnection();
    //ResultSet resultSet=null;
    try {
        PreparedStatement ps = connection.prepareStatement("insert into customer values (?,?,?,?)");
        ps.setString(1, customer.getFirstName());
        ps.setInt(2, 0);
        ps.setInt(3, 0);
        ps.setInt(4, 0);
        System.out.println("prepared statement is created" +ps);
        ps.execute();


        //select query to get Data
        ps = connection.prepareStatement("select * from customer where \"name\"=?");
        ps.setString(1, customer.getFirstName());
        System.out.println("prepared select query statement is created, to see if data is inserted" +ps);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            //List<Customer> list=new ArrayList<>();
            //for (Customer each:list) {
                customer = new Customer(resultSet.getString("name"));
            //}
       }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return customer;
}
}





