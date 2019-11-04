package xin.dbpay.channel.demo.entity;

import com.egzosn.pay.wx.api.WxPayConfigStorage;
import com.egzosn.pay.wx.api.WxPayService;
import com.egzosn.pay.wx.bean.WxTransactionType;
import xin.dbpay.channel.demo.service.handler.WxPayMessageHandler;
import xin.dbpay.channel.provider.alipay.api.AliPayConfigStorage;
import xin.dbpay.channel.provider.alipay.api.AliPayService;
import xin.dbpay.channel.provider.alipay.bean.AliTransactionType;
import xin.dbpay.channel.provider.fuioupay.api.FuiouPayConfigStorage;
import xin.dbpay.channel.provider.fuioupay.api.FuiouPayService;
import xin.dbpay.channel.provider.fuioupay.bean.FuiouTransactionType;
import xin.dbpay.channel.provider.paypal.api.PayPalConfigStorage;
import xin.dbpay.channel.provider.paypal.api.PayPalPayService;
import xin.dbpay.channel.provider.paypal.bean.PayPalTransactionType;
import xin.dbpay.channel.provider.spi.api.PayService;
import xin.dbpay.channel.provider.spi.bean.BasePayType;
import xin.dbpay.channel.provider.spi.bean.CertStoreType;
import xin.dbpay.channel.provider.spi.bean.TransactionType;
import xin.dbpay.channel.provider.spi.http.HttpConfigStorage;
import xin.dbpay.channel.provider.unionpay.api.UnionPayConfigStorage;
import xin.dbpay.channel.provider.unionpay.api.UnionPayService;
import xin.dbpay.channel.provider.unionpay.bean.UnionTransactionType;


/**
 * 支付类型
 *
 * @author egan
 * email egzosn@gmail.com
 * date 2016/11/20 0:30
 */
public enum PayType implements BasePayType {

    aliPay {
        /**
         *  @see AliPayService 17年更新的版本,旧版本请自行切换
         * @param apyAccount
         * @return
         */
        @Override
        public PayService getPayService(ApyAccount apyAccount) {
            AliPayConfigStorage configStorage = new AliPayConfigStorage();
            //配置的附加参数的使用
            configStorage.setAttach(apyAccount.getPayId());
            configStorage.setPid(apyAccount.getPartner());
            configStorage.setAppid(apyAccount.getAppid());
            configStorage.setKeyPublic(apyAccount.getPublicKey());
            configStorage.setKeyPrivate(apyAccount.getPrivateKey());
            configStorage.setNotifyUrl(apyAccount.getNotifyUrl());
            configStorage.setReturnUrl(apyAccount.getReturnUrl());
            configStorage.setSignType(apyAccount.getSignType());
            configStorage.setSeller(apyAccount.getSeller());
            configStorage.setPayType(apyAccount.getPayType().toString());
            configStorage.setMsgType(apyAccount.getMsgType());
            configStorage.setInputCharset(apyAccount.getInputCharset());
            configStorage.setTest(apyAccount.isTest());
            //请求连接池配置
            HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
            //最大连接数
            httpConfigStorage.setMaxTotal(20);
            //默认的每个路由的最大连接数
            httpConfigStorage.setDefaultMaxPerRoute(10);
            return new AliPayService(configStorage, httpConfigStorage);
        }

        @Override
        public TransactionType getTransactionType(String transactionType) {
            // AliTransactionType 17年更新的版本,旧版本请自行切换

            // AliTransactionType 17年更新的版本,旧版本请自行切换
            return AliTransactionType.valueOf(transactionType);
        }


    }, wxPay {
        @Override
        public PayService getPayService(ApyAccount apyAccount) {
            WxPayConfigStorage wxPayConfigStorage = new WxPayConfigStorage();
            wxPayConfigStorage.setMchId(apyAccount.getPartner());
            wxPayConfigStorage.setAppid(apyAccount.getAppid());
            //转账公钥，转账时必填
            wxPayConfigStorage.setKeyPublic(apyAccount.getPublicKey());
            wxPayConfigStorage.setSecretKey(apyAccount.getPrivateKey());
            wxPayConfigStorage.setNotifyUrl(apyAccount.getNotifyUrl());
            wxPayConfigStorage.setReturnUrl(apyAccount.getReturnUrl());
            wxPayConfigStorage.setSignType(apyAccount.getSignType());
            wxPayConfigStorage.setPayType(apyAccount.getPayType().toString());
            wxPayConfigStorage.setMsgType(apyAccount.getMsgType());
            wxPayConfigStorage.setInputCharset(apyAccount.getInputCharset());
            wxPayConfigStorage.setTest(apyAccount.isTest());

            //https证书设置 方式一
        /*    HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
             //TODO 这里也支持输入流的入参。
//          httpConfigStorage.setKeystore(PayType.class.getResourceAsStream("/证书文件"));
            httpConfigStorage.setKeystore("证书信息串");
            httpConfigStorage.setStorePassword("证书密码");
            //设置ssl证书对应的存储方式，这里默认为文件地址
            httpConfigStorage.setCertStoreType(CertStoreType.PATH);
            return  new WxPayService(wxPayConfigStorage, httpConfigStorage);*/
            WxPayService wxPayService = new WxPayService(wxPayConfigStorage);
            wxPayService.setPayMessageHandler(new WxPayMessageHandler(1));
            return wxPayService;
        }

        /**
         * 根据支付类型获取交易类型
         * @param transactionType 类型值
         * @see WxTransactionType
         * @return
         */
        @Override
        public TransactionType getTransactionType(String transactionType) {

            return WxTransactionType.valueOf(transactionType);
        }
    }, fuiou {
        @Override
        public PayService getPayService(ApyAccount apyAccount) {
            FuiouPayConfigStorage fuiouPayConfigStorage = new FuiouPayConfigStorage();
            fuiouPayConfigStorage.setKeyPublic(apyAccount.getPublicKey());
            fuiouPayConfigStorage.setKeyPrivate(apyAccount.getPrivateKey());
            fuiouPayConfigStorage.setNotifyUrl(apyAccount.getNotifyUrl());
            fuiouPayConfigStorage.setReturnUrl(apyAccount.getReturnUrl());
            fuiouPayConfigStorage.setSignType(apyAccount.getSignType());
            fuiouPayConfigStorage.setPayType(apyAccount.getPayType().toString());
            fuiouPayConfigStorage.setMsgType(apyAccount.getMsgType());
            fuiouPayConfigStorage.setInputCharset(apyAccount.getInputCharset());
            fuiouPayConfigStorage.setTest(apyAccount.isTest());
            return new FuiouPayService(fuiouPayConfigStorage);
        }

        @Override
        public TransactionType getTransactionType(String transactionType) {
            return FuiouTransactionType.valueOf(transactionType);
        }


    }, unionPay {
        @Override
        public PayService getPayService(ApyAccount apyAccount) {
            UnionPayConfigStorage unionPayConfigStorage = new UnionPayConfigStorage();
            unionPayConfigStorage.setMerId(apyAccount.getPartner());
            unionPayConfigStorage.setCertSign(true);
//            unionPayConfigStorage.setKeyPublic(apyAccount.getPublicKey());
//            unionPayConfigStorage.setKeyPrivate(apyAccount.getPrivateKey());

            //中级证书路径
            unionPayConfigStorage.setAcpMiddleCert("D:/certs/acp_test_middle.cer");
            //根证书路径
            unionPayConfigStorage.setAcpRootCert("D:/certs/acp_test_root.cer");
            // 私钥证书路径
            unionPayConfigStorage.setKeyPrivateCert("D:/certs/acp_test_sign.pfx");
            //私钥证书对应的密码
            unionPayConfigStorage.setKeyPrivateCertPwd("000000");
            //设置证书对应的存储方式，这里默认为文件地址
            unionPayConfigStorage.setCertStoreType(CertStoreType.PATH);

            unionPayConfigStorage.setNotifyUrl(apyAccount.getNotifyUrl());
            unionPayConfigStorage.setReturnUrl(apyAccount.getReturnUrl());
            unionPayConfigStorage.setSignType(apyAccount.getSignType());
            unionPayConfigStorage.setPayType(apyAccount.getPayType().toString());
            unionPayConfigStorage.setMsgType(apyAccount.getMsgType());
            unionPayConfigStorage.setInputCharset(apyAccount.getInputCharset());
            unionPayConfigStorage.setTest(apyAccount.isTest());
            return new UnionPayService(unionPayConfigStorage);
        }

        @Override
        public TransactionType getTransactionType(String transactionType) {
            return UnionTransactionType.valueOf(transactionType);
        }


    }, payPal {
        @Override
        public PayService getPayService(ApyAccount apyAccount) {
            PayPalConfigStorage storage = new PayPalConfigStorage();
            //配置的附加参数的使用
            storage.setAttach(apyAccount.getPayId());
            storage.setClientID(apyAccount.getAppid());
            storage.setClientSecret(apyAccount.getPrivateKey());
            storage.setTest(true);
            //发起付款后的页面转跳地址
            storage.setReturnUrl(apyAccount.getReturnUrl());
            //取消按钮转跳地址,这里兼容的做法
            storage.setNotifyUrl(apyAccount.getNotifyUrl());
            return new PayPalPayService(storage);
        }

        public TransactionType getTransactionType(String transactionType) {
            return PayPalTransactionType.valueOf(transactionType);
        }


    };

    public abstract PayService getPayService(ApyAccount apyAccount);

}
