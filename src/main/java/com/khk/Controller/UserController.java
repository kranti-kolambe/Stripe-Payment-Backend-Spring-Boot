package com.khk.Controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.khk.Service.PaymentDetailService;
import com.khk.Service.UserService_I;

import com.khk.entity.Checkout;
import com.khk.entity.CheckoutPayment;
import com.khk.entity.PaymentDetails;
import com.khk.entity.Subscription;
import com.khk.entity.User;
import com.google.gson.Gson;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Invoice;
import com.stripe.model.InvoiceItem;
import com.stripe.model.checkout.Session;
import com.stripe.param.InvoiceCreateParams;
import com.stripe.param.InvoiceItemCreateParams;
import com.stripe.param.checkout.SessionCreateParams;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class UserController {
	@Autowired
	UserService_I service;
	@Autowired
	PaymentDetailService paymentDeatailService;
	//create a Gson object
	private static Gson gson = new Gson();
	private PaymentDetails paymentDetails;
	
//	@GetMapping(path = "/basicauth")
//	/* API for returning the authentication success message. */
//    public AuthenticationBean basicauth() {
//        return new AuthenticationBean("You are authenticated");
//    }
	@PostMapping("/payment")
	/**
	 * Payment with Stripe checkout page
	 * 
	 * @throws StripeException
	 */
	public String paymentWithCheckoutPage(@RequestBody CheckoutPayment payment) throws StripeException {
		// We initilize stripe object with the api key
		System.out.println("Request in /payment");
		init();
		// We create a  stripe session parameters
		SessionCreateParams params = SessionCreateParams.builder()
				// We will use the credit card payment method 
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
				.setCancelUrl(
						payment.getCancelUrl())
				.addLineItem(
						SessionCreateParams.LineItem.builder().setQuantity(payment.getQuantity())
								.setPriceData(
										SessionCreateParams.LineItem.PriceData.builder()
												.setCurrency(payment.getCurrency()).setUnitAmount(payment.getAmount())
												.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
														.builder().setName(payment.getName()).build())
												.build())
								.build())
				.build();
  
		System.out.println("Session Param  "+params.getCustomerEmail());
		Session session = Session.create(params);
		
		Map<String, String> responseData = new HashMap<>();
   
		responseData.put("id", session.getId());
		
		
		return gson.toJson(responseData);
		//return paymentDetails;
	}
	@PostMapping(value="/getPaymentDetail/{customerEmailId}")
	public PaymentDetails getPaymentDetail(@PathVariable String customerEmailId) {
		PaymentDetails paymentDetails=paymentDeatailService.getPaymentDetail(customerEmailId);
		return paymentDetails;
	}
	@PostMapping(value="/setPaymentDetail")
	public String setPaymentDetail(@RequestBody PaymentDetails pd) {
//		paymentDetails=new PaymentDetails();
//		paymentDetails.setPaymentDate(new Date());
//		paymentDetails.setCustomerEmailId(email);
//		paymentDetails.setPaidAmount(999);
//		paymentDetails.setPaymentStatus("Paid");
//		paymentDetails.setProductName("1 Month ");
//		paymentDetails.setQuantity(1);
//		
		System.out.println("Payment details in Controller  "+pd);
		String msg=paymentDeatailService.setPaymentDetail(pd);
		//String msg=paymentDeatailService.setPaymentDetail(email);
		return msg;
		
	}
	
	

	private static void init() {
		System.out.println("init()");
		Stripe.apiKey = "sk_test_51JORaaSGhSG5ETGzUVY5h580K8fkKCUExBrL9ONKBO9IBE6sApYufZPyZFYtWoBGTrzUX98wI0Dz4iFJZWWzvYgL00NYzrn6g8";
	}
	@GetMapping(value="/add")
	public int add() {
		return 20;
	}
	
	@PostMapping(value="/registerUser")
	public String registerUser(@RequestBody User user) {
		System.out.println("In resisterUser Controller...."+user);
		String msg=service.registerUser(user);
		return msg;
			
	}
	@GetMapping(value = "/getAllSubscription")
	public ResponseEntity<List<Subscription>> getAllSubscription(){
		List<Subscription> subscriptionList=service.getAllSubscription();
		System.out.println(subscriptionList);
		return new ResponseEntity<List<Subscription>>(subscriptionList, HttpStatus.OK);
	}
	@PostMapping(value="/loginCheck")
	public HashMap<String, String> loginCheck(@RequestBody User u){
		User user=service.loginCheck(u);
		
		HashMap<String, String> hm=new HashMap<>();
		if(user!=null) {
			hm.put("msg","Valid User");
			
			hm.put("email", user.getEmail());
		}
		else
			hm.put("msg", "Invalid User");
		return hm; 
		
	}
	@PostMapping(value="/changeStatus")
	public String changeStatus(@RequestBody String email) {
		String msg=service.changeStatus(email);
		return  msg;
	}
	
	
}
