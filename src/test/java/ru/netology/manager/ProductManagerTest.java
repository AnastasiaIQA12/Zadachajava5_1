package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldSearchNameBook() {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Book book1=new Book(1,"Cinderella",103,"SharlPerro");
        Book book2=new Book(2,"Pinocchio",170,"Tolstoi");
        Book book3=new Book(3,"Mermaid",407,"Anderson");
        Book book4=new Book(4,"iPhone 12",354,"NoAuthor");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual=manager.searchBy("Mermaid");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAuthorBook() {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Book book1=new Book(1,"Cinderella",103,"SharlPerro");
        Book book2=new Book(2,"Pinocchio",170,"Tolstoi");
        Book book3=new Book(3,"Mermaid",407,"Anderson");
        Book book4=new Book(4,"iPhone 12",354,"NoAuthor");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual=manager.searchBy("Tolstoi");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoBook() {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Book book1=new Book(1,"Mermaid",103,"NoAuthor");
        Book book2=new Book(2,"Pinocchio",170,"Tolstoi");
        Book book3=new Book(3,"Mermaid",407,"Anderson");
        Book book4=new Book(4,"iPhone 12",354,"NoAuthor");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual=manager.searchBy("Mermaid");
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameSmartphone () {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Smartphone smartphone1=new Smartphone(1,"Honor 8X", 12000, "Cnina");
        Smartphone smartphone2=new Smartphone(2,"iPhone 12", 80000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchGeneratorSmartphone () {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Smartphone smartphone1=new Smartphone(1,"Honor 8X", 12000, "China");
        Smartphone smartphone2=new Smartphone(2,"iPhone 12", 80000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("China");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoSmartphone () {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Smartphone smartphone1=new Smartphone(1,"Honor 8X", 12000, "Cnina");
        Smartphone smartphone2=new Smartphone(2,"iPhone 12", 80000, "USA");
        Smartphone smartphone3=new Smartphone(3,"iPhone 12", 80000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual=manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{smartphone2, smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookAndSmartphone() {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Book book1=new Book(1,"Cinderella",103,"SharlPerro");
        Book book2=new Book(2,"Pinocchio",170,"Tolstoi");
        Book book3=new Book(3,"Mermaid",407,"Anderson");
        Book book4=new Book(4,"iPhone 12",354,"NoAuthor");
        Smartphone smartphone1=new Smartphone(1,"Honor 8X", 12000, "Cnina");
        Smartphone smartphone2=new Smartphone(2,"iPhone 12", 80000, "USA");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{book4, smartphone2};
        assertArrayEquals(expected, actual);
    }
}