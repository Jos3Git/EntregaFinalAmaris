package com.example.commons.constans;

public interface Constants {

  String URIPRODUCTS = "/products";
  String URIPRICES = "/prices";
  String URIFINDBYFILTER1 = "/by/idProduct/{idProduct}/idBrand/{idBrand}/dateAplication/{dateAplication}";

  String KAFKAURL = "http://localhost:9092";
  String APPID = "proyectoFinalAmaris-kafka-stream-2";
  String TOPIC1 = "proyectoFinalAmaris-topic-second";

  String PRODUCT_FINDALL = "FIND_ALL";
  String PRODUCT_FINDBYID = "FIND_BY_ID";
  String PRODUCT_CREATE = "CREATE";
  String PRODUCT_UPDATE = "UPDATE";
  String PRODUCT_DELETE = "DELETE";
}
