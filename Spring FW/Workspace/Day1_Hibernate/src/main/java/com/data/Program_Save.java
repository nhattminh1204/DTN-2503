package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Program_Save {
    public static void main(String[] args) {
        Session session = null;
        try {
            // Tạo ra 1 phiên làm việc
            session = buildSessionFactory().openSession();

            // Cần Transaction cho việc Thêm, Sửa, Xóa
            session.beginTransaction();

            // Tạo Entity rồi Save lại
            Account account = new Account();
            account.setUsername("mthien");
            account.setPassword("mthien");

            session.save(account);

            session.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Hàm gọi đến cấu file cấu hình hibernate.cfg.xml - > dbname, tài khoản root
    private static SessionFactory buildSessionFactory() {
        // Load db info
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Add entity
        configuration.addAnnotatedClass(Account.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}