package com.demo.blog.errorhandling;

public class ResourceNotFoundException extends Throwable {
    public ResourceNotFoundException(String s) {
        System.out.println(s);
    }
}
