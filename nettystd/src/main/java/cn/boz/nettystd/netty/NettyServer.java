package cn.boz.nettystd.netty;

import cn.boz.nettystd.netty.handler.ServerHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

	private int port;

	public NettyServer(int port) {
		this.port = port;
	}

	public void start() throws InterruptedException {
		EventLoopGroup evg = null;
		try {

			ServerBootstrap serverBootstrap = new ServerBootstrap();
			evg = new NioEventLoopGroup();
			serverBootstrap.group(evg).channel(NioServerSocketChannel.class).localAddress("localhost", port)
					.childHandler(new ChannelInitializer<Channel>() {

						@Override
						protected void initChannel(Channel ch) throws Exception {
							// ChannelInBoundHandler是按照注册顺序进行执行的
							// ChannelOutBoundHandler是按照注册逆序执行的
							ch.pipeline().addLast(new ServerHandler());

						}
					});

			ChannelFuture chf = serverBootstrap.bind().sync();
			System.out.println("开始监听,端口为" + chf.channel().localAddress());
			chf.channel().closeFuture().sync();
		} catch (Exception e) {
			evg.shutdownGracefully().sync();
		} finally {
			evg.shutdownGracefully().sync();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		new NettyServer(7890).start();
	}
}
