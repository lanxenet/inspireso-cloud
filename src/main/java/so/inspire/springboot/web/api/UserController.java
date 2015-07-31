/*
 * Copyright (c) 2015, Inspire.so and/or its affiliates. All rights reserved.
 */

package so.inspire.springboot.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import so.inspire.springboot.domain.User;
import so.inspire.springboot.service.UserService;

/**
 * Created by Inspireso Tream
 */
@Controller
@ResponseBody
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e) {
        return e.getMessage();
    }

    // /user/id
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/user/{id}"
    )
    @ResponseStatus(HttpStatus.OK)
    public User get(
            @PathVariable("id") String id) {
        return this.userService.find(id);
    }

    // /user?code=xxx
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/userall"
    )
    @ResponseStatus(HttpStatus.OK)
    public Page<User> findAll(
            @RequestParam(value = "start", required = false, defaultValue = "0") int start,
            @RequestParam(value = "limit", required = false, defaultValue = "2") int limit
    ) {
        return this.userService.findAll(start, limit);
    }

    // /user?code=xxx
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/user"
    )
    @ResponseStatus(HttpStatus.OK)
    public User getByCode(
            @RequestParam("code") String code) {
        return this.userService.findByCode(code);
    }

    // /user?code=xxx
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public User create(
            @RequestBody User user) {
//        User u = this.userService.findByCode(user.getCode());
//        if (u != null) {
//            return u;
//        }
        return this.userService.saveOrUpdate(user);
    }

    // /user?code=xxx
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User update(
            @RequestBody User user) {
        return this.userService.saveOrUpdate(user);
    }


    // /user?code=xxx
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/user/{id}"
    )
    public void delete(@PathVariable("id") String id) {
        this.userService.delete(id);
    }
}
