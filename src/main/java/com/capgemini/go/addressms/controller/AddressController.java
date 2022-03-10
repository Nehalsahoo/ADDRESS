package com.capgemini.go.addressms.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.addressms.dto.AddressDTO;
import com.capgemini.go.addressms.exceptions.NullParameterException;
import com.capgemini.go.addressms.service.AddressService;


//this is a restcontroller
@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class AddressController {

	private static final Logger logger =Logger.getLogger(AddressController.class);
	
	@Autowired
	AddressService addressService;

	@GetMapping("/viewALLAddress")
	List<AddressDTO> viewAllAddress() {
		// repository.findAllAddress().forEach(i -> list.add(i));
		return addressService.viewAllAddresss();
	}

	@PostMapping("/addAddress")
	String addAddress(@RequestBody AddressDTO address) throws Exception {
		
		if(address==null) {
			
			logger.error("Null request, add Address details not provided at /addAddress");
			throw new NullParameterException("Null request, please provide address details!");

		}
		String status = "Address added";
		addressService.addAddress(address);
		return status;
		
//		String status = "Address added";
//
//		if (addressService.addAddress(address)) {
//			return status;
//		}
//		return "fail to add Address";
	}

	@PostMapping("/updateAddress")
	String updateAddress(@RequestBody AddressDTO address) throws Exception {
		
        if(address==null) {
			
			logger.error("Null request, Address details not provided at /updateAddress");
			throw new NullParameterException("Null request, please provide address details!");

		}
              String status = "Address Updated";
               addressService.updateAddress(address);
               return status;
		
//		String status = "Address Updated";
//
//		if (addressService.updateAddress(address)) {
//			return status;
//		}
//		return "Failed to update Address";
	}

	@PostMapping("/deleteAddress")
	String deleteAddress(@RequestParam String addressId) throws Exception {
		
		  if(addressId==null) {
				
				logger.error("Null request, Address details not provided at /deleteAddress");
				throw new NullParameterException("Null request, please provide address details to remove from existing address");

			}
		
		
		  String status = "Address deleted";
		  addressService.deleteAddress(addressId);
		  return status;
		
//		if (addressService.deleteAddress(addressId)) {
//			return "Address Deleted Successfully";
//		}
//		return "error";
	}
}










