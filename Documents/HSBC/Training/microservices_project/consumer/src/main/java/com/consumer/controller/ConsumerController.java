package com.consumer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity; 
import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpMethod; 
import org.springframework.http.MediaType; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.client.RestTemplate; 

import com.consumer.entity.InstagramUser;
@RestController
public class ConsumerController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/create")
	public String create() {
		List<ServiceInstance> instances=discoveryClient.getInstances("producer");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/userCreate";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response1=null; 
		try{
			HttpHeaders headers = new HttpHeaders(); 
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			InstagramUser Iu = new InstagramUser();
			Iu.setName("onoda");
			Iu.setPwd("oikawa");
			Iu.setEmailid("hime@gmail.com");
			Iu.setAddress("Chiba");
			
			HttpEntity<InstagramUser> h1 = new HttpEntity<InstagramUser>(Iu,headers);
			response1=restTemplate.exchange(baseUrl,HttpMethod.POST, h1,String.class);
			return response1.getBody();
		}
		catch (Exception ex) { 
			System.out.println(ex); 
			return "Could Not Create Profile.";
		} 
		//return response1.getBody();
		//System.out.println(response1.getBody()); 
	}
	
	@GetMapping("/view")
	public String view() {
		
		List<ServiceInstance> instances=discoveryClient.getInstances("producer");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/userView";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response1=null; 
		try{
			HttpHeaders headers = new HttpHeaders(); 
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			InstagramUser Iu = new InstagramUser();
			Iu.setName("onoda");
			Iu.setPwd("oikawa");

			
			HttpEntity<InstagramUser> h1 = new HttpEntity<>(Iu,headers);
			response1=restTemplate.exchange(baseUrl,HttpMethod.GET, h1,String.class);
			return response1.getBody();
		}
		catch (Exception ex) { 
			System.out.println(ex); 
			return "Can't View profile.";
		} 
		//return response1.getBody();
		//System.out.println(response1.getBody()); 
	} 
	
	@GetMapping("/viewAll")
	public String viewAll() {
		List<ServiceInstance> instances=discoveryClient.getInstances("producer");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/userViewAll";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response1=null; 
		try{
			HttpHeaders headers = new HttpHeaders(); 
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity<HttpHeaders> h1 = new HttpEntity<>(headers);
			response1=restTemplate.exchange(baseUrl,HttpMethod.GET, h1,String.class);
			return response1.getBody();
		}
		catch (Exception ex) { 
			System.out.println(ex); 
			return "Can't view all profiles.";
		} 
		//return response1.getBody();
		//System.out.println(response1.getBody()); 
	} 
	
	@GetMapping("/search")
	public String search() {
		List<ServiceInstance> instances=discoveryClient.getInstances("producer");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/userSearch";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response1=null; 
		try{
			HttpHeaders headers = new HttpHeaders(); 
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			InstagramUser Iu = new InstagramUser();
			Iu.setName("Ashutosh");
			
			HttpEntity<InstagramUser> h1 = new HttpEntity<InstagramUser>(Iu,headers);
			response1=restTemplate.exchange(baseUrl,HttpMethod.GET, h1,String.class);
			return response1.getBody();
		}
		catch (Exception ex) { 
			System.out.println(ex); 
			return "Coldn't Search profile.";
		} 
		//return response1.getBody();
		//System.out.println(response1.getBody()); 
	} 
	
	@PutMapping("/update")
	public String update() {
		List<ServiceInstance> instances=discoveryClient.getInstances("producer");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/userUpdate";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response1=null; 
		try{
			HttpHeaders headers = new HttpHeaders(); 
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			InstagramUser Iu = new InstagramUser();
			Iu.setName("Mohan");
			Iu.setPwd("1234");
			InstagramUser up_I = new InstagramUser();
			Iu.setName("Sumit");
			Iu.setPwd("su");
			Iu.setEmailid("did@gmail.com");
			Iu.setAddress("hshsh");
			
			HttpEntity<InstagramUser> h1 = new HttpEntity<>(up_I,headers);
			response1=restTemplate.exchange(baseUrl,HttpMethod.PUT, h1,String.class);
			return response1.getBody();
		}
		catch (Exception ex) { 
			System.out.println(ex); 
			return "Could not update profile!";
		} 
		//return response1.getBody();
		//System.out.println(response1.getBody()); 
	}
	
	@DeleteMapping("/delete")
	public String delete() {
		List<ServiceInstance> instances=discoveryClient.getInstances("producer");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/userDelete";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response1=null; 
		try{
			HttpHeaders headers = new HttpHeaders(); 
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			InstagramUser Iu = new InstagramUser();
			Iu.setName("Ashutosh");
			Iu.setPwd("ashu");
			
			HttpEntity<InstagramUser> h1 = new HttpEntity<>(Iu,headers);
			response1=restTemplate.exchange(baseUrl,HttpMethod.DELETE, h1,String.class);
			return response1.getBody();
		}
		catch (Exception ex) { 
			System.out.println(ex); 
			return "Could not delete profile!";
		} 
		//return response1.getBody();
		//System.out.println(response1.getBody()); 
	}
	
	
}

