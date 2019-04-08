package com.udem.proyecto.mascotaapp;

public interface GenericRepository<Result> {

    void onRequestSuccess(Result result);
    void onRequestFailure(String error);
}
