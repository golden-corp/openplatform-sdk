使用方法
========

npm install golden-developer-platform-sdk --save

```javascript
const sdk = require("../index");

var golden = new sdk("testappkey111", "testappsecret", "test", "1.0.0");

let post = {
  "buyer_title": "sdfsdfsdf",
  "invoice_type_code":"032",
  "title_type": 1,
  "order_id":"13332311x1asdfcsdcc",
  "buyer_taxpayer_num": "123456789406426",
  "buyer_address": "广东 深圳 南山",
  "buyer_bank_name": "中国工商银行",
  "buyer_bank_account": "621281240200099900000",
  "buyer_phone": "0755—26951098",
  "buyer_email": "Calvin.chen@gaopeng.com",
  "user_openid": "201708022e87777ggg74",
  "channel": "GP110001",
  "machine_no":"0",
  "seller_taxpayer_num":"111112222233333",
  "callback_url":"http://test.feehi.com/sign/mock/invoice-callback.php",
  "tax_amount":864,
  "amount_has_tax":9508,
  "amount_without_tax":8644,
  "drawer":"ddd",
  "items": [
    {
      "name": "商品1",
      "tax_rate": 100,
      "models": "XYZ",
      "unit": "个",
      "total_price": 8644,
      "price":"17.288",
      "tax_amount":864,
      "total": "5",
      "tax_code": "1020202000000000000",
      "discount":0,
      "tax_type":"1",
      "preferential_policy_flag":"0"
    }
  ]

}

golden.httpRequest("/invoice/blue", {post:post}).then(function(data){
    console.log("接口返回结果", data.data)
})
```

运行example
==========
```bash
    npm run example
```