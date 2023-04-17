package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.FilmCategoryService;
import com.example.demo.webservices.rest.DTOs.requests.FilmCategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmCategoryDTOResp;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path(("filmcategory"))
public class FilmCategoryController extends BaseController<FilmCategoryDTOResp, FilmCategoryService, FilmCategoryDTOReq>{
    public FilmCategoryController() throws InstantiationException, IllegalAccessException {
    }

    @Override
    public Response get(@QueryParam("column") String columnName,
                        @QueryParam("value") String value,
                        @DefaultValue(value = "0")@QueryParam("pageNumber") Integer pageNumber,
                        @DefaultValue(value = "10")@QueryParam("count") Integer count) {
        FilmCategoryService filmCategoryService = new FilmCategoryService();

        List<FilmCategoryDTOResp> filmCategoryDTOResps = new ArrayList<>();
        if (columnName.toLowerCase().equals("filmid"))
            filmCategoryDTOResps = filmCategoryService.getByFilm(Integer.parseInt(value));
        else if (columnName.toLowerCase().equals("categoryid")) {
            filmCategoryDTOResps = filmCategoryService.getByCategory(Integer.parseInt(value));
        }

        return Response.ok(filmCategoryDTOResps).build();
    }
}
