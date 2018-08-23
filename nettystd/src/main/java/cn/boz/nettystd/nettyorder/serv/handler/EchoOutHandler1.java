package cn.boz.nettystd.nettyorder.serv.handler;

import java.util.Date;

import cn.boz.nettystd.nettyorder.PrintMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class EchoOutHandler1 extends ChannelOutboundHandlerAdapter {
	
	@Override
	// 向client发送消息
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		System.out.println("out1");
		//PrintMsg.printMsg(msg);
		/* System.out.println(msg); */

		ByteBuf resp = Unpooled.copiedBuffer("Jay".getBytes());
		ctx.write(resp);
		//ctx.flush();
		super.write(ctx, msg, promise);
	}
}
