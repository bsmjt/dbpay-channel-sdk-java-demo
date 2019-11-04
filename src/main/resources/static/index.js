$(function ($) {

    $('[data-toggle="tooltip"]').tooltip()


    $('[data-toggle="popover"]').popover()


    $("#submit").click(function () {
        $.ajax({
            url: "add",
            type: "post",
            data: $("#form").serialize(),
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    alert("保存成功");
                    return;
                }
                alert("保存失败");
            },
            error: function (edata) {
                alert("服务器异常")
            }
        })
    });
    $("#js_submit").click(function () {
        $.ajax({
            url: "jsapi",
            type: "post",
            async: true,
            data: $("#jsapi").serialize(),
            dataType: 'json',
            success: function (data) {
                if (data.code == 0) {
                    if (typeof WeixinJSBridge == "undefined") {
                        if (document.addEventListener) {
                            document.addEventListener('WeixinJSBridgeReady', onBridgeReady(data), false);
                        } else if (document.attachEvent) {
                            document.attachEvent('WeixinJSBridgeReady', onBridgeReady(data));
                            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady(data));
                        }
                    } else {
                        onBridgeReady(data);
                    }
                    return;
                }
                alert("保存失败");
            },
            error: function (edata) {
                alert("服务器异常")
            }
        })
    })
});

function onBridgeReady(data) {
    WeixinJSBridge.invoke(
        'getBrandWCPayRequest', {
            "appId": data.appId,     //公众号名称，由商户传入
            "timeStamp": data.timeStamp,         //时间戳，自1970年以来的秒数
            "nonceStr": data.nonceStr, //随机串
            "package": data.package,
            "signType": data.signType,         //微信签名方式：
            "paySign": data.sign //微信签名
        },
        function (res) {
            // 使用以断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
            if (res.err_msg == "get_brand_wcpay_request:ok") {
                alert("支付成功")

            }
        }
    );
}
