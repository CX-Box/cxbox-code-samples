package core.widget.TestingTools;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;


public class ProxyManager {
    private HttpProxyServer proxyServer;

    public void startProxy() {
        proxyServer = DefaultHttpProxyServer.bootstrap()
                .withPort(8080) // Порт прокси-сервера
                .withFiltersSource(new HttpFiltersSourceAdapter() {
                    @Override
                    public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
                        return new HttpFiltersAdapter(originalRequest) {
                            @Override
                            public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                                // Логирование запросов
                                System.out.println("Proxy work");
                                if (httpObject instanceof HttpRequest) {
                                    System.out.println("Proxy print");
                                    HttpRequest request = (HttpRequest) httpObject;
                                    System.out.println("Request URL: " + request.getUri());
                                }
                                return null;
                            }


                            @Override
                            public HttpObject serverToProxyResponse(HttpObject httpObject) {
                                // Логирование ответов
                                System.out.println("Proxy Work2");
                                if (httpObject instanceof HttpResponse) {
                                    System.out.println("Proxy print2");
                                    HttpResponse response = (HttpResponse) httpObject;
                                    System.out.println("Response Status: " + response.getStatus());
                                }
                                return httpObject;
                            }
                        };
                    }
                })
                .start();
    }

    public void stopProxy() {
        if (proxyServer != null) {
            proxyServer.stop();
        }
    }
}