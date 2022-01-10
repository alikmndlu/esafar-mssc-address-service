package com.alikmndlu.addressservice.controller;

import com.alikmndlu.addressservice.model.Address;
import com.alikmndlu.addressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    private final String apiHost = "http://localhost:9002/api/addresses";

    @GetMapping("/{address-id}")
    public ResponseEntity<Address> findAddress(@PathVariable("address-id") Long addressId){
        Optional<Address> address = addressService.findAddressById(addressId);

        return address.isPresent() ?
            ResponseEntity.ok().body(address.get()) :
            ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        address = addressService.createAddress(address);
        return ResponseEntity.created(URI.create(apiHost + "/" + address.getId())).body(address);
    }

    @PutMapping("/{address-id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("address-id") Long addressId, @RequestBody Map<String, ?> updates){
        return ResponseEntity.accepted().body(addressService.updateAddress(addressId, updates));
    }

    @DeleteMapping("/{address-id}")
    public void deleteAddress(@PathVariable("address-id") Long addressId){
        addressService.deleteAddress(addressId);
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<Address[]> findUserAddresses(@PathVariable("user-id") Long useId){
        return ResponseEntity.ok().body(addressService.findAddressesByUserId(useId));
    }
}
