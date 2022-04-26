package com.example;

import com.example.commons.dtos.PriceDTO;
import com.example.inbounds.rest.PricesRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TestEjercicio {

    @Autowired
    private PricesRestController pricesRestController;

    @Test
    void filter1() {
        String idProduct="35455";
        String idBrand="1";
        LocalDateTime datefilter = LocalDateTime.of(2020,6,14,14,00,00);

        List<PriceDTO> response = pricesRestController.findAllByProductIdAndBrandIdAndDateAplication(idProduct,idBrand,datefilter);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size()>0);
        Assertions.assertEquals(1,response.size());

    }

    @Test
    void filter2() {
        String idProduct="35455";
        String idBrand="1";
        LocalDateTime datefilter = LocalDateTime.of(2020,6,14,16,00,00);

        List<PriceDTO> response = pricesRestController.findAllByProductIdAndBrandIdAndDateAplication(idProduct,idBrand,datefilter);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size()>0);
        Assertions.assertEquals(2,response.size());
    }

    @Test
    void filter3() {
        String idProduct="35455";
        String idBrand="1";
        LocalDateTime datefilter = LocalDateTime.of(2020,6,14,21,00,00);

        List<PriceDTO> response = pricesRestController.findAllByProductIdAndBrandIdAndDateAplication(idProduct,idBrand,datefilter);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size()>0);
        Assertions.assertEquals(1,response.size());
    }

    @Test
    void filter4() {
        String idProduct="35455";
        String idBrand="1";
        LocalDateTime datefilter = LocalDateTime.of(2020,6,15,10,00,00);

        List<PriceDTO> response = pricesRestController.findAllByProductIdAndBrandIdAndDateAplication(idProduct,idBrand,datefilter);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size()>0);
        Assertions.assertEquals(2,response.size());
    }

    @Test
    void filter5() {
        String idProduct="35455";
        String idBrand="1";
        LocalDateTime datefilter = LocalDateTime.of(2020,6,16,21,00,00);

        List<PriceDTO> response = pricesRestController.findAllByProductIdAndBrandIdAndDateAplication(idProduct,idBrand,datefilter);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size()>0);
        Assertions.assertEquals(2,response.size());
    }
}
