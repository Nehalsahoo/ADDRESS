package com.capgemini.go.addressms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.go.addressms.dto.AddressDTO;
import com.capgemini.go.addressms.exceptions.CrudException;
import com.capgemini.go.addressms.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressRepository addressRepository;
	
	private String dataAccessException = "distributed transaction exception!";
	private String transientDataAccessException = "database timeout! exception!";

	@Override
	public List<AddressDTO> viewAllAddresss() {
		return (List<AddressDTO>)addressRepository.findAll();
	}

	@Override
	public boolean addAddress(AddressDTO address) {
		try {
		addressRepository.save(address);
		} catch (RecoverableDataAccessException  e) {
			
			
			throw new CrudException(dataAccessException);
		
		} catch (TransientDataAccessException e) {
			
			throw new CrudException(transientDataAccessException);
			
		}
		return true;
	}

	@Override
	public boolean updateAddress(AddressDTO address) {
		Optional<AddressDTO> find=addressRepository.findById(address.getAddressId());
		if(find.isPresent()) {
			addressRepository.save(address);
			return true;
		}
		return false;
	}

	
	/*
	 * name - deleteaddress from the address-ms
	 * description - it will delete available address from the management system
	 */
	
	@Override
	public boolean deleteAddress(String addressId) {
		try {
		addressRepository.deleteById(addressId);
} catch (RecoverableDataAccessException  e) {
			
			throw new CrudException(dataAccessException);
			
		}catch (TransientDataAccessException e) {
			
			throw new CrudException(transientDataAccessException);
			
		}
		return true;
	}




	}
