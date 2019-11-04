package xin.dbpay.channel.demo.service.handler;

import org.springframework.stereotype.Component;
import xin.dbpay.channel.provider.paypal.api.PayPalPayService;
import xin.dbpay.channel.provider.spi.api.PayMessageHandler;
import xin.dbpay.channel.provider.spi.bean.PayMessage;
import xin.dbpay.channel.provider.spi.bean.PayOutMessage;
import xin.dbpay.channel.provider.spi.exception.PayErrorException;

import java.util.Map;

/**
 * PayPal支付回调处理器
 * Created by ZaoSheng on 2016/6/1.
 */
@Component
public class PaypalPayMessageHandler implements PayMessageHandler<PayMessage, PayPalPayService> {


    @Override
    public PayOutMessage handle(PayMessage payMessage, Map<String, Object> context, PayPalPayService payService) throws PayErrorException {


        return payService.getPayOutMessage("fail", "失败");
    }
}
