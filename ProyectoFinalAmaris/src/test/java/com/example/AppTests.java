package com.example;

import com.example.outbounds.model.entities.BrandEntity;
import com.example.outbounds.model.entities.PriceEntity;
import com.example.outbounds.model.entities.ProductEntity;
import com.example.outbounds.model.repositories.BrandEntityRepository;
import com.example.outbounds.model.repositories.PriceEntityRepository;
import com.example.outbounds.model.repositories.ProductEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class AppTests {
//
//    @Autowired PriceEntityRepository priceEntityRepository;
//    @Autowired ProductEntityRepository productEntityRepository;
//
//    @Autowired BrandEntityRepository brandEntityRepository;
//
//    @Test public void test() {
//    String currency = "EUR";
//    LocalDateTime productDatedate = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
//    LocalDateTime date1 = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
//    LocalDateTime date2 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
//    LocalDateTime date3 = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
//    LocalDateTime date4 = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
//    LocalDateTime date5 = LocalDateTime.of(2020, 6, 15, 0, 0, 0);
//    LocalDateTime date6 = LocalDateTime.of(2020, 6, 15, 11, 0, 0);
//    LocalDateTime date7 = LocalDateTime.of(2020, 6, 15, 16, 0, 0);
//    LocalDateTime date8 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
//    ProductEntity product = new ProductEntity("35455", productDatedate, productDatedate, "itemExample", 1L, productDatedate, null);
//    productEntityRepository.save(product); // BrandEntity brand = new BrandEntity("1","Zara", null); BrandEntity brandEntity = new
//    BrandEntity("1", "Zara", null); brandEntityRepository.save(brandEntity);
//
//    PriceEntity price1 = new PriceEntity("1", date1, date2, 1, 0, 35.50, currency, brandEntity, product); PriceEntity price2 = new
//    PriceEntity("2", date3, date4, 2, 1, 25.45, currency, brandEntity, product); PriceEntity price3 = new PriceEntity("3", date5, date6, 3,
//    1, 30.50, currency, brandEntity, product); PriceEntity price4 = new PriceEntity("4", date7, date8, 4, 1, 38.95, currency, brandEntity,
//    product); priceEntityRepository.save(price1); priceEntityRepository.save(price2); priceEntityRepository.save(price3);
//    priceEntityRepository.save(price4); }
//
//    @Test public void test2() {
//        LocalDateTime date1 = LocalDateTime.of(2020, 6, 14, 16, 0, 0); List<PriceEntity> prices = null; prices =
//    priceEntityRepository. findAllByProductIdAndBrandIdAndEnddateBeforeAndStartdateAfter( "35455" , "1" , date1 , date1 );
//
//
//    prices.size();
//    }
//
//    @Test public void test3() {
//        LocalDateTime date1 = LocalDateTime.of(2020, 6, 14, 16, 0, 0); List<PriceEntity> prices = null; prices =
//    priceEntityRepository. findAllByProductIdAndBrandId( "35455" , "1" );
//
//
//    prices.size();
//    }
//
//
}
