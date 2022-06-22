package classroomSix;

import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        Customer customer = new Customer("Juris");
        customer.setMember(true);
        customer.setMemberType("Gold");
        customer.isMember();
        System.out.println(customer.toString());
    }
}
