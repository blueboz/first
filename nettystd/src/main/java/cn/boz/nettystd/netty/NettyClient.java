package cn.boz.nettystd.netty;

import cn.boz.nettystd.netty.handler.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
	private final String host;
	private final int port;

	public NettyClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void start() throws InterruptedException {
		EventLoopGroup elg=null;
		try {
			Bootstrap bootstrap = new Bootstrap();
			elg = new NioEventLoopGroup();
			bootstrap.group(elg).channel(NioSocketChannel.class).remoteAddress(host, port)
					.handler(new ChannelInitializer<Channel>() {

						@Override
						protected void initChannel(Channel ch) throws Exception {
							ch.pipeline().addLast(new ClientHandler());
						}
					});
			ChannelFuture sync = bootstrap.connect().sync();
			sync.channel().closeFuture().sync();
		} finally {
			elg.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new NettyClient("localhost", 7890).start();
	}

}
