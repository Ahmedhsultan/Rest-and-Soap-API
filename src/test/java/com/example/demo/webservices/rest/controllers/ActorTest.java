package com.example.demo.webservices.rest.controllers;

import com.example.demo.webservices.rest.DTOs.requests.ActorDTOReq;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;

public class ActorTest {
    @Test
    void testCRUD() {
        //Prepare
        ActorDTOReq actorDTOReq = new ActorDTOReq();
        actorDTOReq.setFirstName("hamada");
        actorDTOReq.setLastName("hamada2");

        String postUrl = "http://localhost:8082/demo_war_exploded/api/actor";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(postUrl);
        Response postResponse =  target.request().post(Entity.entity(actorDTOReq, MediaType.APPLICATION_JSON));

        //Assert
        Assert.isTrue(postResponse.getStatus() == 200);

        //Test
        String url = "http://localhost:8082/demo_war_exploded/api/actor?column=firstName&value=hamada";
        Response getResponse = ClientBuilder.newClient()
                            .target(url)
                            .request().get();

        //Assert
        Assert.isTrue(getResponse.getStatus() == 200);

        //Deprepare
        String deleteUrl = "http://localhost:8082/demo_war_exploded/api/actor?column=firstName&value=hamada";
        Response deleteResponse = ClientBuilder.newClient()
                .target(deleteUrl)
                .request().delete();

        //Assert
        Assert.isTrue(deleteResponse.getStatus() == 200);
    }
}
