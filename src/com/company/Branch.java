package com.company;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String name){
        this.branchName = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName(){
        return branchName;
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    private Customer findCustomer(String customerName){
        for(int i = 0; i < this.customers.size(); i++){
            Customer checkedCustomer = customers.get(i);
            if(checkedCustomer.getCustomerName().equals(customerName)){
                return checkedCustomer;
            }
        }
        return null;
    }

    public boolean newCustomer(String name, double initialAmount){
        if(findCustomer(name) == null){
            this.customers.add(new Customer(name, initialAmount));
            return true;
        }
        return false;
    }

    public boolean existingCustomer(String name, double amount){
        Customer existingCustomer = findCustomer(name);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

}
