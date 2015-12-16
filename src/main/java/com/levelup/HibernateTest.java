package com.levelup;

import com.levelup.dao.Factory;
import com.levelup.model.*;

import java.util.Calendar;
import java.util.List;

/**
 * Class {@link com.levelup.HibernateTest}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 09.12.15
 */

public class HibernateTest {
    public static void main(String[] args) throws Exception{
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setLogin("tor");
        user1.setPass("123");
        user1.setEmail("adgfjds@dth.com");
        user1.setRole(Role.ADMIN);

        user2.setLogin("lot");
        user2.setPass("321");
        user2.setEmail("4567s@dth.com");
        user2.setRole(Role.CUSTOMER);

        user3.setLogin("NNN");
        user3.setPass("kgh456");
        user3.setEmail("hhhhhhhs@346.com");
        user3.setRole(Role.CUSTOMER);


        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();

        category1.setTitle_category("TV");
        category2.setTitle_category("Mobile");
        category3.setTitle_category("Computer");


        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        product1.setTitle_prod("lg 670");
        product1.setCategory(category1);
        product1.setPrice(8250.98);
        product2.setTitle_prod("samsung 500");
        product2.setCategory(category2);
        product2.setPrice(684.5);
        product3.setTitle_prod("toshiba s30");
        product3.setCategory(category3);
        product3.setPrice(4800.58);

//        Media media1 = new Media();
//
//        media1.setTitle_media("televisor");
//        media1.setLength(250);
//        media1.setWidth(200);
//        media1.setSize(500);
//        media1.setPath("D:/file1.jpg");
//        media1.setTitle_media("big");
//        media1.setMediaType(MediaType.PICTURE);

        // save Users
//        Factory.getInstance().getUserDao().saveUser(user1);
//        Factory.getInstance().getUserDao().saveUser(user2);
//        Factory.getInstance().getUserDao().saveUser(user3);
        // save Category
//        Factory.getInstance().getCategoryDao().saveCategory(category1);
//        Factory.getInstance().getCategoryDao().saveCategory(category2);
//        Factory.getInstance().getCategoryDao().saveCategory(category3);
        // save Products
//        Factory.getInstance().getProductDao().saveProduct(product1);
//        Factory.getInstance().getProductDao().saveProduct(product2);
//        Factory.getInstance().getProductDao().saveProduct(product3);

    // out by all
        List<User> users = Factory.getInstance().getUserDao().getAllUsers();
        System.out.println("====All users===");
        for (int i = 0; i < users.size(); ++i) {
            System.out.println("Login: " + users.get(i).getLogin() + "\n" + "Pass: " + users.get(i).getPass() + "role: "
                    + "\n" + users.get(i).getRole());
        }
        // out by id
//        String u = Factory.getInstance().getUserDao().findById(1).getLogin();
//        System.out.println(u);

       // del by id
//        for (int i = 0; i < 13; i++) {
//            Factory.getInstance().getUserDao().deleteUser(i);
//        }
        // del by id
//        Factory.getInstance().getUserDao().deleteUser(1);

    }
}
