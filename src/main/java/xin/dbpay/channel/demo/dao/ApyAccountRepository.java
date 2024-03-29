


package xin.dbpay.channel.demo.dao;

import xin.dbpay.channel.demo.entity.ApyAccount;
import xin.dbpay.channel.demo.entity.PayType;
import xin.dbpay.channel.provider.spi.bean.MsgType;
import xin.dbpay.channel.provider.spi.util.sign.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户
 *
 * @author: egan
 * email egzosn@gmail.com
 * date 2016/11/18 1:21
 */
//@Repository
public class ApyAccountRepository {

    // 这里简单模拟，引入orm等框架之后可自行删除
    public static Map<Integer, ApyAccount> apyAccounts = new HashMap<>();

    /**
     * 这里简单初始化，引入orm等框架之后可自行删除
     */ {
        ApyAccount apyAccountAlipay = new ApyAccount();
        apyAccountAlipay.setPayId(1);
        apyAccountAlipay.setPartner("2088102169916436");
        apyAccountAlipay.setAppid("2016080400165436");
        // TODO 2017/2/9 16:20 author: egan  sign_type只有单一key时public_key与private_key相等，比如sign_type=MD5的情况
        apyAccountAlipay.setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB");
        apyAccountAlipay.setPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKroe/8h5vC4L6T+B2WdXiVwGsMvUKgb2XsKix6VY3m2wcf6tyzpNRDCNykbIwGtaeo7FshN+qZxdXHLiIam9goYncBit/8ojfLGy2gLxO/PXfzGxYGs0KsDZ+ryVPPmE34ZZ8jiJpR0ygzCFl8pN3QJPJRGTJn5+FTT9EF/9zyZAgMBAAECgYAktngcYC35u7cQXDk+jMVyiVhWYU2ULxdSpPspgLGzrZyG1saOcTIi/XVX8Spd6+B6nmLQeF/FbU3rOeuD8U2clzul2Z2YMbJ0FYay9oVZFfp5gTEFpFRTVfzqUaZQBIjJe/xHL9kQVqc5xHlE/LVA27/Kx3dbC35Y7B4EVBDYAQJBAOhsX8ZreWLKPhXiXHTyLmNKhOHJc+0tFH7Ktise/0rNspojU7o9prOatKpNylp9v6kux7migcMRdVUWWiVe+4ECQQC8PqsuEz7B0yqirQchRg1DbHjh64bw9Kj82EN1/NzOUd53tP9tg+SO97EzsibK1F7tOcuwqsa7n2aY48mQ+y0ZAkBndA2xcRcnvOOjtAz5VO8G7R12rse181HjGfG6AeMadbKg30aeaGCyIxN1loiSfNR5xsPJwibGIBg81mUrqzqBAkB+K6rkaPXJR9XtzvdWb/N3235yPkDlw7Z4MiOVM3RzvR/VMDV7m8lXoeDde2zQyeMOMYy6ztwA6WgE1bhGOnQRAkEAouUBv1sVdSBlsexX15qphOmAevzYrpufKgJIRLFWQxroXMS7FTesj+f+FmGrpPCxIde1dqJ8lqYLTyJmbzMPYw==");
        apyAccountAlipay.setNotifyUrl("http://pay.egzosn.com/payBack1.json");
        // 无需同步回调可不填
        apyAccountAlipay.setReturnUrl("http://pay.egzosn.com/payBack1.json");
        apyAccountAlipay.setInputCharset("UTF-8");
        apyAccountAlipay.setSeller("2088102169916436");
        apyAccountAlipay.setSignType(SignUtils.RSA.name());
        apyAccountAlipay.setPayType(PayType.aliPay);
        apyAccountAlipay.setMsgType(MsgType.text);
        //设置测试环境
        apyAccountAlipay.setTest(true);
        apyAccounts.put(apyAccountAlipay.getPayId(), apyAccountAlipay);

        ApyAccount apyAccountWxPay = new ApyAccount();
        apyAccountWxPay.setPayId(2);
        apyAccountWxPay.setPartner("1469188802");
        apyAccountWxPay.setAppid("wx3344f4aed352deae");
        // TODO 2017/2/9 16:20 author: egan  sign_type只有单一key时public_key与private_key相等，比如sign_type=MD5的情况
        apyAccountWxPay.setPublicKey("991ded080***************f7fc61095");
        apyAccountWxPay.setPrivateKey("991ded080***************f7fc61095");
        apyAccountWxPay.setNotifyUrl("http://pay.egzosn.com/payBack2.json");
        // 无需同步回调可不填
        apyAccountWxPay.setReturnUrl("http://pay.egzosn.com");
        apyAccountWxPay.setInputCharset("UTF-8");
        apyAccountWxPay.setSeller("1469188802");
        apyAccountWxPay.setSignType(SignUtils.MD5.name());
        apyAccountWxPay.setPayType(PayType.wxPay);
        apyAccountWxPay.setMsgType(MsgType.xml);
        //设置测试环境
        apyAccountWxPay.setTest(false);
        apyAccounts.put(apyAccountWxPay.getPayId(), apyAccountWxPay);

        ApyAccount apyAccountWxPay2 = new ApyAccount();
        apyAccountWxPay2.setPayId(3);
        apyAccountWxPay2.setPartner("12****601");
        apyAccountWxPay2.setAppid("wxa39*****ba9e9");
        apyAccountWxPay2.setPublicKey("48gf0i************h9eiut9");
        apyAccountWxPay2.setPrivateKey("48gf0i************h9eiut9");
        apyAccountWxPay2.setNotifyUrl("http://pay.egan.in/payBack3.json");
        // 无需同步回调可不填  app填这个就可以
        apyAccountWxPay2.setReturnUrl("http://pay.egan.in/payBack3.json");
        apyAccountWxPay2.setSeller("12****601");
        apyAccountWxPay2.setInputCharset("UTF-8");
        apyAccountWxPay2.setSignType(SignUtils.MD5.name());
        apyAccountWxPay2.setPayType(PayType.wxPay);
        apyAccountWxPay2.setMsgType(MsgType.xml);
        apyAccounts.put(apyAccountWxPay2.getPayId(), apyAccountWxPay2);

        ApyAccount apyAccountUnionPay = new ApyAccount();
        apyAccountUnionPay.setPayId(4);
        apyAccountUnionPay.setPartner("700000000000001");
        //公钥，验签证书链格式： 中级证书路径;根证书路径
        apyAccountUnionPay.setPublicKey("D:/certs/acp_test_middle.cer;D:/certs/acp_test_root.cer");
        //私钥, 私钥证书格式： 私钥证书路径;私钥证书对应的密码
        apyAccountUnionPay.setPrivateKey("D:/certs/acp_test_sign.pfx;000000");
        apyAccountUnionPay.setNotifyUrl("http://127.0.0.1/payBack4.json");
        // 无需同步回调可不填  app填这个就可以
        apyAccountUnionPay.setReturnUrl("http://127.0.0.1/payBack4.json");
        apyAccountUnionPay.setSeller("");
        apyAccountUnionPay.setInputCharset("UTF-8");
        apyAccountUnionPay.setSignType(SignUtils.RSA2.name());
        apyAccountUnionPay.setPayType(PayType.unionPay);
        apyAccountUnionPay.setMsgType(MsgType.json);
        apyAccountUnionPay.setTest(true);
        apyAccounts.put(apyAccountUnionPay.getPayId(), apyAccountUnionPay);

        ApyAccount apyAccountPaypal = new ApyAccount();
        apyAccountPaypal.setPayId(6);
        apyAccountPaypal.setAppid("1AZ7HTcvrEAxYbzYx_iDZAi06GdqbjhqqQzFgPBFLxm2VUMzwlmiNUBk_y_5QNP4zWKblTuM6ZBAmxScd");//Program ID
        apyAccountPaypal.setPrivateKey("1EBMIjAag6NiRdXZxteTv0amEsmKN345xJv3bN7f_HRXSqcRJlW7PXhYXjI9sk5I4nKYOHgeqzhXCXKFo");//API password
        apyAccountPaypal.setInputCharset("UTF-8");
        apyAccountPaypal.setPayType(PayType.payPal);
        apyAccountPaypal.setMsgType(MsgType.json);
        apyAccountPaypal.setTest(true);
        apyAccounts.put(apyAccountPaypal.getPayId(), apyAccountPaypal);
    }
    //_____________________________________________________________


    /**
     * 根据id获取对应的账户信息
     *
     * @param payId 账户id
     * @return 账户信息
     */
    public ApyAccount findByPayId(Integer payId) {
        // TODO 2016/11/18 1:23 author: egan  这里简单模拟 具体实现 略。。
        return apyAccounts.get(payId);
    }
}
