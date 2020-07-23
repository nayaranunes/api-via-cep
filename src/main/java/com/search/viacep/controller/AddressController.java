package com.search.viacep.controller;

import com.search.viacep.entity.Address;
import com.search.viacep.usage.ClientViaCep;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{cep}")
    public ResponseEntity<Address> getViaCep(@PathVariable String cep) {
        Address address = ClientViaCep.getAddressByCep(cep);
        return ResponseEntity.ok(address);
    }
}