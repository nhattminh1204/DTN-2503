package com.data.day7_thymeleaf.controller;

import com.data.day7_thymeleaf.entity.Product;
import com.data.day7_thymeleaf.repository.ProductRepository;
import com.data.day7_thymeleaf.service.ProductService;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;

//@RestController: restful API
//@Controller: Spring MVC
@Controller
@RequestMapping("product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;
    ProductRepository productRepo;
    JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @GetMapping("list")
    public String getAll(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "ProductList";
    }

    @GetMapping("add")
    public String add() {
        return "ProductAdd";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Product product) {
//        System.out.println(product);
//        return "ProductList";
        productRepo.save(product);
        return "redirect:/product/list";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        productRepo.deleteById(id);
        return "redirect:/product/list";
    }

    @GetMapping("/send-email")
    public String sendEmail(Model model) {
        try {
            List<Product> products = productService.getAll();
            model.addAttribute("products", products);

            // Render template thành HTML String
            Context context = new Context();
            context.setVariable("products", products);
            String htmlContent = templateEngine.process("ProductList", context); // tên file HTML (ko cần .html)

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("nhattminh1204@gmail.com");
            helper.setTo("nhattminh1204@gmail.com");
            helper.setSubject("Danh sách sản phẩm mới nhất");
            helper.setText(htmlContent, true);

            mailSender.send(message);
            System.out.println("Gửi email HTML thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/product/list";
    }

}
