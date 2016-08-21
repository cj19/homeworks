package com.company.rolanddarvas.resources.rest;

import com.company.rolanddarvas.entity.GuestBook;
import com.company.rolanddarvas.model.dto.GuestBookDTO;
import com.company.rolanddarvas.model.dto.GuestBookListDTO;
import com.company.rolanddarvas.model.dto.UpdateGuestBookDTO;
import com.company.rolanddarvas.service.GuestBookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by darvasr on 2016.08.21..
 */
@Path("guestbook")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GuestBookResource {

    private GuestBookService guestBookService;

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") Long id) {
        GuestBook guestBook = guestBookService.getGuestBookById(id);
        return Response.ok(guestBook).build();
    }

    @POST
    @Path("visitor/{visitorId}")
    public Response create(@PathParam("visitorId") Long visitorId, GuestBookDTO guestBookDTO) {
        GuestBook guestBook = guestBookService.createGuestBook(visitorId, guestBookDTO);
        return Response.ok(guestBook).build();
    }

    @PUT
    @Path("{id}")
    public Response updateBook(@PathParam("id") Long id, UpdateGuestBookDTO guestBookDTO) {
        GuestBook guestBook = guestBookService.updateGuestBook(id, guestBookDTO);
        return Response.ok(guestBook).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        GuestBook guestBook = guestBookService.removeGuestBook(id);
        return Response.ok(guestBook).build();
    }

    @GET
    @Path("park/{parkId}")
    public Response getBooksByParkId(@PathParam("parkId") Long parkId) {
        GuestBookListDTO guestBooks = guestBookService.getGuestBooksByParkId(parkId);
        return Response.ok(guestBooks).build();
    }

    @GET
    @Path("visitors/{visitorId}")
    public Response getBooksByVisitorId(@PathParam("visitorId") Long visitorId) {
        GuestBookListDTO guestBooks = guestBookService.getGuestBooksByVisitorId(visitorId);
        return Response.ok(guestBooks).build();
    }

    @GET
    @Path("{visitorId}/{parkId}")
    public Response getBooksByVisitorAndParkId(@PathParam("visitorId") Long visitorId, @PathParam("parkId") Long parkId) {
        GuestBookListDTO guestBooks = guestBookService.getGuestBookByVisitorAndParkId(visitorId, parkId);
        return Response.ok(guestBooks).build();
    }

    @GET
    public Response getAllBooks() {
        GuestBookListDTO guestBooks = guestBookService.getAllGuestBooks();
        return Response.ok(guestBooks).build();
    }

    @Inject
    public void setGuestBookService(GuestBookService guestBookService) {
        this.guestBookService = guestBookService;
    }
}
