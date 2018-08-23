package cn.boz.nettystd.nettyorder;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;

public class PrintMsg {

	public static void printMsg(Object msg) {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body;
		try {
			body = new String(req, "UTF-8");
			System.out.println("Msg对象数据：" + body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
