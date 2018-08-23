package cn.boz.nettystd.nettyorder.cli.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoClientHandler2 extends SimpleChannelInboundHandler{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		ByteBuf bb=(ByteBuf) msg;
		byte[] tmp=new byte[bb.readableBytes()];
		bb.readBytes(tmp);
		for (int i = 0; i < tmp.length; i++) {
			tmp[i]= (byte) (tmp[i]-1);
		}
		ByteBuf rst = Unpooled.copiedBuffer(tmp);
		//ctx.write(rst);
		//不准使用write的方式再次写入吗?
		
		//一旦经过readBytes之后，并且没有继续使用ctx.write方法进行写入的话，后面的是无法抓取得到的
		ctx.fireChannelRead(rst);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
		super.channelReadComplete(ctx);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
		super.exceptionCaught(ctx, cause);
	}

}
