package com.alikmndlu.addressservice.service;

import com.alikmndlu.addressservice.model.Address;

import java.util.Map;
import java.util.Optional;

public interface AddressService {

    Optional<Address> findAddressById(Long addressId);

    Address createAddress(Address address);

    void deleteAddress(Long addressId);

    Address updateAddress(Long addressId, Map<String, ?> updates);

    Address[] findAddressesByUserId(Long userId);
}
