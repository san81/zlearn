
package com.san.rh;

import java.util.List;

class Customer{
    String name;
    String lastName;
    List<Address> address;
}

class Address{
    String street1;
    String street2;
    String state;
}

enum MatchCriteria { IN,LIKE,EQUAL }

class Criteria {
    MatchCriteria matchCriteria;
    String filedName;
    String valToMatch;
}

class SearchCriteria {
    List<Criteria> customerCriteria;
    List<Criteria> addressCriteria;
    int maxResultSize;
}

public interface SearchCustomerService {

    //Json request object to be deserialized to the SearchCriteria instance 
    public List<Customer>  searchCustomers(SearchCriteria sc);
    
}
