package com.company;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public Branch findBranch(String branchName){
        for(int i = 0; i < this.branches.size(); i++){
            Branch thisBranch = branches.get(i);
            if(thisBranch.getBranchName().equals(branchName)){
                return thisBranch;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch thisBranch = findBranch(branchName);
        if(thisBranch != null){
            return thisBranch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double initialAmount){
        Branch thisBranch = findBranch(branchName);
        if(thisBranch != null){
            return thisBranch.existingCustomer(customerName,initialAmount);
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch thisBranch = findBranch(branchName);
        if(thisBranch != null){
            System.out.println("Customer details for branch " + thisBranch.getBranchName() + "\n");

            ArrayList<Customer> branchCustomers = thisBranch.getCustomers();
            for(int i = 0; i < branchCustomers.size(); i++){
                Customer thisCustomer = branchCustomers.get(i);
                System.out.println(i+1 + ") " + thisCustomer.getCustomerName());

                if(showTransactions){
                    System.out.println(" - Transactions - ");
                    ArrayList<Double> transactions = thisCustomer.getTransactions();
                    for(int j = 0; j < transactions.size(); j++){
                        System.out.println(j+1 + " : " + transactions.get(j));
                        if(j == transactions.size()-1){
                            System.out.println();
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }




}
