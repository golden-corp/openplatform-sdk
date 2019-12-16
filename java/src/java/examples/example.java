package examples;

import com.golden.Sdk;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class example {

    public static void main(String []args){
        try {
            Sdk sdk = new Sdk("979ba401daec33d1b3ab", "8431c656b20e07a4441b5c0e1adb9af8", "1.0.0", "prod");
            JSONObject result = invoiceBlue(sdk);
            //JSONObject result = invoiceRed(sdk);
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject invoiceRed(Sdk sdk)throws IOException{
            JSONObject jsonObject = new JSONObject();
            ArrayList invoices = new ArrayList<JSONObject>();
            JSONObject invoice = new JSONObject();
            invoice.put("seller_taxpayer_num", "111112222233333");//销方税号
            invoice.put("callback_url", "回掉地址");//销方税号
            invoice.put("order_sn", "6557136429603008662");//销方税号
            invoices.add(invoice);
            jsonObject.put("invoices", invoices);
            JSONObject result = sdk.httpPost("/invoice/red", jsonObject);
            return result;
    }

    public static JSONObject invoiceBlue(Sdk sdk) throws IOException{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("seller_name", "");
            jsonObject.put("seller_taxpayer_num", "111112222233333");
            jsonObject.put("seller_address", "");
            jsonObject.put("seller_tel", "");
            jsonObject.put("seller_bank_name", "");
            jsonObject.put("seller_bank_account", "");
            jsonObject.put("title_type", 1);
            jsonObject.put("buyer_title", "我是抬头");
            jsonObject.put("buyer_taxpayer_num", "");
            jsonObject.put("buyer_address", "");
            jsonObject.put("buyer_bank_name", "");
            jsonObject.put("buyer_bank_account", "");
            jsonObject.put("buyer_phone", "");
            jsonObject.put("buyer_email", "");
            jsonObject.put("taker_phone", "");
            jsonObject.put("taker_name", "");
            jsonObject.put("order_id", "test001asdfsadfasdf");
            jsonObject.put("invoice_type_code", "032");
            jsonObject.put("callback_url", "http://www.xx.com");
            jsonObject.put("drawer", "小刘");
            jsonObject.put("payee", "小刘");
            jsonObject.put("checker", "小刘");
            jsonObject.put("trade_type", 0);
            jsonObject.put("user_openid", "");
            jsonObject.put("special_invoice_kind", "");
            jsonObject.put("terminal_code", "");
            jsonObject.put("amount_has_tax", 9508);
            jsonObject.put("tax_amount", 864);
            jsonObject.put("amount_without_tax", 8644);
            jsonObject.put("remark", "");

            ArrayList<JSONObject> items = new ArrayList<JSONObject>();

            JSONObject item = new JSONObject();
            item.put("name", "咨询服务22");
            item.put("tax_code", "3020202000000000000");
            item.put("tax_type", "");
            item.put("models", "xyz");
            item.put("unit", "个");
            item.put("total_price", 8644);
            item.put("total", "5");
            item.put("price", "17.288");
            item.put("tax_rate", 100);
            item.put("tax_amount", 864);
            item.put("discount", 0);
            item.put("zero_tax_flag", "");
            item.put("preferential_policy_flag", "");
            item.put("vat_special_management", "");
            items.add(item);
            jsonObject.put("items", items);

            JSONObject item2 = new JSONObject();
            item2.put("name", "咨询服务");
            item2.put("tax_code", "3720202000000000000");
            item2.put("tax_type", "");
            item2.put("models", "xyz");
            item2.put("unit", "个");
            item2.put("total_price", 8644);
            item2.put("total", "5");
            item2.put("price", "17.288");
            item2.put("tax_rate", 100);
            item2.put("tax_amount", 864);
            item2.put("discount", 0);
            item2.put("zero_tax_flag", "");
            item2.put("preferential_policy_flag", "");
            item2.put("vat_special_management", "");
            items.add(item2);
            jsonObject.put("items", items);



            jsonObject.put("aaa", "~");//示例，可以忽略，用于检测特殊情况签名异常
            jsonObject.put("family", "fff@dd.c*+ om");//示例，可以忽略，用于检测特殊情况签名异常
            jsonObject.put("name", "sss");//示例，可以忽略，用于检测特殊情况签名异常
            jsonObject.put("sdfsdfsdf", "sss");//示例，可以忽略，用于检测特殊情况签名异常
            JSONObject result = sdk.httpPost("/invoice/blue", jsonObject);
            return result;
    }
}
