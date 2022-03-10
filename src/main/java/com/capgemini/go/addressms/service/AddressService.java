package com.capgemini.go.addressms.service;

import java.util.List;

import com.capgemini.go.addressms.dto.AddressDTO;

public interface AddressService {
	
	 /*
     * viewAllAddresss
     * descriptio:shows all address
     */
	List<AddressDTO> viewAllAddresss();
	
	/*
	 * name - addAddress
	 * description - It will add an address to the database
	 */
	
	boolean addAddress(AddressDTO address);
	/*
	 * name - updateaddress
	 * description - it will update the available address
	 */
	
	boolean updateAddress(AddressDTO address);
	
	/*
	 * name - deleteaddress
	 * description - it will delete available address
	 */
	boolean deleteAddress(String addressId);
	
}
