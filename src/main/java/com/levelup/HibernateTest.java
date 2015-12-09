package com.levelup;

import com.levelup.dao.Factory;
import com.levelup.model.Role;
import com.levelup.model.User;

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
//        User user3 = new User();

        user1.setLogin("tor");
        user1.setPass("123");
        user1.setRole(Role.ADMIN);

        user2.setLogin("lot");
        user2.setPass("321");
        user2.setRole(Role.CUSTOMER);

        Factory.getInstance().getUserDao().saveUser(user1);
        Factory.getInstance().getUserDao().saveUser(user2);

        List<User> users = Factory.getInstance().getUserDao().getAllUsers();
        System.out.println("====All users===");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Login: " + users.get(i).getLogin() + "\n" + "Pass: " + users.get(i).getPass() + "role: "
                    + "\n" + users.get(i).getRole());
        }


    }

}
