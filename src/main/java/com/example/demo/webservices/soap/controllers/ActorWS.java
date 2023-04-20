package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Actor;
import com.example.demo.servicies.ActorService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.ActorDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public class ActorWS {
    private ActorService actorService;
    public ActorWS(){
        this.actorService = new ActorService();
    }
    public Actor post(ActorDTOReq actorDTOReq) throws SoapException {
        Actor actor = actorService.post(actorDTOReq);

        return actor;
    }
    public List<ActorDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var actorDTOResp = actorService.get(queryPage);

        return actorDTOResp;
    }
    public List<ActorDTOResp> getAll() {
        var actorDTOResps = actorService.getAll();

        return actorDTOResps;
    }
    public long getCount() {
        var count = actorService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        actorService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(ActorDTOResp dtoResp) {
        actorService.delete(dtoResp);

        return true;
    }
    public boolean put(ActorDTOResp dtoResp) {
        actorService.put(dtoResp);

        return true;
    }
}
