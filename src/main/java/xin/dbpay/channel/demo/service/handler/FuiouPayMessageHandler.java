package xin.dbpay.channel.demo.service.handler;

import xin.dbpay.channel.provider.spi.api.PayService;
import xin.dbpay.channel.provider.spi.bean.PayMessage;
import xin.dbpay.channel.provider.spi.bean.PayOutMessage;
import xin.dbpay.channel.provider.spi.exception.PayErrorException;

import java.util.Map;

/**
 * @author Fuzx
 * create 2017 2017/1/24 0024
 */
public class FuiouPayMessageHandler extends BasePayMessageHandler {




    public FuiouPayMessageHandler(Integer payId) {
        super(payId);
    }

    @Override
    public PayOutMessage handle(PayMessage payMessage, Map context, PayService payService) throws PayErrorException {
        //交易状态
        if ("0000".equals(payMessage.getPayMessage().get("order_pay_code"))){
            /////这里进行成功的处理

            return PayOutMessage.JSON().content("success","成功").build();
        }

        return PayOutMessage.JSON().content("fail", "失败").build();
    }
}
