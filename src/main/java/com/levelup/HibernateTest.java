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

    // save users
//        Factory.getInstance().getUserDao().saveUser(user1);
//        Factory.getInstance().getUserDao().saveUser(user2);
//        Factory.getInstance().getUserDao().saveUser(user3);

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
