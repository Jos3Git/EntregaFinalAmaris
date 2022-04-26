package org.greyhawk.rest.clients.outbounds.rest.blocking;

import org.greyhawk.core.utils.commons.http.HttpUriBuilder;
import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.greyhawk.rest.clients.outbounds.rest.blocking.factory.BlockingRestClientFactory;
import org.greyhawk.rest.clients.outbounds.rest.blocking.factory.BlockingRestClientFactoryComp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;

class BlockingRestClientTest {

  @RequiredArgsConstructor
  @Data
  protected static class DtoRequest {
    private final String name;
  }

  @RequiredArgsConstructor
  @Data
  protected static class DtoResponse {
    public static final ClassTypeRef<DtoResponse> TYPEREF = new ClassTypeRef<>(DtoResponse.class, new TypeReference<DtoResponse>() {
    });
    private final Long id;
    private final String name;
  }

  // @Test
  void test_usage() {

    // TODO tests

    ObjectMapper mymapperbean = null;

    BlockingRestClientFactory restClientFactory = new BlockingRestClientFactoryComp();

    // TODO ssl
    BlockingRestClient client = restClientFactory.builderFromConfig("myconfig.entry").header("extra", "aaa").build();

    BlockingRestClient client1 = restClientFactory.builder().url("http://localhost:8080/service/").requestMapper(mymapperbean)
        .responseMapper(mymapperbean).header("aa", "222").build();

    // uribuilder
    String uri1 = new HttpUriBuilder("/id/{}/sales/{}/yyy", "123", "445").build();
    String uri2 = new HttpUriBuilder("/abc/").query("q", "1").query("aa", "222").query("needsSSL").build();

    // GET
    final String get1 = client.get("/");
    final String get2 = client.get("/nobody");
    final DtoResponse get3 = client.get(uri1, DtoResponse.TYPEREF);
    final DtoResponse get4 = client.get("/nobody", DtoResponse.TYPEREF);

    // DELETE
    client.delete("/8787");

    // PUT no request
    final String put1 = client.put("/xxx", "mybody");
    final String put2 = client.put("/nobody", "mybody");
    final DtoResponse put3 = client.put("/xxx", "mybody", DtoResponse.TYPEREF);
    final DtoResponse put4 = client.put("/nobody", "mybody", DtoResponse.TYPEREF);

    // PUT request
    DtoRequest myRequesDto = new DtoRequest("aaaa");
    final String put5 = client.put("/xxx", myRequesDto);
    final String put6 = client.put("/nobody", myRequesDto);
    final DtoResponse put7 = client.put("/xxx", myRequesDto, DtoResponse.TYPEREF);
    final DtoResponse put8 = client.put("/nobody", myRequesDto, DtoResponse.TYPEREF);

    // PATCH, POST

    // TODO throws BlockingRestClientException() --> getBlockingRestClientResponse()

    // read headers, body, etc
    BlockingRestClientResponse<String> res = client.custom().execute();
    final HttpStatus status4 = res.getStatus();
    final String resp4 = res.getBody();
    final HttpHeaders headers4 = res.getHeaders();

    // options
    final BlockingRestClientResponse<String> opt1 = client.custom().method(HttpMethod.OPTIONS).uri("/").execute();
    // response type
    final BlockingRestClientResponse<DtoResponse> cust2 = client.custom(DtoResponse.TYPEREF).execute();

    // full customize
    // TODO ssl
    final BlockingRestClientResponse<String> cust1 = client.custom().responseMapper(mymapperbean).requestMapper(mymapperbean)
        .header("aaa", "111").execute();

    // TODO send/receive binary
    // final BlockingRestClientResponse<byte[]> bin1 = client.buildRequest().execute();
    // inputstream ?

    // TODO test, mocks
    // final static BlockingRestClient client = restClientTestFactory.blocking().buildFromConfig("myconfig.entry");
    // when(client.execute()).thernReturn("asasas");

  }

}
