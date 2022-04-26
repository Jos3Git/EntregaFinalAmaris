package com.example.inbounds.consumerprice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

  Report report = new Report(1L, 1, 12D);

  @Test
  void getProductid() {
    Assertions.assertEquals(1L, report.getProductid());
  }

  @Test
  void getPricelistid() {
    Assertions.assertEquals(1, report.getPricelistid());
  }

  @Test
  void getPrice() {
    Assertions.assertEquals(12D, report.getPrice());
  }

  @Test
  void setProductid() {
    report.setProductid(2L);
    Assertions.assertEquals(2L, report.getProductid());
  }

  @Test
  void setPricelistid() {
    report.setPricelistid(2);
    Assertions.assertEquals(2, report.getPricelistid());
  }

  @Test
  void setPrice() {
    report.setPrice(22D);
    Assertions.assertEquals(22D, report.getPrice());
  }

  @Test
  void testEquals() {
    Report report2 = new Report(1L, 1, 12D);
    Report report3 = new Report(1L, 1, 12D);

    Assertions.assertTrue(report2.equals(report3));
  }

  @Test
  void testHashCode() {
    Report report2 = new Report(1L, 1, 12D);
    Report report3 = new Report(1L, 1, 12D);

    Assertions.assertTrue(report2.hashCode() == report3.hashCode());
  }

  @Test
  void testToString() {

    Assertions.assertNotNull(report.toString());
    Assertions.assertTrue(report.toString().length() > 0);
  }
}