package cn.boz.nettystd.nettyorder.serv.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class EchoOutHandler2 extends ChannelOutboundHandlerAdapter {

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		System.out.println("out2");
		//对welcom 进行加密
		ByteBuf bb=(ByteBuf) msg;
		//byte[] array = bb.array();
		byte[] bs=new byte[bb.readableBytes()];
		bb.readBytes(bs);
		for (int i = 0; i < bs.length; i++) {
			bs[i]=(byte) (bs[i]+1);
		}
		//bb.writeBytes(bs);
		ByteBuf copiedBuffer = Unpooled.copiedBuffer(bs);
		ctx.write(copiedBuffer);
		ctx.flush();

		

		//PrintMsg.printMsg(msg);
		// 执行下一个OutboundHandler
		/*
		 * System.out.println("at first..msg = "+msg); msg = "hi newed in out2";
		 */
		super.write(ctx, msg, promise);
	}

}
