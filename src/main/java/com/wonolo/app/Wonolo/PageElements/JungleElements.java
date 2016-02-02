package com.wonolo.app.Wonolo.PageElements;


import com.wonolo.app.Wonolo.JungleDriver;

public class JungleElements extends JungleDriver {
    //base url
    public static String jungle_url = "https://jungle-socks.herokuapp.com/";

    //jungle_socks_page elements
    //names
    public static String zebra_name = "tr[class='line_item zebra']";
    public static String lion_name = "input[id*=password]";
    public static String elephant_name = "input[name=commit]";
    public static String giraffe_name = "a[id=new_request_button]";
    //prices
    public static String zebra_price = "input[id*=request_name]";
    public static String lion_price = "textarea[id*=description_tasks]";
    public static String elephant_price = "input[id*=slots]";
    public static String giraffe_price = "input[id*=venue]";
    //amount in stock
    public static String zebra_stock = "input[id*=address]";
    public static String lion_stock = "input[id*=city]";
    public static String elephant_stock = "input[id*=zip]";
    public static String giraffe_stock = "input[id*=wage]";
    //quantity ordered
    public static String zebra_quantity = "input[id*='quantity_zebra']:not([type=hidden]";
    public static String lion_quantity = "input[id*='quantity_lion']";
    public static String elephant_quantity = "input[id*='quantity_elephant']";
    public static String giraffe_quantity = "input[id*='quantity_giraffe']";

    public static String checkout = "input[name=commit]";


}
