package com.yashcore.ecommerce.config;

import com.yashcore.ecommerce.model.Category;
import com.yashcore.ecommerce.model.Product;
import com.yashcore.ecommerce.repository.CategoryRepository;
import com.yashcore.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        entityManager.createNativeQuery("ALTER TABLE category AUTO_INCREMENT = 1").executeUpdate();

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        Category accessories = new Category();
        accessories.setName("Accessories");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home, accessories));

        entityManager.createNativeQuery("ALTER TABLE product AUTO_INCREMENT = 1").executeUpdate();

        Product phone = new Product();
        phone.setName("Smartphone");
        phone.setDescription("Latest Model Smartphone with amazing features");
        phone.setImageURL("/images/smartphone.jpg");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High Performance Gaming Laptop");
        laptop.setImageURL("/images/laptop.jpg");
        laptop.setPrice(1299.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Baseball Jacket");
        jacket.setDescription("Fashionable Jacket to go with the Trend");
        jacket.setImageURL("/images/jacket.jpg");
        jacket.setPrice(59.99);
        jacket.setCategory(clothing);

        Product fridge = new Product();
        fridge.setName("Fridge");
        fridge.setDescription("Home Appliance to keep things as cool as the owner of this website");
        fridge.setImageURL("/images/fridge.jpg");
        fridge.setPrice(899.99);
        fridge.setCategory(home);

        Product smartwatch = new Product();
        smartwatch.setName("Smartwatch");
        smartwatch.setDescription("Stylish and feature-packed smartwatch to keep you connected and fit");
        smartwatch.setImageURL("/images/smartwatch.jpg");
        smartwatch.setPrice(129.99);
        smartwatch.setCategory(electronics);

        Product shirt = new Product();
        shirt.setName("Shirt");
        shirt.setDescription("Trendy and comfortable shirt for a perfect casual or formal look");
        shirt.setImageURL("/images/shirt.jpg");
        shirt.setPrice(49.99);
        shirt.setCategory(clothing);

        Product pan = new Product();
        pan.setName("Pan");
        pan.setDescription("Durable and non-stick pan for effortless cooking every day");
        pan.setImageURL("/images/pan.jpg");
        pan.setPrice(39.99);
        pan.setCategory(home);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("Powerful and efficient blender for smooth and hassle-free mixing");
        blender.setImageURL("/images/blender.jpg");
        blender.setPrice(79.99);
        blender.setCategory(home);

        Product bracelet = new Product();
        bracelet.setName("Bracelet");
        bracelet.setDescription("Stylish and elegant bracelet to complement any outfit");
        bracelet.setImageURL("/images/bracelet.jpg");
        bracelet.setPrice(7.99);
        bracelet.setCategory(accessories);

        Product chain = new Product();
        chain.setName("Chain");
        chain.setDescription("Sleek and fashionable chain to add a touch of style and elegance");
        chain.setImageURL("/images/chain.jpg");
        chain.setPrice(5.99);
        chain.setCategory(accessories);

        Product headphones = new Product();
        headphones.setName("Headphones");
        headphones.setDescription("High-quality, immersive sound headphones for an unbeatable audio experience");
        headphones.setImageURL("/images/headphones.jpg");
        headphones.setPrice(89.99);
        headphones.setCategory(electronics);

        Product induction = new Product();
        induction.setName("Induction");
        induction.setDescription("Efficient and fast-heating induction cooktop for convenient and modern cooking");
        induction.setImageURL("/images/induction.jpg");
        induction.setPrice(149.99);
        induction.setCategory(home);

        Product jeans = new Product();
        jeans.setName("Jeans");
        jeans.setDescription("Stylish and comfortable jeans for a perfect blend of fashion and flexibility");
        jeans.setImageURL("/images/jeans.jpg");
        jeans.setPrice(11.99);
        jeans.setCategory(clothing);

        Product knife = new Product();
        knife.setName("Knife");
        knife.setDescription("Sharp and durable knife for precise and effortless cutting");
        knife.setImageURL("/images/knife.jpg");
        knife.setPrice(2.99);
        knife.setCategory(home);

        Product sunglasses = new Product();
        sunglasses.setName("Sunglasses");
        sunglasses.setDescription("Trendy and UV-protected sunglasses for a stylish and safe look");
        sunglasses.setImageURL("/images/sunglasses.jpg");
        sunglasses.setPrice(12.99);
        sunglasses.setCategory(accessories);

        Product tshirt = new Product();
        tshirt.setName("T-shirt");
        tshirt.setDescription("Soft and stylish T-shirt for all-day comfort and a trendy look");
        tshirt.setImageURL("/images/tshirt.jpg");
        tshirt.setPrice(4.99);
        tshirt.setCategory(clothing);

        productRepository.saveAll(Arrays.asList(
                phone, laptop, jacket, fridge, smartwatch, shirt, pan, blender, bracelet, chain,
                headphones, induction, jeans, knife, sunglasses, tshirt
        ));
    }
}
