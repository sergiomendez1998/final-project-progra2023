package com.example.finalprojectbackend.lab2you.controllers;


import org.springframework.web.context.annotation.ApplicationScope;




@ApplicationScope
public class UserManagementServiceProcessingController extends CrudServiceProcessingController{
    @Override
    public void validateForRead(){
     throw new UnsupportedOperationException("Not supported yet.");
    }




}
