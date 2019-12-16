package com.golden;

import com.golden.request.InvoiceBlue;
import com.golden.request.InvoiceBlueGoodsInfo;
import com.golden.request.InvoiceRed;
import com.golden.request.InvoiceRedInvoice;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SdkTest {

    Sdk sdk;

    @Before
    public void before() {
        sdk = new Sdk("fc36541461483b2db498", "d2641bfc30b293505ca2c09560b870aa",  "1.0.0","test");
    }

    @Test
    public void genereateSignTest() throws Exception{

        JSONObject json = new JSONObject();
        json.put("test", "testvalue");
        String signature = null;
        signature = sdk.genereateSign(json, System.currentTimeMillis() / 1000);
        Assert.assertNotNull(signature);
    }

    @Test
    public void httpPostTest()throws Exception{
        JSONObject jsonObject = new JSONObject();
        ArrayList invoices = new ArrayList<JSONObject>();
        JSONObject invoice = new JSONObject();
        invoice.put("seller_taxpayer_num", "111112222233333");//销方税号
        invoice.put("callback_url", "回掉地址");//销方税号
        invoice.put("order_sn", "6557136429603008662");//销方税号
        invoices.add(invoice);
        jsonObject.put("invoices", invoices);
        JSONObject result = sdk.httpPost("/invoice/red", jsonObject);
        Assert.assertEquals(sdk.getEnv(), "test");
        Assert.assertEquals("{\"code\":0,\"data\":[{\"code\":1,\"message\":\"发票已红冲. order_sn:6557136429603008662 invoice_id:6557136429603008662 is_red:1\",\"order_sn\":\"6557136429603008662\",\"invoice_id\":\"6557136624403222679\"}],\"message\":\"success\"}", result.toString());
    }
}
