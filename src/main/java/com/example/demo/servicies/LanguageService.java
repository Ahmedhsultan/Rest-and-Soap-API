package com.example.demo.servicies;

import com.example.demo.repository.entities.Language;
import com.example.demo.repository.repos.LanguageRepo;
import com.example.demo.webservices.rest.DTOs.requests.LanguageDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.LanguageDTOResp;

public class LanguageService extends BaseService<Language, LanguageDTOResp, LanguageRepo, LanguageDTOReq> {
}