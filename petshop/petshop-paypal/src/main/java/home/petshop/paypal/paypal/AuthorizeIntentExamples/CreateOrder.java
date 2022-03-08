package home.petshop.paypal.paypal.AuthorizeIntentExamples;


import com.paypal.http.HttpResponse;
import com.paypal.http.serializer.Json;
import com.paypal.orders.*;
import home.petshop.paypal.paypal.PayPalClient;
import home.petshop.paypal.vo.PaypalOrderVo;
import home.petshop.paypal.vo.PaypalVo;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CreateOrder extends PayPalClient {

    /**
     * Method to create complete order body with <b>AUTHORIZE</b> intent
     *
     * @return OrderRequest with created order request
     */
    private OrderRequest buildCompleteRequestBody(PaypalVo paypalVo , List<PaypalOrderVo> paypalOrderVos , String username) {
        log.debug("進入buildCompleteRequestBody()");
        log.debug("zipcode:{}",paypalVo.getZipcode());
        log.debug("city:{}",paypalVo.getCity());
        log.debug("district:{}",paypalVo.getDistrict());
        log.debug("detail:{}",paypalVo.getDetail());
        log.debug("orderNum:{}",paypalVo.getOrderNum());
        log.debug("total:{}",paypalVo.getTotal());
        paypalOrderVos.forEach(paypalOrderVo -> log.debug("paypalOrderVo:{}",paypalOrderVo));
        log.debug("username:{}",username);
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("AUTHORIZE");

        ApplicationContext applicationContext = new ApplicationContext().brandName("PetShop").landingPage("BILLING")
                .cancelUrl("http://localhost:9000/index_user.html").returnUrl("http://localhost:9000/orderdetail.html?orderNum="+paypalVo.getOrderNum()).userAction("CONTINUE")
                .shippingPreference("SET_PROVIDED_ADDRESS");
        orderRequest.applicationContext(applicationContext);

        List<PurchaseUnitRequest> purchaseUnitRequests = new ArrayList<>();
        PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest().referenceId("PUHF")
                .description("寵物商品").customId("PETSHOP")
                .amountWithBreakdown(new AmountWithBreakdown().currencyCode("TWD").value(paypalVo.getTotal())
                        .amountBreakdown(new AmountBreakdown().itemTotal(new Money().currencyCode("TWD").value(paypalVo.getTotal()))
                                .shipping(new Money().currencyCode("TWD").value("0.00"))
                                .handling(new Money().currencyCode("TWD").value("0.00"))
                                .taxTotal(new Money().currencyCode("TWD").value("0.00"))
                                .shippingDiscount(new Money().currencyCode("TWD").value("0.00"))))
                .items(new ArrayList<Item>() {
                    {
                        for(PaypalOrderVo p : paypalOrderVos){
                            add(new Item().name(p.getTitle()).description(p.getTitle())
                                    .unitAmount(new Money().currencyCode("TWD").value(p.getPrice().toString()))
                                    .tax(new Money().currencyCode("TWD").value("0.00")).quantity(p.getCount().toString())
                                    .category("PHYSICAL_GOODS"));
                        }
                    }
                })
                .shippingDetail(new ShippingDetail().name(new Name().fullName(username))
                        .addressPortable(new AddressPortable().addressLine1(paypalVo.getDetail())
                                .adminArea2(paypalVo.getDistrict()).adminArea1(paypalVo.getCity()).postalCode(paypalVo.getZipcode()).countryCode("TW")));
        purchaseUnitRequests.add(purchaseUnitRequest);
        orderRequest.purchaseUnits(purchaseUnitRequests);
        return orderRequest;
    }


    /**
     * Method to create order with complete payload
     *
     * @param debug true = print response data
     * @return HttpResponse<Order> response received from API
     * @throws IOException Exceptions from API if any
     */
    public HttpResponse<Order> createOrder(boolean debug,PaypalVo paypalVo, List<PaypalOrderVo> paypalOrderVos,String username) throws IOException {
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.header("prefer","return=representation");
        request.requestBody(buildCompleteRequestBody(paypalVo,paypalOrderVos,username));
        HttpResponse<Order> response = client().execute(request);
        if (debug) {
            if (response.statusCode() == 201) {
                System.out.println("Order with Complete Payload: ");
                System.out.println("Status Code: " + response.statusCode());
                System.out.println("Status: " + response.result().status());
                System.out.println("Order ID: " + response.result().id());
                System.out.println("Intent: " + response.result().checkoutPaymentIntent());
                System.out.println("Links: ");
                for (LinkDescription link : response.result().links()) {
                    System.out.println("\t" + link.rel() + ": " + link.href() + "\tCall Type: " + link.method());
                }
                System.out.println("Total Amount: " + response.result().purchaseUnits().get(0).amountWithBreakdown().currencyCode()
                        + " " + response.result().purchaseUnits().get(0).amountWithBreakdown().value());
                System.out.println("Full response body:");
                System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));
            }
        }
        return response;
    }

}