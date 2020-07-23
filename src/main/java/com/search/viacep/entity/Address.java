package com.search.viacep.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String cep;

    private String logradouro;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

    private String number;

    private String ibge;

    private String gia;

    public Address(String cep,
                   String logradouro,
                   String complement,
                   String neighborhood,
                   String city,
                   String state,
                   String number,
                   String ibge,
                   String gia) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.number = number;
        this.ibge = ibge;
        this.gia = gia;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complement='" + complement + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", number='" + number + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                '}';
    }
}