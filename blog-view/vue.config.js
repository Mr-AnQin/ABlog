module.exports = {
	configureWebpack: {
		resolve: {
			alias: {
				'assets': '@/assets',
				'common': '@/common',
				'components': '@/components',
				'api': '@/api',
				'views': '@/views',
				'plugins': '@/plugins'
			}
		}
	}
};
module.exports = {
	devServer: {
		open: true,//启动项目后自动开启浏览器
		disableHostCheck: true,
		host: 'anqin.cc',//对应的主机名
		 // host: '127.0.0.1',//对应的主机名
		port: 8081,//端口号
		https: false,//是否开启协议名,如果开启会发出警告
	}
};
