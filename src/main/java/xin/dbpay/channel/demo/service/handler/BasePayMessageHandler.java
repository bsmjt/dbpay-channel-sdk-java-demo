package xin.dbpay.channel.demo.service.handler;

import xin.dbpay.channel.provider.spi.api.PayMessageHandler;
import xin.dbpay.channel.provider.spi.api.PayService;
import xin.dbpay.channel.provider.spi.bean.PayMessage;

/**
 *
 * Created by ZaoSheng on 2016/6/1.
 */
public abstract class BasePayMessageHandler<M extends PayMessage, S extends PayService> implements PayMessageHandler<M, S> {
    //支付账户id
    private Integer payId;

    public BasePayMessageHandler(Integer payId) {
        this.payId = payId;
    }

    public Integer getPayId() {
        return payId;
    }
}
