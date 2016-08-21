package com.company.rolanddarvas.model.dto;

import com.company.rolanddarvas.entity.GuestBook;

import java.util.List;

/**
 * Created by darvasr on 2016.08.21..
 */
public class GuestBookListDTO {

    private List<GuestBook> guestBooks;

    public GuestBookListDTO(List<GuestBook> guestBooks) {
        this.guestBooks = guestBooks;
    }

    public GuestBookListDTO() {
        //Default constructor
    }

    public List<GuestBook> getGuestBooks() {
        return guestBooks;
    }

    public void setGuestBooks(List<GuestBook> guestBooks) {
        this.guestBooks = guestBooks;
    }
}
