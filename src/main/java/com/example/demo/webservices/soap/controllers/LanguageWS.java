package com.example.demo.webservices.soap.controllers;


import com.example.demo.repository.entities.Language;
import com.example.demo.servicies.LanguageService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.LanguageDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.LanguageDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class LanguageWS {
    private LanguageService languageService;
    public LanguageWS(){
        this.languageService = new LanguageService();
    }
    public Language post(LanguageDTOReq languageDTOReq) throws SoapException {
        Language language = languageService.post(languageDTOReq);

        return language;
    }
    public List<LanguageDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var languageDTOResps = languageService.get(queryPage);

        return languageDTOResps;
    }
    public List<LanguageDTOResp> getAll() {
        var languageDTOResps = languageService.getAll();

        return languageDTOResps;
    }
    public long getCount() {
        var count = languageService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        languageService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(LanguageDTOResp dtoResp) {
        languageService.delete(dtoResp);

        return true;
    }
    public boolean put(LanguageDTOResp dtoResp) {
        languageService.put(dtoResp);

        return true;
    }
}
