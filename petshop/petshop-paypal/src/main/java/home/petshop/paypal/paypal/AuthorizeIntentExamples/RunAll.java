package home.petshop.paypal.paypal.AuthorizeIntentExamples;

import com.paypal.http.HttpResponse;
import com.paypal.orders.LinkDescription;
import com.paypal.orders.Order;
import com.paypal.payments.Capture;
import home.petshop.paypal.vo.PaypalOrderVo;
import home.petshop.paypal.vo.PaypalVo;

import java.util.ArrayList;
import java.util.List;


public class RunAll {
    public static void main(String[] args) {
        try {
            PaypalVo paypalVo = new PaypalVo();
            List<PaypalOrderVo> paypalOrderVos = new ArrayList<>();
            String username = null;
            // 創建訂單
            HttpResponse<Order> orderResponse = new CreateOrder().createOrder(true,paypalVo,paypalOrderVos,username);
            String orderId = "";
            System.out.println("Creating Order...");
            if (orderResponse.statusCode() == 201){
                orderId = orderResponse.result().id();
                System.out.println("Order ID: " + orderId);
                System.out.println("Links:");
                for (LinkDescription link : orderResponse.result().links()) {
                    System.out.println("\t" + link.rel() + ": " + link.href());
                }
            }
            System.out.println("Created Successfully\n");
            System.out.println("Copy approve link and paste it in browser. Login with buyer account and follow the instructions.\nOnce approved hit enter...");
            System.in.read();

            // 授權訂單
            System.out.println("Authorizing Order...");
            orderResponse = new AuthorizeOrder().authorizeOrder(orderId, true);
            String authId = "";
            if (orderResponse.statusCode() == 201){
                System.out.println("Authorized Successfully\n");
                authId = orderResponse.result().purchaseUnits().get(0).payments().authorizations().get(0).id();
            }

            // 獲取訂單
            System.out.println("Capturing Order...");
            HttpResponse<Capture> captureOrderResponse = new CaptureOrder().captureOrder(authId, true);
            if (orderResponse.statusCode() == 201){
                System.out.println("Captured Successfully");
                System.out.println("Status Code: " + captureOrderResponse.statusCode());
                System.out.println("Status: " + captureOrderResponse.result().status());
                System.out.println("Capture ID: " + captureOrderResponse.result().id());
                System.out.println("Links: ");
                for (com.paypal.payments.LinkDescription link : captureOrderResponse.result().links()) {
                    System.out.println("\t" + link.rel() + ": " + link.href() + "\tCall Type: " + link.method());
                }
            }
            /*System.out.println();
            System.out.println("Refunding Order...");
            HttpResponse<Refund> refundHttpResponse = new RefundOrder().refundOrder(captureOrderResponse.result().id(), true);
            if (refundHttpResponse.statusCode() == 201){
                System.out.println("Refunded Successfully");
                System.out.println("Status Code: " + refundHttpResponse.statusCode());
                System.out.println("Status: " + refundHttpResponse.result().status());
                System.out.println("Order ID: " + refundHttpResponse.result().id());
                System.out.println("Links: ");
                for (com.paypal.payments.LinkDescription link : refundHttpResponse.result().links()) {
                    System.out.println("\t" + link.rel() + ": " + link.href() + "\tCall Type: " + link.method());
                }
            }*/

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}