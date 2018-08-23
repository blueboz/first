package cn.boz.nettystd.netty.handler;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter  {


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Server 读取数据中");
		if(msg instanceof ByteBuf) {
			ByteBuf buf=(ByteBuf) msg;
			byte[] req=new byte[buf.readableBytes()];
			buf.readBytes(req);
			String body = new String(req,"UTF-8");
			System.out.println("接受到的客户端数据"+body);
			System.out.println("Server 向客户端发送数据");
			String time = new Date(System.currentTimeMillis()).toString();
			ByteBuf rst = Unpooled.copiedBuffer(time.getBytes());
			ctx.write(rst);
		}else {
			ctx.close();
		}
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Server 读取数据完毕");
		ctx.flush();
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}