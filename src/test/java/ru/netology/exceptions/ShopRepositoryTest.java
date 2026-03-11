package ru.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void removeExistingProduct1() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "ноутбук", 80_000);
        Product product2 = new Product(2, "мотоцикл", 1_000_000);
        Product product3 = new Product(3, "стул", 7000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeExistingProduct2() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "ноутбук", 80_000);
        Product product2 = new Product(2, "мотоцикл", 1_000_000);
        Product product3 = new Product(3, "стул", 7000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "ноутбук", 80_000);
        Product product2 = new Product(2, "мотоцикл", 1_000_000);
        Product product3 = new Product(3, "стул", 7000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(23456));
    }
}