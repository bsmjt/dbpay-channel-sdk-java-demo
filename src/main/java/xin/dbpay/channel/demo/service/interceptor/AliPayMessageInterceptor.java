
package xin.dbpay.channel.demo.service.interceptor;

import xin.dbpay.channel.provider.alipay.api.AliPayService;
import xin.dbpay.channel.provider.alipay.bean.AliPayMessage;
import xin.dbpay.channel.provider.spi.api.PayMessageHandler;
import xin.dbpay.channel.provider.spi.api.PayMessageInterceptor;
import xin.dbpay.channel.provider.spi.exception.PayErrorException;

import java.util.Map;

/**
 * 支付宝回调信息拦截器
 *
 * @author: egan
 * email egzosn@gmail.com
 * date 2017/1/18 19:28
 */
public class AliPayMessageInterceptor implements PayMessageInterceptor<AliPayMessage, AliPayService> {

    /**
     * 拦截支付消息
     *
     * @param payMessage 支付回调消息
     * @param context    上下文，如果handler或interceptor之间有信息要传递，可以用这个
     * @param payService 支付服务
     * @return true代表OK，false代表不OK并直接中断对应的支付处理器
     * @throws PayErrorException PayErrorException*
     * @see PayMessageHandler 支付处理器
     */
    @Override
    public boolean intercept(AliPayMessage payMessage, Map<String, Object> context, AliPayService payService) throws PayErrorException {

        //这里进行拦截器处理，自行实现
        String outTradeNo = payMessage.getOutTradeNo();
        // 设置外部单号
//        amtApplyService.fillApplyoutId(outTradeNo, (String) payMessage.getPayMessage().get("trade_no"));


        //获取账单
//        AmtApply amtApply = amtApplyService.getAmtApplyByApplyId(outTradeNo);
//        if (null == amtApply){
//            Log4jUtil.info("app 阿里pay：" + outTradeNo);
//            return false;
//        }
//
//        重复回调不进行处理
//        if(amtApply.getApplyState().shortValue()== ApplyStateEnum.success.getCode()){
//            return false;
//        }
        //将账单存储至上下文对象中
//        context.put("amtApply", amtApply);


        return true;
    }
}
