package com.alikmndlu.addressservice.service.impl;

import com.alikmndlu.addressservice.model.Address;
import com.alikmndlu.addressservice.repository.AddressRepository;
import com.alikmndlu.addressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Optional<Address> findAddressById(Long addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public Address createAddress(Address user) {
        //todo check user exists
        return addressRepository.save(user);
    }

    @Override
    public void deleteAddress(Long addressId) {
        if (addressRepository.existsById(addressId))
            addressRepository.deleteById(addressId);
    }

    @Override
    public Address updateAddress(Long addressId, Map<String, ?> updates) {
        //todo update address impl
        return null;
    }

    @Override
    public Address[] findAddressesByUserId(Long userId) {
        List<Address> addressesList = addressRepository.findAllByUserId(userId);
        return addressesList.toArray(new Address[0]);
    }
}
