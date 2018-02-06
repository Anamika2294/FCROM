package com.fcrom.library.Constant;


import android.content.Context;

public class API_urls {
    public static Context context;
    public static String baseUrl;



    public static void initialize(Context context, String baseURL){

        API_urls.context=context;
        API_urls.baseUrl=baseURL;

    }
    public static String headerTokenn = "";
    public static String headerNodeID = "";


    //public static final String BaseURL = "http://10.22.0.52:8080";  //HARI MACHINE uat

    //  public static final String BaseURL_custome = "http://10.22.0.52:8082";  //Local SERVER HARI
    public static final String BaseURL = "http://10.22.0.52:8081";  //Local SERVER HARI

    //  public static final String BaseURL_custome = "http://10.0.21.146:8080";  //uat SETVER
   public static String BaseURL_custome = baseUrl;  //uat SERVER
    //  public static final String BaseURL_custome = "https://momapip.dmart.in:443";  //PROD SERVER

    // --- HARI
    public static final String API_POST_LOGIN = "/auth/v1"; //auth,login

    public static final String API_GET_RECEIVE_ORDER_LIST = "/oapi/v1/trips";  //Receive Order List
    public static final String API_GET_RECEIVE_ORDER_API = "/oapi/v1/receive";  // ACCEPT RECEIVE ORDER  //receive_mock
    public static final String API_GET_CUST_PICKUP_API = "/oapi/v1/orderdetails/pickup";// PICK UP LISTING
    public static final String API_POST_FULLACCEPT = "/oapi/v2/pickup";// PICKEDUP Order FULL/PAARTIAL ACCEPT ,FULL REJECT.
    public static final String API_POST_POSTRETURNS = "/oapi/v1/phreturn/orderlist";
    public static final String API_POST_CUSTPHRETURN = "/oapi/v1/phreturn/ro";
    public static final String API_POST_OTP = "/oapi/v1/otp";
    public static final String API_GET_REPORTS = "/oapi/v1/reports/summary";
    public static final String API_GET_CRATEDETAILS = "/oapi/v1/cratedetails";//shipmentNo=AAA00217PS003596
    public static final String API_GET_SEARCH = "/oapi/v1/search";
    public static final String API_POST_UPDATECRATELOCAATION = "/oapi/v1/crateloc/update";
    public static final String API_GET_PUTAWAY = "/oapi/v1/cratelist/putaway";//cratelist/putaway?nodeId=AAAM
    public static final String API_POST_NOSHOW = "/oapi/v1/noshow";//cratelist/putaway?nodeId=AAAM


    public static final String API_GET_CASHSUMMERY = "/capi/v1/cashreport/";//cratelist/putaway?nodeId=AAAM
    public static final String API_GET_PICKUP_CASH = "/capi/v1/cashdeposit";//?PUP=AAAP
    public static final String API_POST_PICKUP_CASH = "/capi/v1/cashdeposit";//

    public static final String API_GET_TRIPS="/lapi/v1/trips";


}


