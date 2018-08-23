package cn.boz.nettystd.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("�ͻ������ӷ�����,��ʼ��������");
		byte[] req = "Query time order".getBytes();
		ByteBuf byteBuf = Unpooled.buffer(req.length);
		byteBuf.writeBytes(req);
		ctx.writeAndFlush(byteBuf);

	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println("client ��ȡ server ����");
		byte[] res=new byte[msg.readableBytes()];
		msg.readBytes(res);
		String body = new String(res,"UTF-8");
		System.out.println("���������Ϊ"+body);
	}
	
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client exception cause");
		ctx.close();
	}

}
