package cn.boz.nettystd.nettyorder.serv.handler;

import cn.boz.nettystd.nettyorder.PrintMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class EchoOutHandler3 extends ChannelOutboundHandlerAdapter{

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		System.out.println("out3");
		//PrintMsg.printMsg(msg);

		
		ByteBuf rs = Unpooled.copiedBuffer("WelCome".getBytes());
		ctx.write(rs);
		ctx.flush();
	}
	
}
