package main.test.facadeTest;

import java.util.ArrayList;

import main.core.beans.Category;
import main.core.beans.Coupon;
import main.core.beans.Customer;
import main.core.exceptions.FacadeException;
import main.core.facade.ClientFacade;
import main.core.facade.CustomerFacade;

public class CustomerFacadeTest extends FacadeTest{

    private CustomerFacade facade;

    public CustomerFacadeTest(ClientFacade facade) {
        this.facade = (CustomerFacade) facade;
    }

    @Override
    public void runTest() {

        Coupon coupon;

        System.out.println();
        System.out.println("____________________________________________ customerFacadeTest _______________________________________________");
        System.out.println();

        // viewing this customer details
        System.out.println("________________________________________ viewCustomerDetailsTest _______________________________________________");
        viewCustomerDetails();
        System.out.println();
        // ------------------------------------------------------------------------------------------------------

        // viewing all this customer coupons within database coupons table
        System.out.println("________________________________________ getCustomerCouponsTest _______________________________________________");
        viewAllCustomerCouponsTest();
        System.out.println();
        // ------------------------------------------------------------------------------------------------------

        // purchasing coupons for current customer
        System.out.println("________________________________________ purchaceCouponTest _______________________________________________");
        System.out.println("\n1. purchacing first legal coupon:-");
        coupon = new Coupon(1);
        purchaceCouponTest(coupon);
        System.out.println();

        System.out.println("\n2. purchacing the same coupon coupon:-");
        coupon = new Coupon(1);
        purchaceCouponTest(coupon);

        System.out.println("\n3. purchacing second legal coupon:-");
        coupon = new Coupon(2);
        purchaceCouponTest(coupon);

        System.out.println("\n4. purchacing out of stack coupon:-");
        coupon = new Coupon(4);
        purchaceCouponTest(coupon);
        System.out.println();
        // ------------------------------------------------------------------------------------------------------

        // viewing all this customer coupons within database coupons table
        System.out.println("________________________________________ getCustomerCouponsTest _______________________________________________");
        viewAllCustomerCouponsTest();
        System.out.println();
        // ------------------------------------------------------------------------------------------------------

        // viewing all this customer coupons from food category within database coupons
        // table
        System.out.println("________________________________________ getcustomerCouponsTest Category = FOOD _______________________________________________");
        viewAllCustomerCouponsTest(Category.FOOD);
        System.out.println();
        // ------------------------------------------------------------------------------------------------------

        // viewing all this customer coupons up to maxPrice = 160 within database
        // coupons
        // table
        System.out.println("________________________________________ getcustomerCouponsTest MaxPrice = 160  _______________________________________________");
        viewAllCustomerCouponsTest(160);
        System.out.println();
        // ------------------------------------------------------------------------------------------------------

    }

    private void purchaceCouponTest(Coupon coupon) {
        System.out.println("-- purchacing: " + coupon);
        try {
            facade.purchaseCoupon(coupon);
            System.out.println("Coupon purchaced");
        } catch (FacadeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void viewAllCustomerCouponsTest() {
        try {
            ArrayList<Coupon> coupons = facade.getCustomerCoupons();
            System.out.println();
            if (!coupons.isEmpty()) {
                for (Coupon coupon : coupons) {
                    System.out.println("\t" + coupon);
                }
            } else {
                System.out.println("-- Empty");
            }
        } catch (FacadeException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void viewAllCustomerCouponsTest(Category category) {
        try {
            ArrayList<Coupon> coupons = facade.getCustomerCoupons(category);
            System.out.println();
            if (!coupons.isEmpty()) {
                for (Coupon coupon : coupons) {
                    System.out.println("\t" + coupon);
                }
            } else {
                System.out.println("-- Empty");
            }
        } catch (FacadeException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void viewAllCustomerCouponsTest(int maxPrice) {
        try {
            ArrayList<Coupon> coupons = facade.getCustomerCoupons(maxPrice);
            System.out.println();
            if (!coupons.isEmpty()) {
                for (Coupon coupon : coupons) {
                    System.out.println("\t" + coupon);
                }
            } else {
                System.out.println("-- Empty");
            }
        } catch (FacadeException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void viewCustomerDetails() {
        System.out.println("-- Customer details: ");
        try {
            Customer customer = facade.getCustomerDetails();
            System.out.println("Id: " + customer.getId());
            System.out.println("First Name: " + customer.getFirstName());
            System.out.println("Last Name: " + customer.getLastName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Password: " + customer.getPassword());
        } catch (FacadeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
