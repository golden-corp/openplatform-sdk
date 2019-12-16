使用方法
===============================
支持JDK >= 1.7

[下载jar包](http://kpcenter.yewifi.com/upload/201907/20190717/20190717145830_1372846368.zip)

导入jar包

- 快速开具蓝票

```java
package examples;

import com.golden.Sdk;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class example{
    
    public static void main(String []args){
        try {
            Sdk sdk = new Sdk("fc36541461483b2db498", "d2641bfc30b293505ca2c09560b870aa", "1.0.0", "test");
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
            item.put("name", "咨询服务");
            item.put("tax_code", "1020202000000000000");
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
            JSONObject result = sdk.httpPost("/invoice/blue", jsonObject);
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

- 快速开具红票

```java
package examples;

import com.golden.Sdk;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class example{
    
    public static void main(String []args){
        try {
            Sdk sdk = new Sdk("fc36541461483b2db498", "d2641bfc30b293505ca2c09560b870aa", "1.0.0", "test");
           JSONObject jsonObject = new JSONObject();
           ArrayList invoices = new ArrayList<JSONObject>();
           JSONObject invoice = new JSONObject();
           invoice.put("seller_taxpayer_num", "111112222233333");//销方税号
           invoice.put("callback_url", "回掉地址");//销方税号
           invoice.put("order_sn", "6557136429603008662");//销方税号
           invoices.add(invoice);
           jsonObject.put("invoices", invoices);
           JSONObject result = sdk.httpPost("/invoice/red", jsonObject);
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```
运行examples
============
```bash
    java -jar developerPlatform-1.0.0-jar-with-dependencies.jar
```

运行测试
============
```bash
    java -jar developerPlatform-1.0.0-jar-with-dependencies.jar
```